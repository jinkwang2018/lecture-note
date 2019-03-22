<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String msg = (String)request.getAttribute("msg");
  String id = (String)request.getAttribute("id");
  if(msg != null && id != null){
%>
   <script>
      alert('<%= msg %>');      
      location.href='<%= request.getContextPath() %>/myedit.ch?id=<%= id %>';
   </script>
<%     
  }
%>