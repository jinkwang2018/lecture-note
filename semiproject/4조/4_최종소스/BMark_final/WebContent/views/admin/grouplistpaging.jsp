<%@page import="kr.or.bmark.dto.team"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Google Icon -->
<%  
   int cpage = (Integer)request.getAttribute("cpage");
   int pagesize = (Integer)request.getAttribute("pagesize");
   int pagecount = (Integer)request.getAttribute("pagecount");
   int totalgroupcount = (Integer)request.getAttribute("totalboardcount");
   List<team> grouplist = (List)request.getAttribute("grouplist");
 %>
<c:forEach var="grouplist" items="<%=grouplist%>">
	<tr>
	<td align="center">${grouplist.gid}</td>
	<td>${grouplist.name}</td>
	<td>${grouplist.pw}</td>
	<td>${grouplist.content}</td>
	<td>${grouplist.register}</td>
	<td>${grouplist.regday}</td>
	
	</tr>
</c:forEach>
<tr align="center">
	<td colspan="3">
		<!--페이지 리스트 구현  -->
		<c:if test="${cpage>1}">
			<a onclick="pagelist(${cpage-1},${pagesize})">이전</a>
		</c:if> <c:forEach var="i" begin="1" end="${pagecount}" step="1">
			<c:choose>
				<c:when test="${cpage==i}">
					<font color='red'>[${i}]</font>
				</c:when>
				<c:otherwise>
					<a onclick="pagelist(${cpage},${pagesize})">[${i}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach> <c:if test="${cpage<pagecount}">
			<a onclick="pagelist(${cpage+1},${pagesize})">다음</a>
		</c:if>

	</td>
	<td colspan="5" align="center">총 그룹수 : <%= totalgroupcount%>
	</td>
</tr>