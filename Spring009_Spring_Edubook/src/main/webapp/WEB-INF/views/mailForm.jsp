<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container pannel-body message">
		<h1 class="text-center">메일 보내기</h1>
		<!-- 메일 작성하는 상황 : 1) text만 구성되어 있는지 2) HTML로 구성 Editor 3) 첨부파일이 있는 경우 -->
		<form action="./mailSender.do" class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label for="to" class="col-sm-1 control-label">To:</label>
				<div class="col-sm-11">
					<input type="email" name="tomail" class="form-control select2-offscreen" id="to" placeholder="상대방 이메일" tabindex="-1">
				</div>			
			</div>
			<div class="form-group">
				<label for="to" class="col-sm-1 control-label">Title:</label>
				<div class="col-sm-11">
					<input type="text" name="title" class="form-control select2-offscreen" id="to" placeholder="제목" tabindex="-1">
				</div>			
			</div>
			<div class="col-sm-11 col-sm-offset-1">
				<br>
				<div class="form-group">
					<textarea class="form-control" name="content" placeholder="메일 전송 내용 작성" rows="12" ></textarea>
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-success" value="매일 보내기">
				<button class="btn btn-danger" onclick="location.href='./main.do'">취소</button>
			</div>
		</form>
	</div>
</body>
</html>