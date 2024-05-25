package com.min.edu.anno06;
/**
 * name 맴버필드를 가지고 있는 DTO POJO
 */
public class UserDto {
	private String name;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
