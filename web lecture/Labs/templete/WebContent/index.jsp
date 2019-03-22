<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

 <script src="vendor/jquery/jquery.min.js"></script> 
 <script src= "https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
 <script src="https://code.highcharts.com/highcharts.js"></script>
 <script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
     
<title>1조  Home Page</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
		
  		

 <script type="text/javascript">
 	
	

	$(function() {
		//SSE
		if (typeof (EventSource) !== "undefined") {
			var source = new EventSource("InformTime.jsp");
			source.onmessage = function(event) {
				var time = event.data;
						
				// 테스트 출력
				alert("시간이"+time+"분 지났습니다.");
				
				if (time > 60){
					alert("접속하신 시간이 " + 60 + "분 지났습니다");
				}else if (time > 50){
					alert("접속하신 시간이 " + 50 + "분 지났습니다");
				}else if (time > 40){
					alert("접속하신 시간이 " + 40 + "분 지났습니다");
				}else if (time > 30){
					alert("접속하신 시간이 " + 30 + "분 지났습니다");
				}else if (time > 20){
					alert("접속하신 시간이 " + 20 + "분 지났습니다");
				}else if (time > 10){
					alert("접속하신 시간이 " + 10 + "분 지났습니다");
				}
				
			};
		} else {
		}
		
		//datepicker
	    $( "#datepicker" ).datepicker(
	    	{	
	    	  dateFormat:"yymmdd",	
	    	  onSelect: function(date){
	    		 
	    		  
	    	  }
	          
	      	} 
	    		 
	    );
		//login
		 var idvalue = localStorage.getItem("id");
	       var sessionid = "<%=session.getAttribute("userid")%>";
	         $('#loginid').attr("value",idvalue);         
	         
	         if(sessionid!="null"){	            
	        	$('#intro').append("&nbsp;&nbsp;&nbsp;&nbsp;"+sessionid+"님 환영합니다.");
		        $('#btn1').show();
				$('#btn2').show();
		        $('#btn3').hide();
		        $('#btn4').hide();
			    $('#btn5').show();
			    $('#btn6').show();
			    $('#btn7').show();
			    $('#tag1').hide();
		        $('#portfolio').show();
		        $('#services').show();
		        $('#chart').show();
	         }
	         else{
		        $('#btn1').hide();
			    $('#btn2').hide();
	            $('#btn3').show();
	            $('#btn4').show();
		        $('#btn5').hide();
		        $('#btn6').hide();
		        $('#btn7').hide();
		        $('#tag1').show();
	            $('#portfolio').hide();
	            $('#services').hide();
	            $('#chart').hide();
	         }
	     //validation
	     
				$.validator.addMethod("regx",
						function(value, element, regexpr) {
							return regexpr.test(value);

						}

				);

				$('#signForm')
						.validate(
								{
									rules : {
										userId : {
											required : true,
											rangelength : [ 3, 16 ],
											regx : /^[a-z|0-9]+$/
										},
										userName : {
											required : true,
											regx : /^[ㄱ-ㅎ|가-힣]+$/
										},
										userPass : {
											required : true,
											rangelength : [ 6, 18 ],
											regx : /^[a-z|0-9]+$/
										},
										userPassCheck : {
											required : true,
											rangelength : [ 6, 18 ],
											equalTo : '#userPass',
											
										},
										userEmail : {
											required : true,
											email : true
										},
										userPhone : {
											required : true,
											rangelength : [ 10, 14 ],
											regx : /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/
										}
									},
									messages : {
										userId : {
											required : "아이디를 입력해주세요.",
											rangelength : $.validator
													.format("아이디의 글자수는 {0}~{1}자까지 입니다."),
											regx : "아이디는 영문자와 숫자만 가능합니다.!!!"
										},
										userName : {
											required : "이름을 입력해주세요.",
											regx : "이름은 한글만 가능합니다."
										},
										userPass : {
											required : "비밀번호를 입력해주세요.",
											rangelength : $.validator
													.format("비밀번호의 글자수는 {0}~{1}자까지 입니다."),
											regx : "비밀번호는 영문자와 숫자만 가능합니다.!!!"
										},
										userPassCheck : {
											required : "입력한 비밀번호와 다릅니다.",
											rangelength : $.validator
													.format("비밀번호의 글자수는 {0}~{1}자까지 입니다."),
											equalTo : "비밀번호가 같지 않습니다.",
										},
										userEmail : {
											required : "email을 입력해주세요 !!",
											email : "email 형식이 아닙니다."
										},
										userPhone : {
											required : "번호를 입력해주세요",
											number : "숫자만 입력하세요",
											regx : " 000-0000-0000형식입니다.",
											rangelength : $.validator
													.format("핸드폰번호의 글자수는 {0}~{1}까지 입니다.")
										}
									}
								});
					
					
				
					//chart
					$("#button").click(function(){
						console.log($('#datepicker').val());
						$('#container ').empty();
						var list = [];
						var audiCnt = [];
						var movieNm = [];
						var percent = [];
						var average=0;
					
						$.getJSON(
									"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?",
									{
										"key" : "464cf0a3c83fed3ec6a678866417c836",
										"targetDt" : $('#datepicker').val()
									}, function(data, textStatus, req) {
										console.log(data);
										console.log(data.boxOfficeResult);
										$.each(data.boxOfficeResult,function(key,obj) {
											list.push(obj);
										})
										//console.log(list);
										$.each(list[2],function(index,element){
											//console.log(element.movieNm);
											movieNm.push(element.movieNm);
											audiCnt.push(element.audiCnt);
											average += parseInt(element.audiCnt);
											
										});
										
										//console.log(average);
										$.each(audiCnt,function(index,element){
											percent.push(eval('element/average'));
										});
										//console.log(audiCnt[0]);
										//console.log(percent[0]);
										
										//chart
	
										Highcharts.chart(
																	'container',
																	{
																		chart : {
																			type : 'pie',
																			height : '50%',
																			fontsize : '35px',
																			options3d : {
																				enabled : true,
																				alpha : 45,
																				beta : 0
																			}
																		},
																																				
																		title : {
																			 
																			text : list[1]+' 의 관객수'
																		},
																		tooltip : {
																	        style: {
																	            
																	            fontWeight: 'bold',
																	           
																	        },
																	    
																			
																			pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
																		},
																		plotOptions : {
																			
																			pie : {
																				
																				allowPointSelect : true,
																				cursor : 'pointer',
																				depth : 35,
																				dataLabels : {
																					enabled : true,
																					format : '{point.name}'
																				}
																			}
																		},
																		series: [{
																			 	
																		        type: 'pie',
																		        name: 'Browser share',
																		        data: [
																		        	[movieNm[6], percent[6]],
																		            [movieNm[1], percent[1]],
																		            {
																		                name: movieNm[3],
																		                y: percent[3],
																		                sliced: true,
																		                selected: true,
																		                
																		            },
																		            [movieNm[4], percent[4]],
																		            [movieNm[5], percent[5]],
																		            [movieNm[0], percent[0]],
																		            [movieNm[7], percent[7]],
																		            [movieNm[8], percent[8]]
																		            
																		        ]
																		    }]
																		
																	});
														$('text').attr({style:"font-size:15pt"})
												});

							});

		});
	</script>



