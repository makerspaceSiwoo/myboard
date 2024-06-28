<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>글쓰기</title>
<style>
	.orange{background-color: orange;}
	table{border-collapse : collapse;}
</style>
</head>
<body>
<form:form action="write" method="post" id="writeform" modelAttribute="board">
<form:errors element="div"/>
	<table border="1" style="width: 1000px">
		<tr>
			<td class="orange">제목</td>
			<td><input name="title" required/></td>
		</tr>
		<tr>
			<td class="orange">작성자</td>
			<td><input id="id" name="id" value="${user.id}" readonly></td>
		</tr>
		<tr>
			<td class="orange">내용</td>
			<td><div id="smarteditor">
        			<textarea name="content" id="editorTxt" 
	                  	rows="20" cols="10" 
	                  	placeholder="내용을 입력해주세요"
	                  	style="width: 850px"></textarea>
      			</div>
      		</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" id="submit" onsubmit="return submit();" value="새글 등록">
				<input type="button" id="save" value="임시저장"> 
			</td>
		</tr>
	</table>

</form:form>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

function submit(){
	if($("#id").val() == ""){
		alert("먼저 로그인 해주세요.");
		location.href="/mem/login";
		return false;
	}else{
		return true;
	}
}

    $(document).ready(function() {
  
     $("#save").click(function(){
    	 console.log("save");
    	 //미구현
     })
     
      
    })
  </script>
</body>
</html>