package com.min.edu.vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	
	private static final long serialVersionUID = 406540286589334313L;
	
	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String delflag;
	private String joindate;
	public UserVO(String id, String name, String password, String email, String auth, String delflag, String joindate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.auth = auth;
		this.delflag = delflag;
		this.joindate = joindate;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", auth=" + auth
				+ ", delflag=" + delflag + ", joindate=" + joindate + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
}
