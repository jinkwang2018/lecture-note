<!DOCTYPE html>
 <html lang="en" class="no-js">
    <head>
        <meta charset="UTF-8" />
        <title>TweetHub</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
session.setAttribute("idck", "null");
%>

        <div id="container"><br>
			    <div id="login-right">
				<div class="login-margin"></div>
				   <form action="SignUpCk.jsp" method="post">
                                <h2> Sign Up </h2>

                                    <input class="long" id="idp" name="id" required="required" type="text" placeholder="Username" />
                                    <input class="long"  name="pwd" required="required" type="password" placeholder="Password"/>
                                    <input class="long"  name="email" required="required" type="email" placeholder="email"/>
                                </p>

           					<button class="btn-signup" type="submit" name="signup" onclick="signup()">Sign Up</button>
                            </form>

				</div>

        		<div id="login-left">
				<h1>Welcome to TweetHub.</h1>
					<br>
					<p>
					Connect with your friends — and other fascinating <br> people.
					Get in-the-moment updates on the things <br>
					that interest you. And watch events unfold, in real <br>time, from every angle.
					</p>
			</div>
			<div class="clear"></div>

       </div>

    </body>
    <footer class="container-fluid bg-4 text-center">
  		<p>ⓒ 2018 Copyright: bit.or.kr</p>
  </footer>
</html>
