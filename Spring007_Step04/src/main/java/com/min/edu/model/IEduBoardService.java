package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.EduVo;

public interface IEduBoardService {

	public List<EduVo> selectBoard();
	public int insertBoard(EduVo vo);
	
	// updateBoard와 insertBoard를 실행해서 둘중에 하나라도 오류가 발생한다면
	//실행되는 dao를 모두 rollback을 제어
	public int transactionTest(EduVo vo);
}
