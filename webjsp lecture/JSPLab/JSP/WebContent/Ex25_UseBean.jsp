<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="e" class="kr.or.bit.Emp" scope="request"></jsp:useBean>
<%
	e.setEmpno(3333);
	e.setEname("kim");
	//자바 코드
	//객체를 생성하고 사용 문제 없어요
	
	//Emp e = new Emp();
	//e.setEmpno(2000);
	//e.setEname("hong");
	
	//request.setAttribute("emp", e); // Include , forward 가지고 있다면 (다른 페이지 객체 사용)
	//session.setAttribute("emp", e); //sessionId 동일한 모든 페이지에서 사용가능
	//application.setAttribute("emp", e); //Web App 안에 모든 페이지에서 사용가능
	
	//scope : e 객체 > default > page 안에서 유효
	//scope : request > 현재 페이지 (단 include , forward 다른 페이지 공유)
    //scope : session > 같은 sessionId 가지 모든 페이지
    //scope : application > 모든 페이지(모든 session 에서 사용가능)
	
    //out.print("empno : " + e.getEmpno() + "<br>");
    //out.print("ename : " + e.getEname() + "<br>");
    
    
    //위 에서 했던 작업을 좀더 편하게 (...)
    //<jsp:useBean id="[빈이름]" class="[자바빈클래스이름]" scope="[범위]" />
    //id - JSP 페이지에서 자바빈 객체에 접근할 때 사용할 이름
	//class - 패키지 이름을 포함한 자바빈 클래스의 완전한 이름
	//scope - 자바빈 객체가 저장될 영역을 지정한다. 
	//page, request, session, application 중 하나를 값으로 갖는다. 기본값은 page
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="Ex25_UseBean_Forward.jsp"></jsp:forward>
</body>
</html>









