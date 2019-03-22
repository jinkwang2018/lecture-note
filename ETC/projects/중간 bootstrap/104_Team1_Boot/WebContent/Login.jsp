<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
        <title>TweetHub</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">

						<link rel="stylesheet" type="text/css" href="css/style.css">

							<style>
			body
				{
					background-image: url('img/eiffel_bg.jpg');
					background-attachment: fixed;
					background-size: 100% 100%;
				}

		</style>
    </head>
<body>
<%
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "bituser";
String upw = "1004";

Connection cn;
Statement stmt;
ResultSet rs;

String id = request.getParameter("localid");
String pwd = request.getParameter("localpwd");
String query = "select * from testlist";

try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn = DriverManager.getConnection(url, uid, upw);
		stmt = cn.createStatement();
		rs = stmt.executeQuery(query);
	
		while(rs.next()){
			if(id.equals(rs.getString("id"))){
				if(pwd.equals(rs.getString("password"))){
					response.sendRedirect("Map.jsp");
				}
			}
		}// end - while
} catch(Exception e){
	e.printStackTrace();
}
%>

        <div id="container"><br>
			    <div id="login-right">
				<div class="login-margin"></div>

				   <form action="LoginCk.jsp" method="post">
                                <h2> Login </h2>

                                    <input class="long"  name="id" required="required" type="text" placeholder="Username" />
                                    <input class="long"  name="pwd" required="required" type="password" placeholder="Password"/>
                                </p>

           					<button class="btn-signup" type="submit" name="signup" onclick="signup()">Login</button>

                            </form>




				</div>

        		<div id="login-left">
            <h1>Welcome to BitCinema</h1>
               <br>
               <p>
               You can see anything <br>
               that you've imagined in BitCinema <br>
               <br>
               Share your best moment!<br>
               
               </p>
			</div>
			<div class="clear"></div>






        </div>
    </body>
    <footer class="container-fluid bg-4 text-center">
  		<p>ⓒ 2018 Copyright: bit.or.kr</p>
  </footer>












</html>