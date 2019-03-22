<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String msg = "";
	String url ="";
	String result = (String)request.getAttribute("result");

	if(result.equals("success")){
		msg = "북과 북 안의 노트가 삭제됩니다.";
		url ="BookList.mo";
	}
	else{
		msg = "delete fail";
		url ="BookList.mo";
	}
	
	request.setAttribute("note_msg", msg);
	request.setAttribute("note_url", url);
%>
<jsp:forward page="redirect.jsp" />    