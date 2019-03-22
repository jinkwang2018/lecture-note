<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String msg = (String)request.getAttribute("board_msg");
  String url = (String)request.getAttribute("board_url");
  
  if(msg != null && url != null){
%>
	<script>
		alert('<%= msg %>');		
	    location.href='<%=url%>';
	</script>
	
<%	  
  }
%>

<!--   
  if(result > 0){
	  msg = "edit success";
	  url ="board_list.jsp";
  }else{
	  msg = "edit fail";
	  url ="board_edit.jsp?idx="+idx;
  }
  request.setAttribute("board_msg", msg);
  request.setAttribute("board_url", url); 
-->