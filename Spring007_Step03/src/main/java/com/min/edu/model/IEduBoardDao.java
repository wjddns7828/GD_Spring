package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.EduVo;

public interface IEduBoardDao {
	
	//전체 조회
	public List<EduVo> selectBoard();
	
	//새글 작성(트랜잭션a)
	public int insertBoard(EduVo vo);
	
	//전체 글 delFlag수정 (트랜잭션a)
	public int updateBoard();
}
