package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO 012 요청에서 정보를 추출(요청주소, 접근자, 접근 브라우저 등) header정보 및 HttpServletRequest에서 조호 및 출력
public class AccessLogFilter implements Filter {
		private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//요청 정보를 출력한다
		HttpServletRequest req = (HttpServletRequest)request;
		
		/**
		 * 1. HttpServletRequest정보
		 * 		1) 요청주소(remoteAddr)
		 * 		2) 요청 값(queryString)
		 * 
		 * 2. Header 정보
		 * 		1)User-Agent
		 * 		2)Referer
		 * 		*)Pragma,Cache-Control,Expires 캐쉬 정보 -> 뒤로가기 정보 삭제
		 */
		
		//1) 접근을 시도하는 Client의 주소를 출력
		String remoteAddr = req.getRemoteAddr(); //기본이 IPV6로 되어있음
//		System.out.println("remoteAddr : "+remoteAddr);
		//2) 접근을 시도하는 URL / URI 
		String URI = req.getRequestURI();
		String URL = req.getRequestURL().toString();
		
//		System.out.println("URI : "+URI);
//		System.out.println("URL : "+URL);
		
		//3)전달 받은 요청 값 (쿼리 스트링)
		String queryString = req.getQueryString();
//		System.out.println("쿼리 스트링 :"+queryString);
//		queryString = queryString==null?"":queryString; //java의 삼항연산자를 이용한 값 변경
		queryString =StringUtils.defaultIfEmpty(queryString, "");
		System.out.println(queryString);
		
		//4) 이전 요청 페이지 확인
		String referer = StringUtils.defaultIfEmpty(req.getHeader("Referer"),"-");
		String agent = StringUtils.defaultIfEmpty(req.getHeader("User-Agent"),"-");
		
		////////-------------///////
		String fulUrl = URL;
		fulUrl += StringUtils.isNotEmpty(queryString)?"?"+queryString:queryString;
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fulUrl).append(":").append(referer).append(":").append(agent);
		
		logger.info("[Logger Filter] {}", sb.toString());
		chain.doFilter(request, response);
	}
		
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Filter에 들어왔다.");
	}


	@Override
	public void destroy() {
		logger.info("Filter를 나왔다.");
	}
}
