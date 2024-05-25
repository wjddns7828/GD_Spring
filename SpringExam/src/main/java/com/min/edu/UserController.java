package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.service.IUserService;
import com.min.edu.vo.UserVo;
import com.min.edu.vo.pageVo;

@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userservice;
	
	@RequestMapping(value = "/registForm.do")
	public String registForm() {
		logger.info("UserController에서 registForm");
		return "registForm";
	}
	
	@RequestMapping(value = "/regist.do",method = RequestMethod.POST)
	public String regist(UserVo vo) {
		logger.info("UserController에서 regist");
		logger.info("UserVo {}", vo);
		int n = userservice.regist(vo);
		if(n==0) {
			return "error";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/loginForm.do")
	public String loginForm() {
		logger.info("UserController에서 LoginForm");
		return "loginForm";
	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map,HttpSession session) {
		logger.info("UserController에서 Login");
		logger.info("받은 값 : {} ",map.toString());
		UserVo vo = userservice.login(map);
		if(vo==null) {
			return "redirect:/loginForm.do";
		}else {
			session.setAttribute("info", vo);
			return "login";
		}
	}
	@RequestMapping(value = "/changepwForm.do")
	public String changePwForm() {
		logger.info("UserController에서 changePwForm");
		return "changepwForm";
	}
	
	@RequestMapping(value = "/changepw.do",method = RequestMethod.POST)
	public String changePw(@RequestParam Map<String,Object> map) {
		logger.info("UserController에서 changePw");
		logger.info("받아온 값 : {}",map.toString());
		int n = userservice.updatePassword(map);
		if(n != 0) {
			return "redirect:/loginForm.do";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/userlist.do",method = RequestMethod.GET)
	public String userlist(int page, Model model) {
		logger.info("UserController에서 userlist");
		logger.info("받아온 값 : {}",page);
		Map<String, Object> map = new HashMap<String,Object>();
		pageVo pvo = new pageVo();
		pvo.setTotalCount(userservice.countuser());
		pvo.setCountList(3);
		pvo.setCountPage(5);
		pvo.setTotalPage(pvo.getTotalCount());
		if(page>pvo.getTotalPage()) {
			page = pvo.getTotalPage();
		}
		pvo.setPage(page);
		pvo.setStartPage(page);
		if(page>pvo.getTotalPage()) {
			pvo.setEndPage(pvo.getTotalPage());
		}else {
			pvo.setEndPage(page);
		}
		logger.info("page : {}",pvo);
		map.put("start",(pvo.getPage()*pvo.getCountList()-(pvo.getCountList()-1)));
		map.put("end", (pvo.getPage()*pvo.getCountList()));
		List<UserVo> lists = userservice.selectUserList(map);
		logger.info("출력 리스트 : {} ",lists);
		model.addAttribute("list",lists);
		model.addAttribute("page",pvo);
		return "userlist";
	}
}
