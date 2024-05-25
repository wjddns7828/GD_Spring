package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;
@Repository
public class UserDaoImpl implements IUserDao {
	
	private String NS = "com.min.edu.model.mapper.UserDaoImpl.";
	
	@Autowired
	public SqlSessionTemplate session;

	@Override
	public int regist(UserVo vo) {
		return session.insert(NS+"regist",vo);
	}

	@Override
	public UserVo login(Map<String, Object> map) {
		return session.selectOne(NS+"login",map);
	}

	@Override
	public List<UserVo> selectUserList(Map<String,Object> map) {
		return session.selectList(NS+"selectUserList",map);
	}

	@Override
	public int updatePassword(Map<String, Object> map) {
		return session.update(NS+"updatePassword",map);
	}

	@Override
	public int countuser() {
		return session.selectOne(NS+"countUser");
	}

}
