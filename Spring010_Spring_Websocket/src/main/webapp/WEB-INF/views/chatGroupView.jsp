<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹채팅 화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/chatGroupView.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="./js/chatGroup.js"></script>
</head>
<body>
	<div class="container">
		<button class="btn btn-danger btn-block" onclick="roomClose()">채팅 종료</button>
		<table>
			<tr>
				<td colspan="2" align="center">
					채팅 그룹 : <b id="group">${sessionScope.gr_id}</b>
				</td>
			</tr>
			<tr>
				<td width="300px" height="400px" align="center">
					<div class="receive_msg" style="border: 1px;">
						<div id="nickName">접속자 ID : <br><b>${mem_id}</b></div>
					</div>
				</td>
				<td width="130px" class="memListBox">
					<div class="listTitle">접속자 목록</div>
					<div class="memList"></div>
				</td>
			</tr>
		</table>
		<div class="chat_div">
			<input type="text" class="chat" onkeypress="if(event.keyCode==13) $('.chat_btn').click();">
			<input type="button" class="chat_btn" value="내용전송">
		</div>
	</div>
</body>
</html>