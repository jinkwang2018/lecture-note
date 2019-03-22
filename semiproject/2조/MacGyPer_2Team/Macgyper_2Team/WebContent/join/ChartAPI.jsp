<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer</title>
<link
	href="<%= request.getContextPath() %>/css/Bootstrap/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%= request.getContextPath() %>/css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath() %>/css/Bootstrap/css/sb-admin.css"
	rel="stylesheet">
<script
	src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script
	src="<%= request.getContextPath() %>/js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
	src="<%= request.getContextPath() %>/js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script
	src="<%= request.getContextPath() %>/js/Bootstrap/js/sb-admin.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/ui-darkness/jquery-ui.css">
<style>
body {
	background-color: #F9C300;
}

body * {
	box-sizing: border-box;
}

.table-users {
	border: 2px solid #F9C300;
	border-radius: 10px;
	max-width: calc(100% - 2em);
	margin: 1em auto;
	overflow: hidden;
	width: 1500px;
}

table {
	width: 100%;
}

table td {
	text-align: center;
}

table th {
	background-color: #F2F1F1;
	font-weight: 900;
	align-content: center;
	text-align: center;
}

@media screen and (max-width: 700px) {
	table, tr, td {
		display: block;
	}
	td:nth-child(1):before {
		content: '온/습도:';
	}
	tr {
		padding: 10px 0;
		position: relative;
	}
	tr:first-child {
		display: none;
	}
}
</style>
<script type="text/javascript">
        $(function(){
                $.ajax({
                       url : 'http://openapi.seoul.go.kr:8088/4f7a68634f7573653934414c4a6559/json/RealtimeWeatherStation/1/1000/',
                          
                    dataType:"json",
                    success:function(responsedata){
                       console.log(responsedata.RealtimeWeatherStation.row);
                        var table = "<table class='table' border='2' style='border-color: #F9C300;'>";
                       
                        table += "<tr>";
                        table += "<th>온/습도</th>";
                        var loc =[];
                        var temp = [];
                        var temp_max = [];
                        $.each(responsedata.RealtimeWeatherStation.row, function(index, obj) {
                           
                               table += "<th>" +obj.STN_NM + "</th>";
                               loc.push(obj.STN_NM);
                               temp.push(obj.SAWS_TA_AVG);
                               temp_max.push(obj.SAWS_HD);
                               
                            });
                            table += "</tr>";    
                            table += "<tr>";
                       table += "<td>온도</td>";
                      
                        $.each(responsedata.RealtimeWeatherStation.row, function(index1, obj1) {
                                          
                              table += "<td>" + obj1.SAWS_TA_AVG + "</td>";
          
                        });
                        table += "</tr>";    
                        table += "<tr>";
                        table += "<td>습도</td>";
                        $.each(responsedata.RealtimeWeatherStation.row, function(index2, obj2) {
              
                            table += "<td>" + obj2.SAWS_HD + "</td>";
             
                    });
                        table += "</tr>";
                        table += "</table>";
                        
                        
                        Highcharts.chart('container', {
                            chart: { //차트 형식
                                type: 'line'
                            },
                            title: { //차트 제목
                                text: ' '
                            },

                            
                            xAxis: { //x축 내용
                               categories:loc
                            },
                            yAxis: { //y축 내용
                                title: {
                                    text: '수치'
                                }
                            },
                            
                            tooltip: { 
                                headerFormat: '<span style="font-size:10px">{point.key}</span><table>', //key는 x축 
                                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                           '<td style="padding:0"><b>{point.y} ㎍/㎥</b></td></tr>',
                                footerFormat: '</table>', 
                                shared: true, //true면 같은 X축의 데이터 값이 같이 보임  
                                useHTML: true  //true면 위의 지정한 html 태그 사용
                          }, 
                            
                            plotOptions: { //해당 X축의 블록지정
                                line: {
                                    dataLabels: {
                                        enabled: true
                                    },
                                    enableMouseTracking: false
                                }
                            },
                            series: [{
                                name: '온도',
                                data:temp
                            }, {
                                name: '최고온도',
                                data:temp_max
                            } ]
                        });
                        
                        
                        
 
                        $('#display').html(table);
                    }
                });
         
        });
                
   </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper" style="max-height: 100px">
		<div class="container-fluid" id="pageContainer"
			style="padding-top: 30px; text-align: center">
			<div align=center style="margin-bottom: 20px;">
				<div
					style="background-color: #F9C300; width: 500px; height: 80px; display: table-cell; vertical-align: middle; border-radius: 10px;">
					<h2 style="color: #fff;">서울시 지역별 실시간 온/습도</h2>
				</div>
			</div>


			<div id="display" class="table-users" style="max-height: 300px;"></div>


			<div id="container" style="height: 550px; max-height: 500px;"></div>

			<jsp:include page="/include/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>