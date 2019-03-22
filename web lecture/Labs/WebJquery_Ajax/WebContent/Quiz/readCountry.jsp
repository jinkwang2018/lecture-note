<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%  
	/*  
		create table keyword(datakeyword varchar2(20));
	    insert into keyword values('java');
	    insert into keyword values('javascript');
	    insert into keyword values('jquery');
	    insert into keyword values('oracle');
	    insert into keyword values('mysql');
	    insert into keyword values('mybatis');
	    insert into keyword values('ibastis');
	    insert into keyword values('jsp');
	    insert into keyword values('spring');
	    commit;
	*/
	String keyword = request.getParameter("keyword");
	
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bituser", "1004");
	String sql = "select datakeyword from keyword where datakeyword like ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, "%" + keyword + "%");		
	ResultSet rs = ps.executeQuery();
	
	List list = new ArrayList();
	while(rs.next()){
		list.add(rs.getString("datakeyword"));
	}
	rs.close();
	ps.close();
	con.close();
	
	
	String Data = "<ul id='country-list'>";	
	for(int i = 0 ; i < list.size() ;i++){
		
		Data+= "<li onclick=selectCountry('" + list.get(i) + "')>"+list.get(i) +"</li>"; 
		
	}
	Data+="</ul>";
	out.print(Data); //클라이언트 넘어가는 데이터

%>
