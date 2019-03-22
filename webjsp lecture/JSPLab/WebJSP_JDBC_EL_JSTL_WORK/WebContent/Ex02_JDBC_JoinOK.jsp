<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*  
		1. 한글처리
		2. parameter 받기 (확인하기)
		3. 로직처리(비지니스 로직)
	              회원가입 -> 데이터 받아서 -> DB연결 -> Insert -> 전달(client)
		
	       Insert 성공 > 페이지 이동 > 로그인 페이지 이동 (Ex02_JDBC_Login.jsp) 
	              이동: response.sendRedirect("") ,javascript (location.href="")
	       >> 클라이언트가 페이지를 재요청 (서버에게)   
	       >> 카페 (1035번글 참조)
	       
	       Insert  실패  > 경고창(가입 실패) > 회원가입 이동       
	             문자열 : <script>alert(); loc....</script>
	       
	           클라이언트 IP : request.getRemoteAddr();   
	      id, pwd ,name , age , gender , email , ip      
		
	*/

%>    
<%	

	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	String name = request.getParameter("mname");
	int age = Integer.parseInt(request.getParameter("age")); 
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	//out.print(id + "/" + pass + "/" + name + "/" + age + "/" + gender + "/" + email);

%>
<%
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	
 
	try{
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
		String sql="insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, email);
		pstmt.setString(7, request.getRemoteAddr());
		
		int result = pstmt.executeUpdate();
		if(result != 0){
			out.print("<script>");
			out.print("location.href='Ex02_JDBC_Login.jsp'");
			out.print("</script>");
		}else{
			out.print("<script>");
			out.print("alert('가입 실패')");
			out.print("</script>");
		}
	}catch(Exception e){
		//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
		e.printStackTrace();
		out.print("<script>");
			out.print("alert('가입실패');");
			out.print("location.href='Ex02_JDBC_JoinForm.jsp'");
		out.print("</script>");
		
	}finally{
		System.out.println("Finally");
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(conn != null) try{conn.close();}catch(Exception e){}
	}
	
	
%>	