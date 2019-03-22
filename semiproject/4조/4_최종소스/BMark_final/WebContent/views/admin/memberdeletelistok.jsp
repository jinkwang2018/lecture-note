<%@page import="kr.or.bmark.dto.myBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Google Icon -->
<% 
   String result = (String)request.getAttribute("result");
   int cpage = (Integer)request.getAttribute("cpage");
   int pagesize = (Integer)request.getAttribute("pagesize");
   int pagecount = (Integer)request.getAttribute("pagecount");
   int totalmembercount = (Integer)request.getAttribute("totalmembercount");
   List<myBoard> memberlist = (List)request.getAttribute("memberlist");
 %>

<c:forEach var="memberlist" items="<%=memberlist%>">
	<tr>
	<td>${memberlist.userid}</td>
	<td>${memberlist.name}</td>
	<td>${memberlist.pw}</td>
	<td>${memberlist.email}</td>
	<td>${memberlist.phone}</td>
	<td>
		<c:choose>
			<c:when test="${memberlist.gid==0}">
				없음
			</c:when>
			<c:otherwise>
				${memberlist.gid}
			</c:otherwise>
		</c:choose> 
	</td>
	<td>${memberlist.regday}</td>
	<td><button type="button" id="delete"class="btn btn-primary" 
	onclick="modalactivate('${memberlist.userid}','${memberlist.name}','${memberlist.pw}','${memberlist.email}','${memberlist.phone}')">
		수정<i class="fa fa-check spaceLeft"></i></button><td>
	<td><button type="button" id="delete"class="btn btn-danger" onclick="memberdelete('${memberlist.userid}',${cpage},${pagesize})">
		삭제<i class="fa fa-check spaceLeft"></i></button><td>
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
					<a onclick="pagelist(${i},${pagesize})">[${i}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach> <c:if test="${cpage<pagecount}">
			<a onclick="pagelist(${cpage+1},${pagesize})">다음</a>
		</c:if>

	</td>
	<td colspan="6" align="center">총 회원수 : <%=totalmembercount%>
	</td>
</tr>
<script>
	if('<%=result%>'=='fail'){
		alert("회원 삭제를 실패하였습니다")
	}else if('<%=result%>'=='success'){
		alert("회원을 삭제하였습니다")
	}else if('<%=result%>'=='success1'){
		alert("회원 수정을 성공 하였습니다")
	}else if('<%=result%>'=='fail1'){
		alert("회원 수정을 실패 하였습니다")
	}
</script>
