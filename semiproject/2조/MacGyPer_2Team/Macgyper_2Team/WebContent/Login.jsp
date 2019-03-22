<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>MacGyPer Login</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/Bootstrap/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/Bootstrap/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/Bootstrap/assets/css/form-elements.css">
    <link rel="stylesheet" href="css/Bootstrap/assets/css/style.css">

    <link rel="shortcut icon" href="css/Bootstrap/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="css/Bootstrap/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="css/Bootstrap/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="css/Bootstrap/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="css/Bootstrap/ico/apple-touch-icon-57-precomposed.png">
    
	<script src="js/Bootstrap/assets/js/jquery-1.11.1.min.js"></script>
    <script src="js/Bootstrap/assets/js/bootstrap.min.js"></script>
    <script src="js/Bootstrap/assets/js/jquery.backstretch.js"></script>
    <script src="js/Bootstrap/assets/js/scripts.js"></script>

<style>       
   body{font-family:"malgun gothic";font-size:9pt;  padding-left: 10%; padding-right: 15%;  width: 100%; height: 50%;}
   th { text-align:right; background-color:#dbdb
   b}
   th.title { text-align:center; font-size:12pt;background-color:#ffffff;}
</style>
</head>
<%
	String id="";
	Cookie[] cs = request.getCookies();
	if(cs != null || cs.length >0){
		for(Cookie c : cs){
			if(c.getName().equals("id")){
				id=c.getValue();
			}
		}
	}
%>
<body>
<div class="top-content">
	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<img src="Images/logoMacgyper.png" style="width:75%;height:75%;">
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					<div class="form-top">
						<div class="form-top-left">
							<h3>로그인</h3>
							<p>아이디와 비밀번호를 입력하세요</p>
						</div>
						<div class="form-top-right">
							<i class="fa fa-lock"></i>
						</div>
					</div>
					
					<div class="form-bottom">
						<form role="form" action="<%= request.getContextPath()%>/loginok.ch" method="post" class="login-form">
							<div class="form-group">
								<label class="sr-only" for="form-username">ID</label>
								<input class="form-username form-control" type="text" name="id" id="id" value="<%= id %>" placeholder = "ID를 입력하세요">
								<input type="checkbox" name="chk" value="">ID 기억하기
							</div>
							
							<div class="form-group">
								<label class="sr-only" for="form-password">비밀번호</label>
 								<input class="form-password form-control" name="pwd" id="pwd" type="password" placeholder="비밀번호를 입력하세요">
 							</div>

  							<button type="submit" class="btn btn-warning" style="position : absoulte;" data-dismiss="modal">로그인</button>
  							<button type="button" class="btn" style="position : absoulte;"  onClick="location.href='<%= request.getContextPath() %>/joingo.ch'">회원가입</button>
						</form>
   					</div>
               	</div>
          	</div>
            <div class="row">
          		<div class="col-sm-6 col-sm-offset-3 social-login">
                		<div class="social-login-buttons">
                        	<a class="btn btn-link-2" href=http://wwww.facebook.com>
                            	<i class="fa fa-facebook"></i> Facebook
                            </a>
                            <a class="btn btn-link-2" href="https://twitter.com/?lang=ko">
                                <i class="fa fa-twitter"></i> Twitter
                            </a>
                            <a class="btn btn-link-2" href="https://plus.google.com">
                                <i class="fa fa-google-plus"></i> Google Plus
                            </a>
                		</div>
            	</div>
			</div>
		</div>
	</div>  
</div>          
 
</body>
</html>