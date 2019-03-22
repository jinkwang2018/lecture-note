<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
				
		
				</script>

 <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="title">수정하기</h4>
        </div>

        <div class="modal-body">
		<c:set var="empedit" value="${sessionScope.editinfo}" />
	<form action="EmpEditOk" method="post" id="editform">
				<br/>
               <h3 style="text-align: center;">회원정보수정</h3>
            
                  <table class="table" style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
                     <tr>
                 
                        <td>사원번호</td>
                        <td><input type="text" value="${empedit.empno}" id="empno" name="empno" readonly/></td>
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
                     <input type="submit" value="수정완료"  class="btn btn-Success" id="btnedit"/>
                     </p>
           
                     </td>
                     </tr>
                  </table>
       </form>	
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-Success" data-dismiss="modal">Close</button>
        </div>