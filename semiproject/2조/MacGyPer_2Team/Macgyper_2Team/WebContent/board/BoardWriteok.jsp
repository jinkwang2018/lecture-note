<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
   String result = (String)request.getAttribute("result");
   String msg ="";
   String url ="";
   if(result.equals("success")){
	   msg = "Insert success";
	   url = "boardlist.bbs";
   }else{
	   msg = "Insert fail";
	   url = "boardwrite.bbs";
   }
   request.setAttribute("board_msg", msg);
   request.setAttribute("board_url", url);
  
%>
<jsp:forward page="redirect.jsp"></jsp:forward>





