package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserService {
	
	//로그인
	public UserVo getLogin(Map<String,Object> map);
	//회원가입 중복체크
	public int isDupulicateCheck(String id);
	//회원가입
	public int signUpMember(UserVo vo);
	//사용 가능 사용자 조회
	public List<UserVo> UserSelectAll();
	//사용자 상세 조회
	public UserVo UserSelectOne(String id);
	//회원검색 아이디 혹은 성명
	public List<UserVo> getSearchUser(UserVo vo);
	//아이디 찾기 email과 이름
	public String findID(Map<String,Object> map);

	//비밀번호 찾기
	public String pwChk(Map<String,Object> map);
	
	//과제//
	
	//권한수정
	public int changeAuthToA(Map<String,Object> map);
	public int changeAuthToU(Map<String,Object> map);
	
	//휴면계정
	public int changeDelflagToN(Map<String,Object> map);
	public int changeDelflagToY(Map<String,Object> map);
	
	//전체 사용자 조회
	public List<UserVo> getAllUser();
}
