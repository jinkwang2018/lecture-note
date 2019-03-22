<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1단계
	<form action="Ex26_loginok.jsp" method = "post">
		사번:<input type = "text" name = "txtempno"><br>
		이름:<input type = "text" name = "txtename"><br>
		<input type = "submit" value = "전송하기"><br>
	</form>
	-->
	<!-- 
	넘어가는 parameter 이름을 Emp클래스의 memberfield 명과 동일 하다면
	
	?empno=9999&ename=김유신
	 -->
	<form action="Ex26_loginok.jsp" method = "post">
		사번:<input type = "text" name = "empno"><br>
		이름:<input type = "text" name = "ename"><br>
		<input type = "submit" value = "전송하기">
	</form>
</body>
</html>
