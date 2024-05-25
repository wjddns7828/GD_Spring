/**
 * Websocket 객체를 브라우저가 실행될 때 생성해주는 js
 */
 
var ws = null;
var url = null;
var nick = null;

$(document).ready(function(){
	$("#nickName").focus();
	
	$("#join_room").bind("click",function(){
		console.log("닉네임 입력");
		if($("#nickName").val()==""){
			alert("닉네임을 입력해주세요");
			$("#nicName").focus();
			return;
		}
		nick=$("#nickName").val();
		console.log("입력받은 닉네임: ",nick);
		$("#resive_msg").html("");
		$("#char_div").show();
		$("#chat").focus();
//		TEST 서버
//		ws = new WebSoket("wss://javascript.info/article/websoket/demo/hello");

		//spring 혹은 ndoe로 구성된 websoket 서버를 구현하여 ws로 사용
		var url = location.href;
		console.log(url);
		var checkUrl=url.substring(url.indexOf('//'),url.lastIndexOf('/')+1);
		console.log(checkUrl);

		ws = new WebSocket("ws:"+checkUrl+"wsChat.do");
		
		
		ws.onopen = function(){
			console.log("웹소켓 객체 오픈")
			ws.send("#&nick_"+nick);
		}
		
		ws.onmessage=function(event){
			$("#resive_msg").append(event.data+"<br>");
		}
		ws.onclose=function(){
			alert("서버의 연결이 종료 되었습니다.");
		}
		
		$("#chat_btn").bind("click",function(){
			console.log("대화 내용 전달");
			if($("#chat").val()==""){
				alert("대화내용을 입력해 주세요");
				return;
			}else{
				ws.send("["+nick+"]"+$("#chat").val());
				$("#chat").val("");
				$("#chat").focus();
			}
		});
		
		
		console.log("생성된 소켓 서버 : ",ws);
	});
});

function disconnection(){
	ws.close();
	ws=null;
}

window.addEventListener("beforeunload", (event)=>{
	event.defaultPrevented();
	event.returnValue="";
	ws.close();
});