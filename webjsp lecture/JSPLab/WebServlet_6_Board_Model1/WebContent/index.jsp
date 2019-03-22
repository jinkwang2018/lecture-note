<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="Stylesheet" href="style/default.css">
</head>
<body>
	<%
		pageContext.include("include/header.jsp");
	%>
	<div id="pageContainer">
		<h3>UI(Css 공통 페이지 적용 확인)</h3>
		<h3>DB연결 정보 확인</h3>
		<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); //java:comp/env/ 규칙 + 이름
		
			conn = ds.getConnection(); //함수가 POOL 에있는 connection 객체 얻어오기
			
			out.print("db 연결여부 :" + conn.isClosed() + "<br>");
			conn.close(); //자원해제 (connection 객체 반환)
			out.print("db 연결여부 :" + conn.isClosed() + "<br>");
		%>
	</div>
</body>
</html>