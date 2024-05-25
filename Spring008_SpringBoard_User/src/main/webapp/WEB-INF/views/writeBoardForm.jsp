<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 작성</title>
<!-- TODO 11_03 새글 쓰기 화면 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>새글 쓰기</h2>
		<form action="./insertBoard.do" method="post">
			<div class="form-group">
				<label for="id">아이디</label>
				<div class="form-control" id="id">${loginVo.id}</div>
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="comment">comment</label>
				<textarea class="form-control" id="comment" name="content"></textarea>				
			</div>
			<button type="submit" class="btn btn-default">글 작성</button>
			<button class="btn btn-warning" onclick="history.back(-1)">취소</button>
		</form>
	</div>
</body>
</html>