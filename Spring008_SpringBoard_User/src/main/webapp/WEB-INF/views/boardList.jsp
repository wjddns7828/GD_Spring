<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function chkbox(){
		var chks=document.getElementsByName("chkVal");
		var cnt = 0;
		for(let c of chks){
			if(c.checked){
				cnt++;
			}
		}
		if(cnt==0){
			alert("한개의 글을 반드시 선택해 주세요");
			return false;
		}
	}
	
	function allValue(bool){
		var chks = document.getElementsByName("chkVal");
		for(let c of chks){
			c.checked = bool;
		}
	}
</script>
<title>메인 페이지</title>
</head>
<body>
<div class="container">
	<c:if test="${loginVo != null }">
		${sessionScope.loginVo.id }님 환영합니다.
		<input type="button" value="로그아웃" onclick="location.href='./logout.do'">
	</c:if>
	<!-- TODO 09_01 [관리자 기능] 권환 회원관리 UserController managemenUser.do -->
	<c:if test="${loginVo.auth =='A'}">
		<input type="button" value="회원관리" onclick="location.href='./managementUser.do'">
	</c:if>
	<!-- TODO 10_01 리스트 출력, 다중 삭제 등 기능 -->
	<form action="./multiDel.do" method="post" id="frm" name="frm" onsubmit="return chkbox()">
		<input type="submit" value="다중 삭제">
	<!-- TODO 11_01 새글 작성 화면으로 이동 insertBoard.do -->
		<input type="button" value="새글 입력" onclick="location.href='insertBoard.do'">
	
		<c:if test="${loginVo.auth eq'A'}">
			<input type="button" value="회원전체 정보 조회" onclick="location,hefr='./userSelectAll.do'">
			<input type="button" value="게시글 복구" onclick="location,hefr='./restoreBoard.do'">
		</c:if>
		
		<c:set var="len" value="${fn:length(lists)}"/>
		TOTAL : ${len}
		
		<table class="table">
			<thead>
				<tr>
					<th><input type="checkbox" onclick="allValue(this.checked)"></th>
					<th>연번</th>
					<th>아이디</th>
					<th>제목</th>
					<th>등록</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${lists}" varStatus="vs">
					<tr>
						<td><input type="checkbox" name="chkVal" value="${dto.seq}"></td>
						<td>${vs.count}</td>
						<td>${dto.id}</td>
						<td><a href="./detailBoard.do?seq=${dto.seq}">${dto.title}</a></td>
						<td>
							<fmt:parseDate var="cDate" value="${dto.regdate}" pattern="yyyy-MM-dd"/>
							<fmt:formatDate value="${cDate}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>