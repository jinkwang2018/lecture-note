<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script type="text/javascript">
	$(function() {
		var list = [];
		var audiCnt = [];
		var movieNm = [];
		var percent = [];
		var average=0;
		$("#button").click(function(){
			
		
			$.getJSON(
						"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?",
						{
							"key" : "464cf0a3c83fed3ec6a678866417c836",
							"targetDt" : $('#input').val()
						}, function(data, textStatus, req) {
							console.log(data);
							console.log(data.boxOfficeResult);
							$.each(data.boxOfficeResult,function(key,obj) {
								list.push(obj);
							})
							//console.log(list);
							$.each(list[2],function(index,element){
								//console.log(element.movieNm);
								movieNm.push(element.movieNm);
								audiCnt.push(element.audiCnt);
								average += parseInt(element.audiCnt);
								
							});
							
							//console.log(average);
							$.each(audiCnt,function(index,element){
								percent.push(eval('element/average'));
							});
							//console.log(audiCnt[0]);
							//console.log(percent[0]);
							//chart
							Highcharts.chart('container', {
							    chart: {
							        plotBackgroundColor: null,
							        plotBorderWidth: null,
							        plotShadow: false,
							        type: 'pie'
							    },
							    title: {
							        text: list[1] + '영화 관객수'
							    },
							    tooltip: {
							        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
							    },
							    plotOptions: {
							        pie: {
							            allowPointSelect: true,
							            cursor: 'pointer',
							            dataLabels: {
							                enabled: true,
							                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
							                style: {
							                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
							                }
							            }
							        }
							    },
							    series: [{
							        name: 'Brands',
							        colorByPoint: true,
							        data: [{
							            name: movieNm[0],
							            y: percent[0],
							            sliced: true,
							            selected: true
							        }, {
							            name: movieNm[1],
							            y: percent[1]
							        }, {
							            name: movieNm[2],
							            y: percent[2]
							        }, {
							            name: movieNm[3],
							            y: percent[3]
							        }, {
							            name: movieNm[4],
							            y: percent[4]
							        }, {
							            name: movieNm[5],
							            y: percent[5]
							        }, {
							            name: movieNm[6],
							            y: percent[6]
							        }, {
							            name: movieNm[7],
							            y: percent[7]
							        }, {
							            name: movieNm[8],
							            y: percent[8]
							        }]
							    }]
							});
							
							
							
							
							
							
						});	
							
						});
		
		

		
	});
	
	
</script>
</head>

<body>
	<input type="text" value="상영날짜" id="input">
	<input type="button" value="보기" id="button">
	<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</body>
</html>
