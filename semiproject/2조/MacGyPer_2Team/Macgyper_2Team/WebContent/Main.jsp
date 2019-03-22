<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer</title>  
<link href="<%= request.getContextPath() %>/css/Bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath() %>/css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/js/sb-admin.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
  	<div class="content-wrapper" style="text-align: center">
		<video width="90%" height="80%" autoplay loop>
  			<source src="css/mp4/Typing - 10839.mp4" type="video/mp4">
		</video>
  		<br><br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>