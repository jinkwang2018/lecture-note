<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%
	String name = request.getParameter("name");
	if(name.equals("kglim")){
		out.print("<b>"+name+"</b>");
	}else if(name.equals("hong")){
		out.print("<i>"+name+"</i>");
	}else{
		out.print("<h3>"+name+"</h3>");
	}
	out.print("<hr>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL & JSTL 사용(choose 구문 : Java 코드 if(){} else if(){}...)</h3>
	<ul>
		<c:choose>
			<c:when test="${param.name == 'kglim'}">
				<li><b>${param.name}</b></li>
			</c:when>
			<c:when test="${param.name == 'hong'}">
				<li><i>${param.name}</i></li>
			</c:when>
			<c:otherwise>
				<li><h3>${param.name}</h3></li>
			</c:otherwise>
		</c:choose>
	</ul>
	<hr>
</body>
</html>
