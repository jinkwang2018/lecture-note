<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<html>
  <head>
    <title>Geolocation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <script src="https://www.gstatic.com/charts/loader.js"></script>
     <script src="js/Map.js"></script>
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     
    <meta charset="utf-8">
    <style>
    /* Always set the map height explicitly to define the size of the div
    element that contains the map. */
    .popup{
       background-color: white;
    }
    #map, #map2, #chart_div{
       width: 100%;
       height: 30%;
          clear: both;
    }

    #map2 > img {
         width: 100%;
         height: 100%;
    }
    #select, #select2 {
       width: 50%;
       float: left;
    }
    h3 {
       /*background-color: #dc143c; */
       
    }
    /* Optional: Makes the sample page fill the window. */
    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
    }
    
    .navbar-nav {
       float: right;
    }
    .navbar-default {
       margin-bottom: 0px;
    }
    .container {
       height: 150%;
       width: 70%;
       
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
   .bg-4 { 
       background-color: #2f2f2f;
       color: #ffffff;
   }
   footer {
      background-color: #555;
      color: white;
      padding: 15px; 
   }
    </style>
    <script type="text/javascript">
    
   $(function () {
      $('#dialog').dialog({
         autoOpen: false,
      });
      $('#kk').click(function () {
         $('#dialog').dialog(
               {   autoOpen: true,
                  modal:true,
                  resizable: false,
               });
         })
   }); 
     </script>
  </head>
 <body>
 
 <script type="text/javascript">
	
		if (typeof (EventSource) !== "undefined") {
			var source = new EventSource("InformTime.jsp");
			source.onmessage = function(event) {
				var time = event.data;
						
				// 테스트 출력
				alert(time);
				
				if (time > 60){
					alert("접속하신 시간이 " + 60 + "분 지났습니다");
				}else if (time > 50){
					alert("접속하신 시간이 " + 50 + "분 지났습니다");
				}else if (time > 40){
					alert("접속하신 시간이 " + 40 + "분 지났습니다");
				}else if (time > 30){
					alert("접속하신 시간이 " + 30 + "분 지났습니다");
				}else if (time > 20){
					alert("접속하신 시간이 " + 20 + "분 지났습니다");
				}else if (time > 10){
					alert("접속하신 시간이 " + 10 + "분 지났습니다");
				}
				
			};
		} else {
		}
	</script>
 
 
    <nav class="navbar navbar-default">
      <div class="container-fluid">
         <div class="navbar-header">
             <a class="navbar-brand" href="#">Bitcamp104 1조</a>
          </div>
          <ul class="nav navbar-nav">
            <li><a href="#">Home</a></li>
            <li><a href="#" id="kk">예매확인하기</a></li>
            <li><a href="Logout.jsp">로그아웃</a></li>
         </ul>
      </div>
   </nav>
   <div id = "header" class="jumbotron text-center">
      <h1>HTML5_API</h1> 
      <p>Geoloaction</p> 
   </div>
    <div class="container">
       <div>
        <h3>영화관 선택</h3>
      <select class="form-control" id="select">
      </select>
      <select class="form-control" id="select2">
      </select>
        </div>
        <div id = "map2">
           <img src="Images/영화관.jpg">
        </div>
        
        <h3>현재 위치로 찾기</h3>
       <div id="map"></div>
       <div id="chart_div"></div>
    </div>
 
    <%
    request.setCharacterEncoding("UTF-8");
   Class.forName("oracle.jdbc.OracleDriver");
   
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   
   try{
      conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
      String sql = "select * from user_"+ session.getAttribute("id");
      stmt = conn.createStatement();
      rs= stmt.executeQuery(sql);
      %>
         <div role="dialog" id="dialog" title="예매 확인하기" class="popup">
         <table border="1">
         <tr><th>영화관</th><th>영화 이름</th><th>예매시간</th><th>예약좌석수</th></tr>
      <%
      
      while(rs.next()){
         %>
         
         <tr><td><%= rs.getString("theater") %></td><td><%=rs.getString("name") %></td><td><%=rs.getString("time") %></td><td><%=rs.getInt(4) %></td></tr>
         
            <%
      }%>
      </table>
      </div>
      <%
   }catch(Exception e){
      out.print(e.getMessage());
   }
    %>
     <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

  </div>
  
</div>
 
     
     <footer class="container-fluid bg-4 text-center">
      <p>© 2018 Copyright: bit.or.kr</p>
   </footer>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyApNrgA6rr4AVN8Pzy8lqreTggSt6wts34&callback=initMap"
    async defer></script>
 </body>
</html>