<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Book List</title>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<link href="css/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#searchbtn')
				.on(
						"click",
						function() {

							var data2 = {
								bookname : $("#bookname").val(),
								id : "hoyong"
							};
							$.ajax({
										url : "SearchBook.mo",
										dataType : "JSON",
										async : true,
										type : "POST",
										data : data2,
										success : function(data) {

											var list = "";
											var count = 0;
											$
													.each(
															data,
															function() {
																count++;
																list += '<div id= "icon" style="float: left; margin-right: 45px;margin-left: 45px; margin-top: 50px;">'
																		+ '<center><h4 style="color: #253D52">'
																		+ this.book_title
																		+ '</h4></center>'
																		+ '<form action="SelectMemo.mo" name="select'+this.book_no+'" method="POST">'
																		+ '<div onClick="document.forms[\'select'
																		+ this.book_no
																		+ '\'].submit();" style="cursor: pointer;">'
																		+ '<input type="hidden" id="book_no" name="book_no" value="'+this.book_no+'"/>'
																		+ '<img class="card-img-top card_img" src="Images/'+count+'.png">'
																		+ '</div>'
																		+ '</form>'

																		+ '<form name="del$'+ this.book_no+'" action="DeleteBook.mo" >'
																		+ '<input type="hidden" id="book_no" name="book_no" value="'+ this.book_no+'"/>'
																		+ '<div onClick="document.forms[\'del'
																		+ this.book_no
																		+ '\'].submit();" style="cursor: pointer;margin-top:1px; margin-left: 210px">'
																		+ '<img  src="Images/trash.png">'
																		+ '</div>'
																		+ '</form>'
																		+ '</div>'
																if (count == 8) {
																	count = 0
																}
																;
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
			<c:set var="booklist" value="${requestScope.booklist}"></c:set>
			<div align=center style="margin-bottom: 20px;">
				<div
					style="background-color: #F9C300; width: 300px; height: 80px; display: table-cell; vertical-align: middle; border-radius: 10px;">
					<h2 style="color: #fff;">BOOK LIST</h2>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">
					<div class="form-group input-group"
						style="float: right; width: 300px; margin-right: 10%">
						<input type="text" class="form-control" id="bookname"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button" id="searchbtn">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			
			<div id="test">
				<c:forEach var="book" items="${booklist}">
					<c:set var="count" value="${count+1}"></c:set>
					<div id="icon"
						style="float: left; margin-right: 45px;margin-left: 45px; margin-top: 50px;">
						<center>
							<h4 style="color: #253D52">${book.book_title}</h4>
						</center>
						<form action="SelectMemo.mo" name="select${book.book_no}"
							method="POST">
							<div onClick="document.forms['select${book.book_no}'].submit();"
								style="cursor: pointer;">
								<input type="hidden" id="book_no" name="book_no"
									value="${book.book_no}" /> <img class="card-img-top card_img"
									src="Images/${count}.png">
							</div>
						</form>
						<form name="del${book.book_no}" action="DeleteBook.mo">
							<input type="hidden" id="book_no" name="book_no"
								value="${book.book_no}" />
							<div onClick="document.forms['del${book.book_no}'].submit();"
								style="cursor: pointer; margin-top: 1px; margin-left: 210px">
								<img src="Images/trash.png">
							</div>
						</form>
						<br>
					</div>
					<c:if test="${count == 8}">
						<c:set var="count" value="0"></c:set>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
