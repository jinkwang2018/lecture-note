<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
URI (Universal Resource Identifier)
- 인터넷상의 자원을 식별하기 위한 표기법 및 규약
- URL + URN = URI
- 인터넷 환경에서 URI는 대부분 URL을 의미, URN은 사용이 제한적


URL (Uniform Resource Locator)
- 물리적인 경로, 즉 자원의 위치 정보를 포함
- 프로토콜, 도메인, 아이피, 포트 등
- 컴퓨터로부터 접근 가능한 형태의 자원만 검색될 수 있어 제한적
- 우리가 흔히 보는 'http://test.com/test.jpg' 형태


URN (Uniform Resource Name)
- 독립적인 이름을 제공하기 위해 존재
- 자원에 대해 영속적이고 유일
- 자원의 위치와는 무관
- 예를들어 우리나라에서는 [주민등록번호]가 대표적



StringBuffer url = request.getRequestURL();    // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)
 String uri = request.getRequestURI();         // URI : 프로젝트 이하 경로 (CP + SP)
 String cp = request.getContextPath();         // CP : 프로젝트 명
 String sp = request.getServletPath();         // SP : 패키지 + 파일명
 
 System.out.println("URL : " + url);
 System.out.println("URI  : " + uri);
 System.out.println("CP   : " + cp);
 System.out.println("SP   : " + sp);
 

-----------------------------------------------------------------
 URL  : http://localhost:8080/TestBoard/JSPBoard/created.jsp
 URI  : /TestBoard/JSPBoard/created.jsp
 CP   : /TestBoard
 SP   : /JSPBoard/created.jsp
 
 
 1.웹브라우져가 가지고 있는 경로(가상경로)
 http://localhost:8090/JSP/Ex11_WebApp_RealPath.jsp 가상경로이다.
 
 2.이 파일의 실경로는?(물리적 경로)
 D:\bitcamp104\webjsp\JSPLab\JSP\WebContent\Ex11_WebApp_RealPath.jsp 실경로
 
 3.웹(가상경로) -> 웹서버(물리적 경로) 반환 객체 제공 !
  request, application
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String resourcepath = "/Download/note.txt";
		out.print(resourcepath + "<br>");
		String contextpath = application.getRealPath(request.getContextPath());
		String realpath = application.getRealPath(resourcepath);
		out.print("request.getContextPath() : " + request.getContextPath() + "<hr>");
		out.print("ContextPath : " + contextpath + "<hr>"); 
		//실제 경로 : D:\bitcamp104\webjsp\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSP\JSP
		//우리가 만든 파일이 아닌 배포된 웹서버 경로가 실경로이다.
		out.print("realpath : " + realpath + "<hr>");
		
	%>
</body>
</html>
