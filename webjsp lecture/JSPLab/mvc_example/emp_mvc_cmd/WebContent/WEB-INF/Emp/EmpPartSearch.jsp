<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/common/Top.jsp"></jsp:include>
	<c:set var="Elist" value="${requestScope.Elist}"></c:set>

	<div class="container">
<form action="EmpbyEmpno">
<label class="control-label required">사원번호로 검색<sup style="color: red">*</sup>
<input type="text" name="empno" id="empno">
<input type="submit" id="btn">
</form>
<div class="container">
		<div class="account-holder" style="border: 1px solid black;">
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
				<c:forEach var="e" items="${Elist}">
				<tr>
				
					<td>${e.empno}</td>
					<td>${e.ename}</td>
					<td>${e.job}</td>
					<td>${e.mgr}</td>
					<td>${e.hiredate}</td>
					<td>${e.sal}</td>
					<td>${e.comm}</td>
					<td>${e.deptno}</td>
				</tr>	
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
</div>
</body>
</html>