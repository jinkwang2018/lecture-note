<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%
//chiar는 찾기 

      String result=null;
      request.setCharacterEncoding("UTF-8");
      String thername = request.getParameter("thername");
      String moviename = request.getParameter("moviename");
      int num = Integer.parseInt(request.getParameter("num"));
      String check = request.getParameter("check");
      
      Class.forName("oracle.jdbc.OracleDriver");
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      
      try{
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
         String sql = "select chair from k where times=? and name=? and thername=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, check);
         pstmt.setString(2, moviename);
         pstmt.setString(3, thername);
         rs = pstmt.executeQuery();
         
         while(rs.next()){
            int chairs = rs.getInt("chair");
            if(chairs>= num){
               int nan= chairs-num;
               String sql2 = "update k set chair=? where thername=? and times=? and name=?";
               pstmt = conn.prepareStatement(sql2);
               pstmt.setInt(1, nan);
               pstmt.setString(2, thername);
               pstmt.setString(3, check);
               pstmt.setString(4, moviename);
               int k = pstmt.executeUpdate();
               if(k!=0){
                  
                  String id = (String) session.getAttribute("userid");
                  String sql3 = "insert into user_"+id+"(theater , NAME, time, CHAIR ) values(?,?,?,?)";
                  pstmt = conn.prepareStatement(sql3);
                  pstmt.setString(1,thername );
                  pstmt.setString(2, moviename);
                  pstmt.setString(3,check );
                  pstmt.setInt(4, num);
                  int n = pstmt.executeUpdate();
                  if(n !=0){
                  result="success";
                  }else{
                     result="db";
                  }
               }
            }else{
            
               result="fail";

            }
         }
         
      }catch(Exception e){
         out.print(e.getMessage());
      }
%>
<%=result%>