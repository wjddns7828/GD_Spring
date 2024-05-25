<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- TODO 04_04 아이디 중복 검사 화면  -->
<title>중복 검사</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- TODO 04_05 id 값을 rest 처리 ajax로 usercontroller로 전송 duplicationAjax.do -->

<!-- TODO 04_07 Rest처리 결과에 따라서 아이디 사용 여부 버튼 노출 -->

<!-- TODO 04 사용버튼으로 누르면 값을 부모의 창으로 전송 -->
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnUseId").css("display","none");
	});
	function checkId(){
		console.log("냠냠");
		var id = document.getElementById("id").value;
		console.log(id);
		if(id!=""){
			$.ajax({
				url: "./duplicationAjax.do",
				type:"post",
				data:"checkId="+id,
				async:"true",
				success:function(msg){
					console.log("Ajax처리된 성공 결과 : ",msg);
					if(msg=="true"){
						document.getElementById("condition").innerHTML="사용 할 수 없습니다.";
						document.getElementById("btnUseId").style.display="none"
					}else{
						document.getElementById("condition").innerHTML="사용 할 수 있는 아이디 입니다.";
						document.getElementById("btnUseId").style.display="block"
					}
				},
				error:function(){
					alert("잘못된 요청값 입니다");
				}
			});
		}
	}
	function useId(){
		var id = document.getElementById("id").value;
		opener.document.getElementById("id").value = id;
		opener.document.getElementById("id").onclick = "";
		window.close();
	}
</script>
</head>
<body>
	<div class="container">
		<h4>아이디 중복 확인</h4>
		<h4>아이디를 입력해 주세요</h4>
		<input type="text" id="id" class="form-control">
		<input type="button" value="확인" class="btn btn-success" onclick="checkId()">
		<input type="button" value="사용하기" class="btn btn-info" id="btnUseId" onclick="useId()">
		<div id="condition"></div> 
	</div>
</body>
</html>