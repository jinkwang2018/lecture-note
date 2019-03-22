<%@page import="kr.or.kosta.service.boardservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String idx_fk =	request.getParameter("idx"); //덧글의 원본 게시글 번호
   String no =	request.getParameter("no"); //덧글의 순번(고유값)
   String pwd =	request.getParameter("delPwd"); //덧글의 암호
   
   //out.println(idx_fk + " /" + no + " /" + pwd);
   
   if(idx_fk == null || no == null || pwd == null || no.trim().equals("") ||
		   pwd.trim().equals("") || idx_fk.trim().equals(""))
   {
%>
	<script type="text/javascript">
		history.back();
	</script>
<%	   
   	return;
   }
   boardservice replyservice = boardservice.getInstance();
   int result = replyservice.replydelete(no, pwd);
   String msg ="";
   String url ="";
   if(result > 0){
	   msg ="덧글 삭제 성공"; 
   }else{
	   msg = "덧글 삭제 실패(비번)";
   }
   url ="board_content.jsp?idx="+idx_fk;
   request.setAttribute("board_msg", msg);
   request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp" />