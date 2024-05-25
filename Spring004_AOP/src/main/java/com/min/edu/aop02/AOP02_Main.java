package com.min.edu.aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.min.edu.aop03.Employee;

public class AOP02_Main {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop02/AOP-Context.xml");
		
		//Spring bean에 의해서 auto-Proxy된 객체는 java의 객체가 아니다 jdk.proxy2.$proxy4
		
		IHumanwork emp = appContext.getBean("employee",IHumanwork.class);
		emp.work();
	}
}
