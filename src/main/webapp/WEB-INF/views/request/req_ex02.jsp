<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>REQUEST_EX02</h3>
	
	<form action="param" method="post">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="pw">
		
		<input type="checkbox" name="inter" value="a">자바
		<input type="checkbox" name="inter" value="b">JSP
		<input type="checkbox" name="inter" value="c">스프링
		
		<input type="submit" value="확인">
	</form>
</body>
</html>