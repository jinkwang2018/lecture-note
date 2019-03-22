<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //useBean  앞에서 처리
	request.setCharacterEncoding("utf-8");

	//동작 : <form 태그 name값이 board  객체의 변수명과 동일 조건
%>
<jsp:useBean id="message" class="kr.or.kosta.dto.board" scope="page">
	<jsp:setProperty property="*" name="message"/>
</jsp:useBean>
<%
	//out.print(message.toString()); 검증 완료
	//서비스요청
/* 	boardservice service = boardservice.getInstance();
	int result = service.rewriteOK(message); */
	//out.print("실행결과 : " + result);
	
	//추가사항 : 처리 완료시 이동 처리 (cpage , pagesize)
	
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






