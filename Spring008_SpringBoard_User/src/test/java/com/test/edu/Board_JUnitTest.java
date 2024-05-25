package com.test.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Board_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private IBoardDao dao;
	
	@Before
	public void db_connectTest() {
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate",SqlSessionTemplate.class);
		assertNotNull(session);
	}
	
//	@Test
//	public void userBoardListTest() {
//		List<BoardVo> lists = dao.userBoardList();
//		System.out.println(lists);
//		assertNotNull(lists);
//	}
	
//	@Test
//	public void delFlagBoard() {
//		Map<String,String[]> map = new HashMap<String, String[]>();
//		map.put("seqs", new String[] {"100","101"});
//		int n = dao.delFlagBoard(map);
//		assertEquals("삭제 범위",2,n,0);
//	}
	
//	@Test
//	public void writeBoard() {
//		BoardVo vo = new BoardVo(0, "포도3", "포도열림3", "포도밭3", 0, 0, 0, null, null);
//		int n = dao.writeBoard(vo);
//		System.out.println(vo.getSeq());
//		assertEquals("입력 후",1,n,0);
//	}
	
//	@Test
//	public void getOneBoard() {
//		BoardVo vo = dao.getOneBoard("183");
//		System.out.println(vo);
//		assertNotNull(vo);
//	}
	
	
//	!!
//	@Test
//	public void replyUpdate() {
//		BoardVo vo = new BoardVo(183, "비", "비가많이온다", "태풍이 지나가니 더 온다", 0, 0, 0, null, null);
//		int n = dao.replyUpdate(vo);
//		assertEquals(n, 0);
//	}
////	!!
//	@Test
//	public void replyInsert() {
//		BoardVo vo = new BoardVo(183, "비", "비가많이온다", "태풍이", 0, 0, 0, null, null);
//		int n = dao.replyInsert(vo);
//		assertEquals(n, 1);
//	}
	
	
//	@Test
//	public void restoreBoard() {
//		List<BoardVo> lists = dao.restoreBoard();
//		assertNotNull(lists);
//	}
//	@Test
//	public void retoreDelfalg() {
//		int n = dao.restoreDelfalg("100");
//		assertEquals(n, 1);
//	}
	
	
	
	
	
}
