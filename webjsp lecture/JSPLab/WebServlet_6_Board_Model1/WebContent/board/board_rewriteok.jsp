<%@page import="kr.or.kosta.service.boardservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	
	/* String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String homepage = request.getParameter("homepage");
	String filename = request.getParameter("filename");
	String pwd = request.getParameter("pwd"); */
%>
<jsp:useBean id="message" class="kr.or.kosta.dto.board" scope="page">
	<jsp:setProperty property="*" name="message" />
</jsp:useBean>
<%
	boardservice service = boardservice.getInstance();
	int result = service.rewriteok(message);
	//out.print("result : " + result);
	
   String cpage = request.getParameter("cp");
   String pagesize = request.getParameter("ps");
	
   String msg="";
   String url="";
   
   if(result > 0){
	   msg = "rewrite insert success";
	   url = "board_list.jsp";
   }else{
	   msg = "rewrite insert fail";
	   url = "board_rewrite.jsp?idx="+message.getIdx();
   }
   
   request.setAttribute("board_msg",msg);
   request.setAttribute("board_url", url);
%> 
<jsp:forward page="redirect.jsp" /> 





