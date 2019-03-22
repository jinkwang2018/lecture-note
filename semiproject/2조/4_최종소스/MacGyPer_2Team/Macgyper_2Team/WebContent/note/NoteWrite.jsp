<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Note</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="ck/ckeditor/ckeditor.js"></script>

<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<link href="css/Bootstrap/vendor/bootstrap/css/bootstrap.css?ver=3" rel="stylesheet">
<script src="js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>

<script type="text/javascript">
$(document).ready( function(){
	$.noConflict();
			CKEDITOR.replace( 'ckEditor', {
				 width: '75%',
				 height: 550
			});
 			$(document).on("click", "#note_btn",function(){
				$("#content").val(CKEDITOR.instances.ckEditor.getData());
				$('#frm').submit();
			});
 				    $( "#dialog" ).dialog({
 				      autoOpen: false,
 				     modal: true,
 				     buttons: {
 				        "Create": function() {
 				         $( this ).children().submit();
 				        },
 				        Cancel: function() {
 				          $( this ).dialog( "close" );
 				        }
 				      },
 				      close: function() {
 				    	 $( this ).dialog( "close" );
 				      }
 				    });
 				 
 				    $( "#book_btn" ).on( "click", function() {
 				      $( "#dialog" ).dialog( "open" );
 				    });
			
		});
	</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer" style="padding-top: 30px;">
			<c:set var="booklist" value="${requestScope.booklist}"></c:set>

			<div id="dialog" title="Basic dialog">
				<form action="InsertBook.mo" method="post" id="frm2">
					<input type="hidden" name="id" value="hoyong" readonly> 
					<label>Book Title </label><br> 
					<input type="text" name="book_title">
				</form>
			</div>
			
			<div style="margin-left: 20%;">
				<form action="InsertMemo.mo" method="post" id="frm">
					<div class="form-group" style="width: 150px; float: left; margin-right: 10px;">
						<label style="padding-right: 80px; font-weight: bold;">
						북 선택</label> 
						<select class="form-control" name="book_no" style="width: 150px">
							<c:forEach var="book" items="${booklist}">
								<option value="${book.book_no}">${book.book_title}</option>
							</c:forEach>
						</select>
					</div>

					<button type="button" id="book_btn" class="btn btn-warning"
						style="color: white; margin-top: 32px;">북만들기</button>

					<div class="form-group input-group"
						style="width: 75%; clear: left;">
						<span class="input-group-addon">제목입력</span> <input type="text"
							class="form-control" placeholder="제목을 입력하세요" name="title">
					</div>
					<input type="hidden" id="content" name="content">
					<textarea id="ckEditor" name="ckEditor"></textarea>
					<button id="note_btn" class="btn btn-warning"
						style="color: white; margin-top: 5px; margin-bottom: 5px; margin-right: 25%; float: right;">저장하기</button>
				</form>
			</div>
		</div>
		<br><br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>