<%@page import="kr.or.bmark.dto.member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	member member =(member) request.getAttribute("member");
%>


<script type="text/javascript">
$(function () {
	//유효성 검사
	$('#memberinfo').validate({
        debug: false,
        onfocus: true,
        rules: {
        	pwd: {
                required: true,
                rangelength: [6,18]    
            },
            pwcheck: {
                required: true,
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
        	pwd: {
                required: "비밀번호를 입력하세요.",
                rangelength: $.validator.format("최소 6글자 이상 18글자 이하로 입력하세요.")
            },
            pwcheck: {
                required: "비밀번호를 다시 입력하세요.",
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
 	$("#membersubmit").click(function(){
 		  var param = $("#memberinfo").serialize();
 			$.ajax(
 					{
 						url: "mypagememberupdate.mybmark",
 						dataType: "HTML",
 						data: param,
 						type: "POST",
 						success:function(data){
 	  	  					$('#memberinfo').empty();
 	  	  					$('#memberinfo').append(data);
 						},
 						error:function(error){
 						}
 					}
 			);
    });  
});
function memberupdate() {
	  var param = $("#memberinfo").serialize();
		$.ajax(
				{
					url: "mypagememberupdate.mybmark",
					dataType: "HTML",
					data: param,
					type: "POST",
					success:function(data){
  	  					$('#memberinfo').empty();
  	  					$('#memberinfo').append(data);
					},
					error:function(error){
					}
				}
		);
}

function memberdelete() {
	var r = confirm("정말 회원님의 정보를 삭제합니까?")
	if (r== true){
		location.href="mypagememberdelete.mybmark";
	}else {
		return false;
	}
};

//주소 찾기 기능 추가(DAUM 주소 API)
function addrdata() {
	var width = 500;	 //팝업 너비
	var height = 600; 	//팝업 높이
	
	daum.postcode.load(function() {
		 new daum.Postcode({
	            oncomplete: function(data) {

	                var fullAddr = ''; // 최종 주소
	                var extraAddr = ''; // 조합형 주소 
	                

	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;

	                } else { 
	                    fullAddr = data.jibunAddress;
	                }


	                if(data.userSelectedType === 'R'){
	                    
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }

	                
	                document.getElementById('inputZoneCode').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('inputAddr1').value = fullAddr;

	                
	                document.getElementById('inputAddr2').focus();
	            }
	        }).open();
	})
}
</script>
<article class="container">
	<c:set var="member" value="<%=member %>" />
	<div class="col-md-12" style="margin-top: 30px">

		<!-- my edit form -->
		<form id="memberinfo" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputID">아이디</label>
				<div class="col-sm-6">
					<input style="width:30%" class="form-control" name="userid" type="text"
						value="${member.userid}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
				<div class="col-sm-6">
					<input class="form-control" name="pwd" type="password" id="inputPassword"
						value="${member.pwd}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호
					확인</label>
				<div class="col-sm-6">
					<input class="form-control" name="pwcheck" id="inputPasswordCheck" type="password" placeholder="비밀번호 한번더 입력해주세요">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputName">이름</label>
				<div class="col-sm-6">
					<input class="form-control" name="name" type="text"
						value="${member.name}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputEmail">이메일</label>
				<div class="col-sm-6">
					<input class="form-control" name="email" type="email"
						value="${member.email}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputNumber">휴대폰번호</label>
				<div class="col-sm-6">
					<input class="form-control" name="phone" type="tel"
						value="${member.phone}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputZoneCode">우편번호</label>
				<div class="col-sm-6">
					<input style="width: 30%; float: left; margin-right: 10px;"
						class="form-control" name="zonecode" id="inputZoneCode"
						value="${member.zonecode}" readonly placeholder="우편번호">
					<button style="float: left" type="button" class="btn btn-default"
						onclick="addrdata()">우편번호 검색</button>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputAddr1">주소</label>
				<div class="col-sm-6">
					<input class="form-control" name="addr1" id="inputAddr1"
						value="${member.addr1}" readonly placeholder="주소">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="inputAddr2">상세주소</label>
				<div class="col-sm-6">
					<input class="form-control" name="addr2" id="inputAddr2"
						value="${member.addr2}" placeholder="상세주소">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<button type="button" class="btn btn-primary" id="membersubmit">
						수정하기<i class="fa fa-check spaceLeft"></i>
					</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-danger"
						onclick="memberdelete()">
						회원탈퇴<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</div>
		</form>
		<hr>
	</div>
</article>