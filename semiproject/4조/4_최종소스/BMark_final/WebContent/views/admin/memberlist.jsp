<%@page import="kr.or.bmark.dto.memberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Google Icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<%  
   int cpage = (Integer)request.getAttribute("cpage");
   int pagesize = (Integer)request.getAttribute("pagesize");
   int pagecount = (Integer)request.getAttribute("pagecount");
   int totalmembercount = (Integer)request.getAttribute("totalmembercount");
   List<memberDto> memberlist = (List)request.getAttribute("memberlist");
 %>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	 
<script type="text/javascript">
	//회원 수정 modal 창 띄우는 함수
	function modalactivate(userid,name,pw,email,phone){
		var temp = [userid,name,pw,email,phone];
		$.each(temp, function(index, element) {
			var userinfo = temp[index];
			$('.container > input').eq(index).val(userinfo);
		});
		$('#userform').css("display", "block");
	}
	//수정하기 버튼누르면 작동하는 함수
	function memberupdate(cpage,pagesize) {
		var param = $("#modalmemberinfo").serialize()+"&cp="+cpage+"&ps="+pagesize;
		$.ajax(
				{
					url: "memberupdate.admin",
					dataType: "HTML",
					data: param,
					type: "POST",
					success:function(data){
  	  					$('#membersinfo').empty();
  	  					$('#membersinfo').append(data);
					}
				}
		);
		document.getElementById('userform').style.display='none';
	}
	//현재 페이지 번호 누르면 바뀌는 함수
  	function pagelist(cpage, pagesize) {
		$.ajax(
				{
					url:"memberlistpaging.admin",
					dataType:"HTML",
					data:{ cp:cpage , ps:pagesize },
					type:"POST",
					success:function(data){
  						$('#membersinfo').empty();
  						$('#membersinfo').append(data);
						
					}
				}
		)
	}
	//현재 페이지 사이즈를 누르면 바뀌는 함수
  	function pagelist1() {
  		var param =$("#pagesize").serialize();
		$.ajax(
				{
					url:"memberlistpaging.admin",
					dataType:"HTML",
					data: param,
					type:"POST",
					success:function(data){
  						$('#membersinfo').empty();
  						$('#membersinfo').append(data);
						
					}
				}
		)
	}

	//회원 정보를 삭제하는 함수
	function memberdelete(username, cpage, pagesize) {
		var r = confirm("정말로"+username+"님의 아이디를 삭제합니까?" );
		if(r == true){
			$.ajax(
					{
						url: "memberdelete.admin",
						dataType: "HTML",
						data: {userid : username, cp: cpage, ps: pagesize},
						type: "POST",
						success:function(data){
							console.log(data);
	  	  					$('#membersinfo').empty();
	  	  					$('#membersinfo').append(data);
						}
					}
			);
		} else{
			return false;
		}
	}
</script>
<c:set var="pagesize" value="<%=pagesize%>" />
<c:set var="cpage" value="<%=cpage%>" />
<c:set var="pagecount" value="<%=pagecount%>" />
<c:set var="memberlist" value="<%=memberlist%>"/>
<c:set var="totalMemberCount" value="<%=totalmembercount%>"/>
<div> 
<!-- 회원정보 수정 ,탈퇴  Modal 창 -->
<div id="userform" class="modal">

	<form id="modalmemberinfo" name="memberinfo" class="modal-content animate" >
		<div align="center">
			<h3>회원 정보 및 삭제</h3>
			<span
				onclick="document.getElementById('userform').style.display='none'"
				class="close" title="Close Modal" style="margin-top: 10px">&times;</span>
		</div>

		<div class="container">
			<label for="uid"><b>아이디</b></label> 
			<input type="text" placeholder="" name="userid" readonly> 
			
			<label for="uname"><b>이름</b></label>
			<input type="text" placeholder="" name="name" >
			 
			<label for="upwd"><b>비밀번호</b></label> 
			<input type="text" placeholder="" name="pwd" >

			<label for="uemail"><b>이메일</b></label>
			<input type="text" placeholder="" name="email" >
			 
			<label for="uphone"><b>휴대폰</b></label> 
			<input type="text" placeholder="" name="phone" >

			<div align="center">
				<button class="btn btn-primary" type="button" onclick="memberupdate(${cpage},${pagesize})" >수정하기</button>
			</div>
			<br>
		</div>
	</form>
