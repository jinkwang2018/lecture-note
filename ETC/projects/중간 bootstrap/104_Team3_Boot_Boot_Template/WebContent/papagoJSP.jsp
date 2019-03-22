<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="papago.APIpapagoTranslate" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	/*
	파일명: papagoJSP.JSP
	작성일시: 2018-03-25
	작성내용: 네이버 Papago NMT API활용 번역 페이지 작성
	작성자: 강성훈
	*/
	
	/* 위의 page trimDirectiveWhitespaces="true" 코드는 jsp -> html 변경 시 빈줄 제거 코드*/
	
	request.setCharacterEncoding("UTF-8");

	APIpapagoTranslate papagoAPI = new APIpapagoTranslate(); //네이버 Papago API 객체 생성
	String inputText = request.getParameter("inputText"); //번역할 내용 (1회 호출시 최대 5,000자까지 가능)
	String source = request.getParameter("source"); //번역 대상 언어 코드
	String target = request.getParameter("target"); //번역 결과 언어 코드
	String result = papagoAPI.translate(inputText, source, target); //번역 결과 내용
%>
<%= result %>