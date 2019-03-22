<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 처리
	request.setCharacterEncoding("UTF-8");
	
	//데이터 받기
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	
	//로직처리
	//DB연결 > select > 회원테이블에 ID , PWD 확인 .... (생략)
	boolean success = false;
	if(uid != null){
	if(uid.equals(pwd)){
		//로그인 성공
		//session 변수에 id 값 담기
		session.setAttribute("memberid", uid); //모든 페이지 접근 가능
		success = true;
	}
	}else{
		response.sendRedirect("Ex23_login.jsp");
	}

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			if(success == true){
				out.print("<b>로그인 성공</b>");
				String user = (String)session.getAttribute("memberid");
				out.print(user + "님 로그인 되었습니다");
				out.print("<a href='Ex23_session_member.jsp'>회원전용</a>");
			}else{
		%>		
				<script type="text/javascript">
					alert("다시 로그인해 주세요");
					window.history.go(-1);
				</script>		
		<%
			}
		%>
</body>
</html>





