<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!--  관리자 외 접근 제한처리-->
 <c:if test="${empty userid}"><c:redirect url="/index.jsp" /></c:if>
<!DOCTYPE html>
<html>

<head>
 
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
					$('#insertbtn').click(function(){
						var actionurl = $('#insertform').attr('action');
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
				 				 					alert("등록 성공!");
				 				 					window.location.href = "EmpList"
												},
				 				 				error:function(xhr){
				 				 					/* alert("success 못함: " + xhr.status); */
				 				 				}
										}
									);
					});
				
					//유효성 검사
				     $("#insertbtn").click(function(){
				         if($("#empno").val()==""){
				             alert("사원번호 입력");
				             $("#empno").focus();
				             return false;
				         }else if($("#ename").val() ==""){
				             alert("사원이름 입력");
				             $("#ename").focus();
				             return false;
				         }else if($("#job").val() ==""){
				                 alert("job입력");
				                 $("#job").focus();
				                 return false;
				         }else if($("#mgr").val() ==""){
			                 alert("mgr입력");
			                 $("#mgr").focus();
			                 return false;
			        	 }else if($("#hiredate").val() ==""){
		                 alert("hiredate입력");
		                 $("#hiredate").focus();
		                 return false;
		        		 }else if($("#sal").val() ==""){
			              alert("sal입력");
			               $("#sal").focus();
			               return false;
			        	}else if($("#comm").val() ==""){
				              alert("comm입력");
				               $("#comm").focus();
				               return false;
				        	}else if($("#deptno").val() ==""){
					              alert("deptno입력");
					               $("#deptno").focus();
					               return false;
					        	}else{
				             $('#insertform').submit();
				         } 
				         
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
		<br/>
			<h3 style="text-align: center;">사원 등록</h3>
				 <form id="insertform" name="insertform" action="EmpInsert" method="post">
                  	<table class="table" style="width: 400px;  margin-left: auto; margin-right: auto;">
           
                     <tr>
                        <th>사원번호:</th>
                        <td><input type="text" name="empno" id="empno" style="width: 280px;"></td>
                     </tr>
                     <tr>
                        <th>사원이름:</th>
                        <td><input type="text" name="ename" id="ename" style="width: 280px;"></td>
                     </tr>
                     <tr>
                        <th>직책:</th>
                        <td><input type="text" name="job" id="job" style="width: 280px;"></td>
                     </tr>
                     <tr>
                        <th>담당자:</th>
                        <td><input type="text" name="mgr" id="mgr" style="width: 280px;"></td>
                     </tr>
                     <tr>
                        <th>입사일:</th>
                        <td><input type="text" name="hiredate" id="hiredate" style="width: 280px;" ></td>
                     </tr>
                     <tr>
                        <th>급여:</th>
                        <td><input type="text" name="sal" id="sal" style="width: 280px;"></td>
                     </tr>
                     <tr>
                        <th>수당:</th>
                        <td><input type="text" name="comm" id="comm" style="width: 280px;"></td>
                     </tr>
                     <tr>
                        <th>부서번호:</th>
                        <td><input type="text" name="deptno" id="deptno" style="width: 280px;"></td>
                     </tr>
                    <tr>       
                   <td colspan="2">	
                   <p align="center">
                   <input type="button" value="사원등록" id="insertbtn" class="btn btn-Success" style="width: 100px;"/> 
                    <input type="reset" value="입력취소" id="cancle" class="btn btn-Success" style="width: 100px; "/>
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
    