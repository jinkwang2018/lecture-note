<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg="";
	String url="";
	String result = (String)request.getAttribute("result");
	String idx = (String)request.getAttribute("idx");
	
	if(result.equals("success")){
		msg ="덧글 입력 성공";
	}else{
		msg ="덧글 입력 실패";
	}
	url="boardRead.bbs?idx="+idx;
	request.setAttribute("board_msg", msg);
    request.setAttribute("board_url", url);
    
%>
<jsp:forward page="redirect.jsp" />