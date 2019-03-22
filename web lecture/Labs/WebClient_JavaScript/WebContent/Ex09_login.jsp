<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Ex09_login.jsp?txtuserid=kglim&txtpwd=1004
	String userid = request.getParameter("txtuserid");
	String pwd = request.getParameter("txtpwd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 입력한 데이터</h3>
	ID : <%= userid %><br>
	PWD : <%= pwd %><br>
</body>
</html>