<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${list }
	<c:forEach var="vo" items="${list }" varStatus="a">
		${a.index} <!-- 삭제 버튼 구분하기 위해 인덱스 값 실어줘야 해서 만듦 -->
	<%-- ${a.count} --%>
		${vo.name }<br>
		${vo.kor }<br>
		${vo.math }<br>
		${vo.eng }<br>
		<button type="button" onclick="location.href='deleteScore?sno=${vo.sno}';">삭제</button>
		<!-- 원래는 post 방식으로 해야 함! 수업 때만 get 방식으로 href 속에 키=값 담아둔 거임 -->
	</c:forEach>
	
	<a href="scoreRegist">추가 등록</a>
</body>
</html>