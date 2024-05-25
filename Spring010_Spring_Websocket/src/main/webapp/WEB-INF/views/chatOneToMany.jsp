<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:N 채팅화면</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style type="text/css">
	table{
		margin: auto;
		border: 1px solid black;
		width: 100%;
		height: 500px;
	}
	.container{
		width: 600px;
		margin: auto;
	}
</style>
<script type="text/javascript" src="./js/chatOneToMany.js"></script>
</head>
<body>
	<div class="container">
		<button style="width:100%" onclick="disconnection()">연결종료</button>
		<table>
			<tr>
				<td align="center">
					<div id="resive_msg" style="overflow: scroll; width: 100%; height: 500px;"> 
						<input type="text" id="nickName" style="width:200px; height: 25px;" onkeypress="if(event.keyCode==13)$('#join_room').click()">
						<input type="button" value="대화입장" id="join_room">
					</div>
				</td>
			</tr>
		</table>
		<hr>
		<div id="chat_div" style="display:block;">
			<input type="text" id="chat" style="width:85%; margin-left: 5px;" onkeypress="if(event.keyCode==13)$('#chat_btn').click()">
			<input type="button" id="chat_btn" style="width: 10%" value="ENTER">
		</div>
	</div>
</body>
</html>