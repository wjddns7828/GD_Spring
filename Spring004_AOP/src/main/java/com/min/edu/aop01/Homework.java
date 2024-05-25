package com.min.edu.aop01;

public class Homework {
	
	//◆ 주기능의 상세 밑 반복적으로 실행되는 기능
	//★ 실질적으로 실행되어야 하는 주 기능
	
	public void workProcess() {
		System.out.println("◆ 업무를 시작하기 위한 준비 운동");
		
		
		try {
			System.out.println("★ 업무를 시작한다.");
		} catch (Exception e) {
			System.out.println("◆ 업무가 힘들 때 조퇴한다");
		}finally {
			
		}
	}
}
