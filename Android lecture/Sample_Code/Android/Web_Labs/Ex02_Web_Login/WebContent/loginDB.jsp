<%@page import="org.jdom2.output.XMLOutputter"%>
<%@ page import="org.jdom2.*" %>    
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	 String userid = request.getParameter("userid");
	 String userpwd = request.getParameter("userpwd");
	 
	 if(userid ==null)userid="";
	 if(userpwd ==null)userpwd="";
	 
	 String User ="kglim";
	 String pwd = "1004";
	
	 String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	 
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection(url,User,pwd);
	 String sql =" SELECT userid , userpwd FROM tb_mobile_member WHERE userid=? AND userpwd=?";
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1,userid );
	 pstmt.setString(2,userpwd);
	 
	 ResultSet rs = pstmt.executeQuery();
	 
	 String rtncode="";
	 String msg ="";
	 
	 if(rs.next()){ //결과가 존재 하다면
		  //rs.getString(columnIndex)
		  rtncode = "200";
	      msg = "로그인 되었습니다";
	 }else{ //결과가 없는 경우
		 rtncode = "100";
	     msg = "아이디또는 비번이 잘못 되었습니다";
	 }
	 
	 Document document= new Document();
	 
	 //root
	 Element root = new Element("login");
	 document.setRootElement(root);
	 
	 //자식(result)
	 Element element = new Element("result");
	 element.addContent(rtncode);
	 root.addContent(element);
	 
	//자식(msg)
	 element = new Element("msg");
	 element.addContent(msg);
	 root.addContent(element);
 
	 
	 
	 XMLOutputter outputter = new XMLOutputter();
	 String returnxml = outputter.outputString(document);
	 System.out.println(returnxml);

%>
<%=returnxml%>