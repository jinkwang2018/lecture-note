<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer JoinList</title>
<link href="<%= request.getContextPath() %>/css/Bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<link	href="<%= request.getContextPath() %>/css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath() %>/css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/js/sb-admin.min.js"></script>
<scrip src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
.over {
	cursor: pointer;
}

body {
	background-color: #F9C300;
}

body * {
	box-sizing: border-box;
}

.table-users {
	border: 2px solid #F9C300;
	border-radius: 10px;
	max-width: calc(100% - 2em);
	margin: 1em auto;
	overflow: hidden;
	width: 1500px;
}

table {
	width: 100%;
}

table td {
	text-align: center;
}

table th {
	background-color: #F2F1F1;
	font-weight: 900;
}

@media screen and (max-width: 700px) {
	table, tr, td {
		display: block;
	}
	td:nth-child(1):before {
		content: 'ID:';
	}
	td:nth-child(2):before {
		content: 'Password:';
	}
	td:nth-child(3):before {
		content: 'Password Check:';
	}
	td:nth-child(4):before {
		content: 'NAME:';
	}
	td:nth-child(5):before {
		content: 'PhoneNumber:';
	}
	td:nth-child(6):before {
		content: 'Email:';
	}
	tr {
		padding: 10px 0;
		position: relative;
	}
	tr:first-child {
		display: none;
	}
}
</style>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
       $(function(){
          RowUpdateJoin();
           
           $('#deletebtn').click(function(){
              var param = $('#updateForm').serialize();
              $.ajax({ 
                 url:"joindelete.ch",
                 type : "POST",
                 data : param,
                 success : function(returndata){
                       console.log(">"+returndata+"<");            
                        if(returndata>0){
                          alert("삭제성공");
                          GetBoardList(); //데이터 갱신하기
                       }else{
                          alert("삭제실패");
                       }  
                    }         
                 });
               return false; 
           });
           GetBoardList();      
      });  
      function RowUpdateJoin(){
         $('#updateForm').on("submit",function(){
            var param = $(this).serialize();
            $.ajax({
               type : "POST",
               url:"joinedit.ch",
               data : param, 
               success : function(returndata){
                     console.log(">"+returndata+"<");      
                      if(returndata>0){
                        alert("수정성공");
                        GetBoardList(); //데이터 갱신하기
                     }else{
                        alert("수정실패");
                     }  
                  }
               });   
             return false; 
         });
      }
      function GetBoardList(){  
        console.log("콘솔하이")
         $.ajax({
            type : "POST" ,
            url : "joinlist.ch",         
            success : function(data){
               var list = JSON.parse(data);
               console.log(data);
               console.log("getboardlist함수");
               $('#listView').empty();
               $('#listView').data("list",list);
                $.each(list, function(index, join){
                  var tr = "";
                  tr += "<tr index='"+ index +"'>";
                  tr += "<td>" + join.id + "</td>";
                  tr += "<td>" + join.pwd + "</td>";
                  tr += "<td>" + join.pwdcheck + "</td>";
                  tr += "<td>" + join.name + "</td>";
                  tr += "<td>" + join.pno + "</td>";
                  tr += "<td>" + join.email + "</td>";
                  tr += "</tr>";
                  
                  var trObj = $(tr);
                   trObj.addClass("over").on("click",function(){
                     var index = $(this).attr("index");
                     var data = $("#listView").data("list");
                     var rowdata = data[index];
                     $('#detailView').find(":input").each(function(){
                        var name = $(this).prop("name"); //속성의 이름만 가져오기
                        var value =rowdata[name];
                        if(value != undefined){
                           $(this).val(value);
                        }
                     });
                  }); 
                  $('#listView').append(trObj);
               });    
            }
         });
      }   
   </script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper" style="max-height: 100px">
		<div class="container-fluid" id="pageContainer"
			style="padding-top: 30px; text-align: center">
			<div class="col-sm-20, table-users" style="top: 20px;">

				<div style="background-color: #F9C300">
					<h2 style="color: #fff;">회원 목록</h2>
				</div>
				<div class="table-responsive">
					<table class="table" border="2" style="border-color: #F9C300;">
						<thead>
							<tr>
								<th>ID</th>
								<th>PWD</th>
								<th>PWDCheck</th>
								<th>NAME</th>
								<th>PHONENUMBER</th>
								<th>EMAIL</th>
							</tr>
						</thead>
						<tbody id="listView">
						</tbody>
					</table>
				</div>
			</div>

			<div class="col-sm-20, table-users" style="top: 20px;">

				<div style="background-color: #F9C300">
					<h2 style="color: #fff;">선택된 회원 정보</h2>
				</div>

				<div class="table-responsive" id="detailView">
					<form id="updateForm">
						<table class="table" border="2" style="border-color: #F9C300;">
							<tr>
								<th>ID</th>
								<th>PWD</th>
								<th>PWDCheck</th>
								<th>NAME</th>
								<th>PHONENUMBER</th>
								<th>EMAIL</th>
							</tr>
							<tr>
								<td><input type="text" name="id" value="" readonly></td>
								<td><input type="text" name="pwd" value="" readonly></td>
								<td><input type="text" name="pwdcheck" value="" readonly></td>
								<td><input type="text" name="name" value=""></td>
								<td><input type="text" name="pno" value=""></td>
								<td><input type="email" name="email" value=""></td>
							</tr>
						</table>
						<center>
							<input class="btn btn-warning" style="color: #fff;" type="submit"
								id="btnUpdate" value="수정하기"> <input
								class="btn btn-warning" style="color: #fff;" type="button"
								id="deletebtn" value="삭제하기"> <input
								class="btn btn-warning" style="color: #fff;" type="button"
								value="메인가기" onclick="location.href='join/Main.jsp'">
					</form>
					<br><br>
				</div>
			</div>
			</center>

		</div>
		<br><br>
	</div>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>