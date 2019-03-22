<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n = (int)request.getAttribute("row");

if(n>0){
	out.print("<script>");
    out.print("alert('등록성공..');");
    out.print("location.href='MemoList.memo';");
    out.print("</script>");
    
  }else{
    out.print("<script>");
    out.print("alert('등록실패..');");
    out.print("location.href='memo.html';");
  }

%>