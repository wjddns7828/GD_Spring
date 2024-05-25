package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@Service
public class USerServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(USerServiceImpl.class);
	
	@Override
	public UserVo getLogin(Map<String, Object> map) {
		logger.info("USerServiceImpl {} 로그인 getLogin",map);
		return dao.getLogin(map);
	}

	@Override
	public int isDupulicateCheck(String id) {
		logger.info("USerServiceImpl회원가입 중복체크 isDupulicateCheck {} ",id);
		return dao.isDupulicateCheck(id);
	}

	@Override
	public int signUpMember(UserVo vo) {
		logger.info("USerServiceImpl 회원가입 signUpMember{} ",vo);
		return dao.signUpMember(vo);
	}

	@Override
	public List<UserVo> UserSelectAll() {
		logger.info("USerServiceImpl 사용 가능 사용자 조회 UserSelectAll {} ");
		return dao.UserSelectAll();
	}

	@Override
	public UserVo UserSelectOne(String id) {
		logger.info("USerServiceImpl 사용자 상세 조회 UserSelectOne {} ",id);
		return dao.UserSelectOne(id);
	}

	@Override
	public List<UserVo> getSearchUser(UserVo vo) {
		logger.info("USerServiceImpl 회원검색 아이디 혹은 성명 getSearchUser {} / {} ",vo.getOpt(),vo.getKeyword());
		return dao.getSearchUser(vo);
	}

	@Override
	public String findID(Map<String, Object> map) {
		logger.info("USerServiceImpl 아이디 찾기 findID {} ",map);
		return dao.findID(map);
	}

	@Override
	public String pwChk(Map<String, Object> map) {
		logger.info("USerServiceImpl 비밀번호 ckwrl pwChk {} ",map);
		return dao.pwChk(map);
	}

	@Override
	public int changeAuthToA(Map<String, Object> map) {
		logger.info("USerServiceImpl {} ");
		return 0;
	}

	@Override
	public int changeAuthToU(Map<String, Object> map) {
		logger.info("USerServiceImpl {} ");
		return 0;
	}

	@Override
	public int changeDelflagToN(Map<String, Object> map) {
		logger.info("USerServiceImpl {} ");
		return 0;
	}

	@Override
	public int changeDelflagToY(Map<String, Object> map) {
		logger.info("USerServiceImpl {} ");
		return 0;
	}

	@Override
	public List<UserVo> getAllUser() {
		logger.info("USerServiceImpl {} ");
		return dao.getAllUser();
	}
	
}
