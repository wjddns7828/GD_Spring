package com.min.edu.aop02;

import com.min.edu.aop02.IHumanwork;

public class CTO implements IHumanwork {
	/*
	 * TODO AOP02 02_02 주 기능을 구현함
	 */
	@Override
	public void work() {
		System.out.println("^^^^^^기술 연구 부서는 항상 신기술을 연구 합니다.");
	}

}
