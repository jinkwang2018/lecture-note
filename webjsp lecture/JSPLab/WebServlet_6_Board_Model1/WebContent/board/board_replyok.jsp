<%@page import="kr.or.kosta.service.boardservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String writer = request.getParameter("reply_writer");
	String content  =request.getParameter("reply_content");
	String pwd = request.getParameter("reply_pwd");
	String idx_fk = request.getParameter("idx");
	String userid ="empty";
	
	boardservice service = boardservice.getInstance();
	int result = service.replywrite(Integer.parseInt(idx_fk), writer, userid, content, pwd);
	
	   String msg="";
	   String url="";
	   
	   if(result > 0){
		   msg = "덧글 입력 성공";
		   
	   }else{
		   msg = "덧글 입력 실패";
		   
	   }
	   
	   url="board_content.jsp?idx="+idx_fk;
	   
	   request.setAttribute("board_msg",msg);
	   request.setAttribute("board_url", url);	
%>
<jsp:forward page="redirect.jsp" />





