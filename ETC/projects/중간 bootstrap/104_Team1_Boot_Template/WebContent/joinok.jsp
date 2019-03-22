<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	request.setCharacterEncoding("UTF-8"); 
	String id = request.getParameter("userId");
	String name = request.getParameter("userName");
	String pwd = request.getParameter("userPass");
	String gender = request.getParameter("gender");
	String email = request.getParameter("userEmail");
	String phonenumber = request.getParameter("userPhone");
	
	
%>
<%
	
		//JDBC
		 Class.forName("oracle.jdbc.OracleDriver");
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 Statement pstmt2 = null;
		 
			try{	
				 conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.9:1521:XE","bituser","1004"); 
				 String create_table = "create table user_" + id + "(theater varchar2(50), name varchar2(20), time varchar2(20), chair number(5))";
				
				 pstmt2 = conn.createStatement();
				 int result = pstmt2.executeUpdate(create_table);
				
					
			}catch(Exception e){			
					
					out.print("<script>");
					out.print("location.href='index.jsp'");
					out.print("</script>");
			}finally{
				
			}
		 
		 
		 
		try{	
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.9:1521:XE","bituser","1004"); 
		 String sql = "insert into koreaMember(id,pwd,name,gender,email,phonenumber) values(?,?,?,?,?,?)";	 
		 
		 pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, email);
			pstmt.setString(6, phonenumber);
			
		 int result = pstmt.executeUpdate();
			if(result != 0){
				out.print("<script>");
				out.print("alert('가입 성공')");	
				out.print("</script>");
				out.print("<script>");
				out.print("location.href='index.jsp'");
				out.print("</script>");
			}else{
				out.print("<script>");
				out.print("alert('가입 실패')");
				out.print("</script>");
				out.print("<script>");
				out.print("location.href='index.jsp'");
				out.print("</script>");
			}
	}catch(Exception e){
			out.print("<script>");
			out.print("alert('아이디가 중복됩니다.')");
			out.print("</script>");
			out.print("<script>");
			out.print("location.href='index.jsp'");
			out.print("</script>");
	}finally{
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(conn != null) try{conn.close();}catch(Exception e){}
	}
		
%>