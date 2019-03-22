<%@page import="kr.or.bmark.dto.category"%>
<%@page import="kr.or.bmark.dao.categoryDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
categoryDao categorydao = new categoryDao();
List<category> list =  categorydao.getCategoryList();
int maxcode = categorydao.getMaxCcode();
%>
<c:set var="list" value="<%=list %>"/>    

<!DOCTYPE html>
<html>
<head>
<link href="../../style/style.css" rel="stylesheet">
<link href="../../style/style-responsive.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
function category_add(frm) {
	if (frm.cname.value == "") {
		alert("카테고리명을 입력하세요");
		frm.cname.focus();
		return false;
	}
	frm.submit();
}
function category_del(frm) {
	alert("삭제하시겠습니까?");
	frm.submit();
}
</script>
<meta charset="UTF-8">
<title>Bmark Category</title>
</head>
<body>
<div class="container" style="width:100%">
<h3>카테고리 관리</h3>
<form name="bbs" action="categorypop_writeok.jsp" method="POST">
코드: <input type="text" name="ccode" value=<%=maxcode %> width="10px" /><br>
카테고리명: <input type="text" name="cname" />
<!-- input type="submit" value="추가" /-->
<input type="button" value="추가" onclick="category_add(this.form)">
</form>
<hr>
		<table class="table table-striped" border=1>
			<thead>
				<tr>
					<th>코드</th>
					<th>카테고리명</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${list}">
					<tr>
						<td>${category.ccode}</td>
						<td>${category.cname}</td>
						<td>
							<form action="boardreply_deleteOk.jsp" method="POST" name="replyDel">
								<input type="hidden" name="ccode" value="${category.ccode}">
								<input type="button" value="삭제" onclick="category_del(this.form)">
							</form>
						<!-- button type="button" id="delete"class="btn btn-primary" onclick="datadelete(${category.ccode})">
							삭제<i class="fa fa-check spaceLeft"></i></button-->
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</div>
</html>