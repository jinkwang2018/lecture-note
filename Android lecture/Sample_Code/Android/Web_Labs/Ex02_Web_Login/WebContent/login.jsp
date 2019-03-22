<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% System.out.println("login.jsp 호출"); %>
	<c:if test="${param.id == 'kglim'}">
		<c:if test="${param.pwd == '1004'}">
			<jsp:forward page="success.xml"></jsp:forward>
		</c:if>
	</c:if>
	<jsp:forward page="fail.xml"></jsp:forward>
</body>
</html>