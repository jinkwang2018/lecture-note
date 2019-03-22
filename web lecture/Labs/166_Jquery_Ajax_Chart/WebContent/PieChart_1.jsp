<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>




<!-- css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="Stylesheet" type="text/css" />
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
   
<script type="text/javascript">
$(function(){
	
	$(window).scroll(function() {
	    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	        alert('End of Window');
	    }});

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
                 str += "<tr class='warning' style='text-align: center;'><td>순위</td><td>제목</td><td>상영횟수</td></tr>";
                 var i = 0;
                 var jsonlist = new Array();
                 $.each(data.boxOfficeResult.dailyBoxOfficeList, function(index, element){
                    if(i%2 == 0 && index != 9){
                       str += "<tr class='active id' style='text-align:center;'><td>" + element.rnum + "</td><td>" + element.movieNm + "</td><td>" + element.showCnt + "</td></tr>";
                    }else if(i%2 != 0 && index != 9){
                       str += "<tr class='font' style='text-align:center;'><td>" + element.rnum + "</td><td>" + element.movieNm + "</td><td>" + element.showCnt + "</td></tr>";
                    }
                    i++;
                    jsonlist.push(element);
                 });
                 str += "</table>";
                 $('#movieList').append(str);
                 console.log(jsonlist[0].movieNm + " / " +jsonlist[0].showCnt);
                 google.charts.load("current", {packages:["corechart"]});
                 google.charts.setOnLoadCallback(drawChart);
                 function drawChart() {
                   var data = google.visualization.arrayToDataTable([
                    ['Language', 'Speakers (in millions)'],
                     [jsonlist[0].movieNm,Number(jsonlist[0].showCnt)],
                     [jsonlist[1].movieNm,Number(jsonlist[1].showCnt)],
                     [jsonlist[2].movieNm,Number(jsonlist[2].showCnt)],
                     [jsonlist[3].movieNm,Number(jsonlist[3].showCnt)],
                     [jsonlist[4].movieNm,Number(jsonlist[4].showCnt)],
                     [jsonlist[5].movieNm,Number(jsonlist[5].showCnt)],
                     [jsonlist[6].movieNm,Number(jsonlist[6].showCnt)],
                     [jsonlist[7].movieNm,Number(jsonlist[7].showCnt)],
                     [jsonlist[8].movieNm,Number(jsonlist[8].showCnt)],
                     [jsonlist[9].movieNm,Number(jsonlist[9].showCnt)]
                     ]);

                 var options = {
                   legend: 'none',
                   pieSliceText: 'label',
                   title: '해당 일자에 따른 영화별 상영 횟수',
                   pieStartAngle: 100
                 };

                   var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                   chart.draw(data, options);
                 }
         	}
         });
     });
})
</script>

<style type="text/css">
@keyframes blink {
    0% {
        opacity:1;
    }
    50% {
        opacity:0;
    }
    100% {
        opacity:1;
    }
} 
.blink-image {
    -moz-animation: blink normal 2s infinite ease-in-out;
    -webkit-animation: blink normal 2s infinite ease-in-out;
    -ms-animation: blink normal 2s infinite ease-in-out;
    animation: blink normal 2s infinite ease-in-out;
}
</style>
</head>
<body>
   <div class="container" style="border:1px solid black">
   <div class="row" style="text-align: center; margin-bottom:10px;">
         Date: <input class="font" type="text" id="datepicker" style="width:120px;">
         <button class="font btn btn-warning btn-sm btn-hover" id="btn">영화목록 출력</button>
      </div>
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
      <div id="piechart" style="width: 900px; height: 500px;"></div>
      <img class="blink-image" src="img/1.png">
   </div>
   <div id="dialog" title="다른 날짜를 선택해주세요!">
       <p>오늘보다 이전의 날짜를 선택해주세요.</p>
     </div>
</body>
</html>

