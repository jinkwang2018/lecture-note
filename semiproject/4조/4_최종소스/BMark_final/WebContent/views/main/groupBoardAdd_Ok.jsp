<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("result");

	String msg = "";
	String url = "main.jsp";
	
	if(result.equals("success")) {
		msg = "사이트 등록이 완료되었습니다";
	}else if (result.equals("fail")) {
		msg = "사이트 등록에 실패했습니다";
	}else {
		msg = "로그인이 필요한 서비스입니다.";
	}
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%>

<jsp:forward page="redirect.jsp"></jsp:forward>
