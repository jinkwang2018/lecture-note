var map;
var map2;
var markers = [];
var markers2 = [];
var sigun = new Set();
var sigun2 = new Set();
var link = "preview.jsp"
var row = [];
var rowMap = new Map();



function drawChart() {
	console.log("draw");
	// Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows(row);

    // Set chart options
    var options = {'title':'경기도 시별 영화관 수',
                   'width':'100%',
                   'height':'40%'};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}

$(function(){
	
	$.getJSON('https://openapi.gg.go.kr/MovieScreening?KEY=0d9f8580204441dbba88e72b3fb9f643&Type=json&pIndex=1&pSize=157', function(data) {
		var MovieScreening = data.MovieScreening;
		$('<option>').appendTo("#select");
		
		console.log("Movie" + MovieScreening[1].row.length);
		
		$.each(MovieScreening[1], function(key, value) {
			$.each(value, function(key2, value2){
				if(value2.BSN_STATE_NM == "운영중"){
					//시군 리스트 추가
					if(!sigun.has(value2.SIGUN_NM)){
						sigun.add(value2.SIGUN_NM);
						console.log(value2.SIGUN_NM);
						$('<option>').text(value2.SIGUN_NM).appendTo("#select");
					}
					//차트 맵 추가
					if(!rowMap.has(value2.SIGUN_NM)){
						rowMap.set(value2.SIGUN_NM, 1);
						//console.log("if");
					}else {
						rowMap.set(value2.SIGUN_NM, Number(rowMap.get(value2.SIGUN_NM)) + 1);
						//console.log("else : " + rowMap.get(value2.SIGUN_NM));
					}
				}
			});
		});
		rowMap.forEach(function(value, key){
			var temp = [key, value];
			row.push(temp);
		});
		console.log(row);
		
		//Load the Visualization API and the corechart package.
		google.charts.load('current', {'packages':['corechart']});

		// Set a callback to run when the Google Visualization API is loaded.
		google.charts.setOnLoadCallback(drawChart);
		
	});
	$('#select').change(function(){
		console.log($('#select option:selected').text());
		if($('#select option:selected').text() != ""){
			console.log($(this).val());
			$('#select2').empty();
			$('<option>').appendTo("#select2");
			$.getJSON("https://openapi.gg.go.kr/MovieScreening?KEY=0d9f8580204441dbba88e72b3fb9f643&Type=json&pIndex=1&pSize=30&SIGUN_NM=" + $(this).val(), function(data){
				var MovieScreening = data.MovieScreening;
				map2 = new google.maps.Map(document.getElementById('map2'), {
					center : {
						lat : 37.2664398,
						lng : 126.9994077
					},
					zoom : 12,
					disableDefaultUI : true
				});
				if(markers2.length > 0){
					for (var i = 0; i < markers2.length; i++) {
						markers2[i].setMap(null);
					}
					markers2 = [];
				}
				$.each(MovieScreening[1], function(key, value) {
					$.each(value, function(key2, value2){
						if(value2.BSN_STATE_NM == "운영중"){
							var marker = new google.maps.Marker({
								map : map2,
								icon : 'http://maps.google.com/mapfiles/kml/shapes/movies.png',
								animation : google.maps.Animation.BOUNCE,
								position : {
									lat : Number(value2.REFINE_WGS84_LAT),
									lng : Number(value2.REFINE_WGS84_LOGT)
								}
							});
							
							var contentString = '<div>' +
								'<b>시군명 </b> : ' + value2.SIGUN_NM + '<br>' +
								'<b>사업장명<b> : ' + value2.BIZPLC_NM +
								'</div>';
							var infowindow = new google.maps.InfoWindow({
								content: contentString
						    });
							marker.addListener('mouseover', function() {
						          infowindow.open(map, marker);
						    });
							marker.addListener('mouseout', function() {
						          infowindow.close(map, marker);
						    });
							marker.addListener('click', function(){
								location.href= link + "?SIGUN_NM="+value2.SIGUN_NM + "&BIZPLC_NM=" + value2.BIZPLC_NM.replace(/ /gi, "_");
							});
							markers2.push(marker);
							$('<option>').text(value2.BIZPLC_NM).appendTo("#select2");
						}
					});
				});
				console.log("markers : " + markers2[0].position.lng());
				var latlng = new google.maps.LatLng(markers2[0].position.lat(), markers2[0].position.lng());
				map2.setCenter(latlng);
			});
		}else {
			$('#map2').empty();
			$('#select2').empty();
			$('<img>').attr("src", "Images/영화관.jpg").appendTo("#map2");
		}
		
	});
	$('#select2').change(function(){
		console.log('select1 :' + $('select').val());
		console.log('select2 :' + $(this).val());
		if($("#select").text() != null && $("#select2").text() != null){
			location.href= link + "?SIGUN_NM=" + $('select').val() + "&BIZPLC_NM=" + $(this).val().replace(/ /gi, "_");
		}
	});
	
	
	
	
	
});







