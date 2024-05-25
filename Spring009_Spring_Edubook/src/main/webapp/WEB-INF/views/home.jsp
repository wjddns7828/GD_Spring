<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
	window.onload=function(){
		var desc = document.getElementById("description");
		var descBtn = document.getElementById("descBtn");
		descBtn.onclick=function(){
			if(desc.style.display=="none"){
				desc.style.display="block";
				descBtn.textContent="설명 닫기";
			}else{
				desc.style.display="none";
				descBtn.textContent="설명 열기";
			}
		}
	}
</script>
	<select id="lang" onchange="langChange()">
		<option value="ko" ${param.lang=="ko"?"selected":""}>한국어</option>
		<option value="en" ${param.lang=="en"?"selected":""}>영어</option>
	</select>
<script type="text/javascript">
	function langChange(){
		var lang = document.getElementById("lang");
		var choiceValue=lang.options[lang.selectedIndex].value;
		console.log("선택된 언어 : "+choiceValue);
		location.href="./main.do?lang="+choiceValue;
	}
</script>
<div class="container">
	<form action="./login.do" method="post">
		<table class="table">
			<tr class="warning">
				<th><spring:message code="label.id"/></th>
				<td>
					<input type="text" name="id" required="required">
				</td>
			</tr>
			<tr>
				<th><spring:message code="label.password"/></th>
				<td>
					<input type="password" name="password" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="btn-warning" type="submit" value='<spring:message code="label.login"/>'>
					<input class="btn-info" type="button" value="회원가입 ajax" onclick="location.href='./registForm.do'">
					<input class="btn-info" type="button" value="회원가입 formvalidation">
				</td>
			</tr>
		</table>
	</form>
	<!-- HttpSession 과 @SessionAttribute 설명 -->
	<fieldset>
		<legend>HttpSession과 @sessionAttrubute 설명</legend>
		<a class="btn btn-success" href="./sessionInit.do"> session_1_Controller이동</a>
		<button id="descBtn">설명 열기</button>
		<div id="description">
			<pre>
				※ @SessionAttribute는 HttpSession을 사용 할 때 @ModelAttribute와 이름을 같게 해야함
					request Scope가 아닌 Session Scope에 값을 저장 할 수 있도록 해준다.
					
				※ @SessionAttribute 4.3이상 버전부터 추가된 Bind Annotation HttpSession에 저장 값을 타입 컨버팅을 쉽게 할 수 있도록 해줌
				
				◆공통 
				1) init.do에 의해서 HttpSession(:httpsessionTest),@SessionAttribute(:sessionTest)
				 -> sessionCheck.jsp출력
				 
				◆ 같은 컨트롤러의 HttpSession과 @SessionAttribute
					2) test01 > @SessionAttribute를 삭제하는 sessionStatus.setComplete();
								test01.do
								
					3) test02 > HttpSession을 삭제하는 session.invalidate():
								test02.do
								
				◆ 다른 컨트롤러의 HttpSession과 @SessionAttribute
					2) test03 > @SessionAttribute를 삭제하는 sessionStatus.setComplete();
								test03.do
								
					3) test04 > HttpSession을 삭제하는 session.invalidate():
								test04.do
								
				■ 시나리오  및 결과 (HttpSession == h // @SessionAttribute == s)
				1. 같은 Controller
					1) init.do(h/@생성) -> result01, result02 확인 ☞ h/@ 모두 사용 가능
					2) init.do(h/@생성) -> test01을 통해서 @만 삭제 ☞ h정상 출력 / @오류
					3) init.do(h/@생성) -> test02을 통해서 h만 삭제 ☞ h == null / @정상 출력
					
				2. 다른 Controller
					1) init.do(h/@생성) -> result01, result02 확인 ☞ 다른 Controller에서도 같은 호출 방식으로 사용이 가능하다
					2) init.do(h/@생성) -> test03 을 통해서 @만 삭제 ☞ h/@ 모두 사용 가능
					3) init.do(h/@생성) -> test04 을 통해서 h만 삭제 ☞ h/@ 모두 사용 불가
						 
				
				<======================================================================================================>
					최종 결론 : 생성된 클래스가 아닌 다른 컨트롤러 에서는 HttpSEssion.invalidate()를 통해서
								모든 HttpSession과 @SessionAttribute로 생성된 객체를 삭제 할 수 있다.
				<======================================================================================================>
			</pre>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>SMTP Email보내기</legend>
		<a class="btn btn-success" href="./mailForm.do">메일 작성 화면</a>
	</fieldset>
	
	<fieldset>
		<legend>파일 업로드 commons-fileupload</legend>
		<a class="btn btn-success" href="./uploadForm.do">파일업로드 작성화면</a>
	</fieldset>
</div>
</body>
</html>
