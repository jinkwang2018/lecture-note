<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	404 : 요청한 페이지 부재
	500 : 서버쪽 코드 에러(실행시 0으로 나누거나 형변환 문제거나 null등등)
	
	500예외가 발생하면 : 별도의 페이지를 서비스 (web.xml)에 설정
 -->
 <%
 	String data = request.getParameter("name").toLowerCase();
 %>
 전달받은 내용 : <%=data %>
</body>
</html>
