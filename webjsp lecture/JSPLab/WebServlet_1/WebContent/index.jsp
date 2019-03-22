<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet test</title>
</head>
<body>
 	<h3>servlet 요청하기</h3>
	<h3>getContextPath() : <%= request.getContextPath()%> </h3>
	<a href="<%= request.getContextPath()%>/simple">일반요청하기</a>
	<br>
	<a href="<%= request.getContextPath()%>/simple?type=date">날짜요청하기</a>
	<br>
	<a href="<%= request.getContextPath()%>/simple?type=aaaa">비정상요청하기</a>
	
	<hr>
	<h3>FrontBoardController</h3>
	<a href="<%= request.getContextPath()%>/board?cmd=boardlist">게시판 목록 보기</a>
	<br>
	<a href="<%= request.getContextPath()%>/board?cmd=boardwrite">게시판 글쓰기</a>
	<br>
	<a href="<%= request.getContextPath()%>/board">Error 유도하기</a>
	<br>
	<a href="<%= request.getContextPath()%>/board?cmd=boarddelete">삭제하기 Error</a>
	<br>
	<a href="<%= request.getContextPath()%>/board?cmd=login">페이지 보안(로그인)</a>
	<br>
	<hr>
	<h3>FrontServletController</h3>
	<a href="<%= request.getContextPath()%>/Front.do?cmd=greeting">요청보내기</a>
	<br>
</body>
</html>
