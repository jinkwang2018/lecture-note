<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //한글처리
  request.setCharacterEncoding("UTF-8");
  //데이터 받기 전에 ...
  //한글처리가 필요한 모든 페이지 상단에 위 코드 필요
  
  //관심사 (주관심 , 보조관심)
  //주관심 : 데이터 받아서 클라이언트 보내기
  //보조관심 : 공통사항 (모든 페이지 상단 한글처리 )
  
  //보조관심을 분리하자 (자기코드만 관리 )  => Filter 객체 통해서 //
  
  
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
한글명 : ${param.kor}<br>
영문명 : ${param.eng}<br>
</body>
</html>