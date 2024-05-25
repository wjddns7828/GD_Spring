<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home화면</title>
</head>
<body>
	<fieldset>
		<legend>처리 방식에 따른 Controller연습</legend>
		<ul>
			<li>Model전달 값 : ${requestScope.str}</li>
			<li>HttpServletRequest 전달 값 : ${requestScope.req_str }</li>
			<li></li>
		</ul>
		
		<ul>
			<!-- TODO 01_02 Home.do를 Get방식으로 호출해보자 -->
			<li><a href="./home.do?name=banana">home Get호출</a></li>
			
			<!-- TODO 02_01 Home.do를 Post 방식으로 호출해보자 -->
			<li>
				homePost호출<br>
				<form action="./home.do" method="post">
					이름 : <input type="text" name="name" value="tomato"><br>
					<input type="submit" value="post전송">
				</form>
			</li>
			<!-- TODO 03_01 info.do Get호출 서버사이드인 Controller는 Get과 Post를 둘 다 처리 할 수 있도록 선언 -->
			<li>
				<a href="./info.do?name=한글&age=100">info Get호출</a>
			</li>
			<!-- TODO 04_01 SpringContainer에서 Redirect호출 -->
			<li>
				<a href="./redirect.do?name=orange">redirect Get호출</a>
			</li>
			<!-- TODO 05_01 Controller의 indexing처리 방식을 통한 요청 -->
			<li>
				<a href="./user/logout.do">indexing요청 처리</a>
			</li>
		</ul>
	</fieldset>
	<!-- TODO 06_01 EduBoardController의 selectBoard.do-->
	<fieldset>
		<legend>게시판 CRUD 및 Transaction 처리</legend>
		<div>
			<a href="./selectBoard.do">게시글 전체보기</a>
		</div>
	</fieldset>
</body>
</html>