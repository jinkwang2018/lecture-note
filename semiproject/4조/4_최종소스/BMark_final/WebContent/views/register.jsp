<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>B Mark Register Page</title>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- Bootstrap CSS/theme -->
<link href="style/bootstrap.min.css" rel="stylesheet">
<link href="style/bootstrap-theme.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- Validation API -->
<script src=https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js></script>
<!-- font awesome -->
<link rel="stylesheet" href="style/font-awesome.min.css" media="screen" title="no title" charset="utf-8">

<!-- Custom style -->
<link rel="stylesheet" href="style/style.css" media="screen" title="no title" charset="utf-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style type="text/css">
/* 유효성 검사 폰트 색깔 */
   .error {
      color: red;
   }
</style>
<script>

$(function () {
	//아이디 확인 함수
	$("#idcheck").click(function () {
		var username = $("#inputID").val();
		if(username ==""){
			$('#idcheckvalid').empty();
			$('#idcheckvalid').append('<p style="color: red;">&nbsp;&nbsp;&nbsp;아이디를 입력하세요<input id="validcheck" type="text" hidden="" value="false"></p>');
			
		} else{
			var param ={userid: username};
			$.ajax(
					{
						url: "idcheck.member",
						dataType: "HTML",
						data: param,
						type: "POST",
						success:function(data){
							$('#idcheckvalid').empty();
	  	  					$('#idcheckvalid').append(data);
						}
					}
			);
		}
	//유효성 확인
	$('#signForm').validate({
        debug: false,
        onfocus: true,
        rules: {
        	userid: {
        		required: true,
        		rangelength: [3,10]
        	},
        	pw: {
                required: true,
                rangelength: [6,18]    
            },
            pwcheck: {
                required: true,
                rangelength: [6,18],
                equalTo: "#inputPassword"
            },
            name: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true,
                rangelength: [8,13]
            }
        },
        messages: {
        	userid :{
        		required: "아이디를 입력하세요.",
        		rangelength: $.validator.format("최소 3글자 이상 20글자 이하로 입력하세요.")
        	},
        	pw: {
                required: "비밀번호를 입력하세요.",
                rangelength: $.validator.format("최소 6글자 이상 18글자 이하로 입력하세요.")
            },
            pwcheck: {
                required: "비밀번호를 다시 입력하세요.",
                rangelength: $.validator.format("최소 6글자 이상 18글자 이하로 입력하세요."),
                equalTo: "비밀번호가 일치하지 않습니다."
            },
            name: {
                required: "이름을 입력하세요."
            },
            email: {
                required: "이메일을 입력하세요.",
                email: "이메일 형식을 확인해주세요."
            },
            phone: {
                required: "핸드폰 번호를 입력하세요.",
                rangelength: $.validator.format("숫자 8~13 자리수로 입력하세요.")
            }
        }
    });
    $("#signup").click(function(){
        if($('#inputID').val()==""){
        	$('#idcheckvalid').empty();
        	$('#idcheckvalid').append('<p style="color: red;">&nbsp;&nbsp;&nbsp;아이디를 입력하세요<input id="validcheck" type="text" hidden="" value="false"></p>');
            $('#idcheckvalid').focus();
            return false;
        }
        if($('#validcheck').val()=="false"){
        	alert('아이디 확인을 해주세요');
        	return false;
        }
        $('#signForm').submit();
    }); 
});


	
});
//다음 팝업창
function addrdata() {
	var width = 500;	 //팝업 너비
	var height = 600; 	//팝업 높이
	
	daum.postcode.load(function() {
		 new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                var fullAddr = ''; // 최종 주소
	                var extraAddr = ''; // 조합형 주소 
	                
	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;

	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === 'R'){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('inputZoneCode').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('inputAddr1').value = fullAddr;

	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('inputAddr2').focus();
	            }
	        }).open();
	})
}

</script>

</head>

<body>
	<%
		pageContext.include("/include/header_register.jsp");
	%>
	
	
	
	<article class="container">
		<div class="col-md-12" style="margin-top: 30px">
			<div class="page-header">
				<h1>
					회원가입 
				</h1>
			</div>
			<hr>
			<form id="signForm" action="registerok.member" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputID">User ID</label>
					<div class="col-sm-6">
						<input style="width:30%;float:left;margin-right: 10px;" class="form-control" name="userid" id="inputID" type="text" placeholder="아이디">
						<button style="float:left" type="button" class="btn btn-default" id="idcheck">
						아이디확인
						</button>
						<div class="help-block" id="idcheckvalid" style="top: 50%;float:left;"><p style="color: red;"><input id="validcheck" type="text" hidden="" value="false"></p></div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
					<div class="col-sm-6">
						<input class="form-control" name="pw" id="inputPassword" type="password"
							placeholder="비밀번호 (숫자 문자 조합)">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호
						확인</label>
					<div class="col-sm-6">
						<input class="form-control" name="pwcheck"id="inputPasswordCheck"
							type="password" placeholder="비밀번호 한번더 입력해주세요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputName">이름</label>
					<div class="col-sm-6">
						<input class="form-control" name="name" id="inputName" type="text"
							placeholder="이름">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">이메일</label>
					<div class="col-sm-6">
						<input class="form-control" name="email" id="inputEmail" type="email" placeholder="이메일">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputNumber">휴대폰번호</label>
					<div class="col-sm-6">
						<input class="form-control" name="phone" id="inputNumber" type="tel" placeholder="- 없이 입력해 주세요" /> 
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputZoneCode">우편번호</label>
					<div class="col-sm-6">
						<input style="width:30%;float:left;margin-right: 10px;" class="form-control" name="zonecode" id="inputZoneCode" readonly placeholder="우편번호" /> 
						<button style="float:left" type="button" class="btn btn-default" onclick="addrdata()">
						우편번호 검색
						</button>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputAddr1">주소</label>
					<div class="col-sm-6">
						<input class="form-control" name="addr1" id="inputAddr1" readonly placeholder="주소" /> 
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputAddr2">상세주소</label>
					<div class="col-sm-6">
						<input class="form-control" name="addr2" id="inputAddr2" placeholder="상세주소" /> 
					</div>
				</div>
				
		
			
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="button" id="signup">
							회원가입<i class="fa fa-check spaceLeft"></i>
						</button>&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-danger" onclick="location.href='main.jsp'">
							가입취소<i class="fa fa-times spaceLeft"></i>
						</button>
					</div>
				</div>
			</form>
			<hr>
		</div>
	</article>

</body>
</html>
