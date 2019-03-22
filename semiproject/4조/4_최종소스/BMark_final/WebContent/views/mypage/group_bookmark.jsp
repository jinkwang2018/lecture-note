<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
int cpage = (Integer)request.getAttribute("cpage");
int pagesize = (Integer)request.getAttribute("pagesize");
int pagecount = (Integer)request.getAttribute("pagecount");
int totalboardcount = (Integer)request.getAttribute("totalboardcount");
JSONArray jsonarray = (JSONArray)request.getAttribute("jsonlist"); 
%>
<!-- Google Icon -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<c:set var="jsonarray" value="<%=jsonarray %>"/>
<!-- mousehover 이벤트에 따라 GoogleIcon 변경 -->

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Bootstrap Dialog CND -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>

<!-- Custom JS -->
<script src="js/mypage_view.js?ver=2"></script>

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
		
		/* 그룹생성 버튼 클릭시 modal창 생성 */
		$('.in-group').click(function(){
			$('#groupaddform').css("display", "block")
		});
		/* Dialog 삭제구간 */
	});
	
  	/* 페이징 삭제구간 */
  	
 	//자신만의 새로운 북마크 추가시, 모달 창에서 유효값 검사
	function my_groupJJimCheck() {
		if(!mypagecreategroup.tname.value) {
			alert("그룹명을 입력하세요");
			groupaddform.mymodalname.focus();
			return false;
		}
		if(!mypagecreategroup.tpwd.value) {
			alert("비밀번호를 입력하세요");
			groupaddform.mymodaladdr.focus();
			return false;
		}
		if(!mypagecreategroup.tcontent.value) {
			alert("카테고리를 선택하세요");
			return false;
		}
		//submit으로 내용 내보내기(없으면 실행 불가)
		document.groupbmark.submit();
	}
</script>


<!-- 사이트 등록 Modal 창 -->
<div id="bookaddform" class="modal">

	<form class="modal-content animate" action="" method="POST">
		<div align="center">
			<h3>사이트 등록</h3>
			<span
				onclick="document.getElementById('bookaddform').style.display='none'"
				class="close" title="Close Modal" style="margin-top: 10px">&times;</span>
		</div>

		<div class="container">
			<label for="uname"><b>사이트명</b></label> 
			<input type="text" placeholder="Title" name=gtitle required> 
			<label for="addr"><b>주소</b></label>
			<input type="text" placeholder="Enter Password" name="gpassword" required>
			<label for="content"><b>설명</b></label> 
			<input type="text" placeholder="Description" name="gcontent"> 
			<label for="content"><b>분류</b></label>

			<!-- 분류 dropdown start  -->
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" id="menu1"
					type="button" data-toggle="dropdown">
					Dropdown Example <span class="caret"></span>
				</button>

				<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">HTML</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">CSS</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">JavaScript</a></li>
					<li role="presentation" class="divider"></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">About Us</a></li>
				</ul>

			</div>
			<!-- 분류 dropdown end  -->

			<div align="center">
				<button class="btn btn-primary" type="submit">등록</button>
				<button class="btn btn-default" type="submit" onclick="document.getElementById('bookaddform').style.display='none'">
					취소</button>
			</div>
			<br>
		</div>
	</form>
</div>


<!-- 그룹생성 Modal 창 -->
<div id="groupaddform" class="modal">

	<form id="mypagecreategroup" class="modal-content animate" name="groupbmark" action="addnewgroup.group" method="POST">
		<div align="center">
			<h3>신규 그룹 등록</h3>
			<span
				onclick="document.getElementById('groupaddform').style.display='none'"
				class="close" title="Close Modal" style="margin-top: 10px">&times;</span>
		</div>

		<div class="container">
			<label for="tname"><b>팀명</b></label> 
			<input type="text" placeholder="Title" name="tname" required> 
			
			<label for="pwd"><b>비밀번호</b></label>
			<input type="text" placeholder="Enter Password" name="tpwd" required>
			
			<label for="content"><b>설명</b></label> 
			<input type="text" placeholder="Description" name="tcontent"> 
			

			<div align="center">
				<button class="btn btn-primary" type="button" onclick="my_groupJJimCheck();">등록</button>
				<button class="btn btn-default" type="button" onclick="document.getElementById('groupaddform').style.display='none'">
					취소</button>
			</div>
			<br>
		</div>
	</form>
</div>


<!--  mainlist  -->
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagecount" value="<%=pagecount%>" />
	<c:set var="jsonarray" value="<%=jsonarray %>"/>
	<c:set var="totalboardcount" value="<%=totalboardcount%>"/>
<div class="container" style="width: 100%">

	<div class="col-md-12" style="background-color: #f0f0f0;  padding-top:15px; padding-bottom:10px">
		<div style="margin-top: 10px;">
		
			<div style="float: left; width: 15%">
				<i class="material-icons" style="font-size: 30px">person_add</i>
			</div>
			
			<div
				style="float: left; width: 70%; text-align: center; background-color: rgb(11, 89, 178);">
				<span style="color: white; font-size: 20px">Group Book Mark</span>
			</div>
			
			<div style="float: right; width: 10%">
				<i class="material-icons" id="plus" style="font-size: 30px">add_circle_outline</i>
			</div>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<td>
						<div align="left">
							<br>
							<form id="pagesize" name="pagesize" onchange="pagelist1()">
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
					<th style="width: 25%" >사이트명</th>
					<th style="width: 50%">설명</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody id="mypageteamblist">
				<c:forEach var="list" items="${jsonarray}">
					<tr>
						<td class="sitelink" data-site="${list.addr}"><img
							alt="" src="${list.icon}" style="height: 16px; width: 16px"
							onerror="this.src='images/bmark.png';">${list.name}</td>
						<td>${list.content}</td>
						<td><button type="button" id="delete"
								class="btn btn-primary"
								onclick="datadelete(${list.mnbid},${cpage},${pagesize})">
								삭제<i class="fa fa-check spaceLeft"></i>
							</button></td>
					</tr>
				</c:forEach>
				<tr align="center">
					<td>
						<!--페이지 리스트 구현  --> <c:if test="${cpage>1}">
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
					<td colspan="2" align="center">총 게시물 수 : <%=totalboardcount%>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<hr>
	<div align="right">
		<c:set var="isGroup" value="${sessionScope.gid}"/>
		<c:choose>
			<c:when test="${isGroup != 0}">
				<button type="button" class="btn btn-default out-group"><b>그룹 탈퇴</b></button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-default in-group" style="margin-right:10px;"><b>그룹 생성</b></button>
			</c:otherwise>
		</c:choose>
	</div>
</div>