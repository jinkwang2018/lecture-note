<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

<%
request.setCharacterEncoding("UTF-8");	

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String chk = null;
chk = request.getParameter("chk");

if(id.equals(pwd)){
	 if(chk!=null){ 		
		 %>
		 localStorage.setItem("id", "<%=id%>");
		 location.href="form.html";
		 <%	
		// 
	 }else{
		 %>
		 localStorage.removeItem("id");
		 location.href="form.html";
		 <%	
		
		 	
	 }
}else{

response.sendRedirect("form.html"); 
}  
%>
</script>
</head>
<body>
complete
</body>
</html>