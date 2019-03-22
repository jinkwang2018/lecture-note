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
<link href="../../style/bootstrap-theme.css" rel="stylesheet">

<link href="../../style/style.css" rel="stylesheet">
<link href="../../style/style-responsive.css" rel="stylesheet" />
<link href="../../style/adminmy-page-table.css?ver=3" rel="stylesheet">

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

		var delconfirm = confirm("삭제 하시겠습니까?")

		if(delconfirm){// 안에는 예를 눌렀을때 발생하는 메서드를 넣어준다. 
			frm.submit();
		}

}
</script>

<meta charset="UTF-8">
<title>Bmark Category</title>
</head>
<body>
<div class="col-sm-9">
<h3>카테고리 관리</h3>
<form name="addfrm" action="categorypop_writeok.jsp" method="POST">
<div class="form-group">
	<label class="col-sm-3 control-label">코드:</label>
	<div class="col-sm-6">
		<input class="form-control" type="text" name="ccode" value=<%=maxcode %> width="10px" readonly="readonly" />
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">카테고리명: </label>
	<div class="col-sm-6">
		<input class="form-control popmargin" type="text" name="cname" /></div>
		<div align="center">
			<input type="button" class="btn btn-default popaddbtn" value="추가" onclick="category_add(this.form)">
		</div>
	</div>
</form>
<hr>
	<div class="col-sm-9 popdiv">
		<table class="table table-striped">
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
							<form action="categorypop_deleteok.jsp" method="POST" name="delfrm">
								<input type="hidden" name="ccode" value="${category.ccode}">
								<input type="button" class="btn btn-primary" value="삭제" onclick="category_del(this.form)">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>