</head>

<body id="page-top">

    <!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="index.jsp" id="intro">1조</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a
						class="nav-link js-scroll-trigger active" href="#services" id="btn1">APIs</a>
					</li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger" href="#chart" id="btn7">chart</a>
					</li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger" id="btn2"
						href="#portfolio">profile</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						data-toggle="modal" data-target="#myModal1" id="btn3">Sign Up</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						data-toggle="modal" data-target="#myModal" id="btn4">Login</a></li>
					<li class="nav-item"><a href='booked.jsp' class="nav-link js-scroll-trigger" id="btn6"
                                                 >ticketing</a></li>                
					<li class="nav-item"><a href='Logout.jsp' class="nav-link js-scroll-trigger" id="btn5"
                                                 >logout</a></li>
                                      
				</ul>
			</div>
		</div>
	</nav>

	<!-- Header -->
    <header class="masthead">
      <div class="container" >
        <div class="intro-text">
          <div class="intro-lead-in">Welcome To Our Studio!</div>
          <div class="intro-heading text-uppercase">It's Nice To Meet You</div>
          <div class="intro-heading text-uppercase" id ="tag1">LOGIN PLEASE</div>
          <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Tell Me More</a>
        </div>
      </div>
    </header>

    <!-- Services -->
	<section id="services"  style="padding : 1;">
		 <div class="container" >
		  <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">APIs</h2>
            <br>
          </div>
		<div style="height: 1000px; width:100%; margin:0;">
			<div class="row"  style="height: 100%; width:100%; padding : 0;">
				<iframe src ="Map.html" style=" width:95%; height: 100%; margin: auto; padding : 0; border: 0px;" ></iframe>
			</div>
			</div>
		</div>
	</section>
	
	<!-- chart -->
	<section class="bg-light" id="chart"  style="padding : 1; height : 1000px !important">
		 <div class="container" >
		  <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">CHART</h2>
            <br>
          </div>
			<p>Date: <input type="text" id="datepicker"></p>
			<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" id="button" href="#chart">차트생성하기</a>
			<div id="container" style="height: 100% !important"></div>
		</div>
	</section>

	<!-- Portfolio Grid -->
    <section id="portfolio">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Profile</h2>
            <br>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/male.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>김정권</h4>
              <p class="text-muted">[조장]</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal2">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/male.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>김희준</h4>
              <p class="text-muted">[부조장]</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal3">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/male.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>황진국</h4>
              <p class="text-muted">[조원]</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal4">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/male.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>전형준</h4>
              <p class="text-muted">[조원]</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal5">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/male.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>강진광</h4>
              <p class="text-muted">[조원]</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal6">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/male.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>김준수</h4>
              <p class="text-muted">[조원]</p>
            </div>
          </div>
          <div class="col-md-4 col-sm-6 portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal7">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/team/female.png" alt="">
            </a>
            <div class="portfolio-caption">
              <h4>김명수</h4>
              <p class="text-muted">[조원]</p>
            </div>
          </div>
        </div>
      </div>
    </section>


   
    <!-- Footer -->
    <footer class="bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <span class="copyright">Copyright &copy; Your Website 2018</span>
          </div>
          <div class="col-md-4">
            <ul class="list-inline social-buttons">
              <li class="list-inline-item">
                <a href="#">
                  <i class="fa fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fa fa-facebook"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fa fa-linkedin"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="col-md-4">
            <ul class="list-inline quicklinks">
              <li class="list-inline-item">
                <a href="#">Privacy Policy</a>
              </li>
              <li class="list-inline-item">
                <a href="#">Terms of Use</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>

    <!-- Portfolio Modals -->

	<!-- Modal 1 -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">김정권</h2>
								<p class="item-intro text-muted">[조장]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/male.png" alt="">

								<ul class="list-inline">
									<li>AGE : 30</li>
									<li>hobby : 운동 </li>
									<li>Favorite movie : 인셉션</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 2 -->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">김희준</h2>
								<p class="item-intro text-muted">[부조장]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/male.png" alt="">
								<ul class="list-inline">
									<li>AGE : 25</li>
									<li>hobby : 잠자기</li>
									<li>Favorite movie : 이미테이션 게임</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 3 -->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">황진국</h2>
								<p class="item-intro text-muted">[조원]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/male.png" alt="">
								<ul class="list-inline">
									<li>AGE : 32</li>
									<li>hobby : 운동</li>
									<li>Favorite movie : 레이드1,2</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 4 -->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">전형준</h2>
								<p class="item-intro text-muted">[조원]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/male.png" alt="">
								<ul class="list-inline">
									<li>AGE : 30</li>
									<li>hobby : 축구</li>
									<li>Favorite movie : 메멘토</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 5 -->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">강진광</h2>
								<p class="item-intro text-muted">[조원]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/male.png" alt="">
								<ul class="list-inline">
									<li>AGE : 28</li>
									<li>hobby : 요리</li>
									<li>Favorite Movie : 뷰티인사이드</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 6 -->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">김준수</h2>
								<p class="item-intro text-muted">[조원]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/male.png" alt="">
								<ul class="list-inline">
									<li>AGE : 28</li>
									<li>hobby : 영화보기</li>
									<li>Favorite movie : 말할 수 없는 비밀</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal 7 -->
	<div class="portfolio-modal modal fade" id="portfolioModal7"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase">김명수</h2>
								<p class="item-intro text-muted">[조원]</p>
								<img class="img-fluid d-block mx-auto"
									src="img/team/female.png" alt="">
								<ul class="list-inline">
									<li>AGE : 25</li>
									<li>hobby : 베이커리</li>
									<li>Favorite movie : 오세암</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fa fa-times"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
   
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="js/jqBootstrapValidation.min.js"></script>
    
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/agency.min.js"></script>
		
	


	<!-- 회원가입 -->
			<div id="myModal1" class="modal fade" role="dialog" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Sign Up</h4>
							</div>
							<form action="joinok.jsp" id="signForm" name="signForm" method="post" >
								<div class="form-group">
									<label for="userId">&nbsp;ID :</label> 
									<input type="text" class="form-control" id="userId" placeholder="Enter id" name="userId">
								</div>
								<div class="form-group">
									<label for="userName">&nbsp;NAME :</label> 
									<input type="text" class="form-control" id="userName" placeholder="Enter name" name="userName">
								</div>
								<div class="form-group">
									<label for="userPass">&nbsp;Password :</label> 
									<input type="password" class="form-control" id="userPass" placeholder="Enter password" name="userPass">
								</div>
								<div class="form-group">
									<label for="userPassCheck">&nbsp;check password :</label> 
									<input type="password" class="form-control" id="userPassCheck" placeholder="Enter check password" name="userPassCheck">
								</div>
								<div class="form-group">
									<label for="gender">&nbsp;gender :</label> 
									<table>
									<tr>
									<td>male&nbsp;<input type="radio"class="form-control" id="gender" name="gender"value="남" ></td>
									<td>female&nbsp;<input type="radio" class="form-control" id="gender1" name="gender" value="여"></td>
									</tr>
									</table>
								</div> 
								<div class="form-group">
									<label for="userEmail">&nbsp;Email :</label> 
									<input type="text" class="form-control" id="userEmail" placeholder="Enter Email" name="userEmail">
								</div>
								<div class="form-group">
									<label for="userPhone">&nbsp;Phone number :</label> 
									<input type="text" class="form-control" id="userPhone" placeholder="Enter check password" name="userPhone">
								</div>
						
	
								<div class="modal-footer">
									<button type="submit" class="btn btn-default">Sign Up</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			<!--로그인-->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Login</h4>
							</div>
							<form action="loginok.jsp" id="loginForm" name="loginForm" method="post" >
							<div class="modal-body">
									<div class="form-group">
										<label for="id">ID:</label> <input type="text"
											class="form-control" name="userId" id="loginid" placeholder="Enter ID">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" name="userPass" placeholder="Enter password">
									</div>
									<div class="checkbox">
										<label><input type="checkbox"  name="chk"> Remember me</label>
									</div>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-default">Login</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</form>
						</div>
					</div>
				</div>
	
  </body>

</html>
