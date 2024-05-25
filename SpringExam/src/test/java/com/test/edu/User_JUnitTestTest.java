package com.test.edu;

import static org.junit.Assert.*;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class User_JUnitTestTest {
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private IUserDao dao;
	
	@Test
	public void test() {
		UserVo vo = new UserVo("test01","test","1234","1234@naver.com");
		int n = dao.regist(vo);
		assertNotNull(n);
	}
}
