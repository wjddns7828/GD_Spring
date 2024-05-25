<%@page import="com.min.edu.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<%
UserVo vo = (UserVo) session.getAttribute("info");
%>
</head>
<body>
	<div class="container">
		<form action="./changepw.do" method="post">
			<h2>비밀번호 변경하기</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>ID</th>
						<td>
							<%=vo.getId()%>
							<input type="hidden" name="id" value="<%=vo.getId()%>">
						</td>
						
					</tr>
					<tr>
						<th>이름</th>
						<td><%=vo.getName()%></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%=vo.getEmail()%></td>
					</tr>
					<tr>
						<th>비밀번호 변경</th>
						<td>
							<input type="text" placeholder="비밀번호를 입력하세요" name="password">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="비밀번호 변경">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>