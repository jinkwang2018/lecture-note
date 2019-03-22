
/*
 * 작성자	: 김래영
 * 목적	: 카테고리별 조회수 TOP5 조회시, 데이터베이스에서 카테고리를 동적으로 가져오는 함수.
 */
function selected() {
	var chartData = [];
	//console.log($('.categorychart').val());
	$.ajax({
		 url: "sitechartshow.mainbmark", //해당 url로
		 data: {id:$('.categorychart').val()}, //데이터 전송
		 dataType: "JSON", //json 형식
		 type: "POST",
		 success: function(data) { //성공시 아래 내용 출력
			console.log(data);
			$.each(data, function(index, obj) {
				var temp = [];
				temp.push(obj.name);
				temp.push(obj.hit);
				chartData.push(temp);
			})
			
			//차트
			Highcharts.chart('chartcontainer', {
			    chart: {
			        type: 'column'
			    },
			    title: {
			        text: '<b>카테고리별 사이트 통계 차트(Top5)</b>'
			    },
			    xAxis: {
			        type: 'category',
			        labels: {
			            rotation: -45,
			        }
			    },
			    yAxis: {
			        min: 0,
			        title: {
			            text: '방문자 수 '
			        }
			    },
			    legend: {
			        enabled: false
			    },
			    tooltip: {
			    },
			    series: [{
			        name: '방문수',
			        data: chartData,
			        dataLabels: {
			            enabled: true,
			            rotation: -90,
			            color: '#FFFFFF',
			            align: 'right',
			            y: 10, // 10 pixels down from the top
			        }
			    }]
			});		
		 },
		 error: function (error) {
			    alert('error : ' + eval(error));
		 }
	});

}