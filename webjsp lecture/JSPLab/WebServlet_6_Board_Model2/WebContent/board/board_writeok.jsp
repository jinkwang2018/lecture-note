
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="message" class="kr.or.kosta.dto.board">
	<jsp:setProperty property="*" name="message" />
</jsp:useBean>

<%

  
   
   String result = (String)request.getAttribute("result");
   
   String msg="";
   String url="";
   
   if(result.equals("success")){
	   msg = "insert success";
	   url = "board_list.jsp";
   }else{
	   msg = "insert fail";
	   url = "board_write.jsp";
   }
   
   request.setAttribute("board_msg",msg);
   request.setAttribute("board_url", url);
   
%>
<jsp:forward page="redirect.jsp"></jsp:forward>





