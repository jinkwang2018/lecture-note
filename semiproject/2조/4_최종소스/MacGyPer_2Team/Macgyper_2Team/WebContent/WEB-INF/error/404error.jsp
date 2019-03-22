<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Bootstrap/assets/css/form-elements.css">
</head>

<body>
<div align="center">
<div style="max-height:100%; width:60%; height:50%;">
	<img src="Images/error.gif" style="width:70%;">	
</div>


<div align="center">
	<img src="Images/logoMacgyper.png" style="width:20%;height:20%;"> 
	<h1 style="color: #253d52">404 ERROR</h1>
	<h2 style="color: #253d52">죄송합니다. 현재 찾을 수 없는 페이지를 요청 하셨습니다.</h2>
	<p>존재하지 않는 주소를 입력하셨거나,</p>
	<p>요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.</p>
	<br>
	<p>감사합니다.</p>
 <button type="button" class="btn" style="position : absoulte;"  onClick="location.href='<%= request.getContextPath() %>/Login.jsp'">로그인</button>
 <button type="button" class="btn" style="position : absoulte;"  onClick="location.href='<%= request.getContextPath() %>/joingo.ch'">회원가입</button>

</div>
</div>
</body>
</html>