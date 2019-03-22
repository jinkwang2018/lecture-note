<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%/*클라이언트가 서버에 전달한 데이터 받기
       request 요청 객체
       ?userid=hong&pwd=111.. hobby = 여러개
       */ 
      //한글처리
      request.setCharacterEncoding("UTF-8");
    
      String uid = request.getParameter("userid"); //단일값 처리
      String pwd = request.getParameter("pwd");
      String [] hobbys = request.getParameterValues("hobby"); //이름은 하나이고 값이 여러개인것  여러개이므로 배열로 받는다. 
      
      
    %>
    <!-- 
    1. 이클립스에서 -> window > preferences > general > workspace > UTF-8 (text기반의 주석처리에 영향)
    2. 각 파일들이 가지는 인코딩 방식을 바꾸어야 한다.    > web > CSS, HTML, JSP files> Encoding(UTF-8)
    	tip> HTML 5형식의 JSP 페이지 window > preferences > web > jsp files > editor > template 추가
    3. Tomcat (서버 : WAS) 한글 설정  > server.xml 로 서버 설정을 변경  (63번째 라인)
    	<Connector connectionTimeout="20000" port="8090" protocol="HTTP/1.1" redirectPort="8443"></Connector>에 추가해야함
                 전송방식 : GET (Tomcat9 한글처리 문제 없다.)
             -1.데이터를 받기 전 페이지 상단에 한글처리를 해야한다. request.setCharacterEncoding("UTF-8");
             -2.<Connector URIEncoding="UTF-8" ...
              POST
             -1.데이터를 받기 전 페이지 상단에 한글처리를 해야한다. request.setCharacterEncoding("UTF-8");  
          정리) Tomcat 9 는 request.setCharacterEncoding("UTF-8");한줄이면 설정 가능하다.
      	    깨지면  <Connector URIEncoding="UTF-8" ... 이것 까지 해야한다.
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	입력값 : <%= uid %><br>
	입력값 : <%= pwd %><br>
	당신의 취미는 : 
	<%
		for(String str : hobbys){
	%>
		hobby:<%=str %><br>
	<% 		
		}
	%>
</body>
</html>
