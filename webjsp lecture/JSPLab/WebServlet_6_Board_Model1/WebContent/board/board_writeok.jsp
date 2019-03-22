<%@page import="kr.or.kosta.service.boardservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="message" class="kr.or.kosta.dto.board">
	<jsp:setProperty property="*" name="message" />
</jsp:useBean>

<%

	/* 
	데이터 검증용 코드
	out.print(message.getSubject() + "<br>");
	out.print(message.getWriter() + "<br>");
	out.print(message.getEmail() + "<br>");
	out.print(message.getHomepage() + "<br>");
	out.print(message.getContent() + "<br>");
	out.print(message.getPwd() + "<br>");
	out.print(message.getFilename() + "<br>");
	
	/................................
	board dto = new board();
	dto.setString(rs.getParameter("subject"));
	>> <jsp:usebean .. 전제 조건 : 
	
	.....
	
	boarddao dao = new boarddao();
	int row = dao.writeok(dto);
	/..................................
	//위 부분을 service 객체 위임 
	
	
	
	if(row > 0){
		페이지 이동
	}
	
   */
   //서비스 요청 (게시글 insert 서비스)
  
   boardservice service = boardservice.getInstance();
   int result = service.writeOK(message);
   
   String msg="";
   String url="";
   
   if(result > 0){
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





