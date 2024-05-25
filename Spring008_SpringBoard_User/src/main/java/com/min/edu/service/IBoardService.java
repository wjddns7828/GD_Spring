package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	
	//게시글 조회
	public List<BoardVo> userBoardList();
	
	//게시글 다중 삭제
	public int delFlagBoard(Map<String, String[]> map);
	
	//새글 작성
	public int writeBoard(BoardVo vo);

	//글 상세조회
	public BoardVo getOneBoard(String seq);

	//답글 입력
	public int reply(BoardVo vo);
	
	//삭제 글 조회
	public List<BoardVo> restoreBoard();

	//삭제 글 복구
	public int restoreDelfalg(String seq);
}
