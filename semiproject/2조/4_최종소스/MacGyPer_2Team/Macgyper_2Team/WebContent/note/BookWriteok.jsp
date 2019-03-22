<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String msg = "";
	String url ="";
	String result = (String)request.getAttribute("result");

	if(result.equals("success")){
		msg = "insert success";
		url ="WriteMemo.mo";
	}
	else{
		msg = "insert fail";
		url ="WriteMemo.mo";
	}
	
	request.setAttribute("note_msg", msg);
	request.setAttribute("note_url", url);
%>
<jsp:forward page="redirect.jsp" />    