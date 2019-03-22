<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>BMark Admin Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Bootstrap -->
  <link href="style/bootstrap-theme.css" rel="stylesheet">
  
  <!-- custom CSS -->
  <link href="style/bookadd-form.css" rel="stylesheet">
	
  <!-- jQuery CDN -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
  <script type="text/javascript">
    alert("등록성공");
  	$(function(){
  		mainlist();
	  	
  	});
  		/* Member List 탭 클릭하면  회원목록 페이지를 div id=display에 append (비동기 처리)*/
  	function memberlist() {
  		$.ajax(
  				{
  	  				url:"memberlist.admin",
  	  				dataType:"html",
  	  				type:"POST",
  	  				success:function(data){
  	  					$('#display').empty();
  	  					$('#display').append(data);
  	  				}
  	  			}
  		)
	}
  	function grouplist() {
  		$.ajax(
  				{
  	  				url:"grouplist.admin",
  	  				dataType:"html",
  	  				type:"POST",
  	  				success:function(data){
  	  					$('#display').empty();
  	  					$('#display').append(data);
  	  				}
  	  			}
  		)
	}
  	function mainlist() {
  		$.ajax(
  				{
  	  				url:"mainlist.admin",
  	  				dataType:"html",
  	  				type:"POST",
  	  				success:function(data){
  	  					$('#display').empty();
  	  					$('#display').append(data);
  	  				}
  	  			}
  		)
	}
  		
  		
  		
  </script>
  
</head>
<body>

<div class="container">
  
  <% pageContext.include("admin/admin_header.jsp"); %>
  
		<!-- tabs menu -->
		<ul class="nav nav-tabs">
			<li><a id="member" onclick='memberlist()'>회원 관리</a></li>
			<li><a id="group" onclick='grouplist()'>그룹 관리</a></li>
			<li><a id="main" onclick='mainlist()'>메인 사이트 관리</a></li>
		</ul>
		<br>
		
		<!-- 페이지 데이타 비동기 -->
		<div id="display">

		</div>
	
</div>

</body>
</html>
