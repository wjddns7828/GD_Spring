package com.min.edu.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.Board_Vo;

public interface IBoardDao {
	
	public List<Board_Vo> getAllBoardPage(Map<String, Object> map);
	public int getAllBoardCount(Map<String, Object> map);
	
	//TODO 20_03 Interface Board Service selBoardDelFlag
		public int selBoardDelFlag(String seq);
		
		public Board_Vo getOneBoard(String seq);
		
		public int setBoardUpdate(Map<String,Object> map);
		
	//TODO 22_03 setReplyUpdate, 값 입력
		public int setReplyUpdate(Board_Vo vo);
		public int setReplyInsert(Board_Vo vo);
}
