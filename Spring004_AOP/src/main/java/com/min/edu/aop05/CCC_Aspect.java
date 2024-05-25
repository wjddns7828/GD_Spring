package com.min.edu.aop05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CCC_Aspect {
	
	@Pointcut("execution(public * *(..))")
	public void myPointcut() {}
	
	@Before("myPointcut()")
	public void beforeMethod() {
		System.out.println("메소드가 실행되었습니다,");
	}
	
	@AfterThrowing(pointcut = "myPointcut()",throwing = "e")
	public void exceptionMethod(Exception e) {
		System.out.println("메소드의 예외가 발생했습니다."+e.getMessage());
	}
	@After("myPointcut()")
	public void afterMethod() {
		System.out.println("CTO메소드가 종료되었습니다,");
	}
}
