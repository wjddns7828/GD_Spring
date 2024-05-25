<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>로그인</h2>
		<form class="form-horizontal" action="./login.do" method="post">
		<div class="form-group">
				<label class="control-label col-sm-2" for="ID">ID:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id"
						placeholder="Enter id" name="id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">PW:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						placeholder="Enter password" name="password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>