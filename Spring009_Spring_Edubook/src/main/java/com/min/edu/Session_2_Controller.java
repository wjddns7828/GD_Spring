package com.min.edu;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class Session_2_Controller {
	/*
	 * 생성하지 않고 사용되는 HttpSession과 @SessionAttribute를 사용과 삭제
	 * 
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/test03.do")
	public String test03(SessionStatus sessionstatus, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("다른 컨트롤러에서 @SessionAttribute를 사용 : {} ",sessionTest);
		logger.info("Session_2_Controller test03.do @SessionAttribute setcomplete()로 삭제");
		sessionstatus.setComplete();
		
		return "sessionChk";
	}
	@GetMapping("/result03.do")
	public String result03(HttpSession session, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("다른 컨트롤러에서 HttpSession과 @SessionAttribute를 출력\n 다른 컨트롤러에서는 SessionStatus.setComplete()수행 하지 못함 ");
		System.out.println("==========HttpSession========="+session.getAttribute("httpsessionTest"));
		System.out.println("==========@SessionAttribute========="+sessionTest);
		return "sessionChk";
	}
	@GetMapping("/test04.do")
	public String test04(HttpSession session) {
		System.out.println("$$$$$$$$$HTTPSESSION싺쪠$$$$$$$$$$$$$");
		session.invalidate();
		return "sessionChk";
	}
	@GetMapping("/result04.do")
	public String result04(HttpSession session) {
		logger.info("HttpSession을 출력");
		System.out.println("$$$$$$$$$$HTTP$$$$$$$$$$$"+session.getAttribute("httpsessionTest"));
		return "sessionChk";
	}
}
