<%@page import="java.util.Calendar"%>
<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Emp e = new Emp();
	e.setEname("홍길동");
	e.setEmpno(1000);
	//Calendar 객체 생성하고
	//오늘 날짜 출력하기 2018년 03월 20일
	Calendar c = Calendar.getInstance();
	int year = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH)+1;
	int date = c.get(Calendar.DATE);
	int hour = c.get(Calendar.HOUR);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
출력(표현식)<br>
사번 : <%=e.getEmpno() %><br>
이름 : <%=e.getEname() %><br>
전체 : <%=e.toString() %><br>

현재 날짜 : <%=year %>년<%=month %>월<%=date %>일<%=hour %>시<%=minute %>분<%=second %>초	
</body>
</html>
