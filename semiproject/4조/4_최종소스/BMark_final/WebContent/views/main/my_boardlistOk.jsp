<!-- 
@Project : BMark 
@File name : myBoardListOk.jsp
@Date : 2018.04.10.
@Author : 김래영
 -->
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bmark.dto.myBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	List<myBoard> mylist = (ArrayList<myBoard>)request.getAttribute("mymarklist");
%>

<table class="table">
	<tbody align="left" id="main-myboard">
		<c:forEach var="mymark" items="<%=mylist %>"> <!-- ArrayList인 mylist 주소값을 변수 main에 삽입 -->
			<tr data-code="${mymark.mnbid}" class="tablehover">
				<td><img alt="" src="${mymark.icon}" style="height:16px; width: 16px" onerror="this.onerror=null; this.src='images/bmark.png'";></td>
				<td data-site="${mymark.addr}" class="sitelink"><%-- <a href="${mymark.addr}"> --%>${mymark.name}</td><!-- name 클릭시 addr로 이동 -->
			</tr>
		</c:forEach>
	</tbody>
</table>

<%
	if (mylist == null) {
		out.print("로그인이 필요한 서비스입니다!");
	}
%>