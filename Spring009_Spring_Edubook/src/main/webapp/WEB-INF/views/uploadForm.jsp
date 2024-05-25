<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<!-- 
	■ form tag의 enctype속성 
	1. application/x-www-form-urlencoded : (default값)
	2. multipart/form-data : fileupload일 때 : 문자 + 데이터를 합쳐서 보내고 반드시 POST여야 함
	3. text/plain : encode를 하지 않음
	
	■ 파일업로드 아작스 사용 방법
	var frm = document.forms[0];
	var formdata = new FormData();
	
	var files=document.querySelector("input[type=file]")[0];
	var formdata = new FormData();
	formdata.append("uplodaFile",files);
	
	$.ajax({
		url :
		enctype: "multipart/form-data",
		processData: false,//서버로 전송 될 데이터가 쿼리스트링으로 되어 있는 여부
		contentType: false,
		data:formdata,// ajax는 html의 form의 데이터를 전송하지 못하기 때문에 new FormData()를 통해서 감싸서 처리함
		type:post,
		success:function(msg){}
	})
 -->
<body>
	<form action="./upload.do" method="post" enctype="multipart/form-data">
		<h3>업로드 할 파일</h3>
		파일 : <input type="file" name="file"><br>
		설명 : <br>
		<textarea rows="10" cols="40" name="desc" class="content"></textarea>
		<input type="submit" value="전송">
	</form>
	
	<fieldset>
		<legend>AJAX를 통한 이미지 업로드 및 미리보기</legend>
		<div>
			<input type="file" class="hidden_input" id="reviewImageFileOpenInput" accept="image/*" multiple="multiple">
		</div>
		<div>
			<ul class="list_thumb">
			</ul>
		</div>
	</fieldset>
	<script type="text/javascript">
		window.onload=function(){
			document.getElementById("reviewImageFileOpenInput").onchange= function(){
				console.log("버튼 변화")
				var imgFile=this.value.toLowerCase();
				var fileForm=/(.*?)\.(jpg|jpeg|png|gif|bmp)$/;//.앞에 모든 값을 선택하고 \.의 다음 값
				var maxSize = 5*1024*1024;
				var fileSize = document.getElementById("reviewImageFileOpenInput").files[0].size;
				console.log(imgFile, fileForm, maxSize, fileSize);
				var chkImg=imgFile.match(fileForm);
				console.log(chkImg,fileSize);
				if(!chkImg){
					alert("이미지파일만 업로드 가능합니다.")
					return;
				}
				if(maxSize<fileSize){
					alert("5MB이하만 업로드 가능합니다.")
					return;
				}
				readUrl(this);
			}
		}
		function readUrl(input){
			const target = document.getElementById("reviewImageFileOpenInput");
			const fileLength = target.files.length;
			console.log("파일의 검색",target.files);
			$.each(target.files, function(index,file){
				var reader = new FileReader();
				reader.onload = function(e){
					var info = e.target.result;
					console.log("result : ", info)
					let reviewIMG="";                                                    
							reviewIMG += "<li class='item' style=''>                        ";
							reviewIMG += "	<a href='#' class='anchor'>                     ";
							reviewIMG += "		<span class='submitImg'>전송</span>         ";
							reviewIMG += "	</a>                                            ";
							reviewIMG += "	<img src='"+e.target.result+"' width='130px;' class='item_thumb'>  ";
							reviewIMG += "	<span class='img_border'></span>                ";
							reviewIMG += "</li>                                             ";
					$(".list_thumb").append(reviewIMG);
				}
				reader.readAsDataURL(file);
			});
		}
// 		document.querySelector(".submitImg").onclick = function(){
// 			console.log("submitImg작동");
// 		}

		//버블링

// 		1) jquery방식
		$(document).on("click",".submitImg",function(){
			console.log("동적 태그 실행");
			imgSubmit();
		});

// 		2) javascript 버블링
// 		document.querySelector(".list_thumb").addEventListner("click",function(){imgSubmit();});

		function imgSubmit(){
			let content = document.querySelector(".content").value;
			let reviewImageFileOpenInput = document.getElementById("reviewImageFileOpenInput").files;
			console.log("content" , content);
			console.log("reviewImageFileOpenInput",reviewImageFileOpenInput);
			
			let formdata = new FormData();
			if(reviewImageFileOpenInput.length>=1){
				for(var i in reviewImageFileOpenInput){
					formdata.append("file",reviewImageFileOpenInput[i]);
				}
			}
			formdata.append("desc",content);
			console.log(formdata.get("desc"));
			
			$.ajax({
				url:"./uploadAjax.do",
				type:"post",
				async : false,
				data:formdata,
				contentType:false,
				processData:false,
				dataType:'JSON',
				success:function(msg){
					console.log(msg);
				},
				error:function(request, status, error){
					console.log(request,error);
				}
			})
		}
	</script>
</body>
</html>