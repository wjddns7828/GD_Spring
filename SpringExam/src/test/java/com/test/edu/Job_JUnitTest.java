package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IJobDao;
import com.min.edu.model.mapper.IUserDao;
import com.min.edu.model.mapper.JobDaoImpl;
import com.min.edu.vo.JobsVo;
import com.min.edu.vo.UserVo;
import com.min.edu.vo.pageVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Job_JUnitTest {
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private IJobDao dao;
	
	@Autowired
	private IUserDao udao;
//	@Autowired
//	SqlSessionTemplate session;
	
//	@Test
//	public void db_ConnectTest() {
//		SqlSessionTemplate session = context.getBean("sqlSessionTemplate",SqlSessionTemplate.class);
//		List<JobsVo> lists = session.selectList("selAll");
//		assertNotNull(lists);
//	}
	
//	@Test
//	public void insertTest() {
//		List<JobsVo> lists = dao.selAll();
//		assertNotNull(lists);
//		JobsVo vo = new JobsVo("woo1n", "woo1on", 12314, 56178);
//		int n = dao.insertJob(vo);
//		assertNotNull(n);
//	}
	@Test
	public void testUser() {
//		UserVo vo = new UserVo("test01","test","1234","1234@naver.com");
//		int n = udao.regist(vo);
//		assertNotNull(n);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "test01");
//		map.put("password", "12334");
//		
//		UserVo vo = udao.login(map);
//		System.out.println(vo);
//		assertNotNull(vo);
//		
//		int n = udao.updatePassword(map);
//		assertNotNull(n);
		pageVo page = new pageVo();
		
		int n = udao.countuser();
		System.out.println(n);
		assertNotNull(n);
		
		page.setTotalCount(n);
		page.setCountList(3);
		page.setCountPage(5);
		page.setTotalPage(page.getTotalCount());
		page.setPage(3);
		page.setStartPage(1);
		page.setEndPage(1);
		
		System.out.println(page);
		System.out.println("start :"+(page.getPage()*page.getCountList()-(page.getCountList()-1)));
		System.out.println("end : "+(page.getPage()*page.getCountList()));
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", (page.getPage()*page.getCountList()-(page.getCountList()-1)));
		map.put("end", (page.getPage()*page.getCountList()));
		List<UserVo> vo = udao.selectUserList(map);
		System.out.println(vo);
		assertNotNull(vo);
	}
}
