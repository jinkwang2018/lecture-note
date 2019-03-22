<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String result = (String)request.getAttribute("result");
	session.invalidate(); //세션 제거
	out.print("<script>");
	out.print("alert('"+result+"');");
	out.print("location.href='main.jsp'");//메인페이지로 이동시켜야한다
	out.print("</script>");

%>    