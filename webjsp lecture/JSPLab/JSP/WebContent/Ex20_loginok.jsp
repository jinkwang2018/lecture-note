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
ID , PWD  , chk 값 받아서

1. ID , PWD 같다면 로그인 성공  (if(ID.equals("PWD") ...
   chk값이 체크 되어 있다면
   >쿠키 생성 ID값을 쿠키에 담아서 : 유효 타입(24시간)
   >쿠키 쓰기 완료
   
2. ID , PWD 같다면 로그인 성공   
   chk값이 체크 되어 있지 않다면
   >기존에 만들었던 쿠키 삭제  setMaxAge(0)
   
3. ID , PWD 같지 않다면
   response.sendRedirect() > Ex20_login.jsp 페이지    
   
-->
<%
		String id = request.getParameter("UID");
		String pwd = request.getParameter("PWD");
		String chk = null;
		chk = request.getParameter("chk");
		out.print(id + " / " + pwd + " / " + chk);
		String checkid = "kang";
		String checkpwd = "1234";
%>
<%
	if(id.equals(checkid) && pwd.equals(checkpwd)){
		Cookie cok = new Cookie("UID",id);
		               
		cok.setMaxAge(60*60*24);
		if(chk != null){
			response.addCookie(cok);
			response.sendRedirect("Ex20_login.jsp");
		}else{
			Cookie[]cokarr = request.getCookies();
			for(int i = 0; i < cokarr.length; i++){
				
				cokarr[i].setMaxAge(0);
				response.addCookie(cokarr[i]);
			}
			
			response.sendRedirect("Ex20_login.jsp");
			
			
		}
	}else{
		response.sendRedirect("Ex20_login.jsp");
	}

%>


</body>
</html>