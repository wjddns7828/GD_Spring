package com.min.edu;

import java.net.Authenticator.RequestorType;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @Controller는 stereotype Bean을 자동으로 동록되는 것들
 * servlet-context.xml > 자동 등록  < context Componet-scan base-package="com.min.edu> 하위에 있는 모든것들이 Bean으로 등록됨 
 *									<context:annotation-config/> Bean으로 생성된 객체 안에 있는 annotation(@)이 동작 될 수 있도록 해줌
 * 요청되는 주소에서 실행하고자 하는 메소드를 찾아 줌(Handler-Mapping)
 * @RequestMapping(value="매핑 명", method=requestMethod.처리방식(GET / POST))
 * spring framework 4.3.25부터 RequestMapping을 구체적으로 구분하기 위해
 * @GetMapping, @PostMapping을 사용 할 수 있다.
 * 
 * String으로 요청되는 주소에서 Handle Adapter에 의해서 메소드를 찾아 실행
 * 요청(param) HttpServletRequest는 자동으로 자바의 객체와 Mapping > 타입,변수명으로 하게 됨
 * --- 파싱(pasing) : 값의 형태를 변환하는 것
 * --- 바인딩(Binding) : 값을 부분에 끼워넣거나 비어있는 부분을 완성
 * 
 * Servlet에서의 화면의 흐름제어 (forward, redirect)객체가 있음
 * Spring framework의 화면 제어는 기본적으로 IoC로 동작이 되기 떄문에 DispatcherServlet이 가지고 있다.
 * 값은 SpringUI에 Model객체가 처리해주고 화면은 ViewResolver가 생성해줌 ==>ModelAndView 객체를 통해서 하나의 객체로 만들 수 있음
 * 
 * Servlet 혹은 MVC에서는 Redirect는 브라우저에 주소에 요청한다 라고 얘기 할 수 있음. response.sendRedirect("./화면 이동");
 * 		따라서 보안폴더인 WEB-INF는 접근 할 수 없음(호출이 불가능함)
 * 
 * 그치만 SpringFramework에서의 Redirect는 Container가 가지고 있는 mapping을 호출한다. return "redirect/호출.do"
 * 전송된 Scope처리
 * Scope 4종류
 * 	page, request, session, application이 있다
 * 
 * Spring Model의 객체는 requset scope이다.
 * 하지만, HttpServletRequest를 사용하여도 같은 역할을 한다
 * 
 * 마지막 위의 설명에서 model과 이동화면을 같이 처리 할 수 있는 객체는 ModelAndView
 * 사용하는 방법은 
 * public ModelAndView(){
 * ModelAndView mav = new ModelAndView();
 * mav.addObject("key",value);
 * mav.setViewName("");
 * return mav'
 * }를 하면 dispatcher가 뜯어서 작동함
 * 
 */
@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * TODO 01_01 요청 home.do로 호출 @GetMapping을 Get방식 만으로 처리함
	 */
	@GetMapping(value = "/home.do")
	public String home(String name, HttpServletRequest req, Model model) {
		
		//전송된 queryString을 요청명으로 자동으로 바인딩 되고 형변환도 된다. 만약 bind타입이 문자열일 경우 특별히 문제가 되지는 않지만 int와 같은 타입이라면 null을 처리(null을 형변환) 할 수 없기 때문에 오류가 뜸
		logger.info("@GetMapping home 요청 받은 name 값 : {} ", name);
		String str = "가장 좋아하는 과일은? " +name;
		String redirectValue = (String)req.getAttribute("name");
		logger.info("reDirect값 : {}", redirectValue);
		req.setAttribute("req_str", str);
		model.addAttribute("str",str);
		//만약에 return이 null로 작성이 되어 있다면 dispatcherServlet은 자동으로 메소드명을 사용하여 화면을 요청하게 됨
		return "home";
	}
	
	//TODO 02_02 요청 home.do로 호출 @PostMapping을 Post방식 만으로 처리함
	@PostMapping(value = "/home.do")
	public String home(String name, Model model) {
		logger.info("@PostMapping home 요청 받은 name 값 : {} ", name);
		String str = "과일 같은 야채  " +name;
		model.addAttribute("str",str);
		
		/**
		 * 반환 결과에 따른 구분
		 * 1) null: 자신의 method명을 반환함
		 * 2) 문자열 : DispatcherServlet에 의해서 문자열이 ViewResolver로 이동하고 "prefix"+문자열+"suffix"로 구성되어 요청한다
		 * 3) resolver 가 겂는 경우 해당위치를 모두 작성해 줘야함 ex /WEB-INF/views/home.jsp
		 * 
		 */
		return null;
	}
	
	//TODO 03_02 home.do를 호출하여 @requestMapping으로 GET POST 둘다 처리
	@RequestMapping(value = "/info.do", method={RequestMethod.GET, RequestMethod.POST})
	public String info(String name, int age, Model model) {
		logger.info("GET/POST모두 info.do 처리");
		String msg = name+"/"+age;
		model.addAttribute("info",msg);
		return "info";
	}
	//TODO 04_02 Spring에서는 Redirect는 "return redirect:/호출매핑.do"하여
	//			작성된 Controller Bean중 RequestMap의 Value가 같은 매핑을 실행해줌
	//			이때 값은 전달이 불가능함
	
	@GetMapping(value = "/redirect.do")
	public String redirect(String name, Model model, HttpServletRequest req) {
		logger.info("@GetMapping redirect 요청받은 name값 {}",name);
		model.addAttribute("name",name);
		return "redirect:/home.do?name=redirect";//redirect는 GET방식의 호출
	}
}
