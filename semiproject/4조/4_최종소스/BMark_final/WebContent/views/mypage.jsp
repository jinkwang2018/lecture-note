<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>BMark My Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap -->
  <link href="style/bootstrap-theme.css" rel="stylesheet">

  <!-- custom CSS -->
  <link href="style/bookadd-form.css" rel="stylesheet">
  <link href="style/adminmy-page-table.css?ver=1" rel="stylesheet">
  <link href="style/my-page-style.css?ver=1" rel="stylesheet">
  <!-- jQuery CDN -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Validation API -->
  <script src=https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js></script>
  <!-- daum addr API  -->
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  <!-- Custom JS -->
  <script src="js/main_view.js?ver=1"></script>

  <script type="text/javascript">
  	$(function(){
  		memberedit();
	  	//$('#edit').on("click", memberedit());
	  	//$('#myb').on("click",mybmark());
	  	//$('#groupb').on("click",groupbmark());
  	});
  	/* 회원정보수정 탭 클릭하면  수정페이지를  div id=display에 append (비동기 처리)*/
  	function memberedit() {
  		$.ajax(
				{
  					url:"mypagememberedit.mybmark",
  					dataType:"html",
  					type:"POST",
  					success:function(data){
  						$('#display').empty();
  						$('#display').append(data);
  					}
  				}
		)
	}
  		/* My Book Mark 탭 클릭하면  My Book Mark페이지를 div id=display에 append (비동기 처리)*/
  	function mybmark() {
  		$.ajax(
  				{
  	  				url:"mypagemyblist.mybmark",
  	  				dataType:"html",
  	  				type:"POST",
  	  				success:function(data){
  	  					$('#display').empty();
  	  					$('#display').append(data);
  	  				}
  	  			}
  		)
	}
  		
  	/* Group Book Mark 탭 클릭하면  Group Book Mark페이지를  div id=display에 append (비동기 처리) */
  	function groupbmark() {
  		$.ajax(
  				{
   					url:"mypagegroupboardlist.mybmark",
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
	<style type="text/css">
	/* 유효성 검사 폰트 색깔 */
	.error {
		color: red;
	}
	</style>
</head>
<body>

<div class="container">
  
  <% pageContext.include("mypage/my_header.jsp"); %>
  
		<!-- tabs menu -->
		<ul class="nav nav-tabs">
			<li><a id="edit" onclick='memberedit()'>회원정보 수정</a></li>
			<li><a id="myb" onclick='mybmark()'>My Book Mark</a></li>
			<li><a id="groupb" onclick='groupbmark()'>Group Book Mark</a></li>
		</ul>
		<br>
		
		<!-- 수정, group book mark, my book mark 페이지 내용 뿌려주는 곳 -->
		<div id="display">

		</div>
	
</div>

</body>
</html>
