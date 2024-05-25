<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOB입력폼</title>
</head>
<body>
	<form action="./jobInsert.do" method="post">
		ID : <input type="text" name="job_id"><br>
		TITLE : <input type="text" name="job_title"><br>
		MINSAL : <input type="number" name="min_salary"><br>
		MAXSAL : <input type="number" name="max_salary"><br>
		<input type="submit" value="등록하기">
	</form>
</body>
</html>