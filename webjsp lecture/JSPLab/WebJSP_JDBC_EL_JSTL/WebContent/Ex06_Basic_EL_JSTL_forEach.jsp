<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 제어문 연습하기</title>
</head>
<body>
<h3>JSTL for</h3>
<!-- 
	for(int i = 0 ; i<=10 ; i++){.....}
	
 -->
 <c:forEach var = "i" begin = "1" end = "10">
 	<c:set var = "sum" value ="${sum+i}"/>
 </c:forEach>
 sum 누적값 : ${sum}<br>
 
 <h3>5단 출력하기</h3>
 <c:forEach var ="i" begin = "1" end ="9">
 	<li>5*${i}=${5*i}</li>
 </c:forEach>
 
 <h3> EL & JSTL사용해서 (디자인 마음대로) 1~9구구단</h3>
 <c:forEach var = "i" begin ="2" end ="9">
 	<c:forEach var = "j" begin = "1" end ="9">
 		
 			${i}*${j}=${i*j}<br>
 	
 	</c:forEach>
 </c:forEach>
 
 <h3>JSTL forEach 객체 출력하기</h3>
 <%
 	int[]arr = new int[]{10,20,30,40};
 	for(int i : arr){
 		out.print("출력값 : " + i + "<br>");
 	}
 %>
 <h3>************[EL 객체 접근 불가, JSTL을 사용해서 변수에 담은 후에 EL사용]*************</h3>
 arr 배열 (객체) : ${arr}<br>
 <c:set var = "intarr" value ="<%=arr%>"/>
 c:set 변수로 접근 : ${intarr}<br>
 <h3> forEach 개선된 for(items 제공)</h3>
 <c:forEach var = "i" items = "${intarr}">
 	배열값_1 : ${i}<br>
 </c:forEach>
 <hr>
 <c:forEach var = "i" items = "<%=arr%>">
 	담아서 쓸 필요가 없다면 배열값_2 : ${i}<br>
 </c:forEach>
 <hr>
 items 속성 : 객체의 주소값 <br>
 <c:forEach var = "i" items = "<%=new int[]{1,2,3,4,5}%>">
 	배열값_3 : ${i}<br>
 </c:forEach>
 
 <h3>forEach 활용하기 2</h3>
 <c:forEach var="i" items="${intarr}" varStatus ="status">
 	index : ${status.index}&nbsp;&nbsp;&nbsp;
 	count : ${status.count}&nbsp;&nbsp;&nbsp;
 	value : ${i}<br>
 </c:forEach>
 
 <h3>TODAY POINT(JSTL forEach활용)</h3>
 <%
 	List<Emp> emplist = new ArrayList<>();
 	emplist.add(new Emp(1000,"A"));
 	emplist.add(new Emp(2000,"B"));
 	emplist.add(new Emp(3000,"C"));
 	
 	//출력
 	for(Emp e : emplist){
 		out.print(e.getEmpno() + "/" + e.getEname()+"<br>");
 	}
 %>
 
 <h3>JSTL로 출력</h3>
 <c:set var = "list" value ="<%=emplist%>"/>
 <table border = "1">
 	<tr><td>사번</td><td>이름</td></tr>
 <c:forEach var = "emp" items = "${list}">
 	<tr><td>${emp.empno}</td><td>${emp.ename}</td></tr>
 </c:forEach>
 </table>
 <hr>
 <table border = "2">
 	<tr><td>사번</td><td>이름</td></tr>
 <c:forEach var = "emp" items = "<%=emplist%>">
 	<tr><td>${emp.empno}</td><td>${emp.ename}</td></tr>
 </c:forEach>
 </table>
 
 <h3>JSTL 사용 Map 다루기</h3>
 <%
 	Map<String,Object> hm = new HashMap<>();
 	hm.put("name","hong");
 	hm.put("pwd","1004");
 	hm.put("date",new Date());
 	
 %>
 <c:set var = "hm" value = "<%= hm %>"/>
 <c:forEach var = "obj" items = "${hm}">
 	${obj.key} => ${obj.value}<br>
 </c:forEach>
 
 <h3>JSTL 단일 구분자</h3>
 <c:forTokens var = "token" items="A.B.C.D" delims=".">
 	${token}<br>
 </c:forTokens>
 <hr>
 <h3>JSTL 복합 구분자</h3>
 <c:forTokens var = "token" items="A.B/C-D" delims="./-">
 	${token}<br>
 </c:forTokens>
 
</body>
</html>
