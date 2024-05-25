package com.min.edu;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.IEduBoardService;
import com.min.edu.vo.EduVo;

@Controller
public class EduBoardController {
	private static final Logger logger = LoggerFactory.getLogger(EduBoardController.class);
	
	@Value("${driver}")
	private String driver;
	
	@Autowired
	private IEduBoardService service;
	
	//TODO 06_02 GET방식으로 호출하여 MVC 모델을 VMI하여 사용함
	@RequestMapping(value="/selectBoard.do",method = RequestMethod.GET)
	public String selectBoard(Model model) {
		logger.info("■■■■EduBoardController selectBoard {}■■■■",new Date());
		List<EduVo> lists = service.selectBoard();
		model.addAttribute("lists", lists);
		return "boardList";
	}
	
	//TODO 07_02 POST방식으로 전송된 값을 Spring의 Binding을 통해서 자동으로 Dto의 객체로 만들어 줌(setter)
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(EduVo vo) {
		logger.info("■■■■EduBoardController insertBoard {}■■■■",new Date());
		logger.info("■■■■Vo의 setter를 통해서 자동으로 parameter 받고 생성{}■■■■",vo);
		int n = service.insertBoard(vo);

		if(n>0) {
			return "redirect:/selectBoard.do";
		}else {
			return "error";
		}
	}
	
	//TODO 08_02 객체를 맵핑할 DTO/Vo가 없는 경우 Map으로 사용하여 name:value의 Map객체를 사용 할 수 있다.
	@RequestMapping(value="/insertBoardMap.do",method = RequestMethod.POST)
	public String insertBoardMap(@RequestParam Map<String,Object> parammap) {
		logger.info("■■■■EduBoardController insertBoardMap {}■■■■",new Date());
		logger.info("■■■■String의 @RequestParam을 통해 Map으로 입력받아 사용한다{}■■■■",parammap);
		return "redirect:/selectBoard.do";
	}
	
	//TODO 09_02 전송되는 name을 변경하여 다른 변수에 Bind하여 사용
	//				값이 null이거나 없을 경우 default 값을 입력 할 수 있다
	/**
	 * @RequestParam(value="화면의 name", defaultValue="null이면 입력되는 값" String 사용변수
	 * 사용처 : Paging
	 * 만약 입력되는 변수가 pagin처리 때 처럼 처음 호출되는 ㄱ밧이 없다면 예외를 발생시킴
	 * 따라서 반드시 defaultValue를 성정을 통해서 값을 초기화 해줘야함
	 */
	@RequestMapping(value="/insertBoardRequestParam.do",method=RequestMethod.POST)
	public String insertBoardRequestParam(
			@RequestParam("a") String id,
			@RequestParam("b") String title,
			@RequestParam("c") String content,
			@RequestParam(value="page", defaultValue="1") int paging
			) {
		logger.info("■■■■ [EduBoardController insertBoardRequestParam {}■■■■",new Date());
		logger.info("■■■■ [@RequestParam으로 값 처리 a :{}]			■■■■",id);
		logger.info("■■■■ [@RequestParam으로 값 처리 b : {}]		■■■■",title);
		logger.info("■■■■ [@RequestParam으로 값 처리 c : {}]		■■■■",content);
		logger.info("■■■■ [@RequestParam으로 값 처리 pagin : {}]	■■■■",paging);
		return "redirect:/selectBoard.do";		
	}
	
	//TODO 10_02 요청된 주소에서 @PathVariable와 {}를 통해서 특정 부분을 값으로 사용 할 수 있음
	@RequestMapping(value="/com/min/edu/{login}/paramvalue.do",method = RequestMethod.POST)
	public String pathVariable(@PathVariable("login")String path) {
		logger.info("context:property-placeholder를 통해서 사용하는 값 : {}",driver);
		return path+"/main";
	}
	
	//TODO 11_04 Spring에서 Transaction은 auto-proxy에 의해서 Spring이 제어권을 가짐
	
	@RequestMapping(value="/transaction.do",method = RequestMethod.POST)
	public String transaction(EduVo vo) {
		logger.info("■■■■ [EduBoardController transaction {}■■■■",new Date());
		logger.info("■■■■ [ 받은 vo 값 : {} ] ■■■■",vo);
		int n = service.transactionTest(vo);
		logger.info("■■■■ [ 트랜잭션 완료 처리 : {} ] ■■■■",n);
		return "redirect:/selectBoard.do";
	}
}
