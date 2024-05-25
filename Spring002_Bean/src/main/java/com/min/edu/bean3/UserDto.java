package com.min.edu.bean3;

import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Required;

public class UserDto {
	
	private String name;
	private Properties per;
	private Date myDate;
	private String hobby;
	
	public UserDto(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", per=" + per + ", myDate=" + myDate + ", hobby=" + hobby + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getPer() {
		return per;
	}

	public void setPer(Properties per) {
		this.per = per;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String getHobby() {
		return hobby;
	}
	
//	@Required
	/**
	 * 생성자 주입을 통해서 필수적으로 입력이 되도록 앙요하기 위한 annotation이다
	 * 하지만 @Resuired는 Springframework 버전 5.1 이후에는 사용되지 않고 있다
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
