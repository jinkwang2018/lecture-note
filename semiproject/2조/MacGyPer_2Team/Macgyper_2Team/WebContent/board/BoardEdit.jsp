<%@page import="kr.or.bit.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String idx = (String)request.getAttribute("idx");
	BoardDto boarddata = (BoardDto)request.getAttribute("boarddata");
	String member = (String)session.getAttribute("member");
%>

	<c:set var="idx" value="<%=idx%>" />
	<c:set var="boarddata" value="<%=boarddata%>" />
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
	<script type="text/javascript">
	function editCheck() {
		
		if (!edit.board_title.value) {
			alert("제목을 입력하세요");
			edit.board_title.focus();
			return false;
		}
		/* 
		if (!edit.content.value) {
			alert("글 내용을 입력하세요");
			edit.content.focus();
			return false;
		} */

		document.edit.submit();

	}
</script>
<script type="text/javascript" src="ck/ckeditor/ckeditor.js" ></script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    
	<jsp:include page="/include/header.jsp"></jsp:include>
		<div class="content-wrapper">
			<div class = "container-fluid" id="pageContainer" style="padding-top: 30px; text-align: center">
			<form name="edit" action="boardEdit.bbs" method="POST">
				<center>
					<table style="width :80%; border:1 ; margin :50px; " cellspacing="0" align="center" class="table table-bordered">
						<tr>
							<td width="20%" align="center"><b> 글번호 </b></td>
							<td width="30%">
									${ idx } 
									<input type="hidden" name="idx" value="${ idx }"></td>
							<td width="20%" align="center"><b>작성일</b></td>
							<td>${ boarddata.getBoard_date() }</td>
						</tr>
						<tr>
							<td width="20%" align="center"><b>글쓴이</b></td>
							<td width="30%">
								<input type="text" name="id" value="${ member }" readonly>
							</td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td width="20%" align="center"><b>제목</b></td>
							<td colspan="3">
								<input type="text" name="board_title" value="${ boarddata.getBoard_title() }" size="40">
							</td>
						</tr>
						<tr height="100">
							<td width="20%" align="center"><b>글내용</b></td>
							<td colspan="3">
								<textarea rows="7" cols="50" name="board_content" class="ckeditor">
									${ boarddata.getBoard_content() }
								</textarea>
							</td>
						</tr>
						<!-- ////////////////////////////////////////////////////////////////////////////// -->
						<tr>
							<td width="20%" align="center"><b>첨부파일</b></td>
							<td colspan="3">${ boarddata.getBoard_filename() } <br /> 
								<input type="file" name="board_filename">
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<input type="button" class="btn btn-warning" style="color:white" value="수정하기" onclick="editCheck();"> 
								<input type="reset" class="btn btn-warning" style="color:white" value="다시쓰기">
							</td>
						</tr>
					</table>
				</center>
			</form>
		</div>
		<br><br>

	</div>
<jsp:include page="/include/footer.jsp"></jsp:include>	
</body>
</html>