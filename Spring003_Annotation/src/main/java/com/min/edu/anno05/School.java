package com.min.edu.anno05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * TODO anno05 05_02 주입방법에 따라서 받는 맴버필드 객체
 *		작성된 bean을 주입(DI)하기 위해서는 반드시 Spring Bean Configuration에 <context:annotation-config>을 선언해줘야함  
 */
public class School {
	
//	@Autowired //생성된 bean이 단 한개만 있을 경우 자동으로 DI를 함, 여러개의 경우에는 사용이 불가능함

//	@Autowired(required = false)// (required = false)==> 주입되는 객체(필수 값)이 없다면 null로 만들어 줌

//	@Autowired
//	@Qualifier("stu01") //생성된 여러개의 같은 타입 bean중에서 해당 ID의 bean을 주입해줌
	
	@Resource(name = "stu02") //Qulifier의 사용도 가능하지만 name을 통해 특정 bean을 주입
//	@Qualifier("stu01")
	private Student student;
	
	private int grade;
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	public School(Student student, int grade) {
		super();
		this.student = student;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "School [student=" + student + ", grade=" + grade + "]";
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
