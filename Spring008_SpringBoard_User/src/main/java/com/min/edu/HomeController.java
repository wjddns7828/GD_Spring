package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home.do",method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome HomeController{}","home");
		model.addAttribute("returnValue","처음 호출 테스트");
		return "home";
	}
}
