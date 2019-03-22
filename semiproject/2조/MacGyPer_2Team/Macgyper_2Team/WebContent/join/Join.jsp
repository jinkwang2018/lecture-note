<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Join</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Bootstrap/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Bootstrap/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Bootstrap/assets/css/form-elements.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Bootstrap/assets/css/style.css">
<link rel="shortcut icon" href="css/Bootstrap/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%= request.getContextPath() %>/css/Bootstrap/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%= request.getContextPath() %>/css/Bootstrap/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%= request.getContextPath() %>/css/Bootstrap/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="<%= request.getContextPath() %>/css/Bootstrap/ico/apple-touch-icon-57-precomposed.png">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="<%= request.getContextPath() %>/js/jquery.validate.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/js/jquery.backstretch.min.js"></script>
<script src="<%= request.getContextPath() %>/js/Bootstrap/assets/js/scripts.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      $('#msg').click(function(){
             if($('#id').val() == ""){
              alert("ID입력");
               $("#id").focus();
             }else{
                var data = {id:$('#id').val()};
               
                 $.ajax(
                 
                      {
                       url:"idcheck.ch",  
                      data:data,
                       dataType:"html",
                       success:function(responsedata){ 
                                 console.log(responsedata);
                                  $('#Message').html(responsedata);               
                        }
                       });    
                      
               }
        });
       //회원가입시 하는 유효성 체크 하는 부분
      $.validator.addMethod("idcheck", function(value, element) {
          return this.optional(element) || /^[a-z0-9]{3,16}$/.test(value);
      });
      $('#join').validate({
            
            rules:{
               id:{
               required: true,
               idcheck: true
            },
            
            pwd:{
               required: true,
               rangelength: [6, 18]
            },
            pwdcheck:{
               required: true,
               rangelength: [6, 18],
                equalTo: '#pwd'
            },
            email:{
               required: true,
                   email: true
            },
            pno:{
               required: true,
               rangelength: [8, 11],
               number: true
            }
         }, messages:{
            id:{
                required: "아이디을 입력하세요.",
                idcheck: "아이디를확인해주세요!(영어 소문자, 숫자만 사용가능합니다!)"
            },
            pwd:{
               required: "패스워드를 입력하세요.",
               rangelength: $.validator.format("패스워드는 최소 6글자 이상 18글자 이하로 입력하세요")
                   
            },
            pwdcheck:{
               required: "패스워드를 확인해주세요.",
                   rangelength: $.validator.format("패스워드 최소 6글자 이상 18글자 이하로 입력하세요"),
                   equalTo: "패스워드 항목과 일치하지 않습니다."
            },
            email:{
               required: "이메일을 입력하세요",
                   email: "올바른 이메일 주소가 아닙니다."
            },
            pno:{
               required: "핸드폰 번호를 입력하세요",
                rangelength: $.validator.format("핸드폰번호는 최소 8글자 이상 11글자 이하로 입력하세요"),
                number: "전화번호는 숫자만 입력하세요."
            }
            
         }
      });
    $("input[type=submit]").click(function(){
           if($('#id').val()==""){
               alert('아이디를 입력해주세요');
               $('#id').focus();
               return false;
           }
           
           
           if($('#pwd').val()==""){
               alert('패스워드를 입력해주세요');
               $('#pwd').focus();
               return false;
           }
           if($('#pwdcheck').val()==""){
               alert('패스워드를 확인해주세요');
               $('#pwdcheck').focus();
               return false;
           }
           if($('#email').val()==""){
               alert('이메일을 입력해주세요');
               $('#email').focus();
               return false;
           }
           if($('#pno').val()==""){
               alert('핸드폰번호를 입력해주세요');
               $('#pno').focus();
               return false;
           }
           if($('#name').val()==""){
               alert('이름를 입력해주세요');
               $('#name').focus();
               return false;
           }
           
       }); 
   });
</script>
<style>
body {
	font-family: "malgun gothic";
	font-size: 9pt;
	padding-left: 10%;
	padding-right: 15%;
	width: 100%;
	height: 50%;
}

th {
	text-align: right;
	background-color: #dbdbdb
}

th.title {
	text-align: center;
	font-size: 12pt;
	background-color: #ffffff;
}
</style>
</head>
<body>
	<div class="top-content">
		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>회 원 가 입</strong>
						</h1>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<p>회원정보를 입력해주세요</p>
							</div>
						</div>
						<form action="<%= request.getContextPath() %>/join.ch"
							method="post" name="join" id="join" class="login-form">

							<label>ID</label> <input class="form-username form-control"
								type="text" name="id" id="id" placeholder="ID를 입력하세요"> <input
								class="form-username form-control" type="button" id="msg"
								value="ID 중복 체크">

							<div id="Message"></div>


							<p>
								<label>Password</label> <input
									class="form-username form-control" name="pwd" id="pwd"
									type="password" placeholder="비밀번호를 입력하세요">
							</p>
							<p>
								<label>Password Check</label> <input
									class="form-username form-control" name="pwdcheck"
									id="pwdcheck" type="password" placeholder="비밀번호를 다시입력하세요">
							</p>
							<p>
								<label>Email</label> <input class="form-username form-control"
									name="email" id="email" type="text" placeholder="Email을 입력하세요">
							</p>
							<p>
								<label>Phone Number</label> <input
									class="form-username form-control" name="pno" id="pno"
									type="text" placeholder="핸드폰 번호를 입력하세요">
							</p>
							<p>
								<label>Name</label> <input class="form-username form-control"
									name="name" id="name" type="text" placeholder="이름을 입력하세요">
							</p>
							<p>

								<button type="submit" class="btn" style="position: absoulte;"
									data-dismiss="modal">회원가입</button>
								<button type="reset" class="btn" style="position: absoulte;">재입력</button>
							</p>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>