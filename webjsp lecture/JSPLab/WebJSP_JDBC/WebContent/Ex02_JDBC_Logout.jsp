<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
%>