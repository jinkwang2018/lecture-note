<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer</title>
<meta charset="UTF-8">
<link href="<%= request.getContextPath() %>/css/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath() %>/css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/js/sb-admin.min.js"></script>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="<%= request.getContextPath() %>/js/jquery.validate.js"></script>
<style>
body {
	background-color: #F9C300;
}

body * {
	box-sizing: border-box;
}
.header {
	background-color: #F9C300;
	color: white;
	font-size: 1.5em;
	padding: 1rem;
	text-align: center;
	text-transform: uppercase;
}

.table-users {
	border: 1px solid #F9C300;
	border-radius: 10px;
	box-shadow: 3px 3px 0 rgba(0, 0, 0, 0.1);
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
	vertical-align: middle;
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
<script type="text/javascript">
 $(document).ready(function(){
	
		$('#update').validate({	
				
				rules:{
				pwd:{
					required: true,
					rangelength: [6, 18]
				},
				pwdcheck:{
					required: true,
					rangelength: [6, 18],
				 	equalTo: '#pwd'
				},
				email:{
					required: true,
	                email: true
				},
				pno:{
					required: true,
					rangelength: [8, 11],
					number: true
				}
			}, messages:{
				pwd:{
					required: "패스워드를 입력하세요.",
	                rangelength: $.validator.format("<font color='red' size='1px'>비밀번호는 6~18글자로 입력해주세요.</font>") 
				},
				pwdcheck:{
					required: "패스워드를 확인해주세요.",
					rangelength: $.validator.format("<font color='red' size='1px'>비밀번호는 6~18글자로 입력해주세요.</font>"),
	                equalTo: "<font color='red' size='1px'>비밀번호가 일치하지 않습니다.</font>"
				},
				email:{
					required: "이메일을 입력하세요",
	                email: "<font color='red' size='1px'>E-Mail 확인해주세요.</font>"
				},
				pno:{
					required: "핸드폰 번호를 입력하세요",
				    rangelength: $.validator.format("<font color='red' size='1px'>핸드폰번호는 8~11글자로 입력해주세요.</font>"),
				    number: "<font color='red' size='1px'>핸드폰번호는 숫자만 입력해주세요.</font>"
				}
				
			}
		});
 });
</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer"
			style="padding-top: 30px; text-align: center">
			<c:set var="myupdate" value="${requestScope.joindto}"></c:set>
			<div class="col-sm-20, table-users" style="margin: auto;">
				<div style="background-color: #F9C300">
					<h2 style="color: #fff;">회원 정보</h2>
				</div>
				<div class="table-responsive" id="detailView">
					<form action="<%= request.getContextPath() %>/myupdate.ch"
						method="post" name="update" id="update">
						<table class="table" border="2"
							style="table-layout: fixed; word-break: break-all; border-color: #F9C300;">
							<tr>
								<th>ID</th>
								<th>Password</th>
								<th>Password Check</th>
								<th>NAME</th>
								<th>PhoneNumber</th>
								<th>Email</th>
							</tr>
							<tr>
								<td><input type="text" name="id" id="id"
									value="${myupdate.id}" readonly></td>
								<td style="text-align: center;"><input name="pwd" id="pwd"
									type="password" value="${myupdate.pwd}"></td>
								<td style="text-align: center;"><input name="pwdcheck"
									id="pwdcheck" type="password" value="${myupdate.pwdcheck}"></td>
								<td style="text-align: center;"><input name="name"
									id="name" type="text" value="${myupdate.name}"></td>
								<td style="text-align: center;"><input name="pno" id="pno"
									type="text" value="${myupdate.pno}"></td>
								<td style="text-align: center;"><input name="email"
									id="email" type="text" value="${myupdate.email}"></td>
							</tr>
						</table>
						<input class="btn btn-warning" style="color: #fff;" type="submit"
							value="수정하기">
					</form>
				</div>
			</div>
		</div>
		<br><br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>