<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>사용되고 있는 DB : ${propValue}</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>Hi Jenkins Deployment</div>

</body>
</html>
