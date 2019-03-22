<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");	
    
	/* 
	int empno = Integer.parseInt(request.getParameter("txtempno"));
	String ename = request.getParameter("txtename");
	
	Emp e = new Emp();
	e.setEmpno(empno);
	e.setEname(ename);
		
	session.setAttribute("empobj", e); // a.jsp , b.jsp 값을 read .... 
	*/
%>    
<jsp:useBean id="emp" class="kr.or.bit.Emp" scope="page"></jsp:useBean>
<!-- Emp 객체만 만들었고 -->
<!-- 1단계 
<jsp:setProperty property="empno" name="emp" param="txtempno"/>
<jsp:setProperty property="ename" name="emp" param="txtename"/>-->
<!-- 전제 조건 :empno setter 구현되어 있지 않으면 안되요  -->
<!-- 2단계 -->
<jsp:setProperty property="*" name="emp"/>
<!-- 정상적인 동작을 위해서는
	parameter값과 Emp클래스의 memberfield 명과 동일해야한다.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
사번 : <jsp:getProperty property="empno" name="emp"/> <br>
이름 : <jsp:getProperty property="ename" name="emp"/> <br>
</body>
</html>