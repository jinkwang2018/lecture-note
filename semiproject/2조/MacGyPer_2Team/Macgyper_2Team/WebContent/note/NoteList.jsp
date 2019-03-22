<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Note List</title>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<link href="css/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>

<style type="text/css">
.notelist{
	margin:30px;
	float:left;
	overflow:scroll; 
	width:300px; 
	height:350px; 
	padding:10px; 
	background-color: #F2F1F1;
	border: solid thin;
	border-color:#D9D9D9;
}
.notelist::-webkit-scrollbar { 
    display: none; 
}
   </style>

<script type="text/javascript">
	$(function() {
		$(document).on('click', '.note_delete', function() {
			var num = $(this).parent().parent().parent();
			document.del.submit();
		});

		$(document).on('click', '.note_update', function() {
			var num = $(this).parent().parent().parent();
			document.upd.submit();
		});

		$('#searchbtn')
				.on(
						"click",
						function() {
							var data2 = {
								notename : $("#notename").val(),
								id : "hoyong"
							};
							$.ajax({
										url : "SearchMemo.mo",
										dataType : "JSON",
										async : true,
										type : "POST",
										data : data2,
										success : function(data) {
											var list = "";
											$.each(
														data,
														function(index, obj) {
														 	list+='<div class="notelist" >'
													 			+'<div class="divdate" style="float:left; margin-right: 12px">날짜: '+obj.note_date+'</div>'
																+'<form name="del'+obj.note_num+'" action="DeleteMemo.mo" style="float: right;">'
													 			+'<input type="hidden" id="note_num" name="note_num" value="'+obj.note_num+'"/>'
													 			+'<div onClick="document.forms[\'del'+obj.note_num+'\'].submit();" style="cursor: pointer;">'
													 			+'<img  src="Images/trash.png">'
													 			+'</div>'
													 			+'</form>'
													 			+'<form action="UpdateMemo.mo" name="select'+obj.note_num+'" method="POST" style="float: right; margin-right: 10px ">'
																+'<div onClick="document.forms[\'select'+obj.note_num+'\'].submit();" style="cursor: pointer;">'
																+'<input type="hidden" id="note_num"  name="note_num" value="'+obj.note_num+'"/>'
													 			+'<img src="Images/note_full-screen.png">'
													 			+'</div>'
																+'</form>'
													 			+'<center><div class="divcontent" style="clear: both;"><h3>'+obj.note_title+'</h3></div></center><hr>'
													 			+'메모: '+obj.note_content+''	
													 			+'</div>' 
															});
											$('#test').empty();
											$('#test').append(list);
										}
									});
						});
	});
</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer"
			style="padding-top: 30px;">
			<c:set var="notelist" value="${requestScope.notelist}"></c:set>
			<div align=center style="margin-bottom: 20px;">
				<div
					style="background-color: #F9C300; width: 300px; height: 80px; display: table-cell; vertical-align: middle; border-radius: 10px;">
					<h2 style="color: #fff;">NOTE LIST</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-8"></div>
				<div class="col-sm-4">
					<div class="form-group input-group"
						style="float: right; width: 300px; margin-right: 10%">
						<input type="text" class="form-control" id="notename"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button" id="searchbtn">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>

			<div id="test">
				<c:forEach var="note" items="${notelist}">
					<div class="notelist">
						<div class="divdate" style="float: left; margin-right: 12px">날짜:
							${note.note_date}</div>
						<form name="del${note.note_num}" action="DeleteMemo.mo"
							style="float: right;">
							<input type="hidden" id="note_num" name="note_num"
								value="${note.note_num}" />
							<div onClick="document.forms['del${note.note_num}'].submit();"
								style="cursor: pointer;">
								<img src="Images/trash.png">
							</div>
						</form>
						<form action="UpdateMemo.mo" name="select${note.note_num}"
							method="POST" style="float: right; margin-right: 10px">
							<div onClick="document.forms['select${note.note_num}'].submit();"
								style="cursor: pointer;">
								<input type="hidden" id="note_num" name="note_num"
									value="${note.note_num}" /> <img src="Images/note_full-screen.png">
							</div>
						</form>
						<center>
							<div class="divcontent" style="clear: both;">
								<h3>${note.note_title}</h3>
							</div>
						</center>
						<hr>
						메모: ${note.note_content}
					</div>
				</c:forEach>
			</div>
		</div>
		<br><br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
