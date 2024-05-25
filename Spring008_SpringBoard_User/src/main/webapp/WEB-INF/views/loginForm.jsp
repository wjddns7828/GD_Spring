<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function findId(){
		window.open("./findId.do","아이디 찾기","width=500px,height=500px");
	};
</script>
</head>
<body>
	<div class="container" style="margin-top:100px;">
	<form action="./login.do" method="post">
		<table class="table table-hover">
			<tr>
				<th>아이디 : </th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<th>비밀번호 : </th>
				<td>
					<input type="text" name="pw">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- TODO 06_01 로그인 UserController -->
					<input type="submit" value="로그인">
					
					<!-- TODO 03_01 회원가입 화면으로 이동 UserController signupForm.do -->
					<input type="button" value="회원가입" onclick="location.href='./signupForm.do'">
					
					<!-- TODO 05_01 아이디 찾기 window.open UserController findIdWindow.do -->
					<input type="button" value="아이디 찾기" onclick="findId()">
				</td>
			</tr>
		</table>
		</form>
	</div>	
</body>
</html>