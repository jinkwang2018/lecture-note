<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String result = (String)request.getAttribute("result");
   String idx_fk = (String)request.getAttribute("idx_fk");
   String msg ="";
   String url ="";
   
   if(result.equals("success")){
	   msg ="덧글 삭제 성공"; 
   }else{
	   msg = "덧글 삭제 실패(작성한 아이디가 아닙니다)";
   }
   url ="boardRead.bbs?idx="+idx_fk;
   request.setAttribute("board_msg", msg);
   request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp" />