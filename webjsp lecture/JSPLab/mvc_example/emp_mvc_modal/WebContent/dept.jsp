<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!--  관리자 외 접근 제한처리-->
 <c:if test="${empty userid}"><c:redirect url="/index.jsp" /></c:if> 	
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
    
    <!-- AJAX 처리 -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
				<script type="text/javascript">
				
				$(function(){
					$('#select').change(function(){
						var actionurl = $('#d_form').attr('action');
						var form_data = {
						         						  dname:$('#select > option:selected').val()
									
				                						};
						$.ajax(
										{
												type:"POST",
												url:actionurl,
												data:form_data,
											
												success:function(responsedata){
														$('body').html(responsedata);
														//console.log($(responsedata).find('table'));
														//$('body').html($(responsedata).find('table'));
				 				 				},
				 				 				error:function(xhr){
				 				 					alert("success 못함: " + xhr.status);
				 				 				}
										}
									);
					
					});
				});
				
		
				</script>
</head>

<body>
	

    <!-- Navigation -->
   <jsp:include page="/common/menu.jsp"></jsp:include>
    <!-- /Navigation -->  

<!--         //////////////////////////////////////////////////////////////////////////////////                 -->
	<!-- 여기에 BODY  -->
	<!-- selector 시작 -->
	<div class="table" style="width: 70%;  margin-left: auto; margin-right: auto;">
	<form id="d_form" name="d_form" action="Dept" method="POST">
				부서명을 선택하세요 : 
				<select id="select" name="select" >
					<option>부서명</option>
					<c:forEach var="list" items="${requestScope.dnamelist }">
					<option value="${list.dname}">${list.dname}</option>
					</c:forEach>
				</select>
			
				</form>
				</div>
				
				<!-- 부서 정보 출력 시작  -->
				<div id="intable">
				</div>
				<table class="table" class="table" style="width: 70%;  margin-left: auto; margin-right: auto;">

             	<tr class="active" style="align:center;"><th>부서명</th><th>사원번호</th><th>사원이름</th><th>사원급여</th><th>사원직종</th></tr>
			 	
                  <c:choose>
                   		<c:when test="${!empty requestScope.jsonlist}">
                   			<c:forEach items="${requestScope.jsonlist}" var="dlist">
                   			 <tr>
                   			 	
                         		<td>${dlist.dname}</td>
                             	<td>${dlist.empno}</td>
                             	<td>${dlist.ename}</td>
                             	<td>${dlist.sal}</td>
                             	<td>${dlist.job}</td>
								</tr>
                   			</c:forEach>
                   		</c:when>
                   		<c:otherwise>
                   			<td>해당 부서는 존재하지 않습니다 </td>
                   		</c:otherwise>
                   	</c:choose>
                       
                  </table>
  	
<!--         //////////////////////////////////////////////////////////////////////////////////                 -->
	<!--footer  -->
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
    