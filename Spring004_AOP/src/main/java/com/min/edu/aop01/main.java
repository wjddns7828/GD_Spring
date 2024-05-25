package com.min.edu.aop01;
//◆ 주기능의 상세 밑 반복적으로 실행되는 기능
//★ 실질적으로 실행되어야 하는 주 기
public class main {
	public static void main(String[] args) {
		System.out.println("프로그램을 실행 시킨디");
		Homework work = new Homework();
		work.workProcess();
		
		System.out.println("프로그램을 종료 시킨다.");
	}
}
