<%@page import="kr.or.kosta.dto.Emp"%>
<%@page import="kr.or.kosta.dao.Empdao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/Top.jsp"></jsp:include>
	<%
		Empdao dao = new Empdao();
		ArrayList<Emp> memolist = dao.getEmpList();

		//요청 결과 저장
		request.setAttribute("memolist", memolist);
	%>
	<c:set var="memolist" value="${requestScope.memolist}"></c:set>
		<div align=center>
		<hr color=pink width=400>
		<h2>사원 수정/삭제 페이지</h2>
		<hr color=pink width=400>
		<div class="container">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>직종</th>
				<th>담당 매니저 번호</th>
				<th>입사일</th>
				<th>월급</th>
				<th>추가수당</th>
				<th>부서번호</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="emp" items="${memolist}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
					<td>${emp.hiredate}</td>
					<td>${emp.sal}</td>
					<td>${emp.comm}</td>
					<td>${emp.deptno}</td>
					<td><a href="Emp.do?cmd=UpdateForm&empno=${emp.empno}&ename=${emp.ename}&job=${emp.job}&mgr=${emp.mgr}&hiredate=${emp.hiredate}&sal=${emp.sal}&comm=${emp.comm}&deptno=${emp.deptno}">[UPDATE]</a>
						<a href="Emp.do?cmd=Delete&empno=${emp.empno}">&nbsp;&nbsp;[DELETE]</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>