<%@page import="kr.or.bit.dao.BoardDao"%>
<%@page import="kr.or.bit.dto.ReplyDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Share Board</title>
<link href="css/Bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>

</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<%
		BoardDto boarddto = (BoardDto) request.getAttribute("boarddto");
		String idx = (String) request.getAttribute("idx");
		String cpage = (String) request.getAttribute("cpage");
		String pagesize = (String) request.getAttribute("pagesize");
		BoardDao dao = (BoardDao) request.getAttribute("dao");
		String member = (String) session.getAttribute("member");
	%>

	<c:set var="boarddto" value="<%=boarddto%>" />
	<c:set var="idx" value="<%=idx%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="dao" value="<%=dao%>" />
	<c:set var="member" value="<%=member%>" />

	<script type="text/javascript">
		function reply_check() {

			var frm = document.reply;
			if (frm.id.value == "" || frm.reply_content.value == "") {
				alert("리플 내용, 작성자를 모두 입력해야합니다.");
				return false;
			}

			var data2 = {
				idx : $.trim($('#idx').val()),
				id : $.trim($('#id').val()),
				reply_content : $.trim($('#reply_content').val())
			};

			$
					.ajax({
						url : "boardReplyok.bbs",
						async : true,
						dataType : "JSON",
						type : "POST",
						data : data2,
						success : function(data) {

							$
									.ajax({
										url : "replylist.bbs",
										data : {
											"idx" : $('#idx').val()
										},
										success : function(data) {
											$('#table').empty();
											//console.log(data);
											var a = JSON.parse(data);
											var table = '<tr><th colspan="2">덧글</th></tr>'
											$
													.each(
															a,
															function(index, val) {
																console
																		.log(val);
																table += '<tr align="left">'
																table += '<td width="80%">'
																table += '['
																		+ val.id
																		+ '] : '
																table += val.reply_content
																		+ '<br>'
																table += '작성일  : '
																		+ val.reply_date
																table += '</td>'
																table += '<td width="20%">'
																table += '<form action="boardreplyDeleteOk.bbs" method="POST" name="replyDel">'
																table += '<input type="hidden" name="no" value='+val.no+'>'
																table += '<input type="hidden" name="idx" value='+val.idx+'>'
																table += '<input type="hidden" name="id" value='+val.id+'>'
																//table+= '<h3>'+val.id.equals(${member})+'</h3>'
																/* table+= '<c:if test="${ '+val.id.equals(${member})+'}">'
																table+= '<input type="button" class="btn btn-warning pull-left" style="color:white; width:100%; height:48px;" value="삭제" onclick="reply_del(this.form)">'
																table+= '</c:if>' */
																if (('${member}' == val.id)
																		|| ('${member}' == 'admin')) {
																	//console.log('${member}');
																	table += '<input type="button" class="btn btn-warning pull-left" style="color:white; width:100%; height:48px;" value="삭제" onclick="reply_del(this.form)">'
																}
																table += '</form></td></tr>'
															});

											$('#table').append(table);
										}
									});
						}

					});
		}

		function reply_del(frm) {
			frm.submit();
		}
	</script>


	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer"
			style="padding-top: 30px; text-align: center">
			<center>
				<b>게시판 글내용</b>
				<table style="width: 80%; border: 1; margin: 50px;" cellspacing="0"
					align="center" class="table">
					<tr>
						<td width="20%" align="center"><b> 글번호 </b></td>
						<td width="30%">${ idx }</td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td>${ boarddto.getBoard_date() }</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%">${boarddto.getId() }</td>
						<td width="20%" align="center"><b>조회수</b></td>
						<td>${ boarddto.getBoard_count() }</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="1">${ boarddto.getBoard_title() }</td>
						<td width="20%" align="center"><b>파일</b></td>
						<td colspan="1"><c:choose>
								<c:when test="${ boarddto.getBoard_filename() == null }">
								</c:when>
								<c:otherwise>
									<a
										href="BoardFileDownloadService.bbs?file_name=${ boarddto.getBoard_filename() }">${ boarddto.getBoard_filename() }</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr height="100">
						<td width="20%" align="center"><b>글내용</b></td>
						<td colspan="3"><c:set var="content"
								value="${ boarddto.getBoard_content() }" /> <c:if
								test="${ content != null }">
								<c:set var="newLine" value="\n" />
									${fn:replace(content, newLine, '<br>') }
								</c:if></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><a class="btn btn-warning"
							style="color: white"
							href="boardlist.bbs?cp=${ cpage }&ps=${ pagesize }">목록가기</a> <c:choose>
								<c:when test="${ boarddto.getId().equals(member) }">
									<a class="btn btn-warning" style="color: white"
										href="boardEditForm.bbs?idx=${ idx }&cp=${ cpage }&ps=${ pagesize }">편집</a>
									<a class="btn btn-warning" style="color: white"
										href="boardDeleteCheck.bbs?idx=${ idx }&cp=${ cpage }&ps=${ pagesize }&id=${ member }">삭제</a>
								</c:when>
								<c:when test="${ member.equals('admin') }">
									<a class="btn btn-warning" style="color: white"
										href="boardDeleteCheck.bbs?idx=${ idx }&cp=${ cpage }&ps=${ pagesize }&id=${ member }">삭제</a>
								</c:when>
							</c:choose> <a class="btn btn-warning" style="color: white"
							href="boardRewrite.bbs?idx=${ idx }&cp=${ cpage }&ps=${ pagesize }&subject=${ boarddto.getBoard_title() }">답글</a>
						</td>
					</tr>
				</table>

				<!--  꼬리글 달기 테이블 -->
				<form name="reply">
					<!-- hidden 태그  값을 숨겨서 처리  -->
					<input type="hidden" name="idx" id="idx" value="${ idx }">

					<!-- hidden data -->
					<table style="width: 80%; border: 1; margin: 50px;" cellspacing="0"
						align="center" class="table table-bordered">
						<tr>
							<th colspan="2">덧글 쓰기</th>
						</tr>
						<tr>
							<td align="left" style="width: 80%"><input type="hidden"
								name="id" id="id" value="${ member }" readonly> <textarea
									name="reply_content" id="reply_content"
									style="resize: none; width: 100%; height: 100px;"></textarea></td>
							<td align="left" style="width: 20%"><input type="button"
								class="btn btn-warning pull-left" id="btn"
								style="color: white; width: 100%; height: 100px;" value="등록"
								onclick="reply_check()"></td>
						</tr>
					</table>
				</form>
				<!-- 꼬리글 목록 테이블 -->
				<!-- 덧글 목록 보여주기 -->
				<c:set var="replylist" value="${ dao.replylist(idx) }" />
				<table id="table" style="width: 80%; border: 1; margin: 50px;"
					cellspacing="0" align="center" class="table table-bordered">
					<c:if test="${ replylist != null && replylist.size() > 0 }">

						<tr>
							<th colspan="2">덧글</th>
						</tr>
						<c:forEach var="replydto" items="${ replylist }">
							<tr align="left">
								<td width="80%">[${ replydto.getId() }] : ${ replydto.getReply_content() }<br>
									작성일 : ${ replydto.getReply_date().toString() }
								</td>
								<td width="20%">
									<form action="boardreplyDeleteOk.bbs" method="POST"
										name="replyDel">
										<input type="hidden" name="no" value="${ replydto.getNo() }">
										<input type="hidden" name="idx" value="${ idx }"> <input
											type="hidden" name="id" value="${ member }">
										<c:if
											test="${ replydto.getId().equals(member) || member=='admin' }">
											<input type="button" class="btn btn-warning pull-left"
												style="color: white; width: 100%; height: 48px;" value="삭제"
												onclick="reply_del(this.form)">
										</c:if>
									</form>
								</td>
							</tr>

						</c:forEach>
					</c:if>
				</table>
			</center>
		</div>
		<jsp:include page="/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>