package com.min.edu.anno04;

import org.springframework.stereotype.Component;

/**
 * TODO anno04_4_02 공통기능을 작성하고 @Componet를 선언하여 bean으로 등록 
 */
@Component
public class Radio implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("라디오를 켜다");

	}

	@Override
	public void powerOff() {
		System.out.println("라디오를 끄다");
	}
}
