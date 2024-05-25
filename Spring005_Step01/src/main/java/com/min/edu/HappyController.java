package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HappyController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String happy(String name, Model model) {
		logger.info("전달받은 요청값 : {}",name);
		model.addAttribute("result",name);
		return"/WEB-INF/views/happy.jsp";
	}
	
	//파라미터 처리 방법
	
	@GetMapping(value = "/param")
	public String param(HttpServletRequest req, String name, int month) {//Srping 처리방식
		logger.info("Servlet 처리 방식의 parameter 처리");
		//1) Servlet 처리 방식 
		String reqName = req.getParameter("name");
		String reqMonth = req. getParameter("month");
		logger.info("Servlet 처리방식은 req.getParameter() 메소드를 통해 처리한다 {} {}",reqName,reqMonth+0);
		
		
		logger.info("Spring은 자동 Binding을 지원한다(타입 자동 변환){} {}",name,month+1);
		
		return "/WEB-INF/views/param.jsp";
	}
	@GetMapping(value="/encoding")
	public String encoding(Model model, Locale local){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getTimeInstance();
		String formatDate = dateFormat.format(date);
		model.addAttribute("serverTime",formatDate);
		logger.info("전달 받은 파라미터 : {} ",local);
		return "/WEB-INF/views/encoding.jsp";
	}
}
