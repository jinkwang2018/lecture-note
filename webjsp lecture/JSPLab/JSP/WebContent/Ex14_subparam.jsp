<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h3>Ex14_include_param_main.jsp : request객체 공유</h3>
		<fieldset>
			<legend>INCLUDE</legend>
			request : <%= request.getParameter("type") %><br>
			request : <%= request.getParameter("userid") %><br>
		</fieldset>
		<h3>Main 페이지 param 액션태그 값 읽기</h3>
		<fieldset>
			<legend>INCLUDE(param 액션태그)</legend>
			<%
				String ttt = request.getParameter("aaaa");
				String ppp = request.getParameter("pwd");
				out.print("param 설정 값 : " + ppp + "<br>");
				if(ttt.equals("CCC")){
					out.print("<i>당싱이 요청한 제품은 :"+ ttt +"</i>");
				}else{
					out.print("<h>당싱이 요청한 제품은 품절입니다.</h>");
				}
			%>
		</fieldset>
	</body>
</html>
