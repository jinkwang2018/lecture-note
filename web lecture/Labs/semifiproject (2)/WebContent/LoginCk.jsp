<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "bituser";
String upw = "1004";

Connection cn;
Statement stmt;
ResultSet rs;

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

String query = "select * from testlist";

Class.forName("oracle.jdbc.driver.OracleDriver");
cn = DriverManager.getConnection(url, uid, upw);
stmt = cn.createStatement();
rs = stmt.executeQuery(query);

boolean loginck = false;
while(rs.next()){
	if((id.equals(rs.getString("id")))&&(pwd.equals(rs.getString("password")))){
		loginck = true;
	}
}

if(loginck){

	// 로그인 성공시 쿠키 생성
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	String timeNow = formatter.format(date);

	Cookie cookie = new Cookie("loginTime", timeNow);
	response.addCookie(cookie);
	
	session.setAttribute("id", id);
	String str = (String) session.getAttribute("id");
	
	out.print("<script>");
	out.print("alert('" + str + "');");
	
	out.print("</script>");

}else{
	out.print("<script>");
	out.print("alert('아이디와 비밀번호를 다시 확인해주세요');");
	out.print("</script>");

	out.print("<script>");
	out.print("location.href='Login.jsp'");
	out.print("</script>");
}

%>

<script type="text/javascript">
// 로그인 성공 실패 여부 떠나서 무조건 로컬 스토리지 생성
var id = '<%=id%>';
var pwd = '<%=pwd%>';
// 로컬 스토리지 생성
if (typeof(Storage) !== "undefined") {
    // Store
    localStorage.setItem("id", id);
    localStorage.setItem("pwd", pwd);
   	location.href='Map.jsp';
}
</script>

</body>
</html>