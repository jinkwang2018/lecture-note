<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //1. board_edit.jsp > 입력값 받기 > board dto 객체에 담기
  
  //방법 1) request.getParameter("subject") > new board > setter >
  //방법 2) usebean 액션태그 (property )통해서 setter  주입
  //방법 3) request 객체를 통으로 넘기는 방법 (이 방법)
  
/*    request.setCharacterEncoding("utf-8");
   String idx = request.getParameter("idx");
   String msg = "";
   String url ="";
   if(idx == null || idx.trim().equals("")){
	   out.print("<script>");
	   out.print("alert('글번호 오류');");
	   out.print("location.href='board_list.jsp'");	   
	   out.print("</script>");
   	return;
   }
  boardservice service = boardservice.getInstance(); */
	  int result = (Integer)request.getAttribute("result");
	  String idx = request.getParameter("idx");
	  String msg = "";
	  String url =""; 
	  if(result > 0){
		  msg = "edit success";
		  url = "boardlist.bbs";
	  }else{
		  msg = "edit fail";
		  url = "boardEditForm.bbs?idx=" + idx;
	  }
	  request.setAttribute("board_msg", msg);
	  request.setAttribute("board_url", url);
%>
<jsp:forward page="redirect.jsp" />






