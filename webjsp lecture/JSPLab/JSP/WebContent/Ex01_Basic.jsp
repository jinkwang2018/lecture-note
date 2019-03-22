<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  --> 
<%
     //스크립트 릿(java code 작성 영역)
     Date day = new Date();

     /*  
     	JSP 페이지 (UI > html + script + css + java코드)
     	JSP 페이지 (tomat(WAS) => (jsp)java => compile(class) => 결과(정적+동적) => client전달)
        Ex01_Basic.jsp.java >> Ex01_Basic.jsp.class
        D:\bitcamp104\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WebJSP\org\apache\jsp
        JSP 구성요소
        
        1.선언부 (JSP 페이지에 대한 기본 설정 세팅)
        ex) page(지시자) > 사용언어, 인코딩 , import 지원 ....

        2.스크립트 요소
        2.1 (스크립트 릿) : java 코드 구현 영역
        2.2 표현식 : 값을출력(출력대상 : client 웹 브라우져)  <%=
        2.3 선언부 (공통적인 자원 (공통함수))  <%!
     */

%>
<%!
/* 선언부 (공통함수 영역) */
public int add(int i , int j){
	return i+j;
}

%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
표현식 : <%= day %>
<%
   int result = add(100, 200);
%>
<hr>
당신이 호출한 함수 결과는 : <%= result %>
</body>
</html>
