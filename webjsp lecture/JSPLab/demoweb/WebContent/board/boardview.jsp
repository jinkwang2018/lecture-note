<%@page import="com.demoweb.model.dao.BoardDao"%>
<%@page import="com.demoweb.model.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//목록 페이지에서 선택한 글의 번호를 읽어서 변수에 저장
Integer boardNo = null;
try {
	boardNo = Integer.valueOf(request.getParameter("boardno"));
} catch (Exception ex) {}
//글번호가 없다면
if (boardNo == null) {
	//목록으로 이동
	response.sendRedirect("boardlist.jsp");
	return;
}
BoardDao dao = new BoardDao();
Board board = dao.getBoardByBoardNo(boardNo);

if (board == null) {//조회된 글이 없다면
	//목록으로 이동
	response.sendRedirect("boardlist.jsp");
	return;
}

dao.increaseReadCount(boardNo);

String pageNo = "1";
if (request.getParameter("pageno") != null) {
	pageNo = request.getParameter("pageno");
}
%>
    
<!DOCTYPE html>

<%@page import="com.demoweb.model.dto.Member"%>
<html>
<head>
	<meta charset="UTF-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input2.css" />
	
	<script type="text/javascript">
	function deleteBoard(number, pageno) {
		//confirm : 예/아니오 버튼의 선택에 따라 true/false 반환
		if (confirm(number + "번 글을 삭제할까요?")) {
			//location.href=path -> 지정된 경로로 이동
			location.href='boarddelete.jsp?boardno=' 
				+ number + "&pageno=" + pageno;
		}
	}
	</script>
</head>
<body>

	<div id="pageContainer">
	
		<% pageContext.include("/include/header.jsp"); %>
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 쓰기</div>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td><%= board.getTitle() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= board.getWriter() %></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td><%= board.getRegDate() %></td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td><%= board.getReadCount() + 1 %></td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">		                    
		                    <%= board.getContent().replaceAll(
		                    	"\r\n", "<br />") %>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        
		        	
		        	
		        	<% if (session.getAttribute("loginuser") != null) { %>
			        	<% Member member = 
			        		(Member)session.getAttribute("loginuser"); %>
			        	<% if (member.getMemberId().equals(board.getWriter())) { %>
			        	<a href="boardeditform.jsp?boardno=<%= board.getBoardNo() %>&pageno=<%= pageNo %>">편집</a>
			        	<a href="javascript:deleteBoard(<%= board.getBoardNo() %>,<%= pageNo %>);">삭제</a>
			        	<% } %>
			        	<a href="boardreplyform.jsp?boardno=<%= board.getBoardNo() %>&pageno=<%= pageNo %>">댓글쓰기</a>
		        	<% } %>
		        	<a href="boardlist.jsp?pageno=<%= pageNo %>">목록보기</a>
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>