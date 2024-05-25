package com.min.edu.anno04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno04_Main {
	public static void main(String[] args) {
		ApplicationContext anno04 = new ClassPathXmlApplicationContext("com/min/edu/anno04/anno04_bean.xml");
		IFunction r =  anno04.getBean("radio",IFunction.class);
		IFunction t = anno04.getBean("samasung",IFunction.class);
		r.powerOn();
		t.powerOff();
		
		//@Component(value="")를 작성하면 클래스의 명명법을 따라가지 않음
		IFunction t2 = anno04.getBean("television",IFunction.class);
		t2.powerOn();
	}
}
