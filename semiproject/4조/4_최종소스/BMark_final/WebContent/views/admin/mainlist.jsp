<%@page import="kr.or.bmark.dto.myBoard"%>
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
   List<myBoard> mainlist = (List)request.getAttribute("mypagelist");
 %>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Custom JS -->
		 
<script type="text/javascript">
	//서버로부터 카테고리 리스트를 비동기로 받아오는 함수
	function categoryAjax() {
		var categoryList = [];
		$.ajax({
			url : "category.mainbmark",
			dataType : "JSON",
			type : "POST",
			success : function(data) {
				//console.log(data); // 카테고리 리스트 확인 콘솔
				$.each(data, function(index, element) {
					categoryList.push(element.cname);
					var html = "<div class='category categoryeffect'>"
							+ "<div><span>" + element.cname + "</span></div>"
							+ "</div>";
					
					$("#category-display").append(html);
	
					$(".my-modal-category").append("<option>" + element.cname + "</option>");
				});
			},
			error: function (error) {
			    alert('error : ' + eval(error));
			}
		});
		return categoryList;
	}

	$(function(){
		var categoryList = categoryAjax();
		var selectedCate = [];
		
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
			categoryAjax();
			$('#bookaddform').css("display", "block")
		});
		
		/* copyright GoogleIcon을 클릭했을때 팝업창 생성 */
		$('#cate1').click(function(){
			window.open( "views/admin/categorypop2.jsp", "idcheck", "top=100, left=100, toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=600" );
		});
	
	});

  	function pagelist(cpage, pagesize) {
		$.ajax(
				{
					url:"mainlistpaging.admin",
					dataType:"HTML",
					data:{ cp:cpage , ps:pagesize },
					type:"POST",
					success:function(data){
  						$('#mainlist').empty();
  						$('#mainlist').append(data);
						
					}
				}
		)
	}
  	function pagelist1() {
  		var param =$("#pagesize").serialize();
		$.ajax(
				{
					url:"mainlistpaging.admin",
					dataType:"HTML",
					data: param,
					type:"POST",
					success:function(data){
  						$('#mainlist').empty();
  						$('#mainlist').append(data);
						
					}
				}
		)
	}
  	
  	function datadelete(mnbid,cpage,pagesize) {
  		var param = { mnbid: mnbid, cp:cpage, ps:pagesize };
  		$.ajax(
  				{
  				url: "maindelete.admin",
  				dataType : "HTML",
  				data : param,
  				type :"POST",
  				success : function(data) {
  					var tempData = data.trim();
  					console.log(tempData);
					$('#mainlist').empty();
					$('#mainlist').append(tempData);
  					
  					
  				}	
  		});
  		
  	}
  	
  //사이트 추가시, 모달 창에서 유효값 검사
	function myJJimCheck() {
		if(!mainbmark.name.value) {
			alert("사이트명을 입력하세요");
			mainbmark.name.focus();
			return false;
		}
		if(mainbmark.addr.value == "https://") {
			alert("사이트 주소를 입력하세요");
			mainbmark.addr.focus();
			return false;
		}
		if($('#main-catename option:selected').val() == "-") {
			alert("카테고리를 선택하세요");
			return false;
		}
		//submit으로 내용 내보내기(없으면 실행 불가)
		document.mainbmark.submit();
		
	}
</script>
<!-- main list -->
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagecount" value="<%=pagecount%>" />
	<c:set var="mainlist" value="<%=mainlist%>"/>
	<c:set var="totalboardcount" value="<%=totalboardcount%>"/>
<div> 
	<!-- 사이트 등록 Modal 창 -->
   	<div id="bookaddform" class="modal">

		<form class="modal-content animate" name="mainbmark" action="maininsert.admin" method="post">
			<div align="center">
				<h3>사이트 등록</h3>
				<span onclick="document.getElementById('bookaddform').style.display='none'"
					class="close" title="Close Modal" style="margin-top:10px">&times;</span> 
			</div>

			<div class="container">
				<label for="uname"><b>사이트명</b></label>
				<input type="text" placeholder="Title" name="name" required> 
				<label for="addr"><b>주소</b></label>
				<input type="text" placeholder="http://site address" name="addr" required>
				<label for="content"><b>설명</b></label>
				<input type="text" placeholder="Description" name="content">
				<label for="content"><b>분류</b></label>

				<!-- 분류 dropdown start  -->
				<select class="my-modal-category" id="main-catename" name="cname">
					<option value="-" selected="selected" disabled="disabled">선택하세요</option>
				</select>

				<!-- 분류 dropdown end  -->
				
				<div align="center">
					
					<button type="button" class="btn btn-primary" onclick="myJJimCheck();">등록</button>
					<button class="btn btn-default" type="submit" onclick="document.getElementById('bookaddform').style.display='none'">
						취소
					</button>
				</div>
				<br>
		</div>
		</form>
	</div>
	
	<div class="container" style="width:100%">

			<div class="col-md-12" style="background-color: #f0f0f0; padding-top:15px; padding-bottom:10px">
				<div style="margin-top: 10px;">
					
					<!-- Google Book Icon -->
					<div style="float: left; width:15%">
					<i class="material-icons" style="font-size: 30px">book</i>
					</div>
					
					<div style="float: left; width: 70%; text-align: center; background-color:rgb(11, 89, 178);">
					<span style="color: white; font-size: 20px">메인 사이트 관리</span>
					</div>
					
					
					<!-- Google add_circle_outline Icon -->
					<div style="float: right; width:5%">
					<i class="material-icons" id="plus1" style="font-size: 30px">add_circle_outline</i>
					</div>
					<!-- Google add_circle_outline Icon -->
					<div style="float: right; width:5%">
					<i class="material-icons" id="cate1" style="font-size: 30px">copyright</i>
					</div>
					
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
					</thead>
				<tbody id="mainlist">
<tr>
	<th style="width:5%">카테고리명</th>
	<th style="width:10%">사이트명</th>
	<th style="width:20%">설명</th>
	<th style="width:5%"></th>
</tr>
					<c:forEach var="main" items="<%=mainlist%>">
					<tr>
						<td>${main.cname}</td>
						<td class="sitelink" data-site="${main.addr}"><img alt="" src="${main.icon}"style="height: 16px; width: 16px;"onerror="this.src='images/bmark.png';">&nbsp;&nbsp;${main.name}</td>
						<!-- name 클릭시 addr로 이동 -->
						<td>${main.content}</td>
						<td><button type="button" id="delete"class="btn btn-primary" onclick="datadelete(${mypage.mnbid},${cpage},${pagesize})">
						삭제<i class="fa fa-check spaceLeft"></i></button></td>
					</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="2">
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
						<td colspan="2" align="center">총 사이트 수 : <%=totalboardcount%>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
</div>