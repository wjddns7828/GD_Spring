package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

@Repository
public class BoardDaoImpl implements IBoardDao {

	private String NS="com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<BoardVo> userBoardList() {
		return session.selectList(NS+"userBoardList");
	}

	@Override
	public int delFlagBoard(Map<String, String[]> map) {
		return session.update(NS+"delFlagBoard",map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		return session.insert(NS+"writeBoard",vo);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		return (BoardVo) session.selectList(NS+"getOneBoard",seq).get(0);
	}

	@Override
	public int replyUpdate(BoardVo vo) {
		return session.update(NS+"replyUpdate",vo);
	}

	@Override
	public int replyInsert(BoardVo vo) {
		return session.insert(NS+"replyInsert",vo);
	}

	@Override
	public List<BoardVo> restoreBoard() {
		return session.selectList(NS+"restoreBoard");
	}

	@Override
	public int restoreDelfalg(String seq) {
		return session.update(NS+"restoreDelfalg",seq);
	}

}
