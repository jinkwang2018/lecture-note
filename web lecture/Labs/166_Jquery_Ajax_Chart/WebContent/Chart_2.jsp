<!DOCTYPE html>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="Stylesheet" type="text/css" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/chart.css" type="text/css" media="all" />
<style type="text/css">
   .font{
       font-family: 'Noto Sans KR', sans-serif;
   }
</style>


<!-- js -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<script src="https://www.amcharts.com/lib/3/themes/none.js"></script>

<script type="text/javascript">
   $(function(){
      $('#dialog').dialog({
         autoOpen : false,
         show : {
            effect : "blind",
            duration : 500
         },
         hide : {
            effect : "blind",
            duration : 500,
         },
         buttons:{
            cancel: function(){
               $(this).dialog("close");
               $('#datepicker').val("");
            }
         },
         width: "330",
         modal: false
      });
      
      function getFormatDate(date){
         var year = date.getFullYear();
         var month = (1 + date.getMonth());
         month = month >= 10 ? month : '0' + month; 
         var day = date.getDate();
         day = day >= 10 ? day : '0' + day;
         return  year + '' + month + '' + day;
      }
      
      $("#datepicker").datepicker({
         dateFormat : "yymmdd",
         onSelect : function(date) {
            var today = getFormatDate(new Date());
            if(date >= today){
               $('#dialog').dialog('open');
            }
         }
      });
        
      
      $('#btn').click(function(){
         var jsonURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=" + $('#datepicker').val();  
         console.log(jsonURL);
         $.ajax({
            url: jsonURL,
            type: "GET",
            datatype: "JSON",
            success: function(data){
               $('#movieList').empty();
               console.log(data);
               var str = "<table class='font table .table-bordered table-hover'>";
               str += "<tr><th colspan='3' style='text-align: center; font-size: 30px;'>" + data.boxOfficeResult.boxofficeType + "(" + data.boxOfficeResult.showRange + ")</th></tr>";
               str += "<tr class='warning' style='text-align: center;'><td>순위</td><td>제목</td><td>개봉일</td></tr>";
               var i = 0;
               var jsonlist = new Array();
               $.each(data.boxOfficeResult.dailyBoxOfficeList, function(index, element){
                  if(i%2 == 0 && index != 9){
                     str += "<tr class='active id' style='text-align:center;'><td>" + element.rnum + "</td><td>" + element.movieNm + "</td><td>" + element.openDt + "</td></tr>";
                  }else if(i%2 != 0 && index != 9){
                     str += "<tr class='font' style='text-align:center;'><td>" + element.rnum + "</td><td>" + element.movieNm + "</td><td>" + element.openDt + "</td></tr>";
                  }
                  i++;
                  jsonlist.push(element);
               });
               str += "</table>";
               $('#movieList').append(str);
               console.log(jsonlist[0]);
               /* $('#chartname').html("<table style=\"width:100%\">" +
                  "<td>"   + jsonlist[0].movieNm + "</td>" +
                  "<td>"   + jsonlist[1].movieNm +   "</td>" +
                  "<td>"   + jsonlist[2].movieNm +   "</td>" +
                  "<td>"   + jsonlist[3].movieNm +   "</td>" +
                  "<td>"   + jsonlist[4].movieNm +   "</td>" +
                  "<td>"   + jsonlist[5].movieNm +   "</td>" +
                  "<td>"   + jsonlist[6].movieNm +   "</td>" +
                  "<td>"   + jsonlist[7].movieNm +   "</td>" +
                  "<td>"   + jsonlist[8].movieNm +   "</td>" +
                  "<td>"   + jsonlist[9].movieNm +   "</td>"
                     + "</table>"); */
               var chart = AmCharts.makeChart("chartdiv",
                     {
                         "type": "serial",
                         "theme": "none",
                         "dataProvider": [{
                             "name": jsonlist[0].movieNm,
                             "points": jsonlist[0].audiCnt,
                             "color": "#CC3D3D",
                             "bullet": "https://www.amcharts.com/lib/images/faces/A04.png"
                         }, {
                             "name": jsonlist[1].movieNm,
                             "points": jsonlist[1].audiCnt,
                             "color": "#FFBB00",
                             "bullet": "https://www.amcharts.com/lib/images/faces/C02.png"
                         }, {
                             "name": jsonlist[2].movieNm,
                             "points": jsonlist[2].audiCnt,
                             "color": "#ABF200",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }, {
                             "name": jsonlist[3].movieNm,
                             "points": jsonlist[3].audiCnt,
                             "color": "#0054FF",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }, {
                             "name": jsonlist[4].movieNm,
                             "points": jsonlist[4].audiCnt,
                             "color": "#FF007F",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }, {
                             "name": jsonlist[5].movieNm,
                             "points": jsonlist[5].audiCnt,
                             "color": "#CC723D",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }, {
                             "name": jsonlist[6].movieNm,
                             "points": jsonlist[6].audiCnt,
                             "color": "#008299",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }, {
                             "name": jsonlist[7].movieNm,
                             "points": jsonlist[7].audiCnt,
                             "color": "#660033",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }, {
                             "name": jsonlist[8].movieNm,
                             "points": jsonlist[8].audiCnt,
                             "color": "#665C00",
                             "bullet": "https://www.amcharts.com/lib/images/faces/E01.png"
                         }],
                         "valueAxes": [{
                             "maximum": (jsonlist[0].audiCnt),
                             "minimum": 0,
                             "axisAlpha": 0,
                             "dashLength": 5,
                             "position": "left"
                         }],
                         "startDuration": 1,
                         "graphs": [{
                             "balloonText": "<span style='font-size:20px;'>[[category]]: <b>[[value]]</b></span>", // 그래프 안에 글씨 크기
                             "bulletOffset": 10, // 사진 위치 ~ 숫자에 따라 위아래로 움직임
                             "bulletSize": 40, // 사진크기
                             "colorField": "color",
                             "cornerRadiusTop": 8, // 모서리 둥근정도
                             "customBulletField": "bullet",
                             "fillAlphas": 0.8, // 투명도
                             "lineAlpha": 0,
                             "type": "column",
                             "valueField": "points"
                         }],
                         "marginTop": 50,
                         "marginRight": 0,
                         "marginLeft": 0,
                         "marginBottom": 0,
                         "autoMargins": false,
                         "categoryField": "name",
                         "categoryAxis": {
                             "axisAlpha": 0,
                             "gridAlpha": 0,
                             "inside": true,
                             "tickLength": 0
                         },
                         "export": {
                            "enabled": true
                          }
                     });
            }
         });
      });
   });
