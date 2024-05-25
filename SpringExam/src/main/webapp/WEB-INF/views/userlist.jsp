<%@page import="com.min.edu.vo.pageVo"%>
<%@page import="com.min.edu.vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.paging{
		text-align: center;
	}
</style>
<title>유저 목록</title>
<%
List<UserVo> lists = (List<UserVo>) request.getAttribute("list");
pageVo p = (pageVo) request.getAttribute("page");
%>
</head>
<body>
	<div class="container">
		<h2>유저 리스트</h2>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>Email</th>
					<th>권환</th>
					<th>삭제여부</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lists.size(); i++) {
				%>
				<tr>
					<td><%=lists.get(i).getId()%></td>
					<td><%=lists.get(i).getName()%></td>
					<td><%=lists.get(i).getEmail()%></td>
					<td><%=lists.get(i).getAuth()%></td>
					<td><%=lists.get(i).getDelflag()%></td>
					<td><%=lists.get(i).getJoindate()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div class="paging">
			<ul class="pagination pagination-sm">
				<li><a href="./userlist.do?page=1">◀</a></li>
				<li><a href="./userlist.do?page=<%=p.getTotalPage() + 1 - p.getEndPage()%>">◁</a></li>
				<%
				for (int i = p.getStartPage(); i <= p.getEndPage(); i++) {
				%>
				<li><a href="./userlist.do?page=<%=i%>"><%=i%></a></li>
				<%
				}
				%>
				<li><a href="./userlist.do?page=<%=(p.getStartPage() + p.getCountPage()>p.getEndPage())?p.getEndPage():p.getStartPage() + p.getCountPage()%>">▷</a></li>
				<li><a href="./userlist.do?page=<%=p.getEndPage()%>">▶</a></li>
			</ul>
		</div>
	</div>
</body>
</html>