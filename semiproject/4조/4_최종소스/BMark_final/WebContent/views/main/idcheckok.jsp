<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msg = (String)request.getAttribute("msg"); 
	if(msg.equals("fail")){%>
		<p style="color: red;">&nbsp;&nbsp;&nbsp;이미 존재하는 아이디입니다<input id="validcheck" type="text" hidden="" value="false"></p>
<%  } else if(msg.equals("success")){%>
		<p style="color: blue;">&nbsp;&nbsp;&nbsp;사용가능한 아이디입니다<input id="validcheck" type="text" hidden="" value="true"></p>
<% 	}%>
