package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {
	
	public int regist(UserVo vo);
	
	public UserVo login(Map<String,Object> map);
	
	public int updatePassword(Map<String,Object>map);

	List<UserVo> selectUserList(Map<String, Object> map);
	
	public int countuser();

}
