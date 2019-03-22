<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.kosta.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member member = new Member();
	//String json = "{"+"username:"+member.getName()+",userpwd: "+.......
	//위에 처럼 하지 말자
	JSONObject obj = JSONObject.fromObject(member);
%>
<%= obj %>
<hr>
<%
	List<Member> memberlist = new ArrayList<>();
	
	memberlist.add(new Member("hong","1004","서울시 강남구","0"));
	memberlist.add(new Member("kim","1002","서울시 양천구","1"));
	memberlist.add(new Member("park","1001","경기도 성남시","1"));
	
	JSONArray arr = JSONArray.fromObject(memberlist);
%>
<%= arr %>
</body>
</html>