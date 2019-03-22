<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "";
	String url ="";
	String result = (String)request.getAttribute("result");

	if(result.equals("success")) {
		msg = "update success";
		url ="MemoList.mo";
	}
	else{
		msg = "update fail";
		url ="MemoList.mo";
	}
	
	request.setAttribute("note_msg", msg);
	request.setAttribute("note_url", url);
%>
<jsp:forward page="redirect.jsp" />    