package com.min.edu.aop04;

public class CCC_Aspect {
	
	/**
	 * CC의 메소드가 실행 되기 전에 실행
	 */
	public void beforeMethod() {
		System.out.println("메소드가 실행되었습니다,");
	}
	
	/**
	 * CC의 메소드에 예외 발생 시 실행
	 */
	public void exceptionMethod(Exception e) {
		System.out.println("메소드의 예외가 발생했습니다."+e.getMessage());
	}
	
	/**
	 * CC의 메소드가 종료되었을 때 실행
	 */
	public void afterMethod() {
		System.out.println("CTO메소드가 종료되었습니다,");
	}
}
