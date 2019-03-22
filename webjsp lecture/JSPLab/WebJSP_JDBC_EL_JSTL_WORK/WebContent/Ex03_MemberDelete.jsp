<%@page import="kr.or.kosta.utils.Singleton_Helper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <c:set var = "userid" value="${sessionScope.userid}"/>
 <c:if test="${userid == null || userid != 'admin'}">
 	<script>location.href='Ex02_JDBC_Login.jsp'</script>
 </c:if>
 
 
 <%
 
    String id = request.getParameter("id");
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    try{
    		conn = Singleton_Helper.getConnection("oracle");
    		String sql = "delete from koreamember where id=?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    		
    		int row = pstmt.executeUpdate();
    		if(row > 0){
    			out.print("<script>");
    				out.print("location.href='Ex03_Memberlist.jsp'");
    			out.print("</script>");
    			
    		}else{
    			//필요에 따라 추가
    		}
    	
    }catch(Exception e){
    	e.printStackTrace();
    }finally{
    	Singleton_Helper.close(pstmt);
    }
 
 	
 
 %>
 
 
 
 