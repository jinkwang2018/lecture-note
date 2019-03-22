<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
    String member = (String)session.getAttribute("member");
    %>

<c:set var="member" value="<%=member%>" />

<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Share Board</title>

<link href="css/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>
<SCRIPT type="text/javascript">
function check(){
    if(!bbs.board_title.value){
        alert("제목을 입력하세요");
        bbs.board_title.focus();
        return false;
    }
  
    document.bbs.submit();
}
</SCRIPT>
<script type="text/javascript" src="ck/ckeditor/ckeditor.js"></script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer"
			style="padding-top: 30px; text-align: center">
			<form name="bbs" action="boardwriteok.bbs" method="POST"
				enctype="multipart/form-data">
				<table style="width: 80%; border: 1; margin: 50px;" cellspacing="0"
					align="center" class="table table-bordered">
					<tr>
						<td width="20%" align="center">제목</td>
						<td width="80%" align="left"><input type="text"
							name="board_title" size="40"></td>
					</tr>
					<tr>
						<td width="20%" align="center">글쓴이</td>
						<td width="80%" align="left"><input type="text" name="id"
							size="40" value="${ member }" readonly></td>
					</tr>
					<tr>
						<td width="20%" align="center">글내용</td>
						<td width="80%" align="left"><textarea rows="10" cols="60"
								name="board_content" class="ckeditor"></textarea></td>
					</tr>

					<tr>
						<td width="20%" align="center">첨부파일</td>
						<td width="80%" align="left"><input type="file"
							name="board_filename"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							class="btn btn-warning" style="color: white" value="글쓰기"
							onclick="check();" /> <input type="reset"
							class="btn btn-warning" style="color: white" value="다시쓰기" /> <a
							href="boardlist.bbs" class="btn btn-warning" style="color: white">되돌아가기</a>
						</td>
					</tr>
				</table>
			</form>

		</div>
		<br>
		<br>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html>