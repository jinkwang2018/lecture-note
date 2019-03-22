<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Dynamic emp member</title>
	<style type="text/css">${demo.css}</style>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>


	<!-- CSS includes -->
	<link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/assets/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/assets/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet">




	</head>
	
<body>
	<div class="container" id="emplist">
		<div class="jumbotron" style="text-align: center; background-color: rgba(255, 41, 66, 0.54);">
			<h2 id="Userlist"><i><b>실시간 사원수보기</b></i></h2>
		</div>
	</div>


	<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath() %>/index.jsp">Admin PAGE</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<%=request.getContextPath() %>/index.jsp">Home</a></li>
				<li class="active"><a href="AdminMain.jsp">DeptnoSelect</a></li>
				<li class="active"><a href="<%=request.getContextPath() %>/jsp/dynamicemp.jsp">DynamicEMP</a></li>
				<li class="active"><a href="<%=request.getContextPath() %>/jsp/highcharts.jsp">HighCharts</a></li>
			</ul>
			
	</nav>





<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>



<script type="text/javascript">

$(document).ready(function () {
    Highcharts.setOptions({
        global: {
            useUTC: false	//시간표시방법
        }
    });

    Highcharts.chart('container', {
        chart: {
            type: 'spline',		//차트모양
            animation: Highcharts.svg, //애니메이션 모양
            marginRight: 10,	//오른쪽 여백
            events: {
                load: function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                    	
                        $.ajax({
                            url : "<%=request.getContextPath() %>/EmpCount",
                            type: "GET",
                            dataType: "JSON",
                            success: function(data)
                            {
                     			console.log(data.count);				//데이터 어떻게 넘어오는지 항상 찍어보라고 선생님께서 말씀하셨지
                                var x = (new Date()).getTime(), // current time
                                y = data.count
                          		series.addPoint([x, y], true, true);	//점추가 할껀지 안할껀지
                     
                            },
                            error: function (xhr)
                            {
                                console.log('Error get data from ajax' + xhr.status);
                            }
                        });
                    }, 1000);
                }
            }
        },
        title: {
            text: 'DYNAMIC EMPLIST'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
        	tickPixelInterval: 300,
            title: {
                text: 'Number of Members'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                    Highcharts.numberFormat(this.y, 2);
            }
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: 'number of members',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -20; i <= 0; i += 1)
                {
                    data.push({
                        x: time + i * 1000,
                        y: data.count	//처음에 나오는 데이터 값
                    });
                }
                return data;
            }())
        }]
    });
});
		</script>
</body>
</html>