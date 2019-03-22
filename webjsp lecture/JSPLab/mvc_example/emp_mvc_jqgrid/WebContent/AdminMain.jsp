<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>사원관리페이지</title>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="assets/jquery/jquery-2.1.4.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/datatables/js/jquery.dataTables.min.js"></script>
	<script src="assets/datatables/js/dataTables.bootstrap.js"></script>
	<script src="assets/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	
	<!-- CSS includes -->
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="assets/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet">

	<script type="text/javascript">
	
	
	function sendData() {
  		var select_type = $("#select_deptno").val();
  		
  		var param_url = "?deptno="+select_type;
  		console.log(param_url);
  		$.ajax({
  	        url : "/zEmpList/EmpSearch2?deptno="+select_type,
  	        type: "POST",
  	        dataType: "JSON",
  	        success: function(data)
  	        {
  	        	var tmp =""; 	        	
  	            if(data.length==0){	       
  	            	tmp="<tr><td colspan=8>해당 부서의 정보가 없습니다.</td></tr>"
  	            }  	        	
  	            else{
	  	        	for(var i= 0; i<data.length; i++){	        		
	  	        		var comm ="";
	  	        		if(data[i].comm != null){
	  	        			comm = data[i].comm;
	  	        		}
	  	        		
	  	        		var mgr ="";
	  	        		if(data[i].mgr != null){
	  	        			mgr = data[i].mgr;
	  	        		}
	  	        		
	  	        		tmp += "<tr>"
	  	        		     +"<td>"+data[i].empno+"</td>"
	  	        		     +"<td>"+data[i].ename+"</td>"
	  	        		 	 +"<td>"+data[i].job+"</td>"
	  	        			 +"<td>"+mgr+"</td>"
	  	        			+"<td>"+data[i].hiredate+"</td>"
	  	        			+"<td>"+data[i].sal+"</td>"
	  	        			+"<td>"+comm+"</td>"
	  	        			+"<td>"+data[i].depno+"</td>"
	  	        		    +"</tr>";
	  	        	}
  	            }
  	        	$("#UserList2").html(tmp);
  	        },
  	        error: function (jqXHR, textStatus, errorThrown)
  	        {	
  	            alert('오류남');
  	 
  	        }
  	    });
	}
  	
  	
  	function fnSearch() {
  		
  		var select_name = $("#select_name").val();
  		var select_type = $("#select_type").val();
  		
  		console.log(select_name);
  		
  		var encode_select_name = encodeURI(select_name);
  		var param_url = "?select_name="+encode_select_name+"&select_type="+select_type;
  		$.ajax({
  	        url : "/zEmpList/EmpSearch"+param_url,
  	        type: "POST",
  	        //data: {"select_name":encode_select_name,"select_type":select_type},
  	        dataType: "JSON",
  	        success: function(data)
  	        {
  	        	console.log(data);
  	            
  	        	var tmp ="";
  	        	
  	        	for(var i= 0; i<data.length; i++){
  	        		
  	        		var comm ="";
  	        		if(data[i].comm != null){
  	        			comm = data[i].comm;
  	        		}
  	        		
  	        		var mgr ="";
  	        		if(data[i].mgr != null){
  	        			mgr = data[i].mgr;
  	        		}
  	        		
  	        		tmp += "<tr>"
  	        		     +"<td>"+data[i].empno+"</td>"
  	        		     +"<td>"+data[i].ename+"</td>"
  	        		 	 +"<td>"+data[i].job+"</td>"
  	        			 +"<td>"+mgr+"</td>"
  	        			+"<td>"+data[i].hiredate+"</td>"
  	        			+"<td>"+data[i].sal+"</td>"
  	        			+"<td>"+comm+"</td>"
  	        			+"<td>"+data[i].depno+"</td>"
  	        			+"</tr>";
  	        	}
  	        	
  	        	$("#UserList2").html(tmp);
  	            
  	 
  	        },
  	        error: function (jqXHR, textStatus, errorThrown)
  	        {	
  	            alert('오류남');
  	 
  	        }
  	    });
  	}
  	
	</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<!-- <div class="container-fluid"> -->
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Admin PAGE</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li class="active"><a href="AdminMain.jsp">DeptnoSelect</a></li>
				<li class="active"><a href="<%=request.getContextPath() %>/jsp/dynamicemp.jsp">DynamicEMP</a></li>
				<li class="active"><a href="<%=request.getContextPath() %>/jsp/highcharts.jsp">HighCharts</a></li>
			</ul>
		<!-- </div> -->
	</nav>
<form action="EmpList" name="empform" id="empform">
	<div class="container">
		<div class="jumbotron" style="text-align: center; background-color: rgba(255, 41, 66, 0.54);">
			<h2 id="Userlist"><i><b>Songvly Fanclub Member List</b></i></h2>
		</div>
 		<div class="container">
		

			<select id="select_type">
				<option value="empno">사원번호</option>
				<option value="ename">사원이름</option>
				<option value="sal">월급</option>
			</select>
			<input type="text" id="select_name" name="select_name" maxlength="5">
			<input type="button" class="btn btn-success" id="searchbtn" value="검색" onclick="fnSearch()">
			
			
			<!-- ---------------------------------서치 수정 ------------------------------------ -->
			
	<!-- 		<input type="button" class="btn btn-success" id="searchbtn" onclick="fnGetList();" value="목록"> -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="search">부서번호를 선택하세요</label> &nbsp;&nbsp;&nbsp;
		
			 <select id="select_deptno" onchange="sendData()">
				<option value="">선택</option>
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
			</select>
			<!-- <input type="text" id="select_name" name="select_name" maxlength="5">
			<input type="button" class="btn btn-success" id="searchbtn" value="검색" onclick="fnSearch2()"> -->
			
		

		</div> 
		<br>
		<div class="container" id="UserList">
 				<%-- <table class="table">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>직종</th>
						<th>Manager</th>
						<th>HireDate</th>
						<th>월급</th>
						<th>Com</th>
						<th>부서번호</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					 	<c:set var = "MemberList" value = "${requestScope.result}"></c:set>
 					<c:forEach var="i" items="${MemberList}">
						<tr>
							<td>${i.getEmpno()}</td>
							<td>${i.getEname()}</td>
							<td>${i.getJob()}</td>
							<td>${i.getMgr()}</td>
							<td>${i.getHiredate()}</td>
							<td>${i.getSal()}</td>
							<td>${i.getComm()}</td>
							<td>${i.getDeptno()}</td>
            				<td><a href="<%=request.getContextPath() %>/EmpUpdate_View?empno=${i.getEmpno()}">수정</a></td>
            				<td><a href="<%=request.getContextPath() %>/EmpDelete?empno=${i.getEmpno()}">삭제</a></td>
<!-- 							<td><a href ="delete.jsp">삭제</a></td> -->
						</tr>
					</c:forEach>
				</table> --%>
			</div>
			
			<div class="container">
 				<table id="table" class="table table-striped table-bordered">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>직종</th>
						<th>Manager</th>
						<th>HireDate</th>
						<th>월급</th>
						<th>Com</th>
						<th>부서번호</th>
					</tr>
					<tbody id="UserList2">
					</tbody>
					
				</table>
			</div>                                                                          
			
			
			
	</div>
	</form>
</body>
</html>
