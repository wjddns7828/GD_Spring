package com.min.edu;


import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
	@Autowired
	private JavaMailSender sender;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/mailForm.do")
	public String mail() {
		logger.info("MailController 메일폼 작성 화면 이동");
		return "mailForm";
	}
	
	@PostMapping("/mailSender.do")
	public String mailSender(@RequestParam Map<String,String> mailmap) {
		logger.info("mailController Mailsender.do 전송 값 : {} ",mailmap);
		//발신자의 메일 주소가 반드시 MimeMessage 객체에 입력이 되어 있어야함
		String setFrom = "juojuo9809@naver.com";
		
		//메일 내용을 전송하기 위한 객체 MimeMessage
		MimeMessage mail = sender.createMimeMessage();
		//MimeMessageHelper 전송을 처리해주는 객체 , MimeMessage(송신서버정보),첨부파일 여부 t/f, 글자 인코딩)
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setFrom(setFrom);//보내는 사람의 이메일 생략 불가능
			helper.setTo(mailmap.get("tomail"));//보낼 사람
			helper.setSubject(mailmap.get("title"));// 제목 생략 가능 
			helper.setEncodeFilenames(true);//첨부파일명 인코딩
			//본문의 내용 true를 체크하면 HTML 형식을 바인당
			helper.setText(mailmap.get("content"),true);
			
			//첨부파일 처리
			//MimeMessageHelper에서 2번째 옵션은 multipart이다
			FileSystemResource fileResource = new FileSystemResource("C:\\Users\\GDJ67\\Desktop");
			helper.addAttachment("고라파덕.png", fileResource);
			
			sender.send(mail);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/main.do";
	}
}
