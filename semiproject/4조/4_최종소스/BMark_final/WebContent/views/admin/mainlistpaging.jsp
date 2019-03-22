<%@page import="kr.or.bmark.dto.myBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Google Icon -->
<%  
   int cpage = (Integer)request.getAttribute("cpage");
   int pagesize = (Integer)request.getAttribute("pagesize");
   int pagecount = (Integer)request.getAttribute("pagecount");
   int totalboardcount = (Integer)request.getAttribute("totalboardcount");
   List<myBoard> mypagelist = (List)request.getAttribute("mypagelist");
   
 %>
<tr>
	<th style="width:5%">카테고리명</th>
	<th style="width:10%">사이트명</th>
	<th style="width:20%">설명</th>
	<th style="width:5%"></th>
</tr>
<c:forEach var="mypage" items="<%= mypagelist %>">
<tr>
	<td>${mypage.cname}</td>
	<td class="sitelink" data-site="${mypage.addr}"><img alt="" src="${mypage.icon}"style="height: 16px; width: 16px;"onerror="this.src='images/bmark.png';">&nbsp;&nbsp;${mypage.name}</td>
	<!-- name 클릭시 addr로 이동 -->
	<td>${mypage.content}</td>
	<td><button type="button" id="delete"class="btn btn-primary" onclick="datadelete(${mypage.mnbid},${cpage},${pagesize})">
	삭제<i class="fa fa-check spaceLeft"></i></button></td>
</tr>
</c:forEach>
<tr align="center">
	<td colspan="2"><c:if test="${cpage>1}">
			<a onclick="pagelist(${cpage-1},${pagesize})">이전</a>
		</c:if> <c:forEach var="i" begin="1" end="${pagecount}" step="1">
			<c:choose>
				<c:when test="${cpage==i}">
					<font color='red'>[${i}]</font>
				</c:when>
				<c:otherwise>
					<a onclick="pagelist(${i},${pagesize})">[${i}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach> <c:if test="${cpage<pagecount}">
			<a onclick="pagelist(${cpage+1},${pagesize})">다음</a>
		</c:if></td>
	<td colspan="6" align="center">총 사이트 수 : <%= totalboardcount %>
</td>
