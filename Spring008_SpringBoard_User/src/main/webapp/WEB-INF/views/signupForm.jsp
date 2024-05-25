<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- TODO 03_03 회원가입 정보 입력 화면 JSP -->
<title>회원가입 정보 입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- TODO 04_02 회원가입 ID 중복 검사 창 window.open UserController duplication.do -->
<script type="text/javascript">
	function duplication(){
		console.log("중복 검사 확인 함수");
		window.open("./duplication.do","중복검사","width=500px, height=500px");
	}
</script>
</head>
<body>
	<div class="container">
		<form action="./signup.do" method="post">
			<h1>회원가입</h1>
			<h3>필수 값을 입력해 주세요</h3>
			<div>
				<input class="form-control" type="text" name="name" placeholder="이름 작성">
				
				<!-- TODO 04_01 회원가입 아이디 중복 검사 창 실행 -->
				<input class="form-control" type="text" name="id" id="id" placeholder="ID 작성 (클릭시 중복체크 화면으로 이동)" 
				maxlength="10" onclick="return duplication()">
				
				<span id="result"></span>
				<input class="form-control" type="password" id="pw" name="password" placeholder="비밀번호 작성">
				<input class="form-control" type="password" id="pwOk" placeholder="비밀번호 확인">
				<input class="form-control" type="text" id="email" name="email" placeholder="이메일 작성">
			</div>
			<div>
			<!-- TODO 04_09 회원가입 완료 버튼 클릭 -->
				<input class="btn btn-primary" type="submit" value="회원가입 완료">
				<input class="btn btn-warning" type="button" value="가입 취소" onclick="javascript:history.back(-1)">
			</div>
		</form>
	</div>
</body>
</html>