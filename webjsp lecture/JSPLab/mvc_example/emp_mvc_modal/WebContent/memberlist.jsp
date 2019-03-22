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
   
   <!--  AJAX 처리 -->
<script type="text/javascript">
$(function() {
/* 	//수정 AJAX처리 
  $("input[name^='editbtn']").on("click", function() {
	 	 var index = $("input[name^='editbtn']").index(this);
	 	 var formurl_edit = $('#form_edit').attr('action');
	 	 var formdata_edit = { empdata_edit:$("input[name^='editno']:eq(" + index + ")").val() };
	 	// var indexval = $("input[name^='editno']:eq(" + index + ")").val();
			//alert(indexval);
       $.ajax(
        {
          type:"POST",
          url:formurl_edit,
          data:formdata_edit,
          success:function(responsedata){
	  			//alert("수정 페이지로 넘어갑니다!");
	  			window.location.href = "memberedit.jsp"
           },
           error:function(xhr){
              alert(xhr.status + ":ERROR");
           }
       });
       
    }); */
	//수정 AJAX처리 모달
	  $("input[name^='editbtn']").on("click", function() {
		 	 var index = $("input[name^='editbtn']").index(this);
		 	 var formurl_edit = $('#form_edit').attr('action');
		 	 var formdata_edit = { empdata_edit:$("input[name^='editno']:eq(" + index + ")").val() };
		 	// var indexval = $("input[name^='editno']:eq(" + index + ")").val();
				//alert(indexval);
	       $.ajax(
	        {
	          type:"POST",
	          url:formurl_edit,
	          data:formdata_edit,
	          success:function(responsedata){
		  			//alert("수정 페이지로 넘어갑니다!");
		  			//window.location.href = "memberedit.jsp"
	        	  //$('modal.html').modal('show');
		  	 		// $("#myModal").modal('show');
	           },
	           error:function(xhr){
	              //alert(xhr.status + ":ERROR");
	           }
	         
	       });
	       
	    });
});
  
 $(function() {
	//삭제AJAX처리 
   $("input[name^='delbtn']").on("click", function() {
	   	var index = $("input[name^='delbtn']").index(this);
		var formurl_del = $('#form_del').attr('action');
	  	var formdata_del = { empdata_del:$("input[name^='delno']:eq(" + index + ")").val() };
	  
	
       $.ajax(
        {
          type:"POST",
          url:formurl_del,
          data:formdata_del,
          success:function(responsedata){
	  			alert("삭제 되었습니다!");
	  			window.location.href = "EmpList";
           },
           error:function(xhr){
              alert(xhr.status + ":ERROR");
           }
       });
       
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
	<div class="table" style="width: 70%;  margin-left: auto; margin-right: auto;">
	<!-- 회원검색 -->
					<br/>
					<form action="EmpSearch" method="post" >
					<input type="text" name="search" id="search" placeholder="사원명을 입력하세요" style="width: 250px; "/>					
					<input type="submit" value="사원검색" id="searchbtn"  class="btn btn-Success"/>
					</form>	
	</div>
					<br/>
	<!-- member list -->	
	<table class="table" class="table" style="width: 70%;  margin-left: auto; margin-right: auto;">

             	<tr class="active" style="align:center;"><th>사원번호</th><th>사원이름</th><th>직책</th><th>담당자</th><th>입사일</th><th>연봉</th><th>커미션</th><th>부서명</th><th>수정</th><th>삭제</th></tr>
			 			<c:set var="memolist" value="${requestScope.emplist}"></c:set>
                   
                        <c:forEach var="emplist" items="${memolist}">
                           <tr>
                              <td>${emplist.empno}</td>
                                <td>${emplist.ename}</td>
                                <td>${emplist.job}</td>
                                <td>${emplist.mgr}</td>
                                <td>${emplist.hiredate}</td>
                                <td>${emplist.sal}</td>
                                <td>${emplist.comm}</td>
                                <td>${emplist.deptno}</td>               
                              
                              
                             <td><form action="EmpEdit" method="post" id="form_edit">
        						 <a href="modal.jsp" data-toggle="modal" data-target="#myModal">
        						 <input type="button" value="수정" class="btn btn-Success" id="editbtn_${var.index }" name="editbtn_${var.index }" />
        						 </a>
       							<input type="hidden" value="${emplist.empno}" id="editno_${var.index }" name="editno_${var.index }"/>
								</form></td>
								<td><form action="EmpDelete" method="post" id="form_del">
        						<input type="button" value="삭제" class="btn btn-Success" id="delbtn_${var.index }" name="delbtn_${var.index }"/>
       							<input type="hidden" value="${emplist.empno}"  id="delno_${var.index }" name="delno_${var.index }"/>
								</form></td>
								 </tr>
                           </c:forEach>
   
                  </table>
			
                  <hr>
			
	<!-- /member list-->
	<!-- modal  -->
  	<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
       
      </div>
      <!-- Modal content end-->     
    </div>
  </div>  
  		<!-- modal end  -->
  	
<!--         //////////////////////////////////////////////////////////////////////////////////                 -->
	<!--footer  -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<!--footer  -->

</body>

</html>
    