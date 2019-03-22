<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  글쓴이 :${param.name} <br>
	  제목 : ${param.title} <br>
	  파일_1 : ${param.filename1} / 원본 파일명 : ${param.orifilename1}<br>  
	  파일_2 : ${param.filename2} / 원본 파일명 : ${param.orifilename2}<br>
	 
	 <hr>
	 <h3>다운로드(특정 경로 저장)</h3>
	 <a href="Ex04_down.jsp?file_name=${param.filename1}">${param.orifilename1}</a>
	 <hr>
	  <a href="Ex04_down.jsp?file_name=${param.filename2}">${param.orifilename2}</a>
	 <h3>웹 브라우져 보기</h3>
	 <a href="upload/${param.filename1}">브라우져 보기</a>
</body>
</html>




