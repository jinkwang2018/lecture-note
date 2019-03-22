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
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
  $(function(){
  $('#button').click(function(){
		  $.ajax({
			url:"Listservlet",
			type:"get",			
			dataType:"json", //서버가 client 응답 형식 : html
			success:function(data){
				$('table').empty();
				console.log(data);
				
				$.each(data,function(index,obj){
					$('table').append(
							
					   "<tbody><tr><td>" + obj.empno + "</td><td>"	+ obj.ename + "</td><td>"
					   +obj.job + "</td><td>" + obj.mgr + "</td><td>" + obj.hiredate +
					   "</td><td>" + obj.sal + "</td><td>" + obj.comm +
					   "</td><td>" + obj.deptno + "</td><td>" + 
					   "<input type='button' class='btn btn-primary' data-toggle='modal' data-target='#myModal1' id ='button1' value='수정'>"
						+ "<a class='btn btn-primary' href='EmpDelete?empno=${'"+ obj.empno + "'}' id='toggleNavColor'>" + '삭제' + 
					   "</a></td></tr></tbody>"
					
					);
				});	
				$('table').append(
				"<thead><tr><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th><th>button</th></tr></thead>"
				)
				
			}
		});
	});
  
  });
  </script>
  
  
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
 <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            
            </table>
 </div>
           
           <input type="button" class="btn btn-primary" data-toggle='modal' data-target='#myModal2' id ="button1" value="추가">
           <input type="button" class="btn btn-primary" data-toggle='modal' data-target='#myModal3' id ="button2" value="사번으로 검색">
           <input type="button" class="btn btn-primary" id ="button" value="전체조회">
      
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
 	
 	<!-- 수정 -->
	<div id="myModal1" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">수정하기</h4>
				</div>
				<form action="memberedit?empno=obj.empno" id="signForm"
					name="signForm" method="post">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">empno</label> <input
									class="form-control" name="empno" type="text"
									placeholder="Enter empno" value="${obj.empno}" readonly>
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">ename</label> <input
									class="form-control" name="ename" type="text"
									placeholder="Enter ename" value="${obj.ename}">
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
									placeholder="Enter sal" value="${emp.sal }">
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

				</form>
			</div>
		</div>
	</div>

	<!-- 추가 -->
	<div id="myModal2" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">추가하기</h4>
				</div>
				<form action="EmpInsertServlet" id="signForm" name="signForm"
					method="post">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">empno</label> <input
									class="form-control" name="empno" type="text"
									placeholder="Enter empno">
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">ename</label> <input
									class="form-control" name="ename" type="text"
									placeholder="Enter ename">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputEmail1">job</label> <input
									class="form-control" name="job" type="text"
									placeholder="Enter job">
							</div>
							<div class="col-md-6">
								<label for="exampleInputPassword1">mgr</label> <input
									class="form-control" name="mgr" type="text"
									placeholder="Enter mgr">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleConfirmPassword">hiredate</label> <input
									class="form-control" name="hiredate" type="text"
									placeholder="Enter hiredate">
							</div>
							<div class="col-md-6">
								<label for="exampleInputPassword1">sal</label> <input
									class="form-control" name="sal" type="text"
									placeholder="Enter sal">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleConfirmPassword">comm</label> <input
									class="form-control" name="comm" type="text"
									placeholder="Enter comm">
							</div>
							<div class="col-md-6">
								<label for="exampleInputPassword1">deptno</label> <input
									class="form-control" name="deptno" type="text"
									placeholder="Enter deptno">
							</div>
						</div>
					</div>

					<input type="submit" value="추가하기" class="btn btn-primary btn-block">

				</form>
			</div>
		</div>
	</div>

	<!-- 검색 -->
	<div id="myModal3" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">이름으로 검색하기</h4>
				</div>
				<form action="EmpSearch">
					<div class="form-group">
						<label for="exampleInputEmail1">검색하실 Empno를 입력해주세요</label> <input
							class="form-control" name="empno" type="text"
							placeholder="Enter empno">
					</div>
					<input type="submit" value="사번으로 검색하기"
						class="btn btn-primary btn-block">
				</form>
			</div>
		</div>
	</div>

</body>

</html>
