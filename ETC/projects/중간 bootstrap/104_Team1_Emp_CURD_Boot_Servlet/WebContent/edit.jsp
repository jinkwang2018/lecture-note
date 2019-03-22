<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>
<c:set var="emp" value="${requestScope.empedit}"></c:set>
<body class="bg-dark">
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">추가하기</div>
			<div class="card-body">
				<form action="editok" method="post">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">empno</label> <input
									class="form-control" name="empno" type="text"
									placeholder="Enter empno" value="${emp.empno}" readonly>
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">ename</label> <input
									class="form-control" name="ename" type="text"
									placeholder="Enter ename" value="${emp.ename}">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputEmail1">job</label> <input
									class="form-control" name="job" type="text"
									placeholder="Enter job" value="${emp.job}">
							</div>
							<div class="col-md-6">
								<label for="exampleInputPassword1">mgr</label> <input
									class="form-control" name="mgr" type="text"
									placeholder="Enter mgr" value="${emp.mgr}">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleConfirmPassword">hiredate</label> <input
									class="form-control" name="hiredate" type="text"
									placeholder="Enter hiredate" value="${emp.hiredate}" readonly>
							</div>
							<div class="col-md-6">
								<label for="exampleInputPassword1">sal</label> <input
									class="form-control" name="sal" type="text"
									placeholder="Enter sal" value="${emp.sal }" >
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleConfirmPassword">comm</label> <input
									class="form-control" name="comm" type="text"
									placeholder="Enter comm" value="${emp.comm}">
							</div>
							<div class="col-md-6">
								<label for="exampleInputPassword1">deptno</label> <input
									class="form-control" name="deptno" type="text"
									placeholder="Enter deptno" value="${emp.deptno}">
							</div>
						</div>
					</div>
					
					<input type="submit" value="수정하기" class="btn btn-primary btn-block">
					<input type="button" onclick="location.href='tables.jsp'" value="취소" class="btn btn-primary btn-block">

				</form>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>

