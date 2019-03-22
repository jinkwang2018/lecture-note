<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 
	  int result = (Integer)request.getAttribute("result");
	  String idx = request.getParameter("idx");
	  String msg = "";
	  String url =""; 
	  if(result > 0){
		  msg = "edit success";
		  url = "boardlist.bbs";
	  }else{
		  msg = "edit fail";
		  url = "boardEditForm.bbs?idx=" + idx;
	  }
	  request.setAttribute("board_msg", msg);
	  request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp" />






