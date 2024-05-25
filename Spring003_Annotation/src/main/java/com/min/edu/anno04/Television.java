package com.min.edu.anno04;

import org.springframework.stereotype.Component;

/**
 * TODO anno04_4_03 공통기능을 작성하고 @Componet를 선언하여 bean으로 등록 
 */
@Component(value="samasung")
public class Television implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("TV를 켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("TV를 끄다");
	}
}
