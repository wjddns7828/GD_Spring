<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function findId(){
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		console.log(name);
		console.log(email);
		if(name != "" && email!=""){
		$.ajax({
			url:"./findIdAjax.do",
			type:"post",
			data:{"name":name,"email":email},
			async:"true",
			success:function(msg){
				console.log("ajax처리된 성공 결과 :",msg);
				if(msg!="false"){
					alert("사용자의 ID는 : "+msg+"입니다,");
				}else{
					alert("등록된 아이디가 없습니다.")
				}
			},
			error:function(){
				alert("잘못된 요청입니다.");
			}
			});
		};
	}
</script>
</head>
<body>
		이름 : <input type="text" id="name">
		<br>
		이메일 : <input type="text" id="email">
		<br>
		<input type="button" value="아이디찾기" onclick="findId()">
		<input type="button" value="창닫기" onclick="self.close()">	
</body>
</html>