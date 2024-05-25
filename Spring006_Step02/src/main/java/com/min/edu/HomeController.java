package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//TODO 003 <context:componet-scan>에 의해서 bean으로 만들어 질 수 있는 com.min.edu 패키지의 하위 @controller

@Controller
public class HomeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//TODO 004 처음 요청되는 Mapping 메소드 작성
	@RequestMapping(value="/home.do", method =  RequestMethod.GET)
	public String home(String name, Model model){
		logger.info("home에 전달되는 param : {}",name);
		model.addAttribute("name", name+"님 안녕하세요");
//		return "home";//view resolver에 의해서 만들어질 view 페이지의 이름
		return null; //반환이 null인 경우 dispatcherServlet은 메소드명으로 반환한다.
	}
	
	//TODO 009 index.jsp의 POST요청을 통해 name과 age를 처리
	//			name의 parameter 값이 한글로 입력이 되었다면 전달받은 Controller에서 request를 Encoding처리하지 않는다면 System의 encoding으로 번역된다.
	
	@RequestMapping(value="/info.do",method=RequestMethod.POST)
	public String info(String name, int age) { //Binding은 String이 아닌 경우 타입의 형 변환 오류(null) 발생 할 수 있다.
		logger.info("info.do에서 전달받은 값 : {} / {} ", name, age);
		return null;
	}
}
