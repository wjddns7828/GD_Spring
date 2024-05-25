package com.min.edu.aop02;

import com.min.edu.aop02.IHumanwork;

public class Employee implements IHumanwork {
	/*
	 * TODO AOP02 02_02 주 기능을 구현함
	 */
	@Override
	public void work() {
		System.out.println("@ 회사원의 주 기능인 점심식사를 합니다.");
	}

}
