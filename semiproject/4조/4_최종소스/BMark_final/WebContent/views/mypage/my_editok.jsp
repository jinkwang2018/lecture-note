<%@page import="kr.or.bmark.dto.member"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
	String result = (String)request.getAttribute("result");
	member member = (member)request.getAttribute("member");
	out.print("<script>");
	out.print("alert('"+result+"');");	   
	out.print("</script>");

%>    

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
		<button type="button" class="btn btn-primary" id="membersubmit" onclick="memberupdate()">
			수정하기<i class="fa fa-check spaceLeft"></i>
		</button>
		&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-danger"
			onclick="memberdelete()">
			회원탈퇴<i class="fa fa-times spaceLeft"></i>
		</button>
	</div>
</div>
