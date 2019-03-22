<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "bituser";
String upw = "1004";

Connection cn;
PreparedStatement pstm;
Statement stmt;
%>

<%
// ID 검사하여 중복 ID가 아닐때 session에 남긴 true를 받아와서
// 회원가입 insert 문을 실행한다
int n;
String query = "insert into testlist (id, password, email) values(?,?,?)";


if(((String)session.getAttribute("idck")).equals("ok")){
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String create_table = "create table user_" + id + "(theater varchar2(50), name varchar2(20), time varchar2(20), chair number(5))";
	
	out.print("<script>");
	out.print("alert('"  + create_table +  "')");
	out.print("</script>");
	
	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, uid, upw);
			
			pstm = cn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pwd);
			pstm.setString(3, email);
			n = pstm.executeUpdate(); 

			stmt = cn.createStatement();
			out.print("<script>");
			out.print("alert('여긴되나?')");
			out.print("</script>");
			
			stmt.executeUpdate(create_table);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	out.print("<script>");
	out.print("alert('가입을 환영합니다. 다시 로그인 해주세요');");
	out.print("</script>");
	
	out.print("<script>");
	out.print("location.href='Login.jsp'");
	out.print("</script>");
	
} else{
	out.print("<script>");
	out.print("alert('ID 중복 체크를 먼저 해주세요');");
	out.print("</script>");
	
	out.print("<script>");
	out.print("location.href='SignUp.jsp'");
	out.print("</script>");
}

%>
</body>
</html>
