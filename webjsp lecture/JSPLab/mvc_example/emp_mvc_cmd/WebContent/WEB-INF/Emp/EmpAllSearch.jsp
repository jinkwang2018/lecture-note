<%@page import="kr.or.kosta.dto.Emp"%>
<%@page import="kr.or.kosta.dao.Empdao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <%
		request.setCharacterEncoding("UTF-8");
		Empdao dao = new Empdao();
		ArrayList<Emp> Emplist = dao.getEmpList();
		ArrayList<Integer> DeptnoList = dao.getDeptnoList();
		// 요청 결과 저장
		request.setAttribute("Emplist", Emplist);
		request.setAttribute("DeptnoList", DeptnoList);
		int count = Emplist.size();
		if(count%2 == 0){
			count = count/2;
		}else{
			count = count/2 + 1;
		}
		String cp = request.getParameter("cp");
		if(cp == null){
		   cp = "0";
		}
   %> 
<script type="text/javascript">
$(function(){
   $('.btn').click(function(){
      var cur = $(this).text();
      if(cur == "처음"){
         $.ajax({
            url: "EmpAllSearch",
            dataType: "JSON",
            type: "POST",
            data: {cp: 0},
            success: function(data){
               console.log(data.emplist[0].empno);
               $('#Dlist').empty();
               var str = "<table class=\"table table-striped\" style='border:1px solid black; text-align: center;'><tr><th style='text-align: center;'>사원번호</th><th style='text-align: center;'>사원이름</th><th style='text-align: center;'>직종</th><th style='text-align: center;'>담당 매니저 번호</th><th style='text-align: center;'>입사일</th>"
               + "<th style='text-align: center;'>월급</th><th style='text-align: center;'>추가수당</th><th style='text-align: center;'>부서번호</th></tr>";
               $.each(data.emplist, function(index, element){
                  if(0 <= index && index <= 1){
                     str += "<tr><td>" + element.empno + "</td><td>" + element.ename + "</td><td>" + element.job + "</td><td>" + element.mgr + 
                        "</td><td>" + element.hiredate + "</td><td>" + element.sal + "</td><td>" + element.comm + "</td><td>" + element.deptno + "</td></tr>" 
                  }
               });
               str += "</table>"
               $('#Dlist').html(str);
               
            },
            error : function(xhr, status, error) {
               console.log("에러!: " + error);
            }
         });
      }else if(cur == "마지막"){
         $.ajax({
            url: "EmpAllSearch",
            dataType: "JSON",
            data: {cp: (<%=count%>-1)},
            type: "POST",
            success: function(data){
               console.log(data.emplist[0].empno);
               $('#Dlist').empty();
               var str = "<table class=\"table table-striped\" style='border:1px solid black; text-align: center;'><tr><th style='text-align: center;'>사원번호</th><th style='text-align: center;'>사원이름</th><th style='text-align: center;'>직종</th><th style='text-align: center;'>담당 매니저 번호</th><th style='text-align: center;'>입사일</th>"
               + "<th style='text-align: center;'>월급</th><th style='text-align: center;'>추가수당</th><th style='text-align: center;'>부서번호</th></tr>";
               $.each(data.emplist, function(index, element){
                  if(data.emplist.length - 1  <= index && index <= data.emplist.length){
                     str += "<tr><td>" + element.empno + "</td><td>" + element.ename + "</td><td>" + element.job + "</td><td>" + element.mgr + 
                        "</td><td>" + element.hiredate + "</td><td>" + element.sal + "</td><td>" + element.comm + "</td><td>" + element.deptno + "</td></tr>" 
                  }
               });
               str += "</table>"
               $('#Dlist').html(str);
            },
            error : function(xhr, status, error) {
               console.log("에러!: " + error);
            }
         });
      }else{
         $.ajax({
            url: "EmpAllSearch",
            dataType: "JSON",
            data: {cp: (cur-1)},
            type: "POST",
            success: function(data){
               console.log(data.emplist[0].empno);
               $('#Dlist').empty();
               var str = "<table class=\"table table-striped\" style='border:1px solid black; text-align: center;'><tr><th style='text-align: center;'>사원번호</th><th style='text-align: center;'>사원이름</th><th style='text-align: center;'>직종</th><th style='text-align: center;'>담당 매니저 번호</th><th style='text-align: center;'>입사일</th>"
               + "<th style='text-align: center;'>월급</th><th style='text-align: center;'>추가수당</th><th style='text-align: center;'>부서번호</th></tr>";
               $.each(data.emplist, function(index, element){
              		str += "<tr><td>" + element.empno + "</td><td>" + element.ename + "</td><td>" + element.job + "</td><td>" + element.mgr + 
                        "</td><td>" + element.hiredate + "</td><td>" + element.sal + "</td><td>" + element.comm + "</td><td>" + element.deptno + "</td></tr>" 
               });
               str += "</table>"
               $('#Dlist').html(str);
            },
            error : function(xhr, status, error) {
               console.log("에러!: " + error);
            }
         });
      }
   });
   
   $('#btn').click(function(){
      $.ajax({
         url: "EmpbyEmpno",
         data: {empno: $('#empno').val()},
         dataType: "JSON",
         type: "POST",
         success: function(data){
            console.log(data);
            $('#Dlist').empty();
            var str = "<table class=\"table table-striped\" style='border:1px solid black; text-align: center;'><tr><th style='text-align: center;'>사원번호</th><th style='text-align: center;'>사원이름</th><th style='text-align: center;'>직종</th><th style='text-align: center;'>담당 매니저 번호</th><th style='text-align: center;'>입사일</th>"
            + "<th style='text-align: center;'>월급</th><th style='text-align: center;'>추가수당</th><th style='text-align: center;'>부서번호</th></tr>";
            
            str += "<tr><td>" + data.empno + "</td><td>" + data.ename + "</td><td>" + data.job + "</td><td>" + data.mgr + 
                     "</td><td>" + data.hiredate + "</td><td>" + data.sal + "</td><td>" + data.comm + "</td><td>" + data.deptno + "</td></tr></table>";
            
            $('#Dlist').html(str);
         },
         error : function(xhr, status, error) {
            console.log("에러!: " + error);
         }
      });
   });
   
   $('#deptnoselect').change(function(){ 
      if($('#deptnoselect').val() == 10 || $('#deptnoselect').val() == 20 || $('#deptnoselect').val() == 30){
         $.ajax({
            url: "DeptnoSearch",
            data: {deptno: $('#deptnoselect').val()},
            dataType: "JSON",
            type: "POST",
            success: function(data){
               console.log(data.emplist[0].empno);
               $('#Dlist').empty();
               var str = "<table class=\"table table-striped\" style='border:1px solid black; text-align: center;'><tr><th style='text-align: center;'>사원번호</th><th style='text-align: center;'>사원이름</th><th style='text-align: center;'>직종</th><th style='text-align: center;'>담당 매니저 번호</th><th style='text-align: center;'>입사일</th>"
               + "<th style='text-align: center;'>월급</th><th style='text-align: center;'>추가수당</th><th style='text-align: center;'>부서번호</th></tr>";
               $.each(data.emplist, function(index, element){
                  str += "<tr><td>" + element.empno + "</td><td>" + element.ename + "</td><td>" + element.job + "</td><td>" + element.mgr + 
                        "</td><td>" + element.hiredate + "</td><td>" + element.sal + "</td><td>" + element.comm + "</td><td>" + element.deptno + "</td></tr>" 
               });
               str += "</table>"
               
               $('#Dlist').html(str);
            },
            error : function(xhr, status, error) {
               console.log("에러!: " + error);
            }
         });
      }else{
         $.ajax({
            url: "EmpAllSearch",
            data: {cp: -1},
            dataType: "JSON",
            type: "POST",
            success: function(data){
               console.log(data.emplist[0].empno);
               $('#Dlist').empty();
               var str = "<table class=\"table table-striped\" style='border:1px solid black; text-align: center;'><tr><th style='text-align: center;'>사원번호</th><th style='text-align: center;'>사원이름</th><th style='text-align: center;'>직종</th><th style='text-align: center;'>담당 매니저 번호</th><th style='text-align: center;'>입사일</th>"
               + "<th style='text-align: center;'>월급</th><th style='text-align: center;'>추가수당</th><th style='text-align: center;'>부서번호</th></tr>";
               $.each(data.emplist, function(index, element){
                  str += "<tr><td>" + element.empno + "</td><td>" + element.ename + "</td><td>" + element.job + "</td><td>" + element.mgr + 
                        "</td><td>" + element.hiredate + "</td><td>" + element.sal + "</td><td>" + element.comm + "</td><td>" + element.deptno + "</td></tr>" 
               });
               str += "</table>";
               
               $('#Dlist').html(str);
            },
            error : function(xhr, status, error) {
               console.log("에러!: " + error);
            }
         });
      }
   });
})

