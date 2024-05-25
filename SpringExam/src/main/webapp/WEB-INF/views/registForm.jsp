<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<form class="form-horizontal" action="./regist.do" method="post">
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
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name"
						placeholder="Enter name" name="name">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">회원가입</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>