package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.aes.Encrypt_AES;
import com.min.edu.service.IUserService;
import com.min.edu.vo.UserVo;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService service;
	
	//TODO 02_02 로그인 화면으로 이동 처리
	@RequestMapping(value="/loginForm.do",method = RequestMethod.GET)
	public String loginForm() {
		logger.info("WelComeHomeController > loginForm");
		return "loginForm";
	}
	
	//TODO 03_02 회원가입 화면 이동 signupForm.do
	@RequestMapping(value="/signupForm.do",method = RequestMethod.GET)
	public String signupForm() {
		logger.info("WelComeHomeController > signupForm");
		return "signupForm";
	}
	//TODO 04_04 중복 검사 JSP 요청
	@RequestMapping(value="/duplication.do",method=RequestMethod.GET)
	public String duplication() {
		logger.info("WelComeHomeController > duplication");
		return "duplication";
	}
	
	//TODO 04_06 아이디 중복처리를 위한 REST처리 : text만 전송(true / false)
	@RequestMapping(value = "/duplicationAjax.do",method = RequestMethod.POST)
	@ResponseBody
	public String duplicationAjax(String checkId) {
		logger.info("WelComeHomeController > duplicationAjax");
		logger.info("CheckId : {}", checkId);
		int n = service.isDupulicateCheck(checkId);
		return (n>0)?"true":"false";
	}
	
	//TODO 04_10 회원가입 정보를 입력받아 DB에 저장, 성공하면 redirect/loginForm.do를 호출
	@RequestMapping(value="/signup.do",method=RequestMethod.POST)
	public String signup(UserVo vo, HttpServletResponse resp) throws IOException {
							//UserVo 는 화면의 전달값을 Binding함, resp는 회원가입 실패시 alert를 전달하기 위해서
		logger.info("WelComeHomeController > signup{}",vo);
		
		Encrypt_AES aes = new Encrypt_AES();
		try {
			vo.setPassword(aes.encrypt(vo.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n = service.signUpMember(vo);
		if(n==1) {
			return "redirect:/loginForm.do";
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("<script>alert('회원가입에 실패 하였습니다.'); location.href='./signupForm.do';</script>");
			return null;
		}
	}
	@RequestMapping(value="/findId.do",method=RequestMethod.GET)
	public String findId(){
		logger.info("WelComeHomeController > findIdGET");
		return "findId";
	}
	
	@RequestMapping(value="/findIdAjax.do",method=RequestMethod.POST)
	@ResponseBody
	public String findIdprint(String name, String email) throws IOException{
		logger.info("WelComeHomeController > findIdprint / name : {}  / email : {}",name,email);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("email", email);
		String id = service.findID(map);
		if(id!=null) {
			return id;
		}else {
			return "false";
		}
	}
	
	//TODO 06_02 요청값은 map으로 처리, httpsession에 저장, 성공 servlert alert를 통해서 boardList.do로 이동
	@RequestMapping(value="/login.do",method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session, HttpServletResponse resp, HttpServletRequest req ) throws IOException {
		logger.info("WelComeHomeController > login.do  / name : {}  / email : {}",map);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		try {
			UserVo loginVo=service.getLogin(map);
			if(loginVo != null) {
				session.setAttribute("loginVo", loginVo);
				session.setMaxInactiveInterval(60*10);
				PrintWriter out = resp.getWriter();
				out.print("<script>alert('로그인 되었습니다');location.href='./boardList.do';</script>");
				out.flush();
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		out.print("<script>alert('로그인 정보가 없습니다.되었습니다');location.href='./loginForm.do';</script>");
		out.flush();
		return null;
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("welcome usercontroller 로그아웃");
		session.invalidate();
		return "redirect:/loginForm.do";
	}
	
	//TODO 09_02
	@RequestMapping(value = "/managementUser.do", method = RequestMethod.GET)
	public String mamagementUser(Model model) {
		logger.info("Welcome managementUser 회원관리 전체조회");
		List<UserVo> lists = service.getAllUser();
		model.addAttribute("listVo",lists);
		return "managementUser";
	}
}