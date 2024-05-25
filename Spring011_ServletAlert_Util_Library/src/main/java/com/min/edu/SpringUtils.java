package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Spring Framewokr 프로젝트의 Controller에서 Alert를 호출하기 위한 ServletAlert
 * 
 * @since 2023. 08. 24
 * @author JeonWoon
 *
 */

public class SpringUtils {
	/**
	 * 반환되는 Response에 이동 URL과 메시지를 전달하여 Script를 통해 alert을 동작하는 메소드
	 * @param resp 브라우저에 응답 해주는 객체
	 * @param msg alert에 메시지 전달
	 * @param url 이동 경로
	 * @throws IOException
	 */
	
	public static void servletAlert(HttpServletResponse resp,
									String msg, String url) throws IOException {
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		out.printf("<script>alert('%s'); location.href='./%s';</script>",msg,url);
		out.flush();
	}
}
