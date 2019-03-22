<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String member2 = (String) session.getAttribute("member");
%>
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
	$(function() {
		CKEDITOR.replace('ckEditor', {
			width : '75%',
			height : 550
		});
		$(document).on("click", "#btn", function() {
			$("#content").val(CKEDITOR.instances.ckEditor.getData());
			$('#frm').submit();
		});

		$(document).on('click', '#note_delete', function() {
			var num = $(this).parent().parent().parent();
			document.del.submit();
		});

	});
</script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer" style="padding-top: 30px;">
			<c:set var="note" value="${requestScope.note}"></c:set>
			
			<div style="margin-left: 20%;">
				<form name="share" method="POST" action="boardwriteok.bbs"
					class="frmshare" enctype="multipart/form-data">
					<input type="hidden" id="board_content" name="board_content"
						value='${note.note_content}' /> <input type="hidden"
						id="board_title" name="board_title" value="${note.note_title}" />
					<input type="hidden" name="id" value="<%=member2%>" />
					<button type="submit" class="btn btn-warning"
						style="color: white;float:right; margin-right: 25%; margin-bottom: 10px">공유하기</button>
				</form>

				<form action="UpdateMemoOk.mo" method="post" id="frm">
					<div class="form-group input-group"
						style="width: 75%; clear: left;">
						<span class="input-group-addon">제목입력</span> <input type="text"
							class="form-control" placeholder="제목을 입력하세요" name="note_title"
							id="note_title" value="${note.note_title}">
					</div>
					<input type="hidden" id="note_num" name="note_num"
						value="${note.note_num}"> <input type="hidden"
						id="book_no" name="book_no" value="${note.book_no}"> <input
						type="hidden" id="content" name="note_content">
					<textarea id="ckEditor" name="ckEditor">${note.note_content}</textarea>
				</form>
				
				<button id="btn" class="btn btn-warning"
					style="float: left; color: white; margin-top: 10px; margin-right: 10px">수정하기</button>
				<form name="del" method="POST" action="DeleteMemo.mo" class="frmdel"
					style="float: left;">
					<input type="hidden" id="note_num" name="note_num"
						value="${note.note_num}" />
					<button id="note_delete" class="btn btn-warning"
						style="color: white; margin-top: 10px;">삭제</button>
				</form>
			</div>

		</div>
		<br><br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
