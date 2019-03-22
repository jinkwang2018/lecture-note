<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "";
	String url ="";
	String result = (String)request.getAttribute("result");

	if(result.equals("success")) {
		msg = "write success";
		url ="MemoList.mo";
	}
	else{
		msg = "write fail";
		url ="MemoList.mo";
	}
	
	request.setAttribute("note_msg", msg);
	request.setAttribute("note_url", url);
%>
<jsp:forward page="redirect.jsp" />    