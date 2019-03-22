<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="message" class="kr.or.bit.dto.BoardDto" scope="page">
	<jsp:setProperty property="*" name="message"/>
</jsp:useBean>
<%

	String cpage = (String)request.getAttribute("cpage");
	String pagesize = (String)request.getAttribute("pagesize");
	String result = (String)request.getAttribute("result");
	String msg="";
	String url="";
	
	if(result.equals("success")){
		msg = "rewrite success";
		url = "boardlist.bbs?cp="+cpage+"&ps="+pagesize;
	}
	else{
		msg = "rewrite fail";
		url = "boardRewrite.bbs?idx="+message.getIdx()+"&cp="+cpage+"&ps="+pagesize;
	}
	
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%> 
<jsp:forward page="redirect.jsp" />