function addYourLocationButton(map) {
	var controlDiv = document.createElement('div');

	var firstChild = document.createElement('button');
	firstChild.style.backgroundColor = '#fff';
	firstChild.style.border = 'none';
	firstChild.style.outline = 'none';
	firstChild.style.width = '28px';
	firstChild.style.height = '28px';
	firstChild.style.borderRadius = '2px';
	firstChild.style.boxShadow = '0 1px 4px rgba(0,0,0,0.3)';
	firstChild.style.cursor = 'pointer';
	firstChild.style.marginRight = '10px';
	firstChild.style.padding = '0px';
	firstChild.title = 'Your Location';
	controlDiv.appendChild(firstChild);

	var secondChild = document.createElement('div');
	secondChild.style.margin = '5px';
	secondChild.style.width = '18px';
	secondChild.style.height = '18px';
	secondChild.style.backgroundImage = 'url(https://maps.gstatic.com/tactile/mylocation/mylocation-sprite-1x.png)';
	secondChild.style.backgroundSize = '180px 18px';
	secondChild.style.backgroundPosition = '0px 0px';
	secondChild.style.backgroundRepeat = 'no-repeat';
	secondChild.id = 'you_location_img';
	firstChild.appendChild(secondChild);

	google.maps.event.addListener(map, 'dragend', function() {
		$('#you_location_img').css('background-position', '0px 0px');
	});

	firstChild.addEventListener('click', function() {
		var imgX = '0';
		var animationInterval = setInterval(function() {
			if (imgX == '-18')
				imgX = '0';
			else
				imgX = '-18';
			$('#you_location_img').css('background-position', imgX + 'px 0px');
		}, 500);
		if (navigator.geolocation) {
			navigator.geolocation
					.getCurrentPosition(function(position) {
						var latlng = new google.maps.LatLng(
								position.coords.latitude,
								position.coords.longitude);
						map.setCenter(latlng);
						clearInterval(animationInterval);
						$('#you_location_img').css('background-position',
								'-144px 0px');
					});
		} else {
			clearInterval(animationInterval);
			$('#you_location_img').css('background-position', '0px 0px');
		}
	});

	controlDiv.index = 1;
	map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(controlDiv);
}

function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : 37.2664398,
			lng : 126.9994077
		},
		zoom : 14,
		disableDefaultUI : true
	});
    
    addYourLocationButton(map);
	
	
	

	map.addListener('dragend', function() {
		console.log('dragend');
		console.log('lat: ' + map.center.lat() + "lng: " + map.center.lng());
		if(markers.length > 0){
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}
		$.getJSON('https://openapi.gg.go.kr/MovieScreening?KEY=0d9f8580204441dbba88e72b3fb9f643&Type=json&pIndex=1&pSize=157', function(data) {
			var MovieScreening = data.MovieScreening;
			$.each(MovieScreening[1], function(key, value) {
				$.each(value, function(key2, value2){
					
					
					if(value2.BSN_STATE_NM == "운영중" && Math.abs(map.center.lat() - Number(value2.REFINE_WGS84_LAT)) <= 0.03 && Math.abs(map.center.lng() - Number(value2.REFINE_WGS84_LOGT)) <= 0.03){
						var marker = new google.maps.Marker({
							map : map,
							icon : 'http://maps.google.com/mapfiles/kml/shapes/movies.png',
							animation : google.maps.Animation.BOUNCE,
							position : {
								lat : Number(value2.REFINE_WGS84_LAT),
								lng : Number(value2.REFINE_WGS84_LOGT)
							}
						});
						
						var contentString = '<div>' +
							'<b>시군명 </b> : ' + value2.SIGUN_NM + '<br>' +
							'<b>사업장명<b> : ' + value2.BIZPLC_NM +
							'</div>';
						var infowindow = new google.maps.InfoWindow({
							content: contentString
					    });
						marker.addListener('mouseover', function() {
					          infowindow.open(map, marker);
					    });
						marker.addListener('mouseout', function() {
					          infowindow.close(map, marker);
					    });
						marker.addListener('click', function(){
							location.href= link + "?SIGUN_NM="+value2.SIGUN_NM + "&BIZPLC_NM=" + value2.BIZPLC_NM.replace(/ /gi, "_");
						});
						markers.push(marker);
						console.log("add");
					}
				});
			});
		});
	});

	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat : position.coords.latitude,
				lng : position.coords.longitude
			};
			map.setCenter(pos);
		});
	}
}
