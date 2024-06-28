<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>회원 가입</title>
</head>
<body>
	<div id="head">
		회원 가입 페이지
	</div>
	<div id="body">
		<%-- <form:form action="/mem/join" method="post"  modelAttribute="member" onsubmit="return formcheck();" >
		<form:errors element="div"/> --%>
		<form action="/mem/join" method="post" onsubmit="return formcheck();">
			<table>
				<tr>
					<td>id</td><td><input type="text" id="formid" name="id" value="${bef.id }" required>
					<button type="button" id="id_chk">id 중복확인</button>
					<span id="id_chk_msg" style="display:none">사용 가능한 아이디 입니다.</span>
					</td>
				<tr>
				<tr>
					<td>pw</td><td><input type="password" id="pw1" name="password" value="${bef.password }" required>
					<button id="pw_show" type="button">보기</button></td>
				<tr>
				<tr>
					<td>pw 확인</td><td><input type="password" id="pw2"></td>
				<tr>
				<tr>
					<td>name</td><td><input type="text" name="name" value="${bef.name}"></td>
				<tr>
				<tr>
					<td>birth</td><td><input type="date" name="birth" value="${bef.birth }"></td>
				<tr>
				<tr>
					<td>email</td><td><input type="email" name="email" value="${bef.email }" required>
					<button type="button">email 인증</button></td>
					<span>
						<!-- 이메일 인증 번호 입력란 -->
					</span>
				<tr>

			</table>
			<input type="submit" value="가입">
			<button type="reset">초기화</button>
		<%-- </form:form> --%>
		</form>
		<a href="/"><button>돌아가기</button></a>
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
function formcheck(){
	if($("#pw1").val() == $("#pw2").val()){
		alert("회원가입에 성공했습니다!");
		return true;
	}else{
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
}

function save(){
	console.log("save");
	// 미구현
}

$("#id_chk").click(function(){
	let id = $("#formid").val();
	if(id == ""){
		alert("먼저 아이디를 입력하세요");
	}else{
		$.ajax({
			  type: "get",
			  url: "/mem/id_chk/"+id,
			  success: function(data) { // 서버에서 받은 결과
			    console.log(data);
			  	if(eval(data) != true){
			  		alert("이미 존재하는 아이디 입니다.");
			  		$("#formid").val("");
			  		$("#id_chk_msg").css("display","none");
			  	}else{
			  		console.log("사용 가능");
			  		$("#id_chk_msg").css("display","block");
			  	}
			  }
			})// ajax
	}
})

// 비밀 번호 보여주기
$("#pw_show").mousedown(function(){
	$("#pw1").prop("type","text");
})

$("#pw_show").mouseup(function(){
	$("#pw1").prop("type","password");
})



/* 
$(fucntion(){
	console.log('ready 작동 확인');
});//ready */
</script>
</body>
</html>