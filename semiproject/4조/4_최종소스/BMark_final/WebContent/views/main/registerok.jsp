<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msg = (String)request.getAttribute("msg"); 

%>
<script>
	if("<%=msg%>"=="success"){
		alert("가입에 성공하셨습니다. 다시 한번 로그인 해주세요");
	}else if("<%=msg%>"=="fail"){
		alert("가입에 실패하였습니다. 다시 한번 가입 부탁드립니다");
	}
	location.href='main.jsp';

</script>
