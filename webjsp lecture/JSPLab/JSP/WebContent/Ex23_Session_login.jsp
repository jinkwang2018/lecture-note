<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex23_Session_ok.jsp" method="get">
		<input type="text" name="uid"><br>
		<input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
	<hr>
	<h3>회원 전용 페이지</h3>
	<a href="Ex23_session_member.jsp">회원접속</a>
</body>
</html>