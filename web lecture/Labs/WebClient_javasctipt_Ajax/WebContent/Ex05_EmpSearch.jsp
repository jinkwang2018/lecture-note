<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
		String sql="select empno, ename, sal , job from emp where empno=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(request.getParameter("empno")));
		rs = pstmt.executeQuery();
		
		/*  
		코드 구현
		<table>
			<tr><td>empno</td><td>7788</td></tr>
			<tr><td>ename</td><td>SCOTT</td></tr>
			<tr><td>sal</td><td>1000</td></tr>
			<tr><td>job</td><td>SALES</td></tr>
		</table>
		작성된 것  out.print() 하세요
		*/
		out.print("<table border='1'>");
		while(rs.next()){
			out.print("<tr><th>empno</th><td>"+ rs.getInt(1) +"</td></tr>");
			out.print("<tr><th>ename</th><td>"+ rs.getString(2) +"</td></tr>");
			out.print("<tr><th>sal</th><td>"+ rs.getInt(3) +"</td></tr>");
			out.print("<tr><th>job</th><td>"+ rs.getString(4) +"</td></tr>");
		}
		out.print("</table>");
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(rs != null) try{rs.close();}catch(Exception e){}
		if(conn != null) try{conn.close();}catch(Exception e){}
	%>