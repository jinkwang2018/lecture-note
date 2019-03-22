<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- container section start -->
	<section id="container" class="">
		<header class="header dark-bg">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips"
					data-original-title="Toggle Navigation" data-placement="bottom">
					<i class="icon_menu"></i>
				</div>
			</div>

			<!--logo start-->
			<a href="main.jsp" class="logo"><b>B </b><span class="lite"><b>Mark</b></span></a>
			<!--logo end-->

			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">

					<!-- header 오른쪽 부분에 login, logout, mypage, 
					sign up, management(관리자 페이지) 이동 아이콘  Start-->
					
					<c:set var="userid" value="${sessionScope.userid }"/>
					<c:choose>
						<c:when test="${sessionScope.userid == null}">
							<li><a href="register.member">
								<span class="profile-ava">
								<img src="images/user.png" class="headimage">
								</span>
									Sign Up</a></li>
									
							<li><a id="login_btn">
								<span class="profile-ava">
								<img src="images/login.jpg" class="headimage">
								</span>
									Login</a></li>
						</c:when>
						<c:otherwise>
							<!-- <span class="profile-ava"><img src="images/user.png" style="width: 35px;"></span> -->
							<c:choose>
								<c:when test="${userid == 'admin'}">
									<li class="afterlogin"><a href="mypage.mybmark">
										<span class="profile-ava">
										<img src="images/mypage.png" class="headimage">
										</span>
											Mypage</a></li>
									
									<li class="afterlogin"><a href="member.admin">
										<span class="profile-ava">
										<img src="images/setting.jpeg" class="headimage">
										</span>
											Management</a></li>
								</c:when>
								<c:otherwise>
									<li class="afterlogin"><a href="mypage.mybmark">
										<span class="profile-ava">
										<img src="images/mypage.png" class="headimage">
										</span>
											Mypage</a></li>
								</c:otherwise>
							</c:choose>
							
							<li class="afterlogin"><a href="logout.member">
										<span class="profile-ava">
										<img src="images/logout.jpg" class="headimage">
										</span>
											Logout</a></li> 
						</c:otherwise>
					</c:choose>
					
					<!-- user login dropdown end -->
				</ul>
				<!-- notificatoin dropdown end-->
			</div>

		</header>
		<!--header end-->
	</section>

	