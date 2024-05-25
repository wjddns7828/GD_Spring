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
</head>
<body>
	<div class="container">
		<h2>게시글 상세</h2>
		<div>
			<div class="form-control">아이디:${boardVo.id}</div>
			<div class="form-control">제목:${boardVo.title}</div>
			<div class="form-control">내용:${boardVo.content}</div>
			<div class="form-control">작성일:${boardVo.regdate}</div>
		</div>
		<div>
			<!-- TODO 13_01 단일 삭제 이지만 다중삭제를 통해서 실행 바인딩 처리 확인 -->
			<input class="btn btn-success" type="button" value="삭제" onclick="deleteOne('${boardVo.seq}')">
			<!-- TODO 14_01 수정-->
			<input class="btn btn-success" type="button" value="수정" onclick="">
			<!-- TODO 15_01 답글 -->
			<input class="btn btn-success" type="button" value="답글" onclick="answerBoardOne()">
		</div>
	</div>
	<script type="text/javascript">
		function deleteOne(val) {
			console.log(val, ${boardVo.seq});
			var seq = ${boardVo.seq}
			location.href="./multiDel.do?chkVal="+seq;
		}
		function answerBoardOne(){
			var seq = ${boardVo.seq};
			location.href="./replyInsert.do?chkVal="+seq;
		}
	</script>
</body>
</html>