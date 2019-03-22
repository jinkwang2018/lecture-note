<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   /* String idx_fk =	request.getParameter("idx"); //덧글의 원본 게시글 번호
   String no =	request.getParameter("no"); //덧글의 순번(고유값)
   String pwd =	request.getParameter("delPwd"); //덧글의 암호
   
   //out.println(idx_fk + " /" + no + " /" + pwd);
   
   boardservice replyservice = boardservice.getInstance(); */
   String result = (String)request.getAttribute("result");
   String idx_fk = (String)request.getAttribute("idx_fk");
   
   /////////////////////
   String msg ="";
   String url ="";
   if(result.equals("success")){
	   msg ="덧글 삭제 성공"; 
   }else{
	   msg = "덧글 삭제 실패(비번)";
   }
   url ="boardRead.bbs?idx="+idx_fk;
   request.setAttribute("board_msg", msg);
   request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp" />