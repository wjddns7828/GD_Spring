package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@Service
public class BoardServiceImpl implements IBoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public List<BoardVo> userBoardList() {
		logger.info("BoardServiceImpl 게시글 전체 조회");
		return dao.userBoardList();
	}

	@Override
	public int delFlagBoard(Map<String, String[]> map) {
		logger.info("BoardServiceImpl 게시글 다중 삭제");
		return dao.delFlagBoard(map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		logger.info("BoardServiceImpl 새글 작성");
		return dao.writeBoard(vo);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		logger.info("BoardServiceImpl 글 상세 조회");
		return dao.getOneBoard(seq);
	}

	@Override
	public int reply(BoardVo vo) {
		logger.info("BoardServiceImpl 답글 입력");
		int n = dao.replyUpdate(vo);
		int m =dao.replyInsert(vo);
		return (m>0||n>0)?1:0;
	}

	@Override
	public List<BoardVo> restoreBoard() {
		logger.info("BoardServiceImpl 삭제 글 리스트");
		return dao.restoreBoard();
	}

	@Override
	public int restoreDelfalg(String seq) {
		logger.info("BoardServiceImpl 삭제글 복구");
		return dao.restoreDelfalg(seq);
	}

}
