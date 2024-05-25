package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {
	public UserVo getLogin(Map<String,Object> map);
	public int isDupulicateCheck(String id);
	public int signUpMember(UserVo vo);
	public List<UserVo> UserSelectAll();
	public UserVo UserSelectOne(String id);
	public List<UserVo> getSearchUser(UserVo vo);
	public String findID(Map<String,Object> map);
	public String pwChk(Map<String,Object> map);
	
	//과제//
	
	//권한수정
	public int changeAuthToA(Map<String,Object> map);
	public int changeAuthToU(Map<String,Object> map);
	
	//휴면계정
	public int changeDelflagToN(Map<String,Object> map);
	public int changeDelflagToY(Map<String,Object> map);
	
	public List<UserVo> getAllUser();
}
