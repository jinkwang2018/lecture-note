<%@page import="kr.or.bmark.dao.memberDao"%>
<%@page import="kr.or.bmark.dto.team"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 모델2변경 및 페이징 작업중.. -->
<%
	
	memberDao meberdao = new memberDao();
	List<team> list =  meberdao.getGroupList();
	
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


<!-- 사이트 등록 Modal 창 -->
<script type="text/javascript">
$(function(){
	/* grouptable tr태그 클릭하면 회원 수정 modal창 생성  */
	$('table > tbody > tr').click(function(){
		
		/* td 태그 내용 list를 담는 변수 */
		var temp = $(this).children();
		
		/* td의 내용 그룹명, 그룹 이름, 인원을 순차적으로 input 태그의 value를 넣어줌 */
		$.each(temp, function(index, element) {
			var userinfo = $(temp[index]).text();
			$('.container > input').eq(index).val(userinfo);
		});
		
		$('#groupform').css("display", "block");
	});
	
	/* input 태그의 수정사항이 있으면 더블클릭 이벤트를 통해 readonly속성을 제거 */
	$('.container > input').dblclick(function() {
		$(this).removeAttr("readonly");
	});
	
});
</script>

<!-- 그룹정보 수정 ,삭제  Modal 창 -->
<div id="groupform" class="modal">

	<form class="modal-content animate">
		<div align="center">
			<h3>그룹 정보 및 삭제</h3>
			<span
				onclick="document.getElementById('groupform').style.display='none'"
				class="close" title="Close Modal" style="margin-top: 10px">&times;</span>
		</div>

		<div class="container">
		<div align="right"><small><b>※ 수정을 원하시면 더블클릭을 해주세요 ♡</b></small><br></div>
			<label for="gid"><b>그룹명</b></label> 
			<input type="text" placeholder="" name="gid" readonly> 
			
			<label for="gname"><b>그룹 이름</b></label>
			<input type="text" placeholder="" name="gname" readonly>
			 
			<label for="gnum"><b>인원</b></label> 
			<input type="text" placeholder="" name="gnum" disabled>

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
				<span class="adminfont">그룹관리 PAGE</span>
			</div>
			
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					
					<th>팀명</th>
					<th>팀 소개</th>
					<th>그룹id</th>
					<th>팀등록</th>
					<th>팀생성일</th>	
				
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${list}">
					<tr>
						<td>${team.name}</td>
						<td>${team.content}</td>
						<td>${team.gid}</td>
						<td>${team.register}</td>
						<td>${team.regday}</td>	
											
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>