</script>
</head>
<body>
   <div class="container" style="border:1px solid black">
      <div id="movieList">
         <table class="font table .table-bordered table-hover">
            <tr><th colspan='3' style=" font-family: 'Noto Sans KR', sans-serif; text-align: center; font-size: 30px;">일별 박스오피스</th></tr>
            <tr class="warning" style=" font-family: 'Noto Sans KR', sans-serif; text-align:center;"><td>순위</td><td>제목</td><td>개봉일</td></tr>
            <tr class="active"style="text-align:center;"><td>1</td><td></td><td></td></tr>
            <tr style="text-align:center;"><td>2</td><td></td><td></td></tr>
            <tr class="active"style="text-align:center;"><td>3</td><td></td><td></td></tr>
            <tr style="text-align:center;"><td>4</td><td></td><td></td></tr>
            <tr class="active"style="text-align:center;"><td>5</td><td></td><td></td></tr>
            <tr style="text-align:center;"><td>6</td><td></td><td></td></tr>
            <tr class="active"style="text-align:center;"><td>7</td><td></td><td></td></tr>
            <tr style="text-align:center;"><td>8</td><td></td><td></td></tr>
            <tr class="active" style="text-align:center;"><td>9</td><td></td><td></td></tr>
         </table>
      </div>
      <div id="chartdiv"></div>
      <div class="row" id="chartname"></div>
      <div class="row" style="text-align: center; margin-bottom:10px;">
         Date: <input class="font" type="text" id="datepicker" style="width:120px;">
         <button class="font btn btn-warning btn-sm btn-hover" id="btn">영화목록 출력</button>
      </div>
   </div>
   <div id="dialog" title="다른 날짜를 선택해주세요!">
       <p>오늘보다 이전의 날짜를 선택해주세요.</p>
     </div>
</body>
</html>