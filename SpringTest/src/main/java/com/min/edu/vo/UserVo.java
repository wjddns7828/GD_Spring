package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String delflag;
	private String joindate;
	
	private String otp;
	private String keyword;
}
