package com.min.edu.aop06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP06_Main {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop06/AOP-Context.xml");
		
//		IPerson lb = appContext.getBean("leftBrain",IPerson.class);
//		lb.thinking();
//		IPerson lb = appContext.getBean("rightBrain",IPerson.class);
//		lb.thinking();
		
		System.out.println("--VMI에 선언하지않은 use(String action) 실행----");
		RightBrain rbVMI = appContext.getBean("rightBrain",RightBrain.class);
		/**
		 * Spring Framwork는 기본 구성이 interface를 통한 vmi실행을 기본으로 한다
		 * rightbrain의 use()메소드는 interface인 Iperson에 작성되어 있지않기 떄문에 문제가 발생됨 
		 * 이를 해결하기 위해서는 Auto-proxy의 설정을
		 * proxy-target-class=true 로 설정해주면 된다
		 * java객채의 생성은 invocationHandler
		 */
		rbVMI.use("생각해본다");
	}
}
