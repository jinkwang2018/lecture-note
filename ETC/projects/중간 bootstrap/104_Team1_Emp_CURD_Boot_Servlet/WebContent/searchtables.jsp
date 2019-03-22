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
					   "<a class='btn btn-primary' href='memberedit?empno=${'"+ obj.empno + "'}' id='toggleNavColor'>" + '수정' + "</a>"
						+ "<a class='btn btn-primary' href='EmpDelete?empno=${'"+ obj.empno + "'}' id='toggleNavColor'>" + '삭제' + 
					   "</a></td></tr></tbody>"
					
					);
				});	
				$('table').append(
				"<thead><tr><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th><th>button</th></tr></thead>"
				)
				
			}
		}
	 );		
  });
  </script>
  
  
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

 <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            
            </table>
 </div>
           <a class="btn btn-primary" href="insert.jsp"id="toggleNavColor">추가</a>
           <a class="btn btn-primary" href="search.jsp" id="toggleNavColor">사번으로 검색</a>
      
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
