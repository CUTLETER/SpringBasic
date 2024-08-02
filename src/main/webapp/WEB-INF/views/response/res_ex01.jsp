<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>res_ex01</h3>
	
	<a href="res_ex02">ex02 이동</a>
	<a href="res_ex03?info=홍길동">ex03 이동</a>
	
	<form action="res_ex04">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="pw">
		<input type="submit" value="확인">
	</form>
</body>
</html>