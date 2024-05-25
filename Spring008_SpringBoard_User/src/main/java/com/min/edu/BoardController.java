package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService service;
	
	//TODO 07_02 게시글 전체 조회 후 model로 값 전송
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("Welcome BoardController / boardList");
		List<BoardVo> lists =service.userBoardList();
		for (BoardVo vo : lists) {
			String content = vo.getContent();
			content.replace("<", "&lt");
			content.replace(">", "&gt");
			vo.setContent(content);
		}
		model.addAttribute("lists",lists);
		return "boardList";
	}
	
	//TODO 10_02 다중삭제 로직 후에 BoardList.do를 redirect
	@RequestMapping(value = "/multiDel.do",method=RequestMethod.POST)
	public String multidel(String[] chkVal) {
		logger.info("Welcome BoardController / multidel");
		Map<String, String[]> map = new HashMap<String,String[]>();
		map.put("seqs", chkVal);
		service.delFlagBoard(map);
		return "redirect:/boardList.do";
	}
	
	//TODO 11_02 새글 작성 화면으로 이동
	@RequestMapping(value="/insertBoard.do",method = RequestMethod.GET)
	public String insertBoard() {
		logger.info("Welcome BoardController / 새글 작성화면 이동");
		return "writeBoardForm";
	}
	
	//TODO 11_04 새글정보 입력 BoardVo 바인딩 하여 처리
	@RequestMapping(value="/insertBoard.do",method = RequestMethod.POST)
	public String insertBoard(BoardVo vo, HttpSession session) {
		logger.info("Welcome BoardController / 새글 작성 {} ",vo);
		vo.setId(((UserVo)session.getAttribute("loginVo")).getId());
		int n = service.writeBoard(vo);
		return (n==1)?"redirect:/boardList.do":"redirect:logout.do";
	}
	
	//TODO 12_02 글 상세보기
	@RequestMapping(value="/detailBoard.do",method = RequestMethod.GET)
	public String detailBoard(@RequestParam("seq")String id, Model model) {
		logger.info("WelcomeBoardController 상세글 보기 {}",id);
		BoardVo vo = service.getOneBoard(id);
		model.addAttribute("boardVo",vo);
		return "detailBoard";
	}
	
	//TODO 15_02 답글 작성화면으로 Parameter 전송 범위
	@RequestMapping(value="/replyInsert.do",method = RequestMethod.GET)
	public String replyInsert() {
		logger.info("WelcomeBoardController 답글 입력 폼");
		return "replyInsert";
	}
	
	//TODO 15-04 답글 입력
	@RequestMapping(value="/replyInsert.do",method = RequestMethod.POST)
	public String replyInsert(BoardVo vo, HttpSession session) {
		logger.info("WelcomeBoardController 답글 입력 {} ", vo);
		UserVo uVo=(UserVo) session.getAttribute("loginVo");
		vo.setId(uVo.getId());
		int n = service.reply(vo);
		if(n!=0) {
			return "redirect:/boardList.do";
		}else {
			return "redirect:/replyInset.do?chkVal="+vo.getSeq();
		}
	}
}
