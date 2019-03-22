<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool</title>
</head>
<body>
<%
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	Context context =new InitialContext();
	DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
	
	conn=ds.getConnection();//함수가 tool에 있는 connection연결 객체 불러오기
	
	out.print("db 연결 여부 : " + conn.isClosed() + "<br>");
	conn.close(); //자원해제(connection객체반환)
	out.print("db 연결 여부 : "  +conn.isClosed() + "<br>");
%>
</body>
</html>