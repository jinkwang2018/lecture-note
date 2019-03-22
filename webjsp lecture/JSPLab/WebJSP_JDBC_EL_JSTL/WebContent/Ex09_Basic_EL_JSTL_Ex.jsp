<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>out</h3>
<c:out value="<p>태그는 문단 태그입니다."/>
마치 &lt;p&gt;
<!--catch 구문안에서 exception 발생하면 발생객체의 주소를 var = "msg" 할당 -->
	<h3>예외처리</h3>
	<c:catch var = "msg">
		name : <%= request.getParameter("name") %>
		<%
			if(request.getParameter("name").equals("hong")){
				out.print("당신의 이름은 : " + request.getParameter("name"));
			}
		%>
	</c:catch>
	<c:if test="${msg != null}">
		<h3>예외 발생</h3>
		오류메시지 : ${msg}<br>
	</c:if>
</body>
</html>
