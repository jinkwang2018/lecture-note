<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>table</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$.ajax({
			
			// 받아올 페이지 주소(전송주소)
			url : "getdeptname",

			//서버가 client 응답 형식 : html
			dataType : "json",

			success:function(data){
				console.log(data);
				
				// <option value="1">전체</option>
				var intvalue = 10;
				$.each(data,function(index,el){
				var optionstr = '';
				optionstr = '<option value = "' + intvalue + '">' + el + '</option>';  				
				intvalue += 10;
				$('#search_deptno').append(optionstr);
				});
				
			} // end - success		
		});
		
		
		$('#emp_btn').click(function() {
			$('#targetdiv').empty();
			var empno = $('#search_empno').val();

			jQuery.ajax({

				// 받아올 페이지 주소(전송주소)
				url : "Listservlet",

				// 전송타입
				type : "get",

				// 보내는 data
				data : {
					"empno" : empno
				},

				//서버가 client 응답 형식 : html
				dataType : "json",

				success:function(data){
					//$('#targetdiv').empty();
					console.log(data);
					
					var tablestr = '<table class="table table-bordered">';
					tablestr += '<th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th><th>수정하기</th><th>삭제하기</th> ';
					$.each(data,function(index,obj){
						tablestr+='<tr>';
						tablestr+='<td>' + obj.empno + '</td>';
						tablestr+='<td>' + obj.ename + '</td>';
						tablestr+='<td>' + obj.job + '</td>';
						tablestr+='<td>' + obj.mgr + '</td>';
						tablestr+='<td>' + obj.hiredate + '</td>';
						tablestr+='<td>' + obj.sal + '</td>';
						tablestr+='<td>' + obj.comm + '</td>';
						tablestr+='<td>' + obj.deptno + '</td>';
						tablestr+="<td><a class='btn btn-primary' href='memberedit?empno="+ obj.empno+"'id = 'toggleNavColor'>" + "수정" + "</a></td>";
                        tablestr+="<td><a class='btn btn-primary' href='EmpDelete?empno="+ obj.empno+"'id = 'toggleNavColor'>" + "삭제" + "</a></td>";
						tablestr+='</tr>';
					});	
					tablestr+= '</table>';
					$('#targetdiv').append(tablestr);
					
				} // end - success
			}); // end - ajax
		}); // end - click
		
		$('#empno_btn').click(function() {

			$('#targetdiv').empty();
			var empno = $('#search_empno').val();

			jQuery.ajax({

				// 받아올 페이지 주소(전송주소)
				url : "EmpSearch",

				// 전송타입
				type : "get",

				// 보내는 data
				data : {
					"empno" : empno
				},

				//서버가 client 응답 형식 : html
				dataType : "json",

				success:function(data){
					//$('#targetdiv').empty();
					console.log(data);
					
					var tablestr = '<table class="table table-bordered">';
					tablestr += '<th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th><th>수정하기</th><th>삭제하기</th> ';
					$.each(data,function(index,obj){
						tablestr+='<tr>';
						tablestr+='<td>' + obj.empno + '</td>';
						tablestr+='<td>' + obj.ename + '</td>';
						tablestr+='<td>' + obj.job + '</td>';
						tablestr+='<td>' + obj.mgr + '</td>';
						tablestr+='<td>' + obj.hiredate + '</td>';
						tablestr+='<td>' + obj.sal + '</td>';
						tablestr+='<td>' + obj.comm + '</td>';
						tablestr+='<td>' + obj.deptno + '</td>';
						tablestr+="<td><a class='btn btn-primary' href='memberedit?empno="+ obj.empno+"'id = 'toggleNavColor'>" + "수정" + "</a></td>";
                        tablestr+="<td><a class='btn btn-primary' href='EmpDelete?empno="+ obj.empno+"'id = 'toggleNavColor'>" + "삭제" + "</a></td>";
						tablestr+='</tr>';
					});	
					tablestr+= '</table>';
					$('#targetdiv').append(tablestr);
					
				} // end - success
			}); // end - ajax
		}); // end - click
		
		$('#emp_btn').click();
		
	}); // end - function

</script>


</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="main.jsp">Start Bootstrap</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link" href="main.jsp"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Tables"><a class="nav-link" href="tables.jsp"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Tables</span>
				</a></li>
			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">

			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">

			사번으로 검색 : <input type="text" id="search_empno">
			<input class="btn btn-primary" type="button" id="empno_btn" value="검색">
			<input class="btn btn-primary" type="button" id="emp_btn" value="전체검색">
			<input class="btn btn-primary" data-toggle="modal" data-target="#myModal1" type="button" id="mamodal1" value="추가">
			
			<br><br> 
			부서번호로 검색	: <select name="deptno" id="search_deptno">
			</select>
			<br><br> 

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Emp
				</div>

				<div class="card-body">
						<div class="table-responsive" id="targetdiv">
						
			            </div> <!-- end - targetdiv -->
				</div> 

			</div>

          
           
		</div>
	</div>

<script type="text/javascript">

$("select").change(function () {    
	$('#targetdiv').empty();
	var deptno = $('#search_deptno').val();
	
	jQuery.ajax({

		// 받아올 페이지 주소(전송주소)
		url : "dept",

		// 전송타입
		type : "get",

		// 보내는 data
		data : {
			"deptno" : deptno
		},

		//서버가 client 응답 형식 : html
		dataType : "json",

		success:function(data){
			//$('#targetdiv').empty();
			console.log(data);
			
			var tablestr = '<table class="table table-bordered">';
			tablestr += '<th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th><th>수정하기</th><th>삭제하기</th> ';
			$.each(data,function(index,obj){
				tablestr+='<tr>';
				tablestr+='<td>' + obj.empno + '</td>';
				tablestr+='<td>' + obj.ename + '</td>';
				tablestr+='<td>' + obj.job + '</td>';
				tablestr+='<td>' + obj.mgr + '</td>';
				tablestr+='<td>' + obj.hiredate + '</td>';
				tablestr+='<td>' + obj.sal + '</td>';
				tablestr+='<td>' + obj.comm + '</td>';
				tablestr+='<td>' + obj.deptno + '</td>';
				tablestr+="<td><a class='btn btn-primary' href='memberedit?empno="+ obj.empno+"'id = 'toggleNavColor'>" + "수정" + "</a></td>";
                tablestr+="<td><a class='btn btn-primary' href='EmpDelete?empno="+ obj.empno+"'id = 'toggleNavColor'>" + "삭제" + "</a></td>";
				tablestr+='</tr>';
				
			});	
			tablestr+= '</table>';
			$('#targetdiv').append(tablestr);
			
		} // end - success
	}); // end - ajax
	
});  
</script>

<!-- 추가하기 -->
	<div id="myModal1" class="modal fade" role="dialog" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Sign Up</h4>
							</div>
							<form action="EmpInsertServlet">
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
				
				
				
				
	<!-- /.content-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © Your Website 2018</small>
			</div>
		</div>
	</footer>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>
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
	</div>
</body>

</html>