</script>
<script   src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
   <jsp:include page="/common/Top.jsp"></jsp:include>
   <c:set var="Emplist" value="${requestScope.Emplist}"></c:set>
   <div class="container">
      <div>
         <label class="control-label required" style="margin-bottom:10px;">사원번호로 검색</label><sup style="color: red">*</sup>
         <input type="text" name="empno" id="empno" placeholder="사원번호를 입력해주세요">
         <button id="btn">검색</button>
      </div>
      <div>
         <label class="control-label required">부서번호로 검색</label><sup style="color: red">*</sup>
         <select id="deptnoselect" name="deptnoselect" style = "width:50px; height:24px; margin-bottom:10px;">
               <option value="10or20or30" selected>전체</option>
            <c:forEach var="deptno" items="${DeptnoList}">
               <option value="${deptno }">${deptno}</option>
            </c:forEach>
         </select>
      </div>
   </div>
   <div class="container">
      <div id="Dlist">
         <table class="table table-striped" style="border:1px solid black; text-align: center;">
            <tr>
               <th style="text-align: center;">사원번호</th>
               <th style="text-align: center;">사원이름</th>
               <th style="text-align: center;">직종</th>
               <th style="text-align: center;">담당 매니저 번호</th>
               <th style="text-align: center;">입사일</th>
               <th style="text-align: center;">월급</th>
               <th style="text-align: center;">추가수당</th>
               <th style="text-align: center;">부서번호</th>
            </tr>
            <c:forEach var="i" begin="0" end="1">
               <tr>
                  <td>${Emplist[i].empno }</td>
                  <td>${Emplist[i].ename }</td>
                  <td>${Emplist[i].job }</td>
                  <td>${Emplist[i].mgr }</td>
                  <td>${Emplist[i].hiredate }</td>
                  <td>${Emplist[i].sal }</td>
                  <td>${Emplist[i].comm }</td>
                  <td>${Emplist[i].deptno }</td>
               </tr>
            </c:forEach>
         </table>
      </div>
      <div style="margin-bottom:15px; text-align:center">
         <span style="padding:0;" class="btn" id="first">처음</span>
         <c:forEach var="i" begin="1" end="<%=count %>">
            <span style="padding:0;" class="btn" id="paging">${i}</span>
         </c:forEach>
         <span style="padding:0;" class="btn" id="end">마지막</span>
      </div>
   </div>
</body>
</html>