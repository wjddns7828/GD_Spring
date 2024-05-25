package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao udao;

	@Override
	public int regist(UserVo vo) {
		return udao.regist(vo);
	}

	@Override
	public UserVo login(Map<String, Object> map) {
		return udao.login(map);
	}

	@Override
	public int updatePassword(Map<String, Object> map) {
		return udao.updatePassword(map);
	}

	@Override
	public List<UserVo> selectUserList(Map<String, Object> map) {
		return udao.selectUserList(map);
	}

	@Override
	public int countuser() {
		return udao.countuser();
	}
	
	
}
