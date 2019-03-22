<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	클라이언트(로컬 pc) : 서버(웹서버:메모리 , 파일)
	
	정보(데이터:자료) 어디에 저장하고 보관할까
	고민 : 소멸(일시적 , 영속적) , 보안요소(정보의 중요성)
	
	일시적 , 정보 중요 X (팝업창 정보 , 등등)
	Client(Local PC : 웹 브라우져)
	1.Cookie (소멸시기에 따라서 다르다. memory cookie :브라우져가 켜있는 동안만 , file cookie :지우기전까지 유지) , 암호화되어있다.
	2.Local storage(저장소)
	
	Server(WebServer)
	1.Server memory : session 객체 (접속한 사용자를 식별할 수 있다.) -> 임시적
	2.Server memory : application 객체 (공유 객체 : 접속한 모든 사용자가 사용 가능한) -> 임시적
	3.Server file : log.txt 등으로 파일 기반으로 만든다. -> 영속적
	4.DB Server : 영속적
 -->
 <%
 	//Cookie
  	Cookie mycookie = new Cookie("cname","1007"); //쿠키객체 생성
 	//접속한 클라이언트에게 사용 (브라우져에게 전달)
	response.addCookie(mycookie);
 %>
 서버 설정한 쿠키 이름 : <%= mycookie.getName() %><br>
 서버 설정한 값 : <%= mycookie.getValue() %><br>
 서버 설정한 쿠키 소멸설정 : (-1 소멸시간이 없다 ,memory cookie, 브라우져를 닫으면 사라진다.)<%= mycookie.getMaxAge() %><br>
 <hr>
 <!-- 서버가 클라이언트에세 Response한 cookie객체를 얻어오기 -->
 <%
 	Cookie[]cs = request.getCookies();
 	if(cs != null || cs.length > 0 ){
 		for(Cookie c : cs){
 			out.print(c.getName()+"<br>");
 			out.print(c.getValue()+"<br>");
 			out.print(c.getMaxAge()+"<br>");
 		}
 	}
 %>
 </body>
</html>
