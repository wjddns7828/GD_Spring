package com.min.edu;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.service.IUserService;
import com.min.edu.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Edubook_JUnit {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IUserService service;
	
//	@Autowired
//	private ApplicationContext context;
	
	@Before
	public void test() {
		assertNotNull(sqlSession);
	}
	@Test
	public void login() {
		UserVO vo = new UserVO();
		vo.setId("hello");
		vo.setPassword("1234");
		UserVO vvo = service.login(vo);
		System.out.println(vvo);
		assertNotNull(vvo);
	}
}
