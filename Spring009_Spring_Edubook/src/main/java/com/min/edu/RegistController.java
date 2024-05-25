package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/registForm.do")
	public String registForm() {
		logger.info("Welcome RegistController 일반 회원가입으로 이동");
		return "registForm";
	}
	@GetMapping(value = "/duplicateId.do")
	public String duplicateId() {
		logger.info("Welcome RegistController window.open 아이디 중복검사 화면 이동");
		return "duplicateId";
	}
}
