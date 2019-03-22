<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="Emplist" value="${requestScope.Emplist}"></c:set>
<div align=center>
<h2> Line Memo List </h2>
<table style="border-style: "border = > 
	 <tr>
	 	<th>EMPNO</th> 
	 	<th>ENAME</th>
	 	<th>JOB</th>
	 	<th>MGR</th>
	 	<th>HIREDATE</th>
	 	<th>SAL</th>
	 	<th>COMM</th>
	 	<th>DEPTNO</th>
	 </tr>
	 <c:forEach var="emp" items="${Emplist}">
	 	<tr>
	 		<td>${emp.empno}</td>
	 		<td>${emp.ename}</td>
	 		<td>${emp.job}</td>
	 		<td>${emp.mgr}</td>
	 		<td>${emp.hiredate}</td>
	 		<td>${emp.sal}</td>
	 		<td>${emp.comm}</td>
	 		<td>${emp.deptno}</td>
			<td><a href="memberedit?empno=${emp.empno}">[수정]</a> 	</td>			
				  						 	
	 </tr>
	 </c:forEach>   
</table>
</div>


</body>
</html>
