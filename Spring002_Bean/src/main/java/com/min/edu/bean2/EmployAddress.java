package com.min.edu.bean2;

public class EmployAddress {
	private String name;
	private String address;
	private String phone;
	public EmployAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployAddress(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "EmployAddress [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
