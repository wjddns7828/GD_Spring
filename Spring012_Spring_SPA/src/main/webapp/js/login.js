//TODO 12_03 엔터의 로그인 체크 이벤트 연결
function enterKey(){
	if(window.event.keycode == 13){
		loginCheck();
	}
}

//TODO 12_04 로그인 버튼 클릭시 회원가입 여부 Validation 처리
window.onload = function(){
	document.querySelector("button[type=submit]").onclick = function(e){
		console.log("로그인 버튼 클릭");
		e.preventDefault();
		loginCheck();
	}
	
}

//TODO 12_05 입력된 아이디와 비밀번호를 확인하여 DB에 정보가 있는지 확인하는 비동기식 fetch Ajax
function loginCheck(){
	console.log("로그인 검수 실행");
	var id = document.getElementById("id").value;
	var pwd = document.getElementById("password").value;
	console.log("화면의 값: ", id, pwd);
	
	var form = document.forms[0];
	form.action = "./login.do";
	form.method = "get";
	
	var regex = /^(?=.*\d)(?=.*[a-zA-Z]).{4,}$/;
	//^ : 문자열시작
	//(?=.*\d) : 숫자를 포함하는 길이가 0이상인 문자열이 있어야 함
	//(?=.*[a-zA-Z]): 알파벳을 포함하는 길이가 0이상인 문자열이 있어야 함
	//.{4,}: 길이가 최소 4 이상인 임의의 문자열
	//$ : 문자열의 끝
	
	var obj = {
		"id": id,
		"pwd": pwd
	}
	
	objectData.id = "아이디";
	objectData.pwd = "비밀번호";
	console.log("obj 객체 : ",obj);
	
	if(!regex.test(id) && !regex.test(pwd)){
		alert("잘못된 아이디와 비밀번호를 입력하였습니다");
	} else {
		fetch("./loginCheckText.do",{
			method : "POST",
			headers : {"Content-Type": "application/json"},
			body:
//				JSON.stringify({id:id}), // stringify에 javascript 객체를 통한 전송
				JSON.stringify(obj), // 외부에서 javascript 객체를 생성하여 전달
//				JSON.stringify(objectData) // javascript class를 통한 전달
		}).then( //fetch ajax의 실행결과인 response의 성공 ok를 판단하여 오류 처리
				 //성공한다면 반환된 response가 Promise의 객체를 JSON으로 변경하여 다음 then으로 전달
			response => {
				if(!response.ok){
					throw new Error("검색된 회원의 정보가 없습니다 \n 회원가입해주세요 :< ");
				} else {
					return response.json();
				}
			}
		).then( //성공했을 경우 혹은 반환되는 data를 받아 처리하는 곳
			data => {
				console.log("반환된 data: ",data);
				//TODO 13_01 로그인 검증이 완료되면 세션을 담는 요청 GET
				location.href='./login.do';
			}
		).catch((e)=>{ //예외 throw가 발생하면 처리되는 곳
			alert(e.message);
//			function(e){
//				alert(e.message);
//			}
		});
	}
}