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
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
                      
                   }else if(get=='db'){
                      alert("db에 안올라감");
                   }else{
                      alert("성공")
                   }
                   location.href='Map.html'  
                },
                error:function(xhr){
                  alert('error :' + xhr.status + "/" + xhr.statusText);
                  location.href='index.jsp'
               }
             }
      )
   });    

 });
   
   
   </script>
</head>
<body>

   <%
   Class.forName("oracle.jdbc.OracleDriver");
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   String movie = request.getParameter("Moviename");
   String thername = request.getParameter("BIZPLC_NM");

   try{
   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
   out.print(request.getParameter("Moviename"));
      
   out.print(thername);

   String sql= "select name, times, chair from k where thername=? and name=?";
   pstmt = conn.prepareStatement(sql);
   pstmt.setString(1,thername );
   pstmt.setString(2, movie);

   rs = pstmt.executeQuery();
   
   while(rs.next()){
      
%>
   <form id="myform" action="ticketingck.jsp">
      <label class="radio-inline"> <input type="radio" id="check"
         name="check" value="<%= rs.getString("times") %>"><%=rs.getString("name") %>/
         <%= rs.getString("times") %>/<%=rs.getInt(3) %>
      </label>
      <%      
   };
      
      }catch(Exception e){
         out.print(e.getMessage());
      }
      %>

      <br> <label for="num">인원수 선택</label> <br> <select
         class="col-md-4" id="num" name="num">
         <option value="1" selected>1명</option>
         <option value="2">2명</option>
         <option value="3">3명</option>
         <option value="4">4명</option>
      </select>

      <div class="errorTxt"></div>
      <input type="button" value="예매" id="btn">

   </form>

   <%
   if(rs != null)try{rs.close();}catch(Exception e){}
   //if(pstmt != null)try{pstmt.close();}catch(Exception e){}
   if(conn != null)try{conn.close();}catch(Exception e){}
%>




</body>
</html>