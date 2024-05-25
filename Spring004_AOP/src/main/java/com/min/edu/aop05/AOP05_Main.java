package com.min.edu.aop05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP05_Main {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop05/AOP-context.xml");
		IHumanwork c =  appContext.getBean("employee",IHumanwork.class);
		c.work();
	}
}
