<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<%
	Emp e = new Emp();
	e.setEmpno(2000);
	e.setEname("user");
	
	HashMap<String,String> hp = new HashMap();
	hp.put("data","1004");
	hp.put("data2","1005");
	hp.put("data3","1006");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
기존방식:<%= e %><br>
기존방식:<%= e.getEmpno() %><br>
기존방식:<%= e.getEname() %><br>

<h3>EL(출력)</h3>
자바객체 출력하기(객체에 대한 직접접근 불가) : ${e}<br>
${e.getEmpno()}<br>

1.JSTL (core) 변수생성, 제어문 <br>
<c:set var = "m" value ="<%=e %>"/>
JSTL 변수 m을 만들고 서버쪽 코드로 값 설정 : ${m}<br>
<hr>
EL  출력 : JSTL 변수값을 : ${m}<br>
EL  출력 : JSTL 변수(이렇게 안써요) : ${m.getEmpno()}<br>
EL  출력 : 변수통해서 getter 함수 호출(member field) : ${m.empno}<br>
EL  출력 : 변수통해서 getter 함수 호출(member field) : ${m.ename}<br>
<hr>
<h3>EL & JSTL 사용하기</h3>
****EL 통해서 객체에 직접 접근 불가 *****<br>
request , session 객체 담은 것은 접근 가능 <br>
JSTL 변수의 (value 값)으로 (EL표현식)을 사용할 수 있다<br>
<c:set var="username"  value="${m.empno}"/> 
변수에 담긴 값 출력 : ${username}<br>

<hr>
<h3>JSTL 변수 만들고 scope 정의하기</h3>
<c:set var = "job" value = "농구선수" scope = "request"/>
당신의 직업은 : ${job }<br>
include or forward 된 페이지에서 JSTL 변수값을 공유 할 수 있다 <br>
<%//<jsp:include page=""></jsp:include> %>
<hr>
<c:set var = "job2" value = "야구선수" scope = "request"/>
변수 삭제하기 <br>
${job2 }<br>
<c:remove var="job2"/>
job2 변수 삭제 : ${job2}<br>

<c:set var="vhp" value="<%=hp %>"/>
hp객체 : ${vhp}<br>
hp객체 : ${vhp.data}<br>
hp객체 : ${vhp.data2}<br>
hp객체 : ${vhp.data3}<br>
<!-- 
	hp.put("color","red");
	
 -->
 JSTL로 put을 구현
 <c:set target="${vhp}" property="color" value="red"/>
 hp객체 : ${vhp}
</body>
</html>

