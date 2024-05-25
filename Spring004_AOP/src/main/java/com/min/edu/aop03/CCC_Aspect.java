package com.min.edu.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CCC_Aspect {
	
	/**
	 * CC의 메소드가 실행 되기 전에 실행
	 */
	@Before("execution(public void com.min.edu.aop03.*.*(..))")
	public void beforeMethod() {
		System.out.println("메소드가 실행됩니다.");
	}
	
	/**
	 * CC의 메소드에 예외 발생 시 실행
	 */
	@AfterThrowing(pointcut = "execution(public void com.min.edu.aop03.*.*(..))", throwing = "e")
	public void exceptionMethod(Exception e) {
		System.out.println("메소드의 예외가 발생했습니다."+e.getMessage());
	}
	
	/**
	 * CC의 메소드가 종료되었을 때 실행
	 */
	@After("execution(public void com.min.edu.aop03.CTO.*(..))")
	public void afterMethod() {
		System.out.println("CTO메소드가 종료되었습니다,");
	}
}
