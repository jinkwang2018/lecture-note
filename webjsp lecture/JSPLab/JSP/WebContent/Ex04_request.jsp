<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	/*
		request 객체
		Tomcat이 가지고 있는 내장 객체 (web 프로젝트가 tomcat을 가지고 있어야 한다.)
		*.JSP 파일은 default로 tomcat의 내장 객체를 선언 없이 사용할 수 있다.
		
		request(요청 객체)는
		1. 요청 페이지당 한개의 request객체가 생성된다.
		2. 클라이언트 정보를 서버로 가지고 온다.
		3. 클라이언트 정보(입력값,기본정보(브라우져 정보 , Ip정보))
		4. 내장객체이다. 내장객체는 클라이언트에서 서버로 요청할 때 생성되는 객체이다. 
		   HttpServletRequest 타입의 객체가 생성되고 그 주소를 request라는 참조변수 가 받는다.
	    
	*/
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>request 객체 탐구</title>
	</head>
	
	<body>
	id : <%= id %><hr>
	접속한 클라이언트 IP : <%= request.getRemoteAddr() %><br>
	서버 요청 방식 (인코딩 방식) : <%= request.getCharacterEncoding() %><br>
	전송 방식 : <%= request.getMethod()%><br>
	포트 : <%=request.getServerPort()%><br>
	context root(가상의 디렉토리, 홈디렉토리) :<%=request.getContextPath() %><br>
	<!-- 
	D:\bitcamp104\webjsp\JSPLab\Webjsp : 실제경로
	http://ip:port/WebJSP/파일 : 가상경로
	가상경로로 들어가면 실제 경로가 연결된다.>[WebContent] 
	 -->
	<%=request.getRequestURI()%><br>
	<!-- 가상 디렉토리 부터 파일까지의 경로 --> 
	</body>
</html>
