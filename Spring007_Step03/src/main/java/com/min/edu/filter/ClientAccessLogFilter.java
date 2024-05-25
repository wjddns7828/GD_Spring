package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientAccessLogFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Client 요청 정보 Filter 시작");
	}
	/**
	 * import javax.servlet.filter 사용하려면 선택 할 수 있는 클래스가 두개가 나옴
	 * 1) 외부의 WAS 인 tomcat9.0에 있는 라이브러리
	 * 2) Maven dependency에 선언된 serlvet-api에 있는 라이브러리
	 * 
	 * pom.xml의 scope 만약 provide로 되어있기 떄문에 시스템의 maven사용이 가능하도록 만들었다
	 * 현재 WAS의 라이브러리를 서택
	 *  > 배포하게 배포 서버의 WAS를 사용하기 떄문
	 * 
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String remoteAddr = req.getRemoteAddr();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String userAgent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr)
			.append(":")
			.append(url)
			.append("?")
			.append(queryString)
			.append(":")
			.append(referer)
			.append(":")
			.append(userAgent);
		logger.info("[Client FilterLogger] {}",sb.toString());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("Client 요청 정보 Filter 종료");
	}

}
