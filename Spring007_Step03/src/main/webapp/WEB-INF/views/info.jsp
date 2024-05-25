<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info화면</title>
</head>
<body>
	<h2>${info}</h2>
		<fieldset>
			<legend>인코딩 처리 하는 방법</legend>
			<ol>
				<li>각 요청되는 페이지 혹은 servlet에서 request.setCharaterEncoding("UTF-8")</li>
				<li>web.xml에서  &lt; filter &gt;를 통해서 ws를 사용하는 모든 요청에 대한 인코딩 처리</li>
				<li>tomact의 설정인 server.xml 63번째 줄의 tag에 속성을 URIEncoding-"UTF-8"설정</li>
			</ol>
		</fieldset>
</body>
</html>