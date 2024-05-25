package com.min.edu.anno05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno05_Main {

	public static void main(String[] args) {
		ApplicationContext anno05 = new ClassPathXmlApplicationContext("com/min/edu/anno05/anno05_bean.xml");
		
		//TODO anno05 05_03 주입을 하지않고 실행 시
//		School obj = anno05.getBean("school",School.class);
//		System.out.println(obj);
		
		//TODO anno05 05_04 @Qulifier에 stu01을 value로 작성
//		School obj = anno05.getBean("school",School.class);
//		System.out.println(obj);
		
		//TODO anno05 05_05 @Resource
		School obj = anno05.getBean("school",School.class);
		System.out.println(obj);
	}
}
