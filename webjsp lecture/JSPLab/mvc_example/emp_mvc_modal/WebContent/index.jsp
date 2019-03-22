<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TEAM 3 , Member Manager</title>
	
    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="css/nivo-lightbox.css" rel="stylesheet" />
	<link href="css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
	<link href="css/animations.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet">
	<link href="color/default.css" rel="stylesheet">
    <!-- =======================================================
        Theme Name: Bocor
        Theme URL: https://bootstrapmade.com/bocor-bootstrap-template-nice-animation/
        Author: BootstrapMade
        Author URL: https://bootstrapmade.com
    ======================================================= -->
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
	
	<section class="hero" id="intro">
            <div class="container">
              <div class="row">
                <div class="col-md-12 text-right navicon">
                  <a id="nav-toggle" class="nav_slide_button" href="#"><span></span></a>
                </div>
              </div>
              <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center inner">
					<div class="animatedParent">
						<h1 class="animated fadeInDown">사원관리 시스템</h1>
						<p class="animated fadeInUp">WE ARE TEAM 3, WE CAN DO WHATEVER WE WANT!</p>
					</div>
			   </div>
              </div>
          
              <div class="row">
             
               <div class="col-md-6 col-md-offset-3 text-center">
               	 <!--   login/logout show 처리-->
                <c:choose>
                     <c:when test="${sessionScope.userid != null }">
                 	
					<form action="EmpSearch" method="post" >
					&nbsp;&nbsp;
					<input type="text" name="search" id="search" placeholder="사원이름을 입력하세요" class="form-control" style="width: 80%; float:left;"/>
					<input type="submit" value="사원검색" id="searchbtn"  class="btn" style="width: 100px; float:left;"/>
					</form>	
					</c:when>
		
				<c:otherwise>
				  <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="login" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="id">ID</label>
			                        	<input type="text" name="id" placeholder="ID....." class="form-username form-control" id="id">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="pwd">PASSWORD</label>
			                        	<input type="password" name="pwd" placeholder="Password..." class="form-password form-control" id="pwd">
			                        </div>
			                        <button type="submit" class="btn">Login In!</button>
			                    </form>
			                    <!-- <div class="form-top-left">       
                            		<p>로그인 해주세요.</p>
                        		</div> -->
		                    </div>
                        </div>
                    </div>
				
				</c:otherwise>
				</c:choose>
                </div>
              </div>
            
            </div>
       
    </section>
	
	
    <!-- Navigation -->
   <jsp:include page="/common/menu.jsp"></jsp:include>
    <!-- /Navigation -->  

	<!-- Section: about -->
  	
<!--         //////////////////////////////////////////////////////////////////////////////////                 -->
	<!-- 여기에 BODY  -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  	
<!--         //////////////////////////////////////////////////////////////////////////////////                 -->
	
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<!--footer  -->

    <!-- Core JavaScript Files -->
    <script src="js/jquery.min.js"></script>	 
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
    <script src="js/jquery.easing.min.js"></script>	
	<script src="js/jquery.scrollTo.js"></script>
	<script src="js/jquery.appear.js"></script>
	<script src="js/stellar.js"></script>
	<script src="js/nivo-lightbox.min.js"></script>
	
    <script src="js/custom.js"></script>
	<script src="js/css3-animate-it.js"></script>
	

   
</body>

</html>
    