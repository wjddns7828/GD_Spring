package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	@RequestMapping(value = "/home.do",method = RequestMethod.GET)
	public String home() {
		logger.info("home컨트롤러에 home 메소드");
		return "home";
	}
}
