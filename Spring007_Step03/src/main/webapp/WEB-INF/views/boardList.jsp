<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD &amp; Transaction 연습</title>
</head>
<body>
	<!-- TODO 06_03 처리된 결과를 EL로 출력한다 -->
	${lists}
	<hr>
	<!-- TODO 07_01 Controller에 POST 방식으로 id title context의 name으로 요청을 보낸다 -->
	<fieldset>
		<legend>기본 Parameter 처리 DTO / VO </legend>
		<form action="./insertBoard.do" method="post">
			아이디 : <input type="text" name="id" value="토맛토">
			제목 : <input type="text" name="title" value="멋쟁이 토맛토">
			내용 : <input type="text" name="content" value="멋쟁이 토토맛토">
			<input type="submit" value="제출">
		</form>
	</fieldset>
	
	<!-- TODO 08_01 Bind되는 값의 객체(DTO/VO)가 없는 경우 java.util.Map을 통해서 key:value의 형태가 됨
			key==name / value = value
	 -->
	<fieldset>
		<legend>기본 Parameter 처리 DTO / VO </legend>
		<form action="./insertBoardMap.do" method="post">
			아이디 : <input type="text" name="id" value="방울 토마토">
			제목 : <input type="text" name="title" value="멋쟁이 방울 토마투">
			내용 : <input type="text" name="content" value="멋쟁이 방울 토토마토토">
			<input type="submit" value="제출">
		</form>
	</fieldset>
	
		<!-- TODO 09_01 @RequestParam을 톹ㅇ한 param의 유효값 제어 -->
	<fieldset>
		<legend>@RequestParam</legend>
		<p>
			화면에서 요쳥되느 name값을 변경하게 처리 할 수 있다.<br>
			예를 들어 화면의 name이 pw라고 전송이 되고 
			서버 사이드에서 password라고 하는 name을 필요로 함<br>
			&lt;기존 &gt;<br>
			String password = req.getParameter("pw")
		</p>
		<p>
			문제점 해결<br>
			화면에서의 요청은 모두 문자열(String)이기 때문에 name이 없으면 null이 발생함<br>
			null이면 받는 값이 int로 bind되면 null형변환 문제가 발생함
		</p>
		<form action="./insertBoardRequestParam.do" method="post">
			<input type="text" name="a" value="B003">
			<input type="text" name="b" value="감기 조심하세요">
			<input type="text" name="c" value="몸이 건강해야 공부도 잘됨">
			<input type="submit" value="전송">
		</form>
	</fieldset>
	
	<!-- TODO 10_01 @PathVariable 요청되는 주소의 특정부분은 값을 사용 할 수 있다. -->
	<fieldset>
		<legend>주소값은 Parameter 값으로 처리</legend>
		<form action="./com/min/edu/login/paramvalue.do" method="post">
			<input type="submit" value="주소처리 전송">		
		</form>
	</fieldset>
	
	<!-- TODO 11_01 Transaction 처리-->
	<fieldset>
		<legend>Transaction Annotation 처리</legend>
		<form action="./transaction.do" method="post">
			아이디 : <input type="text" name="id" value="대추 토마토">
			제목 : <input type="text" name="title" value="멋쟁이 대추 토마토">
			내용 : <input type="text" name="content" value="멋쟁이 대추 토토마토">
			<input type="submit" value="제출">
		</form>
	</fieldset>
</body>
</html>