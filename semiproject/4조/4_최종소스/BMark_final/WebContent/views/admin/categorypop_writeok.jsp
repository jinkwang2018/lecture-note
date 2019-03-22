<%@page import="kr.or.bmark.service.AdminPopService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="message" class="kr.or.bmark.dto.category">
	<jsp:setProperty property="*" name="message" />
</jsp:useBean>

<%

	
   //서비스 요청 (카테고리 insert 서비스)
  
   AdminPopService service = new AdminPopService();
   int result = service.writeOK(message);
   
   String msg="";
   String url="";
   
   if(result > 0){
	   msg = "insert success";
	   url = "categorypop2.jsp";
   }else{
	   msg = "insert fail";
	   url = "categorypop2.jsp";
   }
   
   request.setAttribute("board_msg",msg);
   request.setAttribute("board_url", url);
   
%>
<jsp:forward page="redirect.jsp"></jsp:forward>