<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>로그인</title>
</head>
<body>
	<div id="head">
		로그인 페이지
	</div>
	<div id="body">
		<form:form action="/mem/login" method="post" modelAttribute="member">
		<form:errors element="div"/>
			<table>
				<tr>
					<td>id</td><td><input type="text" name="id" value="${bef.id }"></td>
				<tr>
				<tr>
					<td>pw</td><td><input type="password" name="password" value="${bef.password }"></td>
				<tr>
							
			</table>
			<input type="submit" value="로그인">
			<button type="reset">초기화</button>	
		</form:form>
			<a href="/mem/join">회원가입</a>
			<a href="#">아이디 찾기</a>
			<a href="#">비밀번호 찾기</a>
			<a href="/main"><button>돌아가기</button></a>
	</div>

</body>
</html>