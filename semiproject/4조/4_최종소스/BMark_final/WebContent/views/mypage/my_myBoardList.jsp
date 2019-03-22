<%@page import="kr.or.bmark.dto.myBoard"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page Mybook Mark</title>
<link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" />
</head>
<body>
<%  
   int cpage = (Integer)request.getAttribute("cpage");
   int pagesize = (Integer)request.getAttribute("pagesize");
   int pagecount = (Integer)request.getAttribute("pagecount");
   int totalboardcount = (Integer)request.getAttribute("totalboardcount");
   List<myBoard> mypagelist = (List)request.getAttribute("mypagelist");
%>
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagecount" value="<%=pagecount%>" />
	<c:set var="mypagelist" value="<%=mypagelist%>"/>
	<c:set var="totalboardcount" value="<%=totalboardcount%>"/>
	<div id="pagecontainer">
		<div style="padding-top: 30px; text-align: cetner">
			<table border="1">
				<tr>
					<td colspan="5">
						<form name="mypagelist">
						PageSize설정: 
							<select name="ps" onchange="submit()">

		   						<c:forEach var="i" begin="5" end="20" step="5">
		   							<c:choose>
									<c:when test="${pagesize == i}">
	                            		 <option value='${i}' selected>${i}건</option>
	                        		</c:when>
									<c:otherwise>
	                                  	  <option value='${i}'>${i}건</option>
	                               </c:otherwise>
								</c:choose>
		   						</c:forEach>
		   					</select>
						</form>
					</td>
				</tr>
				<tr>
					<th>cname</th>
					<th>favicon</th>
					<th>name</th>
					<th>content</th>
				</tr>
		<!-- 데이터가 한건도 없는 경우  -->
		<%
     	if(mypagelist == null){
     		out.print("<tr><td>해당 리스트에 데이터가 없습니다</td></tr></table>");
     		return;
     	} 
       %>
	       
		       
	<c:forEach var="mypage" items="<%= mypagelist %>">
		<c:set var="cname" value="${mypage.cname}" />
		<c:set var="icon" value="${mypage.icon}" />
		<c:set var="name" value="${mypage.name}" />
		<c:set var="content" value="${mypage.content}" />
		<tr>
			<td>${mypage.cname}</td>
			<td><img alt="" src="${mypage.icon}" style="height:16px ; width: 16px"></td>
			<td><a href="${mypage.addr}">${mypage.name}</a></td><!-- name 클릭시 addr로 이동 -->
			<td>${mypage.content}</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<!--이전 링크 --> 
				<c:if test="${cpage>1}">
					<a href="mypagemyblist.mybmark?cp=${cpage-1}&ps=${pagesize}">이전</a>
				</c:if> 
				<!--페이지 리스트 구현  -->
				<c:forEach var="i" begin="1" end="${pagecount}" step="1">
					<c:choose>
						<c:when test="${cpage==i}">
							<font color='red'>[${i}]</font>
						</c:when>
						<c:otherwise>
							<a href="mypagemyblist.mybmark?cp=${i}&ps=${pagesize}">[${i}]</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<!--다음 링크 --> 
				<c:if test="${cpage<pagecount}">
					<a href="mypagemyblist.mybmark?cp=${cpage+1}&ps=${pagesize}">다음</a>
				</c:if>
			</td>
			<td colspan="2" align="center">총 게시물 수 : <%= totalboardcount %>
			</td>
		</tr>
			</table>
		</div>
	</div>
</body>
</html>