package com.min.edu.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean1_Main {

	public static void main(String[] args) {
		//SpringContainer가 시작 될 떄 Spring Bean Configuration을 사용하여 bean을 객체로 만들어 사용
		ApplicationContext bean1 = new ClassPathXmlApplicationContext("com/min/edu/bean1/bean1.xml");
		IMessageBean coffe =  (IMessageBean) bean1.getBean("Arabica", IMessageBean.class);//한개는 이름만, 캐스팅될 객체
		coffe.call();
	}

}
