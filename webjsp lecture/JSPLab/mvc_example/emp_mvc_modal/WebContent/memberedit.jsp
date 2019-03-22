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
   <!--  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
				<script type="text/javascript">
				
				$(function(){
					$('#btnedit').click(function(){
						var actionurl = $('#editform').attr('action');
						var form_data = {
						         						 empno:$('#empno').val(),
						         						 ename:$('#ename').val(),
						         						 job:$('#job').val(),
						         					 	 mgr:$('#mgr').val(),
						         					    hiredate:$('#hiredate').val(),
						         						 sal:$('#sal').val(),
						         					 	 comm:$('#comm').val(),
						         						 deptno:$('#deptno').val()			  
									
				                						};
						$.ajax(
										{
												type:"POST",
												url:actionurl,
												data:form_data,
											
												success:function(responsedata){
				 				 					console.log(responsedata);
				 				 					alert("수정 성공!");
				 				 					window.location.href = "EmpList"
												},
				 				 				error:function(xhr){
				 				 					/* alert("success 못함: " + xhr.status); */
				 				 				}
										}
									);
					});
				});
				
		
				</script> -->
</head>

<body>
	
	
	
	
    <!-- Navigation -->
   <jsp:include page="/common/menu.jsp"></jsp:include>
    <!-- /Navigation -->  

<!--         //////////////////////////////////////////////////////////////////////////////////                 -->
	<!-- 여기에 BODY  -->
	
	
	
	<c:set var="empedit" value="${sessionScope.empedit}"></c:set>
	<form action="EmpEditOk" method="post" id="editform">
				<br/>
               <h3 style="text-align: center;">회원정보수정</h3>
            
                  <table class="table" style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
                     <tr>
                 
                        <td>사원번호</td>
                        <td><input type="text" value="${empedit.empno}" id="empno" name="empno"/></td>
                     </tr>
                     <tr>
                        <td>사원이름</td>
                        <td><input type="text" value="${empedit.ename}" id="ename" name="ename"/></td>
                     </tr>
                     <tr>
                        <td>직책</td>
                        <td><input type="text" value="${empedit.job}" id="job" name="job"/></td>
                     </tr>
                     <tr>
                        <td>담당자</td>
                         <td><input type="text" value="${empedit.mgr}" id="mgr" name="mgr"/></td>
                     </tr>
                     <tr>
                        <td>입사일</td>
                         <td><input type="text" value="${empedit.hiredate}" id="hiredate" name="hiredate"/></td>
                     </tr>
                     <tr>
                        <td>급여</td>
                         <td><input type="text" value="${empedit.sal}" id="sal" name="sal"/></td>
                     </tr>
                      <tr>
                        <td>수당</td>
                         <td><input type="text" value="${empedit.comm}" id="comm" name="comm"/></td>
                     </tr>
                      <tr>
                        <td>부서번호</td>
                         <td><input type="text" value="${empedit.deptno}" id="deptno" name="deptno"/></td>
                     </tr>
                     <tr>
                     <td colspan="2">
                     <br/>
                     <p align="center">
                     <input type="button" value="수정완료"  class="btn btn-Success" id="btnedit"/>
                     </p>
           
                     </td>
                     </tr>
                  </table>
       </form>
	

	
	
  	
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
    