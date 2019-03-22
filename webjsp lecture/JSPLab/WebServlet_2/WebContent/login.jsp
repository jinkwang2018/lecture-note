<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>GET 방식 요청</h3>
	<a href="<%= request.getContextPath()%>/Login.do?id=hong">로그인</a>
	<hr>
	<h3>POST 방식 요청</h3>
	<form action="<%=request.getContextPath()%>/Login.do" method="post">
		<input type="text" name="id">
		<input type="submit" value="로그인">	
	</form>
</body>
</html>