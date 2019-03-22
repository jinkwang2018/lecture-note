<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>High Charts</title>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	
	<!-- CSS includes -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/le-frog/jquery-ui.css">


	<!-- 담은 -->
	 <script type="text/javascript">

  $(function() {
   var isShow = true;
   var xCategories = [];
   var accident = [];
   var breakdown = [];
   var fall = [];
   var etc = [];
   var totalData = [];
   
   $("#container-dam").hide();
   
   $("#button").click(function() {
    // "bounce", "clip", "drop", "explode", "fold", "highlight", 
    // "puff", , "pulsate", "scale", "shake", "size", "slide"
    if (isShow) {
     setHighChart();
     $("#container-dam").show("blind");
     isShow = false;
    } else {
     $("#container-dam").hide("blind");
     isShow = true;
    }
   });
   

   function setHighChart() {
    $("#container-dam").empty();
    $.getJSON("dam.json", function(data) {
     var items = data.MonthlyOutbreakStatsEng.row;
     
     $.each(items, function(index, obj) {
      xCategories[index] = obj.ROADNM;
      accident[index] = parseInt(obj.ACCIDENT);
      breakdown[index] = parseInt(obj.BREAKDOWN);
      fall[index] = parseInt(obj.FALL);
      etc[index] = parseInt(obj.ETC);
      totalData[index] = parseInt(obj.NO_OUTBK_SIT);
     });

     $('#container-dam').highcharts({
    	 chart: {
    	        type: 'column'
    	    },
      title : {
       text : '서울시 월별 사고 통계',
       x : -20
      },
      subtitle : {
       text : 'Source: http://data.seoul.go.kr/',
       x : -20
      },
      xAxis : {
       categories : xCategories //[]
      },
      yAxis : {
       title : {
        text : '사고건수'
       },

      },
      tooltip: {
          headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
          pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
              '<td style="padding:0"><b>{point.y:.1f} 건</b></td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
      },
      plotOptions: {
          column: {
              pointPadding: 0.2,
              borderWidth: 0
          }
      },
     /*  legend : {
       layout : 'vertical',
       align : 'right',
       verticalAlign : 'middle',
       borderWidth : 0
      }, */
      series : [ {
       name : 'ACCIDENT',
       data : accident
      }, {
       name : 'BREAKDOWN',
       data : breakdown
      }, {
       name : 'FALL',
       data : fall
      }, {
       name : 'ETC',
       data : etc
      }, {
       name : '합계',
       data : totalData
      } ]
     });
    });
   }
  });
 </script>
 
 <!-- 건휘 -->
 	<script type="text/javascript">
	
		$(function() {
			var isShow = true;
			var dateData = [];
			var countData = [];
			var dayData = [];
			
			$("#container-gun").hide();
			
			$("#button").click(function() {
				if(isShow) {
					setHighChart();
					$('#container-gun').show("blind");
					isShow = false;
				} else {
					$("#container-gun").hide("blind");
					isShow = true;
				}
			});
			
			function setHighChart() {
				$('#container-gun').empty();
				$.getJSON('gun.json', function (data) {
					var items = data.DATA;
					$.each(items, function(idx, obj) {
					dateData[idx] = obj.USE_YEAR;
					countData[idx] = parseInt(obj.USE_CNT);
					   
					
					$('#container-gun').highcharts({
						title : {
							text : "서울시 여성 안심 택배함 이용실적 통계",
							x : -20
						},
						subtitle : {
							text : "Source: http://data.seoul.go.kr",
							x : -20
						},
						xAxis : {
							categories : dateData
						},
						yAxis : {
							title : {
								text : "이용건수"
							} ,
							ploLines : [{
								value : 0,
								width : 10,
								color : '#FFFFFF'
							}] 
						}, 
						states: {
		                    hover: {
		                        lineWidth: 1
		                    }
		                },
						tooltip : {
							valueSuffix : '건',
							shared: true,
							useHTML: true
						},
						 legend: {
					            enabled: false
					        },
						ploOption: {
							column: {
								pointPadding: 0.2,
								borderWidth: 0
							}
						},
						
						series : [{
							type: 'area',
							name : '서울시 여성 안심 택배함 이용실적 통계',
							data : countData
						}]
					    });
					});
					
				});
			}
		});
	
	</script>
 
 
 <!-- 지은이 -->
  <script type="text/javascript">

  $(function() {
   var isShow = true;
   var maxparking = [];
   var owner = [];
   var parking = [];
   var company = [];
   var totalData = [];
   var tel = [];
   var parkaddress = [];
   var parkname = [];
   var partmaster = [];
   
   $("#container-ji").hide();
   
   $("#button").click(function() {
    // "bounce", "clip", "drop", "explode", "fold", "highlight", 
    // "puff", , "pulsate", "scale", "shake", "size", "slide"
    if (isShow) {
     setHighChart();
     $("#container-ji").show("blind");
     isShow = false;
    } else {
     $("#container-ji").hide("blind");
     isShow = true;
    }
   });
   
   //$( "#effect" ).show( selectedEffect, options, 500, callback );
   /* function callback() {
    setTimeout(function() {
            $("#effect:visible").removeAttr("style").fadeOut();
            }, 1000);
   }; */

   function setHighChart() {
    $("#container-ji").empty();
    $.getJSON("jieun.json", function(data) {
     var items = data.DATA;
     $.each(items, function(index, obj) {
      maxparking[index] = parseInt(obj.MAX_PARKING_CNT);
      owner[index] = obj.OWNER_NAME;
      parking[index] = parseInt(obj.PARKING_CNT);
      company[index] = obj.COMPANY_NM;
      tel[index] = obj.TEL_NO;
      parkaddress[index] = obj.PARK_ADDRESS;
      parkname[index] = obj.PARK_NAME;
      partmaster[index] = parseInt(obj.PARKMASTER_CD);
     });

     $('#container-ji').highcharts({
      title : {
       text : '서울시 공영주차장 주차 가능대수',
       x : -20
      },
      subtitle : {
       text : 'Source: http://data.seoul.go.kr/',
       x : -20
      },
      xAxis : {
       categories : parkname
      },
      yAxis : {
       title : {
        text : '대수'
       },
       plotLines : [ {
        value : 0,
        width : 1,
        color : '#F361A6'
       } ]
      },
      tooltip : {
       valueSuffix : '대수'
      },
      legend : {
       layout : 'vertical',
       align : 'right',
       verticalAlign : 'middle',
       borderWidth : 0
      },
      series : [ {
       name : '최대주차대수',
       data : maxparking
      }, {
       name : '잔여주차가능대수',
       data : parking
      } ]
     });
    });
   }
  });
 </script>
 
 
  <!-- 준성 -->
  <script type="text/javascript">

  $(function() {
   var isShow = true;
   var maxparking = [];
   var owner = [];
   var parking = [];
   var company = [];
   var totalData = [];
   var tel = [];
   var parkaddress = [];
   var parkname = [];
   var partmaster = [];
   
   $("#container-jun").hide();
   
   $("#button").click(function() {
    // "bounce", "clip", "drop", "explode", "fold", "highlight", 
    // "puff", , "pulsate", "scale", "shake", "size", "slide"
    if (isShow) {
     setHighChart();
     $("#container-jun").show("blind");
     isShow = false;
    } else {
     $("#container-jun").hide("blind");
     isShow = true;
    }
   });
   
   //$( "#effect" ).show( selectedEffect, options, 500, callback );
   /* function callback() {
    setTimeout(function() {
            $("#effect:visible").removeAttr("style").fadeOut();
            }, 1000);
   }; */
  
   Highcharts.createElement('link', {
      href: 'https://fonts.googleapis.com/css?family=Unica+One',
      rel: 'stylesheet',
      type: 'text/css'
   }, null, document.getElementsByTagName('head')[0]);


   Highcharts.setOptions(Highcharts.theme);
   function setHighChart() {
    $("#container-jun").empty();
    $.getJSON("jun.json", function(data) {
     var items = data.DATA;
     $.each(items, function(index, obj) {
      maxparking[index] = parseInt(obj.MAX_PARKING_CNT);
      owner[index] = obj.OWNER_NAME;
      parking[index] = parseInt(obj.PARKING_CNT);
      company[index] = obj.COMPANY_NM;
      tel[index] = obj.TEL_NO;
      parkaddress[index] = obj.PARK_ADDRESS;
      parkname[index] = obj.PARK_NAME;
      partmaster[index] = parseInt(obj.PARKMASTER_CD);
     });
	Highcharts.chart('container-jun', {
         chart: {
             type: 'column'
         },
         title: {
             text: '공용주차장 주차현황'
         },
         subtitle: {
             text: 'Source: WorldClimate.com'
         },
         xAxis: {
             categories: 
            	 parkname
               
             ,
             crosshair: true
         },
         yAxis: {
             min: 0,
             title: {
                 text: '주차가능대수'
             }
         },
         tooltip: {
             headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
             pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                 '<td style="padding:0"><b>{point.y:.1f} 대</b></td></tr>',
             footerFormat: '</table>',
             shared: true,
             useHTML: true
         },
         plotOptions: {
             column: {
                 pointPadding: 0.2,
                 borderWidth: 0
             }
         },
         series: [{
        	
     		 name: '최대주차대수',
             data: maxparking

         }, {
             name: '잔여주차가능대수',
             data: parking

         }, 

        

         ]
     });
    });
   }
  });
 </script>



