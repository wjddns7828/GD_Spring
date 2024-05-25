package com.min.edu.aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO AOP06 06_03 Aspect를 Bean으로 등록하기 위해 @Component를 사용
 * 						MyAspect 클래스를 @Aspect로 선언해서 CCC로 작성이 될 수 있도록 함 : Auto-Proxy의 대상이 될 수 있게 함
 */

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public void com.min.edu.aop06.LeftBrain.*(..))")
	public void usePointCutLeftBrain() {}
	
	@Pointcut("execution(public void com.min.edu.aop06.RightBrain.*(..))")
	public void usePointCutRightBrain() {}
	
	@Pointcut("execution(public void com.min.edu.aop06.*.*(..))")
	public void userPointCutBrain() {}
	
	@Before("userPointCutBrain()")
	public void before() {
		System.out.println("메소드 시작 전 공통으로 작성");
	}
	
	@After("usePointCutLeftBrain()")
	public void afterLeft() {
		System.out.println("난 왼쪽 뇌가 생각하는 오른쪽");
	}
	
	@After("usePointCutRightBrain()")
	public void afterRight() {
		System.out.println("난 오른쪽 뇌가 생각하는 왼쪽");
	}
	
	   @AfterReturning(pointcut = "execution(public * *(..))", returning = "returnValue")
	   public void afterReturning(JoinPoint join, String returnValue) {
	      System.out.println("####"+join.getSignature().getName()+"####");
	      Object[] args = join.getArgs();
	      for (Object o : args) {
	         System.out.println("메소드를 실행하기 위한 argument : "+(String)o);
	      }
	      System.out.println("반환되는 결과 : "+returnValue);
	   }
}
