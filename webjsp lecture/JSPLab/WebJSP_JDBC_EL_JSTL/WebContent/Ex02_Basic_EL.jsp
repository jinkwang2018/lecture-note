<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL은 서버쪽의 자원 출력 <%=을 쓰지 않고 데이터를 담지 않는다. 담으려면 EL을 사용하면 안된다.
	//EL 사용한다고 해서 모든 java코드를 표현하는 스크립트릿이 생략되는 것은 아니다
	
	Date today = new Date();
	
	request.setAttribute("day",today);
	request.setAttribute("day2",today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL의 목적은 출력</h3>
	<%= request.getAttribute("day") %><br>
	EL:${day}<br>
	습관 : ${requestScope.day}<br>
	session EL : ${sessionScope.day2}<br>
</body>
</html>
