
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


		request.setCharacterEncoding("UTF-8");
		
		//2. 데이터 받기
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPass");
		String chk = null;
		chk = request.getParameter("chk");

		out.print(id+"/"+pwd+"/"+chk);
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection   conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try{
	    	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.9:1521:XE","bituser","1004");;
	    	//conn = Singleton_Helper.getConnection("oracle");
	    	String sql = "select id,pwd from koreamember where id=?";
	    	pstmt = conn.prepareStatement(sql);
	    	pstmt.setString(1,id);
	    	rs = pstmt.executeQuery();
	    	Date date = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	        String timeNow = formatter.format(date);

	         
	    	
	    	
	    	
	    	while(rs.next()){
	    		out.print(rs.getString("pwd"));
	    		//ID존재
	    		if(pwd.equals(rs.getString("pwd"))){
	    			//ID(0) , PWD(0)
	    			//정상회원
	    			 Cookie cookie = new Cookie("loginTime", timeNow);
	         		 response.addCookie(cookie);
	    			//Top.jsp 활용
	    			session.setAttribute("userid", rs.getString("id"));
	    			
	    			if(chk!=null){ 		
	    				out.print("<script>");
		    			out.print("localStorage.setItem('id','"+id+"' )");
		    			out.print("</script>");
		    			out.print("<script>");
		                out.print("localStorage.setItem('pwd','"+pwd+"' )");
		                out.print("</script>");  
	    					    				 
	    				 
	    				// 
	    			 }else{
	    				 
	    				 out.print("<script>");
			    		 out.print("localStorage.removeItem('id')");
			    		 out.print("</script>");
			    		 out.print("<script>");
				    	 out.print("localStorage.removeItem('pwd')");
				    	 out.print("</script>");
	    								 	
	    			 }	    			
	    			out.print("<script>");
	    			out.print("alert('로그인성공')");
	    			out.print("</script>");
	    			
	    			out.print("<script>");
	    			out.print("location.href='index.jsp'");
	    			out.print("</script>");
	    		}else{
	    			//ID(0) , PWD(x)
	    			out.print("<script>");
	    			out.print("alert('비밀번호가 다릅니다')");
	    			out.print("</script>");
	    			out.print("<script>");
  					out.print("location.href='index.jsp'");
  					out.print("</script>");
	    		}
	    	}
	    	//ID(x)
	    	out.print("<script>");
	        out.print("alert('아이디가 다릅니다')");
	    	out.print("</script>");
	    	out.print("<script>");
			out.print("location.href='index.jsp'");
			out.print("</script>");
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	    	System.out.println("Finally");
	    	if(rs != null) try{rs.close();}catch(Exception e){}
			if(pstmt != null) try{pstmt.close();}catch(Exception e){}
			//if(conn != null) try{conn.close();}catch(Exception e){}
			
			//연결은 해제 하지 않아요 ....
	    }

%>