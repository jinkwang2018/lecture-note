<%@page import="kr.or.kosta.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<%
    request.setCharacterEncoding("UTF-8");
	//회원목록(관리자 접근 가능)
	//로그인한 ID > admin
	//String AdminID = null;
	if(session.getAttribute("userid") == null ||
	   !session.getAttribute("userid").equals("admin")){
		//강제 다른 페이지 이동
		//코드가 모든 페이지에서 반복적으로 사용된다면 (include 통해서 : sessionCheck.jsp)
		out.print("<script>");
			out.print("location.href='Ex02_JDBC_Login.jsp'");
		out.print("</script>");
	}
 
 
%>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}
 
tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}
 
td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table style="width: 900px; height: 500px ;margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!-- UI 구성하는 곳 -->
						<%  
						    String name = request.getParameter("search");
							Connection conn = null;
							PreparedStatement pstmt = null;
							ResultSet rs = null;
							
							    //where dong like '%개포동%'
								conn = Singleton_Helper.getConnection("oracle");
								String sql="select count(*) from koreamember where name like ?";
								String sql2="select id,name,email from koreamember where name like '%" + name + "%'";
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, '%' + name + '%');
								rs = pstmt.executeQuery();
								rs.next();
								int count = rs.getInt(1); //조회건수
								
						%>
							<table style="width: 400px; height: 100px ;margin-left: auto; margin-right: auto;">
								<tr><th colspan="4">회원검색리스트</th></tr>
								<%
									if(count > 0){
										pstmt = conn.prepareStatement(sql2);
										rs = pstmt.executeQuery();
										while(rs.next()){
										String id = rs.getString(1);
										String mname = rs.getString(2);
										String email = rs.getString(3);
								%>
										<tr>
											<td><%=id %></td> 
											<td><%=mname %></td> 
											<td><%=email %></td>
										</tr>	 
								
								<%		
									}//end while
										out.print("<tr><td colspan='3'>");
									    out.print("<b>[" + name + "]조회 결과" + count +"명입니다</b>");
									    out.print("</td></tr>");
										
									}else{
										out.print("<tr><td colspan='3'>");
									    out.print("<b>[" + name + "]결과 없습니다</b>");
									    out.print("</td></tr>");
										
									}//end if
								%>
						   </table>
						   <a href="Ex03_Memberlist.jsp">회원리스트</a>
						
						<%	 	
						Singleton_Helper.close(pstmt);
						Singleton_Helper.close(rs);

						%> 

			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>