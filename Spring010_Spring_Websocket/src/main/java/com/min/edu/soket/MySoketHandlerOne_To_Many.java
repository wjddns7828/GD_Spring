package com.min.edu.soket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component(value = "wsChat.do")
public class MySoketHandlerOne_To_Many extends TextWebSocketHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ArrayList<WebSocketSession> list; // 웹 소켓 세션을 담아주는 객체(참여하는 모든 세션 채팅 대상을 담음)
	private Map<WebSocketSession, String> map = new HashMap<WebSocketSession, String>();// webSoketSession에 mapping된
																						// 이름(nickName)

	public MySoketHandlerOne_To_Many() {
		list = new ArrayList<WebSocketSession>();
	}

	// Client화면에서 WebSoket객체를 생성 했을 때 호출 => ws.onopen
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Web Soket Connection 객체 생성 afterConntectionEstablished & WebSoketSession 생성");
		logger.info("방금 참여한 WebSoketSession 정보 : {}", session.getId());
		super.afterConnectionEstablished(session);
		list.add(session); // 현재 참여한 WebSoketSession을 Session목록에 담아줌
		logger.info("현재 참여하고 있는 WebSoketSession의 갯수 : {}", list.size());
		Map<String, Object> map = session.getAttributes();
		logger.info("------------------------------------------session.getAttributes()-------------------------\n{}",
				map);
	}

	// Client화면에서 WebSoket객체가 닫겼을 때 => ws.onclose
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("웹소켓 세션 삭제 afterConnectionClosed");
		super.afterConnectionClosed(session, status);
		logger.info("웹소켓 세션 삭제 대상 : {}", session);
		list.remove(session);
		logger.info("현재 입력되어있는 객체의 수 closed : {}", list.size());
		// 화면에 메세지 보내기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String out = sdf.format(new Date());
		for (WebSocketSession s : list) {
			s.sendMessage(new TextMessage("<font style='color:red;'>"+map.get(session)+"님이 방을 나갔ㅅ브니다.(" + out + ")</font>"));
		}
		logger.info("웹소캣 세션 이름 삭제 : {}", map.get(session));
		map.remove(session);
	}

	// Clinet에서 Message를 전달받아 모든 참여 WebSoketSession에 Broadcasting을 해줄 떄 =>ws.send
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("웹소켓 메시지 전달 : handleTextMessage ");
		String msg = message.getPayload();// 메세지를 담고 있는 객체
		String msgToString = message.toString();

		logger.info("전달 된 메세지 getPayload() : {}", msg);
		logger.info("전달 된 메세지 toString() : {}", msgToString);

		if (msg != null && !msg.equals("")) {
			if (msg.indexOf("#&nick_") != -1) {
				map.put(session, msg.replace("#&nick_", ""));
				logger.info(session + "의 이름은 : {} ", map.get(session));
				for (WebSocketSession s : list) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String out = sdf.format(new Date());
					s.sendMessage(new TextMessage("<font style='color:forestgreen;'>" + map.get(session) + "님이 입장하셨습니다("
							+ out + ").</font>"));
				}
			} else {// #&nick_ 없다면 채팅 글 이기 때문에 모든 참여자에게 메세지를 보냄
				for (WebSocketSession s : list) {
					String m = "<font style='color:black;'>" + msg + "</font>";
					s.sendMessage(new TextMessage(m));
				}
			}
		}
		logger.info("채팅 참여자들 : {} ", map);
		super.handleTextMessage(session, message);
	}
}
