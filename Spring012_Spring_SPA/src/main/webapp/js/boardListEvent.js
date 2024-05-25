/**
 * TODO 20_08 화면의 삭제 버튼 클릭시 동작하는 Event
 */
 
 function del(val){
	location.href="./boardDelte.do?seq="+val;
}

//TODO 21_09 글 수정 버튼 클릭시 데이터를 가져와 Modal FORM을 만들고 modal을 실행
function modify(val){
	console.log("수정 모달 버튼 클릭 : ",val)
	var id = "[href*=collapse"+val+"]";
	console.log(id);
	$(id).closest("tr").css("background","yellow")
	$("#modify").modal({backdrop:'static',keyboard:false});
	ajaxModify(val);
	
}

var ajaxModify = function(seq){
	$.ajax({
		url:"./modifyForm.do",
		type:"post",
		data:"seq="+seq,
		success:function(msg){
			console.log(typeof msg,msg);
			var json = JSON.parse(msg);
			console.log(typeof json, json);
			html="";
			html+="<div class='form-group'>";
    		html+="	<label for='id'>아이디:</label>";
    		html+="	<input type='hidden' name='seq' value='"+json.seq+"'>   ";
    		html+="	<b class='form-control'>"+json.id+"</b>";
    		html+="</div>";
    		
			html+="<div class='form-group'>";
    		html+="	<label for='id'>작성일:</label>";
    		html+="	<b class='form-control'>"+json.regdate+"</b>";
    		html+="</div>";
    		
    		html+="<div class='form-group'>";
    		html+="	<label for='id'>제목:</label>";
    		html+="	<input type='text' class='form-control' name='title' id='title'value='"+json.title+"'>   ";
    		html+="</div>";
    		
    		html+="<div class='form-group'>";
    		html+="	<label for='id'>내용:</label>";
    		html+="<textarea class='form-control' row='5' name='content' id='content'>"+json.content+"</textarea>";
    		html+="</div>";
    		
			html+="<div class='modal-footer'>                                                        ";
			html+="<input type='button' class='btn btn-success' value='글수정' onclick='modifyVal()'";
			html+="<input type='reset' class='btn btn-info' value='초기화'";
        	html+="	<button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";
			html+="</div>                                                                            ";
			$("#formmodify").html(html);
		},
		error:function(){
			alert("잘못된 요청 처리");
		}
	});
}

//TODO 21_11 수정된 내용을 서버에 전송하여 저장
var modifyVal = function(){
	var frm = $("#formmodify");
	var idx = $(".active").text();
	
	$.ajax({
		url:"./modify.do",
		type:"post",
		data:frm.serialize(),
		success:function(msg){
			console.log(msg.index);
			console.log(msg.isc=="true")
			if(msg.isc=="true"){
				$("#modify").modal("hide");
				spa_ajax(idx);
			}else{
				location.href="./logout.do";
			}
		},
		error:function(){
			alert("잘못된 요청처리입니다.");
		}
	})
}

//TODO 22_09 답글 버튼 클릭시 데이터를 가져오는 modalform을 만들기 modal 실행
function reply(seq){
	console.log("답글 작성",seq);
	$("#reply").modal();
	$("#reply").modal({backdrop:'static',keyboard:false});
	ajaxReply(seq);
}

var ajaxReply=function(seq){
	$.ajax({
		url:"./replyForm.do",
		type:"post",
		data:{"seq":seq},
		dataType:"json",
		success:function(obj){
			console.log(obj);
			$("#frmReply").html("");
			
			html="";
			html+="<div class='form-group'>";
    		html+="	<input type='hidden' name='seq' id='parentseq' value="+obj.seq+">   ";
    		html+="	<label>부모글의 정보("+obj.seq+")</label>";
    		html+="	<b class='form-control'>작성일:"+obj.regdate+" 작성자:"+obj.id+"</b>";
    		html+="</div>";
    		
			html+="<div class='form-group'>";
    		html+="	<label>작성자</label>";
    		html+="	<b class='form-control'>GUEST</b>";
    		html+="</div>";
    		
    		html+="<div class='form-group'>";
    		html+="	<label id='tit'>제목(원본):</label>";
    		html+="	<input type='text' class='form-control' name='title' id='title'value='"+obj.title+"'>   ";
    		html+="</div>";
    		
    		html+="<div class='form-group'>";
    		html+="	<input type='hidden' name='title' id='hiddenContent'value='"+obj.content+"'>   ";
    		html+="	<label id='con'>내용(원본):</label>";
    		html+="	<textarea type='text' class='form-control'row='5' name='content' id='textarea' onclick='chk()'>"+obj.content+"</textarea>";
    		html+="</div>";
    		
			html +="<div class='modal-footer'>";
	        html +="<input type='button' class='btn btn-success' value='답글작성' onclick='replyVal()'>";
	        html +="<span onclick='reset()'><input type='reset' class='btn btn-info' value='초기화'>";
	        html +="<button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>";
	        html +="</div>";
    		
    		$("#frmReply").html(html);
		},
		error:function(){
			alert("잘못된 요청입니다.");
		}
	})
}

function reset(){
	console.log("리셋")
	document.getElementById('tit').innerHTML="제목(원본):";
	document.getElementById('con').innerHTML="내용(원본):";
}

function chk(){
	var tit = document.getElementById('tit');
	var con= document.getElementById('con');
	var title= document.getElementById('title');
	var textarea = document.getElementById('textarea');
	var hiddenContent = document.getElementById('hiddenContent');
	console.log(tit,con,title,textarea,hiddenContent);
	
	if(textarea.value == hiddenContent.value){
		con.innerHTML = "답글 내용";
		tit.innerHTML = "답글 제목";
		textarea.value="";
		title.value="";
	}
}

//TODO 22_11 수정된 내용을 서버에 전송하여 처리
function replyVal(){
	var tit = document.getElementById('tit').textContent;
	console.info('화면의 tit값 : ', tit);
	if(tit=="제목(원본):"){
		alert("답글은 필수 입니다");
		return;
	}
	var parentseq = document.getElementById('parentseq').value;
	var title= document.getElementById('title');
	var textarea = document.getElementById('textarea');
	
	const extactTextPatter = /(<([^>]+)>)/gi;
	
	let convertTitle = title.value.replace(extactTextPatter,'');
	let convertContent = textarea.value.replace(extactTextPatter,'');
	console.log(convertTitle);
	console.log(convertContent);
	
	var idx = $(".active").text();
	console.log("현재 페이지의 index :",idx);
	console.log("asdasdasdasd",parentseq);
	
	$.ajax({
		url:"./reply.do",
		type:"post",
		data:{"seq":parentseq, "title":convertTitle, "content":convertContent},
		success:function(msg){
			if(msg.isc == true){
				$('#reply').modal("hide");
				spa_ajax(idx);
			}else{
				alert("답글 작성 오류", "다시작성해 주세요");
			}
		},
		error:function(){
			alert("잘못된 요청입니다.");
		}
	});
	
}