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
// 아이디 중복검사를 하고 중복이 아닐 때 세션에 값을 남긴다
// 아래의 로직은 팝업에서 수행되어야 하는 로직들이다

String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "bituser";
String upw = "1004";

Connection cn;
Statement stmt;
ResultSet rs;
%>

<%
//String id = request.getParameter("id");
//id = "'" + id + "'";
//String query = "select * from testlist where id=" + id;

// 아래 세 줄 테스트용
String id = "'jindddddd'";
String query = "select * from testlist where id=" + id;

try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn = DriverManager.getConnection(url, uid, upw);
		stmt = cn.createStatement();
		rs = stmt.executeQuery(query);
	
		// 기본적으로 중복 아니라고 설정하고
		// 중복 있으면 true 처리
		boolean idck = false;
		while(rs.next()){
			if(rs.getString("id").equals(id.substring(1, id.length()-1))){
				idck = true;				
			}
		}

		// ID 중복시 발동
		if(idck){
		out.print("<script>");
		out.print("alert('중복된 ID 입니다');");
		out.print("</script>");

		out.print("<script>");
		out.print("location.href='SignUp.jsp'");
		out.print("</script>");
		} 
		
		// ID 중복이 아닐시 알림창을 띄우고 세션에 값을 남긴다
		else{
			session.setAttribute("idck", "ok");
			out.print("<script>");
			out.print("alert('사용할 수 있는 ID 입니다');");
			out.print("location.href='SignUp.jsp'");
			out.print("</script>");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</body>
</html>
