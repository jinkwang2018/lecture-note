<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	Tomcat(WAS) 기본적으로 제공하는 객체
	1. request - 요청(클라이언트의 정보)
	2. response - 응답(특정 페이지에 대한 링크, 표현식 등등, 쿠키 사용)
	3. application - 전역객체(xml 제어 , 변수 만들어 모든 page에서 사용)
	4. session - (사용자마다 고유하게 부여되는 객체) 
	5. out - 출력
	6. .......
	
	session 객체
	[session변수]
	scope : 모든 페이지에서 사용가능(a.jsp(session.setAtt..) -> b.jsp(session.getAtt))
	Life-cycle : sessionId와 동일하다.
	 
	application 객체
	[application변수 : 전역]
	scope : 모든 사용자와 모든 페이지에서 사용가능하다. 
	       (모든 session == 모든 사용자)
	Life-cycle : web server가 죽으면 (재부팅되면)
	
	request 객체
	[request변수 : 지역]
	scope : 요청 page 한개 (login.jsp에서 요청하면 이곳에서만 사용할 수 있다.)
	 예외적으로 forward와  include가 있다면 request 객체를 공유할 수 있다.
	 -->
<%
	Emp emp = new Emp();
	emp.setEmpno(2000);
	emp.setEname("홍길동");
	session.setAttribute("empobj", emp);
	Emp e = (Emp)session.getAttribute("empobj");
	
	out.print(e.getEmpno() + "<br>" + e.getEname()+"<br>");
	
	request.setAttribute("who","king");
	String who = (String)request.getAttribute("who");
	out.print("request : " + who);
%>	
	
</body>
</html>
