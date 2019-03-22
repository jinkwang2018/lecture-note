<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//로그 아웃 (sessionId 소멸)
	session.invalidate();
	out.print("<script>location.href='Ex23_Session_login.jsp'</script>");
%>
</body>
</html>