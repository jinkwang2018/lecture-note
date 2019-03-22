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
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

	//jquery 로 간단하게 유효성 check 하기
	$(function() {
		var monthNames = [];
		for (var i = 1; i <= 12; i++) {
			monthNames.push(i + "월")
		}
		/* hiredate- datepicker */
		$("#hiredate").datepicker(
				{
					dateFormat : "yy년mm월dd일",
					prevText : "이전달",
					nextText : "다음달",
					monthNames : monthNames,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					yearSuffix : '년',
					numberOfMonths : 1,
					onSelect : function(date) {
						var currentdate = $("#hiredate").datepicker('getDate');
						var date = new Date(currentdate);
						$("#inputdate").val(
								date.getFullYear() + "- "
										+ (date.getMonth() + 1) + "- "
										+ date.getDate());
					}
				});
		/* deptno-spinner */
		var spinner = $('#deptno').spinner({
			step : 10,
			numberFormat : "n",
			max : 30,
			min : 10
		});
	});
</script>
<%
	Empdao dao = new Empdao();
	ArrayList<Emp> memolist = dao.getEmpList();

	//요청 결과 저장
	request.setAttribute("memolist", memolist);
%>
</head>
<body>
	<jsp:include page="/common/Top.jsp"></jsp:include>
	<!-- container -->

	<c:set var="empno" value="${param.empno}"></c:set>
	<c:set var="ename" value="${param.ename}"></c:set>
	<c:set var="job" value="${param.job}"></c:set>
	<c:set var="mgr" value="${param.mgr}"></c:set>
	<c:set var="hiredate" value="${param.hiredate}"></c:set>
	<c:set var="sal" value="${param.sal}"></c:set>
	<c:set var="comm" value="${param.comm}"></c:set>
	<c:set var="deptno" value="${param.deptno}"></c:set>

	<div class="container">
		<div class="account-holder" style="border: 1px solid black;">
			<form action="Update.do" method="post" name="InsertForm"
				id="InsertForm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">사원번호<sup
								style="color: red">*</sup>
							</label> <input id="empno" name="empno" type="text" class="form-control"
								value="${empno}" readonly>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">사원이름<sup
								style="color: red">*</sup></label> <input id="ename" name="ename"
								type="text" class="form-control" value="${ename}">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">직종<sup
								style="color: red">*</sup></label> <select id="job" name="job"
								class="form-control">
								<option>직종을 선택하세요</option>
								<c:choose>
									<c:when test="${job == 'CLERK'}">
										<option value="CLERK" selected="${job}">CLERK</option>
									</c:when>

									<c:when test="${job == 'SALESMAN'}">
										<option value="SALESMAN" selected="${job}">SALESMAN</option>
									</c:when>

									<c:when test="${job == 'MANAGER'}">
										<option value="MANAGER" selected="${job}">MANAGER</option>
									</c:when>

									<c:when test="${job == 'ANALYSY'}">
										<option value="ANALYST" selected="${job}">ANALYST</option>
									</c:when>

									<c:when test="${job == 'PRESENT'}">
										<option value="PRESENT" selected="${job}">PRESENT</option>
									</c:when>
								</c:choose>
								<option value="CLERK">CLERK</option>
								<option value="SALESMAN">SALESMAN</option>
								<option value="MANAGER">MANAGER</option>
								<option value="ANALYST">ANALYST</option>
								<option value="PRESENT">PRESENT</option>

							</select>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">담당 매니저 번호<sup
								style="color: red">*</sup></label> 
								<input id="mgr" name="mgr" type="text" class="form-control"
								value="${mgr}">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">입사일<sup
								style="color: red">*</sup></label>
							<div id="hiredate"></div>
							<input id="inputdate" name="hiredate" type="text" value="${hiredate}"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">월급<sup
								style="color: red">*</sup></label> <input id="sal" name="sal"
								type="text" class="form-control" value="${sal}">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">추가수당<sup
								style="color: red">*</sup></label> <input id="comm" name="comm"
								type="text" class="form-control" value="${comm}">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required" for="spinner">부서번호<sup
								style="color: red">*</sup></label> <input id="deptno" name="deptno"
								value="${deptno}" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<input type="submit" class="btn btn-primary btn-block"
							value="UPDATE">
					</div>
					<div class="col-sm-6">
						<input type="reset" class="btn btn-primary btn-block" value="취소">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>