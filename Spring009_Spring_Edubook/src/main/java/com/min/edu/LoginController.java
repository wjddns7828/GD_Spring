package com.min.edu;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.service.IUserService;
import com.min.edu.vo.UserVO;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/login.do")
	public String login(UserVO vo, HttpSession session, Model model,HttpServletRequest request) {
		logger.info("@Controller LoginController login 요청받은 값{}",vo);
		UserVO loginvo = service.login(vo);
		if(loginvo==null) {
			return "redirect:/main.do";
		}else {
			/*
			 * model은 Spring container의 request객체이다 @RequestMapping과 값을 공유
			 * 1)org.springframework.ui.Model model -> model.addAttribute("loginVo",loginvo);=>request scope 처리
			 * 2) javax.servlet.HttpSession session -> session.setAttribute("loginVo",loginVo); => session scope처리
			 * 3)@SessionAttribute(loginVo)->model.addAttribute("loginVo",loginvo);=>session+springContainer Session scope로 처리함
			 */
			session.setAttribute("loginVo", loginvo);
			model.addAttribute("loginVo",loginvo);
			return "afterLogin";
		}
	}
	@GetMapping("/logout.do")
	public String logOut(HttpSession session, Model model) {
		logger.info("@Controller LoginController logOut");
		logger.info("session 삭제는 session.invalidate()");//세션 사용이 무효화 되어 메소드를 사용할 수 없다
		
		UserVO modelVo = (UserVO) model.getAttribute("loginVo");
		if(modelVo == null) {
			logger.info("Model은 request scope이기 때문에 값을 유지 할 수 없음");
		}
		UserVO sessionVo = (UserVO)session.getAttribute("loginVo");
		if(sessionVo!=null) {
			logger.info("HttpSession은 session scope이기 떄문에 값이 유지 됨{}",sessionVo.getName());
		}
		
		try {
//			session.invalidate();
			UserVO sessionVoTmp = (UserVO) session.getAttribute("loginVo");
		} catch (Exception e) {
			logger.info("invalidate는 객체 자체가 어쩌구 저쩌구");
		}
		//세션의 삭제는 invalidate()와 removeAttribute("key")가 있다
		logger.info("세션의 삭제는 session.removeAttribute()");
		session.removeAttribute("loginVo");
		UserVO sessionVoTmp2 = (UserVO) session.getAttribute("loginVo");
		logger.info("HttpSession의 내부에서 객체만 삭제된다. 삭제된 session {}",sessionVoTmp2);
		return "home";
	}
}
