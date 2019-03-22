var map;
var markers = [];

function addYourLocationButton(map, marker) {
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
						marker.setPosition(latlng);
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
			lat : 37.541,
			lng : 126.986
		},
		zoom : 14,
		disableDefaultUI : true
	});
    
	var myMarker = new google.maps.Marker({
        map: map,
        animation: google.maps.Animation.DROP,
        position: {lat : 37.541,lng : 126.986}
    });
    addYourLocationButton(map, myMarker);
	
	
	function deleteMarkers() {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
		}
		markers = [];
	}

	map.addListener('dragend', function() {
		console.log('dragend');
		console.log('lat: ' + map.center.lat() + "lng: " + map.center.lng());
		if(markers.length > 0){
			deleteMarkers();
		}
		$.getJSON('영화상영관현황.json', function(data) {
			$.each(data, function(key, value) {
				if(Math.abs(map.center.lat() - Number(value.REFINE_WGS84_LAT)) <= 0.03 && Math.abs(map.center.lng() - Number(value.REFINE_WGS84_LOGT)) <= 0.03){
					var marker = new google.maps.Marker({
						map : map,
						icon : 'http://maps.google.com/mapfiles/kml/shapes/movies.png',
						animation : google.maps.Animation.BOUNCE,
						position : {
							lat : Number(value.REFINE_WGS84_LAT),
							lng : Number(value.REFINE_WGS84_LOGT)
						}
					});
					markers.push(marker);
					console.log("add");
				}
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
			
			infoWindow.setPosition(pos);
			infoWindow.setContent('Location found.');
			map.setCenter(pos);
			
		}, function() {
			handleLocationError(true, infoWindow, map.getCenter());
		});
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false, infoWindow, map.getCenter());
	}
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow
			.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
					: 'Error: Your browser doesn\'t support geolocation.');
}
