package com.min.edu.anno06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno06_Main {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/anno06/anno06_bean.xml");
		
//		UserServiceImpl user = bean.getBean("userServiceImpl",UserServiceImpl.class);
//		user.addUser();
		
		UserServiceImpl2 user2 = bean.getBean("userServiceImpl2",UserServiceImpl2.class);
		user2.addUser();
	}

}
