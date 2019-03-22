<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response 객체(응답객체)</title>
</head>
<body>
	<!-- 
		Client -> Server 
	     (request : 요청)
	 	Server -> Client
	 	 (response : 응답)
	 	
	 	javax(Tomcat)
	 	response 객체  
	 	1.표현식(출력)
	 	2.페이지이동처리(sendRedirect)
	 	
	 	response.sendRedirect() : WAS가 가지는 객체의 함수(java)
	 		 == location.href = "Ex01_Basic.jsp"; : javascript 코드
	 -->
	 1.일반적인 사용(=출력) : <%= 100+200+300 %> 응답해라 , 출력해라 <br>
	 2.sendRedirect  : response 객체의 함수(클라이언트 서버에게 재요청)<br>
	 <%
	 	//response.sendRedirect("Ex01_Basic.jsp"); // 페이지에 대한 재요청
	 	
	 %>
	
	 <script type="text/javascript">
	 	location.href = "Ex01_Basic.jsp"; /*서버에게 페이지를 재요청*/
	 </script>
</body>
</html>
