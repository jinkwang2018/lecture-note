<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String member = (String)session.getAttribute("member");
   boolean loginstate = (member == null) ? false : true; 
%>
<link href="<%= request.getContextPath() %>/css/Bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<a class="navbar-brand" href="Main.jsp"><img src="<%= request.getContextPath() %>/Images/logoMacgyper4.png" style="width: 90%;"> </a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Share Board"><a class="nav-link" href="boardlist.bbs">
					<i class="fa fa-fw fa-share-alt"></i> <span class="nav-link-text">Share
						Board</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Calendar"><a class="nav-link" href="Event.jsp"> <i
					class="fa fa-fw fa-calendar"></i> <span class="nav-link-text">Calendar</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Note"><a class="nav-link nav-link-collapse collapsed"
				data-toggle="collapse" href="#collapseComponents"
				data-parent="#exampleAccordion"> <i class="fa fa-fw fa-book"></i>
					<span class="nav-link-text">Note</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseComponents">
					<li><a href="WriteMemo.mo">새로 만들기</a></li>
					<li><a href="MemoList.mo">Note</a></li>
					<li><a href="BookList.mo">Book</a></li>
				</ul></li>

			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="WeatherChart"><a class="nav-link" href="chartAPI.ch">
					<i class="fa fa-fw fa-bar-chart-o"></i> <span class="nav-link-text">WeatherChart</span>
			</a></li>
		</ul>

		

		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><c:choose>
					<c:when test="${sessionScope.member != null}">
						<a class="nav-link"> ${sessionScope.member}님 로그인 상태입니다
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a></li>
			<c:choose>
				<c:when test="${member.equals('admin')}">
					<li class="nav-item"><a class="nav-link"
						onclick="location.href='<%= request.getContextPath() %>/adminlist.ch'">
							<i class="fa fa-fw fa-edit"></i>회원 목록 및 수정
					</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						onclick="location.href='<%= request.getContextPath() %>/myedit.ch?id=<%= member %>'">
							<i class="fa fa-fw fa-edit"></i>개인정보확인
					</a></li>
				</c:otherwise>
			</c:choose>
			</c:when>
			<c:otherwise>
				<script>alert('로그인 해주세요.')</script>
				<script>location.href='<%= request.getContextPath() %>/Login.jsp'</script>
			</c:otherwise>
			</c:choose>
			</li>
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"
				onclick="location.href='<%= request.getContextPath() %>/join/Logout.jsp'">
					<i class="fa fa-fw fa-sign-out"></i>Logout
			</a></li>
		</ul>
	</div>
</nav>
