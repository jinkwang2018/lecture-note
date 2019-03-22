<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		session 값 : 웹 서버가 접속한 클라이언트	(브라우져)에 부여하는 고유한 ID 값(식별값)
		A라는 사용자가 웹서버에 접속 (session객체를 하나 생성하고 > id값을 만들고 > Client response)
		클라이언트와 서버가 갖는 session객체는 동일 한 값을 가진다.
		:처음 접속한 시간 , :마지막 접속한 시간 등을 가진다. 
	-->
	<%
		Date time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	%> 
	<h3>세션 정보</h3>
	<%= session.getId() %>
	<hr>
	<%
		time.setTime(session.getCreationTime());
	%>
	[session 생성된 시간] : <%=formatter.format(time) %>
	<hr>
	<%
		time.setTime(session.getLastAccessedTime());
	%>
	[session 마지막으로 접속한 시간] : <%=formatter.format(time) %>
</body>
</html>
