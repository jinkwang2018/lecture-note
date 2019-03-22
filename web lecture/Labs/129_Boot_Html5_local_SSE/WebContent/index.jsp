<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sid = (String)session.getAttribute("id");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="css/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>  
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<%
	if(sid == null){
%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.html">Main</a></li>
        <li><a href="GeoLocation.html">GeoLocation</a></li>
        <li><a href="Drag_Drop.html">Drag & Drop</a></li>
        <li><a href="LocalStorage.html">LocalStorage</a></li>
        <li><a href="SSE.html">SSE</a></li>
        <li><a href="Web_Worker.html">Web Worker</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
		<li><a href="Member.html"><span class="glyphicon glyphicon glyphicon-user"></span> 4조 조원보기</a></li>
        <li><a href="Login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>	
<%
	}else{
%>

	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.html">Main</a></li>
        <li><a href="GeoLocation.html">GeoLocation</a></li>
        <li><a href="Drag_Drop.html">Drag & Drop</a></li>
        <li><a href="LocalStorage.html">LocalStorage</a></li>
        <li><a href="SSE.html">SSE</a></li>
        <li><a href="Web_Worker.html">Web Worker</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
		<li><a href="Member.html"><span class="glyphicon glyphicon glyphicon-user"></span> 4조 조원보기</a></li>
        <li><a href="Logout.jsp"><span class="glyphicon glyphicon-log-out"></span><%=sid%>님 환영합니다.</a></li>
      </ul>
    </div>
  </div>
</nav>	

<%
	}
%>









<div class="jumbotron text-center">
  <h1>4조</h1>
  <div class="ui-widget">
   <form class="form-inline">
    <input type="text" class="form-control" placeholder="메뉴를 입력하세요" required id="emailinput" style="size:50">
    <button type="button" class="btn btn-danger" id="search">검색하기</button>
   </form>
  </div>
</div>

<!-- Container (About Section) -->

<!-- Container (Services Section) -->
<div id="services" class="container-fluid text-center">
  <h2>발표내용</h2>
  <h4>뭐가 있을까요?</h4>
  <br>
  <div class="row slideanim">
    <div class="col-sm-4">
      <a href="GeoLocation.html"><span class="glyphicon glyphicon-off logo-small"></span></a>
      <h4>GeoLocation</h4>
      <p>위치 정보</p>
    </div>
    <div class="col-sm-4">
      <a href="Drag_Drop.html"><span class="	glyphicon glyphicon-th-large logo-small"></span></a>
      <h4>Drag & Drop</h4>
      <p>드래그 앤 드롭</p>
    </div>
    <div class="col-sm-4">
      <a href="LocalStorage.html"><span class="glyphicon glyphicon-lock logo-small"></span></a>
      <h4>LocalStorage</h4>
      <p>로컬 스토리지</p>
    </div>
  </div>
  <br><br>
  <div class="row slideanim">
    <div class="col-sm-4">
      <a href="SSE.html"><span class="glyphicon glyphicon-leaf logo-small"></span></a>
      <h4>SSE</h4>
      <p>서버에서 클라이언트로!</p>
    </div>
    <div class="col-sm-4">
      <a href="Web_Worker.html"><span class="glyphicon glyphicon-certificate logo-small"></span></a>
      <h4>Web Worker</h4>
      <p>웹 워커</p>
    </div>
    <div class="col-sm-4">
      <a href="Member.html"><span class="glyphicon glyphicon-user logo-small"></span></a>
      <h4>4조 보기</h4>
      <p>조원 소개</p>
    </div>
    
    
  </div>
</div>

<!-- Container (Portfolio Section) -->
<div id="portfolio" class="container-fluid text-center bg-grey">
  <h2>주님은 언제나 당신을 사랑하십니다.</h2>
  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <h4>"기록된바 내가 너를 많은 민족의 조상으로 세웠다 하심과 같으니 그의 믿은바 하나님은 죽은 자를 살리시며 없는 것을 있는 것 같이 부르시는 이시니라 "<br><br/><span style="font-style:normal;">로마서 4:17 </span></h4>
      </div>
      <div class="item">
        <h4>"이는 그리스도 예수 안에서 아브라함의 복이 이방인에게 미치게 하고 또 우리로 하여금 믿음으로 말미암아 성령의 약속을 받게 하려 함이니라 "<br><br/><span style="font-style:normal;">갈라디아서 3:14</span></h4>
      </div>
      <div class="item">
        <h4>"오직 우리 주 곧 구주 예수 그리스도의 은혜와 저를 아는 지식에서 자라가라 영광이 이제와 영원한 날까지 저에게 있을지어다 "<br><br/><span style="font-style:normal;">베드로후서 3:18</span></h4>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-white">
  <h2 class="text-center">연락해요~♥</h2>
  <div class="row">
    <div class="col-sm-5">
      <p>24시간 널 기다리고있어요.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> 코스타, 정자</p>
      <p><span class="glyphicon glyphicon-phone"></span> 010-1111-2222</p>
      <p><span class="glyphicon glyphicon-envelope"></span> kglim@1004.com</p>
    </div>
    <div class="col-sm-7 slideanim">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
          <button class="btn btn-default pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
</div>


<!-- Add Google Maps -->
<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Bootstrap Theme Made By <a href="http://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a></p>
</footer>

<script>

function writeDiary(){
	
	location.href="LocalStorageEx01.html";
	
}

function whereamI(){
	location.href="Where.html";
}


$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
  
  
  

	 var availableTags = [
	                      "Geolocation",
	                      "Drag&Drop",
	                      "LocalStorage",
	                      "SSE",
	                      "Web Worker",
	                      "조원 소개"
	                    ];
	
	
	$('#emailinput').autocomplete({
		source: availableTags
	});
  
  //검색 부분
  $("#search").click(function(){
	 
	  var search = $("#emailinput").val();
	  
	  var atag = "Geolocation";
	  var atag2 = "Drag&Drop";
	  var atag3 = "LocalStorage";
	  var atag4 = "SSE";
	  var atag5 = "Web Worker";
	  var atag6 = "조원 소개";
	  if(search == atag){
		 location.href="GeoLocation.html";  
	  }else if(search == atag2){
		  location.href="Drag_Drop.html";
	  }else if(search == atag3){
		  location.href="LocalStorage.html";
	  }else if(search == atag4){
		  location.href="SSE.html";
	  }else if(search == atag5){
		  location.href="Web_Worker.html";
	  }else if(search == atag6){
		  location.href = "Member.html";
	  }
	  
  });
  
})
</script>

	
</body>
</html>