<!-- 단비 -->

	<script type="text/javascript">
	
		$(function() {
			var isShow = true;
			var dateData = [];
			var countData = [];
			var dayData = [];
			
			$("#container-dan").hide();
			
			$("#button").click(function() {
				if(isShow) {
					console.log("<h3>test - true</h3>");
					setHighChart();
					$('#container-dan').show("blind");
					isShow = false;
				} else {
					$("#container-dan").hide("blind");
					isShow = true;
				}
			});
			
			function setHighChart() {
				$('#container-dan').empty();
				$.getJSON("dan.json", function(data) {
					var items = data.DATA;
					$.each(items, function(idx, obj) {
						dateData[idx] = obj.NALJA;
						countData[idx] = parseInt(obj.HOISU);
						dayData[idx] = obj.YOIL;
					});
					
					$('#container-dan').highcharts({
						title : {
							text : "서울시 구로구 여성 안심귀가 스카우트 일별 이용현황 (2014.4.1.~8.22.)",
							x : -20
						},
						subtitle : {
							text : "Source: http://data.seoul.go.kr",
							x : -20
						},
						xAxis : {
							categories : dateData
						},
						yAxis : {
							title : {
								text : "이용건수"
							}/* ,
							ploLines : [{
								value : 0,
								width : 10,
								color : '#FFFFFF'
							}] */
						},
						tooltip : {
							valueSuffix : '건',
							shared: true,
							useHTML: true
						},/* 
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'middle',
							borderWidth : 1
						}, */
						ploOption: {
							column: {
								pointPadding: 0.2,
								borderWidth: 0
							}
						},
						series : [{
							name : '구로구 여성안심귀가 스카우트 일별 이용 횟수',
							data : countData
						}]
					});
					
				});
			}
		});
	
	</script>

</head>

<body>
	<button id="button" class="ui-state-default ui-corner-all">담은이의 HighChart</button>
		<div class="toggler">
			<div id="container-dam"></div>
		</div>
	<hr><br>
		
		
	<button id = "button" class="ui-state-default ui-corner-all">건휘의 HighChart</button>
		<div class = "toggler">
			<div id = "container-gun"></div>
		</div>
	<hr><br>



	<button id="button" class="ui-state-default ui-corner-all">준성이의 HighChart</button>
		<div class="toggler">
			<div id="container-jun"></div>
		</div>
	<hr><br>

	<button id="button" class="ui-state-default ui-corner-all">단비의 HighChart</button>
		<div class="toggler">
			<div id="container-dan"></div>
		</div>
	<hr><br>


	<button id="button" class="ui-state-default ui-corner-all">지은이의 HighChart</button>
		<div class="toggler">
			<div id="container-ji"></div>
		</div>
	<hr><br>
</body>
</html>