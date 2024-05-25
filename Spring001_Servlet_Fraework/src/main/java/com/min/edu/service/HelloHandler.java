package com.min.edu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.handle.Handler;

public class HelloHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("invoke패턴에 의해서 위임되어 실행되어지는 service");
		String name = req.getParameter("name");
		//dao처리 실행
		req.setAttribute("result", name);
		return "HelloPage";
	}

}