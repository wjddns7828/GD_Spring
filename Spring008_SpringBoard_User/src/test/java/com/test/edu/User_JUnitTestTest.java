package com.test.edu;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.aes.Encrypt_AES;
import com.min.edu.model.mapper.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class User_JUnitTestTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private IUserDao dao;
	
//	@Test
//	public void getLogin() {
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("id", "user");
//		map.put("password", "1234");
//		UserVo vo = dao.getLogin(map);
//		System.out.println(vo.toString());
//		assertNotNull(vo);
//	}
	
//	@Test
//	public void isDupulicateCheck() {
//		int n = dao.isDupulicateCheck("user");
//		assertNotNull(n);
//	}
	
//	@Test
//	public void signUpMember() {
//		UserVo vo = new UserVo("woon","임정운", "1234", "wjddns7828@naver.com", null, null, null, null, null);
//		int n = dao.signUpMember(vo);
//		assertEquals(n, 1);
//	}

//	@Test
//	public void UserSelectAll() {
//		List<UserVo> lists = dao.UserSelectAll();
//		System.out.println(lists);
//		assertNotNull(lists);
//	}
	
//	@Test
//	public void UserSelectOne() {
//		UserVo vo = dao.UserSelectOne("woon");
//		System.out.println(vo);
//		assertNotNull(vo);
//	}
	
//	@Test
//	public void getSearchUser() {
//		UserVo vo = new UserVo();
//		
////		vo.setKeyword("woon");
////		vo.setOpt("id");
//		
//		vo.setKeyword("임정운");
//		vo.setOpt("name");
//		List<UserVo> lists = dao.getSearchUser(vo);
//		System.out.println(lists);
//		assertNotNull(lists);
//	}
	
//	@Test
//	public void findId() {
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("name", "임정운");
//		map.put("email", "wjddns7828@naver.com");
//		String id = dao.findID(map);
//		System.out.println(id);
//		assertNotNull(id);
//	}
	
//	@Test
//	public void pwChk() {
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("id", "woon");
//		String pw = dao.pwChk(map);
//		assertNotNull(pw);
//	}
	//암호화 복호화 테스트
	@Test
	public void crypto() throws Exception{
		Encrypt_AES en = new Encrypt_AES();
		String pwEncode = en.encrypt("1234");
		System.out.println("암호화 된 1234 : "+pwEncode);
		
		String pwDecode = en.decrypt(pwEncode);
		System.out.println("복호화 된 1234 : "+pwDecode);
		
		assertTrue(true);
	}
}