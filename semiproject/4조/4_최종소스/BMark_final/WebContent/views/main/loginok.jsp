<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msg = (String)request.getAttribute("msg"); 

%>
<script>
	if("<%=msg%>"=="failid"){
		alert("아이디가 존재하지않습니다");
	}else if("<%=msg%>"=="failpwd"){
		alert("비밀번호를 확인해주세요");
	}else if("<%=msg%>"=="error"){
		alert("에러가 발생하였습니다");
	}
	location.href='main.jsp';

</script>
