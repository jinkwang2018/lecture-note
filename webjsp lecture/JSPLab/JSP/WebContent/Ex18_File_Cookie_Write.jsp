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
		1.메모리 쿠키(브라우져 쿠키) : 클라이언트가 강제로 지우지 않는한 브라우져가 닫히기 전까지 유지된다. 
							 소멸타입 : -1 > Session 이 소멸되면 같이 없어진다.
			
		2.파일 쿠키(소멸 시간을 가지고 있다.) : 클라이언트가 강제로 지우지 않는한 브라우져를 닫아도 정해진 시간까지 남아있다.
								  setMaxAge(60) // 60초
								  setMaxAge(30*24*60*60) // 30일
		
	 -->
	 <%
	 	Cookie co = new Cookie("bit","kim");
	 	//co.setMaxAge(30*24*60*60); //30일 동안 유지해라
	 	co.setMaxAge(60);
	 	response.addCookie(co);
	 %>
</body>
</html>
