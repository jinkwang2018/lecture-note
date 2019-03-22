<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8"); 
	String id = request.getParameter("userId");
	String name = request.getParameter("userName");
	String pwd = request.getParameter("userPass");
	String pwdcheck = request.getParameter("userPassCheck");
	String gender = request.getParameter("gender");
	String email = request.getParameter("userEmail");
	String ssn1 = request.getParameter("userSsn1");
	String ssn2 = request.getParameter("userSsn2");
	String Zipcode = request.getParameter("userZipCode");
	String addr1 = request.getParameter("userAddr1");
	String addr2 = request.getParameter("userAddr2");
	String phone = request.getParameter("userPhone");
	String[] hobbys = request.getParameterValues("hobby");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <%=id %><br>
	이름 : <%=name %><br>
	비밀번호 : <%=pwd %><br>
	비밀번호확인 : <%=pwdcheck %><br>
	성별 : <%=gender %><br>
	이메일 : <%=email %><br>
	ssn1 : <%=ssn1 %><br>
	ssn2 : <%=ssn2 %><br>
	Zipcode : <%=Zipcode %><br>
	addr1 : <%=addr1 %><br>
	addr2 : <%=addr2 %><br>
	전화번호 : <%=phone %><br>
	<%
	for(int i = 0 ; i < hobbys.length ; i++){
	%>
	취미 : <%=hobbys[i] %>
	<%
	}
	%><br>
	날짜 : <%=year %>년<%=month %>월<%=day %>일
</body>
</html>
