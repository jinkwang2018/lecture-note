<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화관선택>영화선택>예매</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
	.navbar-nav {
    	float: right;
    }
    .navbar-default {
    	margin-bottom: 0px;
    }

	.jumbotron { 
	    margin-bottom: 0;
		background-image: url('Images/tree.jpg');
		background-repeat: no-repeat;
		background-size: 100% 100%;
	}
	.jumbotron > h1, p {
		color: white;
	}
	footer {
		background-color: #555;
		color: white;
		padding: 15px;
	}
	.container {
    	height: 120%;
    	width: 70%;
    	
    }
    body {
    	height: 518px !important;
    	margin: 0;
        padding: 0;
    }
    
    
    
</style>

<script type="text/javascript">
$(function() {
   $('#myform').validate(
         {
            rules: {check:{required:true}},
            messages: {check: {required: "please select a movie time"}},
             errorElement : 'div',
            errorLabelContainer: '.errorTxt'
         }
   );
   $('#btn').click(function () {
      var url ="ticketingck.jsp"
      var form={
            "thername":"<%=request.getParameter("BIZPLC_NM")%>",
            "moviename":"<%=request.getParameter("Moviename")%>",
            "num":$('#num').val(),
            "check":$("input:radio[name=check]:checked").val()
            }
      $.ajax(
             {
                type:"POST",
                url:url,
                data:form,
                datType:"html",
                success:function(result){
                   var get = result.trim();
                   console.log(">>>>"+get+"<");
                   if(get=='success'){
                      alert("성공");
                      location.href = 'Map.jsp';
                   }else if(get=='db'){
                      alert("db에 안올라감");
                   }else{
                      alert("성공")
                   }
                      
                },
                error:function(xhr){
                  alert('error :' + xhr.status + "/" + xhr.statusText);
               }
             }
      )
   });    

 });
   
   
   </script>
</head>
<body>
	
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
			    <a class="navbar-brand" href="#">Bitcamp104 1조</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
			    <li><a href="Logout.jsp">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<div id = "header" class="jumbotron text-center">
		<h1>HTML5_API</h1> 
		<p>Geoloaction</p> 
	</div>
	<div class="container">
		<%
		   Class.forName("oracle.jdbc.OracleDriver");
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   String movie = request.getParameter("Moviename");
		   String thername = request.getParameter("BIZPLC_NM");
		
		   try{
		   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
		
		   String sql= "select name, times, chair from k where thername=? and name=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1,thername );
		   pstmt.setString(2, movie);
		
		   rs = pstmt.executeQuery();
		%>
		
		<form id="myform" action="ticketingck.jsp">
			<table class="table table-striped">
				<tr><td><%= movie%></td></tr>
				<%
				   while(rs.next()){     
				%>
				<tr>
					<td>
						<label class="radio-inline"> 
						<input type="radio" id="check" name="check" value="<%= rs.getString("times") %>">
						<%=rs.getString("name") %>/<%= rs.getString("times") %>/<%=rs.getInt(3) %>
		      			</label>
	      			</td>
	      		</tr>
	      		<% 
				   };
	      		%>
	      		<tr>
	      			<td><label for="num">인원수 선택</label></td>
	      		</tr>
	      		<tr>
	      			<td>
		      			<select
				         class="col-md-4" id="num" name="num">
				         <option value="1" selected>1명</option>
				         <option value="2">2명</option>
				         <option value="3">3명</option>
				         <option value="4">4명</option>
	      				</select>
	      			</td>
	      		</tr>
			</table>
	      <%
	      
	      }catch(Exception e){
	         out.print(e.getMessage());
	      }
	      %>
	
	      <div class="errorTxt"></div>
	      <input type="button" value="예매" id="btn">
	
	   </form>
	
	   <%
	   if(rs != null)try{rs.close();}catch(Exception e){}
	   //if(pstmt != null)try{pstmt.close();}catch(Exception e){}
	   if(conn != null)try{conn.close();}catch(Exception e){}
		%>
	</div>

	<footer class="container-fluid bg-4 text-center">
			<p>ⓒ 2018 Copyright: bit.or.kr</p>
	</footer>
</body>
</html>