</div>
	
	<!-- main list -->
	<div class="container" style="width:100%">

			<div class="col-md-12" style="background-color: #f0f0f0; padding-top:15px; padding-bottom:10px">
				<div style="margin-top: 10px;">
					
					<!-- Google Book Icon -->
					<div style="float: left; width:15%">
					<i class="material-icons" style="font-size: 30px">person</i>
					</div>
					
					<div style="float: left; width: 70%; text-align: center; background-color:rgb(11, 89, 178);">
					<span style="color: white; font-size: 20px">전체 회원 관리</span>
					</div>
					
					<!-- Google add_circle_outline Icon -->
<!-- 					<div style="float: right; width:10%"> -->
<!-- 					<i class="material-icons" id="plus1" style="font-size: 30px">add_circle_outline</i> -->
<!-- 					</div> -->
					
				</div>
				
				<!-- My Book Mark List Table -->
				<table class="table table-striped">
					<thead>
						<tr>
							<td colspan="3">
								<div align="left">
									<br>
									<form id = "pagesize" name="pagesize" onchange="pagelist1()">
										PageSize설정: <select name="ps">
	
											<c:forEach var="i" begin="5" end="20" step="5">
												<c:choose>
													<c:when test="${pagesize == i}">
														<option value='${i}' selected>${i}건</option>
													</c:when>
													<c:otherwise>
														<option value='${i}'>${i}건</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</form>
								</div>
							</td>
						</tr>
						<tr>
						<th style="width:10%">회원 아이디</th>
						<th style="width:10%">이름</th>
						<th style="width:10%">비밀번호</th>
						<th style="width:20%">이메일</th>
						<th style="width:15%">전화번호</th>
						<th style="width:10%">그룹아이디</th>
						<th style="width:15%">등록일</th>
						<th style="width:10%"></th>
						<th style="width:10%"></th>
						</tr>
					</thead>
				<tbody id="membersinfo">
					<c:forEach var="memberlist" items="<%=memberlist%>">
						<tr>
						<td>${memberlist.userid}</td>
						<td>${memberlist.name}</td>
						<td>${memberlist.pw}</td>
						<td>${memberlist.email}</td>
						<td>${memberlist.phone}</td>
						<td>
							<c:choose>
								<c:when test="${memberlist.gid==0}">
									없음
								</c:when>
								<c:otherwise>
									${memberlist.gid}
								</c:otherwise>
							</c:choose> 
						</td>
						<td>${memberlist.regday}</td>
						<td><button type="button" id="delete"class="btn btn-primary" 
						onclick="modalactivate('${memberlist.userid}','${memberlist.name}','${memberlist.pw}','${memberlist.email}','${memberlist.phone}')">
							수정<i class="fa fa-check spaceLeft"></i></button><td>
						<td><button type="button" id="delete"class="btn btn-danger" onclick="memberdelete('${memberlist.userid}',${cpage},${pagesize})">
							삭제<i class="fa fa-check spaceLeft"></i></button><td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="3">
							<!--페이지 리스트 구현  -->
							<c:if test="${cpage>1}">
								<a onclick="pagelist(${cpage-1},${pagesize})">이전</a>
							</c:if> <c:forEach var="i" begin="1" end="${pagecount}" step="1">
								<c:choose>
									<c:when test="${cpage==i}">
										<font color='red'>[${i}]</font>
									</c:when>
									<c:otherwise>
										<a onclick="pagelist(${i},${pagesize})">[${i}]</a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <c:if test="${cpage<pagecount}">
								<a onclick="pagelist(${cpage+1},${pagesize})">다음</a>
							</c:if>

						</td>
						<td colspan="6" align="center">총 회원수 : <%=totalmembercount%>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
</div>