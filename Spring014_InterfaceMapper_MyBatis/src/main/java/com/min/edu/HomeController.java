package com.min.edu;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method =RequestMethod.GET )
	public String home (Model model) {
		Date date = new Date();
		model.addAttribute("time",date.toLocaleString());
		return "home";
	}
}
