<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="e" class="kr.or.bit.Emp" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
객체의 주소가 넘어온다.<br>
<% 
	out.print(e.getEmpno()+"<br>");
	out.print(e.getEname()+"<br>");
%>
</body>
</html>
