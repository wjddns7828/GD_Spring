package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {

	private String NS="com.min.edu.model.mapper.UserDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public UserVo getLogin(Map<String, Object> map) {
		return (UserVo) session.selectList(NS+"getLogin",map).get(0);
	}

	@Override
	public int isDupulicateCheck(String id) {
		return session.selectOne(NS+"isDupulicateCheck",id);
	}

	@Override
	public int signUpMember(UserVo vo) {
		return session.insert(NS+"signUpMember",vo);
	}

	@Override
	public List<UserVo> UserSelectAll() {
		return session.selectList(NS+"UserSelectAll");
	}

	@Override
	public UserVo UserSelectOne(String id) {
		return session.selectOne(NS+"UserSelectOne",id);
	}

	@Override
	public List<UserVo> getSearchUser(UserVo vo) {
		return session.selectList(NS+"getSearchUser",vo);
	}

	@Override
	public String findID(Map<String, Object> map) {
		return session.selectOne(NS+"findID",map);
	}

	@Override
	public String pwChk(Map<String, Object> map) {
		return session.selectOne(NS+"pwChk",map);
	}

	@Override
	public int changeAuthToA(Map<String, Object> map) {
		return 0;
	}

	@Override
	public int changeAuthToU(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changeDelflagToN(Map<String, Object> map) {
		return 0;
	}

	@Override
	public int changeDelflagToY(Map<String, Object> map) {
		return 0;
	}

	@Override
	public List<UserVo> getAllUser() {
		return session.selectList(NS+"UserSelectAll");
	}

}
