<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>    
<script type="text/javascript">
function aaa(){
	location.href="index.jsp";
}
</script>
<%
	String id = (String)session.getAttribute("userid");
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");

	stmt = conn.createStatement();
	String sql= "select * from user_" + id;
	
	rs = stmt.executeQuery(sql);
	
	out.print("<table border='1px'><tr><td>&nbsp;예매확인&nbsp;</td></tr>");

	while(rs.next()){
		out.print("<tr><td>");
		out.print("&nbsp;" + rs.getString(1)+"&nbsp;");
		out.print("</td><td>");
		out.print("&nbsp;" +rs.getString(2)+"&nbsp;" );
		out.print("</td><td>");
		out.print("&nbsp;" +rs.getString(3)+"&nbsp;" );
		out.print("</td><td>");
		out.print("&nbsp;" +rs.getString(4)+"&nbsp;" );
		out.print("</td></tr>");
	}
	out.print("</table>");
	out.print("<input type='button' onclick='aaa()' value='홈으로' style='background-color:#fed136; color:white;'>");
%>












