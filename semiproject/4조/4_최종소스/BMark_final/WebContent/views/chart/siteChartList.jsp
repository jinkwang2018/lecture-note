<!-- 
@Project : BMark 
@File name : chartList.jsp
@Date : 2018.04.11.
@Author : 김래영
 -->
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리별 사이트 통계차트</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>

	<!-- Custom JS -->
	<script src="js/main_chart.js?ver=1"></script>

	<script type="text/javascript">
		$(function() {
			$.ajax({
				 url: "sitechartcategory.mainbmark", //해당 url로
				 dataType: "JSON", //json 형식
				 type: "POST",
				 success: function(data) { //성공시 아래 내용 출력
					$.each(data, function(index, obj) {
						//console.log(obj.cname);
						$('.categorychart').append("<option>" + obj.cname + "</option>");
					});
						
				 },
				 error: function (error) {
					    alert('error : ' + eval(error));
				 }
			});
			
			selected();
		});
	</script>
</head>
<body>

	<select class="categorychart" onchange="selected()">
		 <option value="-" selected="selected" disabled="disabled">선택하세요</option>
	</select> 
	
	<div id="chartcontainer">
	
	</div>

</body>
</html>