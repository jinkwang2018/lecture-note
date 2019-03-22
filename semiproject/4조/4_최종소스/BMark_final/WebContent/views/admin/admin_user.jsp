<%@page import="kr.or.bmark.dao.memberDao"%>
<%@page import="kr.or.bmark.dto.member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 모델2변경 및 페이징 작업중.. -->
<%
	
	memberDao meberdao = new memberDao();
	List<member> list =  meberdao.getMemberList();
	
%>
<c:set var="list" value="<%=list %>"/>

<!-- Google Icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- mousehover 이벤트에 따라 GoogleIcon 변경 -->
<script type="text/javascript">
	$(function() {
		$('#plus').hover(function() {
			$('#plus').empty();
			$('#plus').append("add_circle");
		}, function() {
			$('#plus').empty();
			$('#plus').append("add_circle_outline");
		});
		
		/* add_circle GoogleIcon을 클릭했을때 modal창 생성 */
		$('#plus').click(function(){
			$('#bookaddform').css("display", "block")
		});

	});
</script>
<script type="text/javascript">
	$(function(){
		/* usertable tr태그 클릭하면 회원 수정 modal창 생성  */
		$('table > tbody > tr').click(function(){
			
			/* td 태그 내용 list를 담는 변수 */
			var temp = $(this).children();
			
			/* td의 내용 아이디, 이름, 비밀번호, 이메일, 휴대폰번호 순차적으로 input 태그의 value를 넣어줌 */
			$.each(temp, function(index, element) {
				var userinfo = $(temp[index]).text();
				$('.container > input').eq(index).val(userinfo);
				/* $('.container > input').eq(index).; */
			});
			
			$('#userform').css("display", "block");
		});
		
		/* input 태그의 수정사항이 있으면 더블클릭 이벤트를 통해 readonly속성을 제거 */
		$('.container > input').dblclick(function() {
			$(this).removeAttr("readonly");
		});
		
	});
</script>

<!-- 회원정보 수정 ,탈퇴  Modal 창 -->
<div id="userform" class="modal">

	<form class="modal-content animate">
		<div align="center">
			<h3>회원 정보 및 삭제</h3>
			<span
				onclick="document.getElementById('userform').style.display='none'"
				class="close" title="Close Modal" style="margin-top: 10px">&times;</span>
		</div>

		<div class="container">
			<div align="right"><small><b>※ 수정을 원하시면 더블클릭을 해주세요 ♡</b></small><br></div>
			<label for="uid"><b>아이디</b></label> 
			<input type="text" placeholder="" name="uid" disabled> 
			
			<label for="uname"><b>이름</b></label>
			<input type="text" placeholder="" name="uname" readonly>
			 
			<label for="upwd"><b>비밀번호</b></label> 
			<input type="text" placeholder="" name="upwd" readonly>

			<label for="uemail"><b>이메일</b></label>
			<input type="text" placeholder="" name="uemail" readonly>
			 
			<label for="uphone"><b>휴대폰</b></label> 
			<input type="text" placeholder="" name="uphone" readonly>

			<div align="center">
				<button class="btn btn-primary" type="submit">수정</button>
				<button class="btn btn-default" type="submit">삭제</button>
			</div>
			<br>
		</div>
	</form>
</div>


<div class="container" style="width: 100%">
	<div class="col-md-12" class="admindiv">
		<div style="margin-top: 10px;">
		
			<div class="adminicon">
				<i class="material-icons" style="font-size: 30px">person_add</i>
			</div>
			<div class="admintitle">
				<span class="adminfont">회원관리 PAGE</span>
			</div>
			
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>팀ID</th>
					<th>가입일</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${list}">
					<tr>
						<td>${member.userid}</td>
						<td>${member.name}</td>
						<td>${member.pwd}</td>
						<td>${member.email}</td>
						<td>${member.phone}</td>
						<td>${member.gid}</td>
						<td>${member.regidate}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>