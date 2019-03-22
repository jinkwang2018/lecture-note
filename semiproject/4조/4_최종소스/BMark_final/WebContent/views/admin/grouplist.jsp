<%@page import="kr.or.bmark.dto.team"%>
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
   int totalboardcount = (Integer)request.getAttribute("totalboardcount");
   List<team> grouplist = (List)request.getAttribute("grouplist");
   
 %>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	 
<script type="text/javascript">
	$(function(){
		/* mousehover 이벤트에 따라 GoogleIcon 변경 */	
		$('#plus1').hover(function() {
			$('#plus1').empty();
			$('#plus1').append("add_circle");
		}, function() {
			$('#plus1').empty();
			$('#plus1').append("add_circle_outline");
		});
		
		/* add_circle GoogleIcon을 클릭했을때 modal창 생성 */
		$('#plus1').click(function(){
			$('#bookaddform').css("display", "block")
		});
		
		/* 관리자만이 사용자 요구에 따라서 그룹 생성 혹은 삭제를 할 수 있음. */
		$(document).on('click', '.group-admin-button', function() {
			console.log($(this).text().trim());
		});
	});

  	function pagelist(cpage, pagesize) {
		$.ajax(
				{
					url:"grouplistpaging.admin",
					dataType:"HTML",
					data:{ cp:cpage , ps:pagesize },
					type:"POST",
					success:function(data){
  						$('#mypagelist').empty();
  						$('#mypagelist').append(data);
						
					}
				}
		)
	}
  	function pagelist1() {
  		var param =$("#pagesize").serialize();
		$.ajax(
				{
					url:"grouplistpaging.admin",
					dataType:"HTML",
					data: param,
					type:"POST",
					success:function(data){
  						$('#mypagelist').empty();
  						$('#mypagelist').append(data);
						
					}
				}
		)
	}
</script>
<div> 
	<!-- 사이트 등록 Modal 창 -->
   	<div id="bookaddform" class="modal">

		<form class="modal-content animate" action="/action_page.php">
			<div align="center">
				<h3>사이트 등록</h3>
				<span onclick="document.getElementById('bookaddform').style.display='none'"
					class="close" title="Close Modal" style="margin-top:10px">&times;</span> 
			</div>

			<div class="container">
				<label for="uname"><b>사이트명</b></label>
				<input type="text" placeholder="Title" name="sname" required> 
				<label for="addr"><b>주소</b></label>
				<input type="text" placeholder="Enter Password" name="addr" required>
				<label for="content"><b>설명</b></label>
				<input type="text" placeholder="Description" name="content">
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
					<button class="btn btn-primary" type="submit">
						등록
					</button>
					<button class="btn btn-default" type="submit" onclick="document.getElementById('bookaddform').style.display='none'">
						취소
					</button>
				</div>
				<br>
		</div>
		</form>
	</div>
	
	<!-- main list -->
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagecount" value="<%=pagecount%>" />
	<c:set var="grouplist" value="<%=grouplist%>"/>
	<c:set var="totalboardcount" value="<%=totalboardcount%>"/>
	<div class="container" style="width:100%">

			<div class="col-md-12" style="background-color: #f0f0f0; padding-top:15px; padding-bottom:10px">
				<div style="margin-top: 10px;">
					
					<!-- Google Book Icon -->
					<div style="float: left; width:15%">
					<i class="material-icons" style="font-size: 30px">group</i>
					</div>
					
					<div style="float: left; width: 70%; text-align: center; background-color:rgb(11, 89, 178);">
					<span style="color: white; font-size: 20px">전체 그룹 관리</span>
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
							<td colspan="2">
								<div class="group-admin-button"
									style="float: right; margin-right: 25px;">
									<button type="button" class="btn btn-primary btn-block"
										style="margin: 0px 10px 0px 10px;">
										<b>신규 그룹 추가</b>
									</button>
								</div>
							</td>
							<td>
								<div class="group-admin-button"
									style="float: left; margin-right: 10px;">
									<button type="button" class="btn btn-danger btn-block"
										style="margin: 0px 10px 0px 10px;">
										<b>그룹 삭제</b>
									</button>
								</div>
							</td>

					</tr>
					<tr>
					<th style="width: 9%">그룹 아이디</th>
					<th style="width: 9%">그룹 이름</th>
					<th style="width: 9%">비밀번호</th>
					<th>상세 설명</th>
					<th style="width: 10%">등록자</th>
					<th style="width: 15%">등록일 </th>
					</tr>
					</thead>
				<tbody id="mypagelist">
					<c:forEach var="grouplist" items="<%=grouplist%>">
						<tr>
						<td align="center">${grouplist.gid}</td>
						<td>${grouplist.name}</td>
						<td>${grouplist.pw}</td>
						<td>${grouplist.content}</td>
						<td>${grouplist.register}</td>
						<td>${grouplist.regday}</td>
						
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
										<a onclick="pagelist(${cpage},${pagesize})">[${i}]</a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <c:if test="${cpage<pagecount}">
								<a onclick="pagelist(${cpage+1},${pagesize})">다음</a>
							</c:if>

						</td>
						<td colspan="5" align="center">총 그룹수 : <%= totalboardcount%>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
	<hr style="margin-top: 0px;">


	
	
</div>