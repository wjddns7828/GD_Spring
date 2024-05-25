package com.min.edu;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.min.edu.service.IBoardService;
import com.min.edu.vo.Board_Vo;
import com.min.edu.vo.User_Vo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestBoardController {
	
	@Autowired
	private IBoardService service;
	
	//TODO 21_07 글 수정 정보를 가져오는 REST 처리 ModifyFOrm
		//방식1) jackson bind라이브러리를 사용하는 방식
		//방식2) text를 통한 JSON 변경
												//TODO 22_07 답글시 부모글 정보를 가져옴
		@PostMapping(path={"/modifyForm.do","/replyForm.do"},produces = "application/text; charset=UTF-8")
		public String modifyform(String seq) {
			log.info("RESTBoardController 게시판 수정 REST 처리를 위한 modifyFOrm.do : {} ", seq);
			Board_Vo vo = service.getOneBoard(seq);
			//첫번째 방법 
			Gson gjson = new Gson();
//			JsonObject jsonObject = new JsonObject();
//			jsonObject.addProperty("seq", vo.getSeq());
//			jsonObject.addProperty("id", vo.getId());
//			jsonObject.addProperty("title", vo.getTitle());
//			jsonObject.addProperty("content", vo.getContent());
//			jsonObject.addProperty("regdate", vo.getRegdate());
//			String jsonString = gjson.toJson(jsonObject);
//			return jsonString;
			
			//두번째 방법
			String boardToJson = gjson.toJson(vo);
			return boardToJson;
			
		}
		
		
		//TODO 21_10 화면의 수정 modal에서 전달 받은 값을 처리하는 REST
		@PostMapping(path = "/modify.do")
		public Map<String,Object> modify(@RequestParam Map<String, Object> map){
			log.info("RESTBoardController 게시판 수정 REST 처리를 위한 modify.do : {} ", map);
			int n = service.setBoardUpdate(map);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("isc", n==1?"true":"false");
			return resultMap;
		}
		
		//TODO 22_10 화면의 답글 modal에서 전달받은 값을 DB에 처리하는 REST
		@PostMapping(value = "/reply.do")
		public Map<String,Object> reply(Board_Vo vo, HttpSession session){
			log.info("RESTBoardController 게시판 답글 업데이트 및 입력을위한 REST reply.do : {} ", vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			User_Vo loginVo = (User_Vo)session.getAttribute("loginVo");
			vo.setId(loginVo.getId());
			boolean isc =service.setReply(vo);
			resultMap.put("isc", isc);
			return resultMap;
		}
		
}
