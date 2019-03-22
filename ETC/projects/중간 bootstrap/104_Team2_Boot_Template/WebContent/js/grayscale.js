/*!
 * Start Bootstrap - Grayscale Bootstrap Theme (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

// jQuery to collapse the navbar on scroll
function collapseNavbar() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
}

$(window).scroll(collapseNavbar);
$(document).ready(collapseNavbar);

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function() {
    $(this).closest('.collapse').collapse('toggle');
});

/*// Google Maps Scripts
var map = null;
// When the window has finished loading create our google map below
google.maps.event.addDomListener(window, 'load', init);
google.maps.event.addDomListener(window, 'resize', function() {
    map.setCenter(new google.maps.LatLng(37.4994553, 127.02924710000002));
});

function init() {
    // Basic options for a simple Google Map
    // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions = {
        // How zoomed in you want the map to start at (always required)
        zoom: 15,

        // The latitude and longitude to center the map (always required)
        center: new google.maps.LatLng(37.4994553, 127.02924710000002), // New York

        // Disables the default Google Maps UI components
        disableDefaultUI: true,
        scrollwheel: false,
        draggable: false,

        // How you would like to style the map. 
        // This is where you would paste any style found on Snazzy Maps.
        styles: [{
            "featureType": "water",
            "elementType": "geometry",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 17
            }]
        }, {
            "featureType": "landscape",
            "elementType": "geometry",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 20
            }]
        }, {
            "featureType": "road.highway",
            "elementType": "geometry.fill",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 17
            }]
        }, {
            "featureType": "road.highway",
            "elementType": "geometry.stroke",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 29
            }, {
                "weight": 0.2
            }]
        }, {
            "featureType": "road.arterial",
            "elementType": "geometry",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 18
            }]
        }, {
            "featureType": "road.local",
            "elementType": "geometry",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 16
            }]
        }, {
            "featureType": "poi",
            "elementType": "geometry",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 21
            }]
        }, {
            "elementType": "labels.text.stroke",
            "stylers": [{
                "visibility": "on"
            }, {
                "color": "#000000"
            }, {
                "lightness": 16
            }]
        }, {
            "elementType": "labels.text.fill",
            "stylers": [{
                "saturation": 36
            }, {
                "color": "#000000"
            }, {
                "lightness": 40
            }]
        }, {
            "elementType": "labels.icon",
            "stylers": [{
                "visibility": "off"
            }]
        }, {
            "featureType": "transit",
            "elementType": "geometry",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 19
            }]
        }, {
            "featureType": "administrative",
            "elementType": "geometry.fill",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 20
            }]
        }, {
            "featureType": "administrative",
            "elementType": "geometry.stroke",
            "stylers": [{
                "color": "#000000"
            }, {
                "lightness": 17
            }, {
                "weight": 1.2
            }]
        }]
    };

    // Get the HTML DOM element that will contain your map 
    // We are using a div with id="map" seen below in the <body>
    var mapElement = document.getElementById('map');

    // Create the Google Map using out element and options defined above
    map = new google.maps.Map(mapElement, mapOptions);

    // Custom Map Marker Icon - Customize the map-marker.png file to customize your icon
    var image = 'img/map-marker.png';
    var myLatLng = new google.maps.LatLng(37.4994553, 127.02924710000002);
    var beachMarker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        icon: image
    });
}*/
//---map-- 영역

function initMap() { /*구글맵 실행 함수*/
	var uluru = { /*맵 초기 경도 위도 값 설정*/
		lat : 37.464541,
		lng : 127.02758300000005
	}; 
	var map = new google.maps.Map(document.getElementById('map'), { /*구글맵 <div id="map">에 생성*/
		zoom : 6, /*맵 확대 값 초기화*/
		center : uluru  /*설정한 위도 경도로 위치 설정*/
	
	});
}
window.onload = function() {
	var gangbtn = document.getElementById("gang"); /*비트캠프 강남점으로 이동하는 버튼 */
	var sinbtn = document.getElementById("sin");
	var jongbtn = document.getElementById("jong");
	var mybtn = document.getElementById("my");
	
	var image = new google.maps.MarkerImage(new google.maps.Size(10, 10)); /*마크 이미지 생성 및 크기 설정*/
	
	gangbtn.onclick = function() { /*강남 선택 시*/

		var uluru = {
			lat : 37.4994553,
			lng : 127.02924710000002
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 17,
			center : uluru
		});		
		var marker = new google.maps.Marker({/*마커 생성*/
			position : uluru, /*마커 위치 지정*/
			map : map, /*구글맵*/
			icon : image, /*마커 이미지 */
			title : '강남점' /*마커 title*/
		});
		var content = "비트캠프_강남점<br/><br/>Tel: 010-1234-1241";
		var infowindow = new google.maps.InfoWindow({
			content : content
		});
		google.maps.event.addListener(marker, "click", function() {
			infowindow.open(map, marker);
		});
		/*마커 클릭 시 생성되는 말풍선 실행함수*/
	}
	sinbtn.onclick = function() { /*비트캠프 신촌점 선택 시*/
		var uluru = {
			lat : 37.5524589,
			lng : 126.93782620000002
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 17,
			center : uluru
		});
		var marker = new google.maps.Marker({
			position : uluru,
			map : map,
			icon : image,
			title : '신촌점'
		});
		var content = "비트캠프_신촌점<br/><br/>Tel: 010-1235-5123";
		var infowindow = new google.maps.InfoWindow({
			content : content
		});
		google.maps.event.addListener(marker, "click", function() {
			infowindow.open(map, marker);
		});
	}
	jongbtn.onclick = function() {  /*비트캠프 종로점 선택 시*/
		var uluru = {
			lat : 37.5706042,
			lng : 126.98529189999999
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 17,
			center : uluru
		});
		var marker = new google.maps.Marker({
			position : uluru,
			map : map,
			icon : image,
			title : '종로점'
		});
		var content = "비트캠프_종로점<br/><br/>Tel: 010-8567-1234";
		var infowindow = new google.maps.InfoWindow({
			content : content
		});
		google.maps.event.addListener(marker, "click", function() {
			infowindow.open(map, marker);
		});
	}
	mybtn.onclick = function() { /*내 위치 클릭 시*/
		if (navigator.geolocation) { 
			navigator.geolocation.getCurrentPosition(function(position) { 
				/*네비게이터객체의 지오로케이션으로 현위치 위도 경도 추적*/
				var uluru = {
					lat : position.coords.latitude, /*현위치 위도 경도 설정*/
					lng : position.coords.longitude
				};
				var map = new google.maps.Map(document
						.getElementById('map'), {
					zoom : 17,
					center : uluru
				});
				var marker = new google.maps.Marker({
					position : uluru,
					map : map,
					icon : image,
					title : '현위치'
				});
				var content = "현재 나의 위치<br/><br/>GPS기준";
				var infowindow = new google.maps.InfoWindow({
					content : content
				});
				google.maps.event.addListener(marker, "click", function() {
					infowindow.open(map, marker);
				});
			}, function() { //지오로케이션 서비스가 실패했을 경우
				handleLocationError(true, infoWindow, map.getCenter());
			});
		} else {
			//브라우져가 지오로케이션을 지원하지 않는 경우
			handleLocationError(false, infoWindow, map.getCenter());
		}
	}
	function handleLocationError(browserHasGeolocation, infoWindow, pos) { /*지오로케이션 에러 메세지 설정 함수*/
		infoWindow.setPosition(pos);
		infoWindow
				.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
						: 'Error: Your browser doesn\'t support geolocation.');
	}
}

