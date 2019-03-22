<%@page import="kr.or.kosta.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*  
		회원목록 출력 
		1. 관리자만 접근 가능(userid > admin)
		2. 로그인한 일반 회원이 주소값을 외부서 접근 불가 > 로그인 페이지
		3. 고려사항 (아래 코드가 여러 페이지 사용된다면 유지보수 : include 통해서 : sessionCheck.jsp)
	*/
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){
		//강제로 다른 페이지 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!--  
					회원 리스트 출력
					관리자인 경우 (MemberList 볼수 있다)
					목록 출력 (select id , ip from koreamember)
					
				  -->
				  <%
				  		Connection conn = null;
				  		PreparedStatement pstmt = null;
				  		ResultSet rs = null;
				  		
				  		try{
				  			conn = Singleton_Helper.getConnection("oracle");
				  			String sql = "select id , ip from koreamember";
				  			pstmt = conn.prepareStatement(sql);
				  			rs = pstmt.executeQuery();
				  %>
				  <table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto;">
				  		<tr><th colspan="4">회원리스트</th></tr>
				  <% while(rs.next()){ %>
				  			<tr>
				  				<td width="100px">
				  					<a href="Ex03_MemberDetail.jsp?id=<%=rs.getString("id")%>">
				  					<%=rs.getString("id")%>
				  					</a>
				  				</td>
				  				<td width="100px"><%= rs.getString("ip") %></td>
				  				<td>
				  					<!-- 삭제  -->
				  					<a href="Ex03_MemberDelete.jsp?id=<%=rs.getString("id")%>">
				  					[삭제]
				  					</a>
				  				</td>
				  				<td width="100px">
				  					<!-- 수정 -->
				  					<a href="Ex03_MemberEdit.jsp?id=<%=rs.getString("id")%>">
				  					[수정]
				  					</a>
				  				</td>
				  			</tr>
				  	<% } %>
			</table>
			<hr>
				<form action="Ex03_MemberSearch.jsp" method="post">
					회원명:<input type="text" name="search">
					     <input type="submit" value="이름검색하기">			
				</form>
			
			<hr>
			
				  <%
				  		}catch(Exception e){
				  			
				  		}finally{
				  			Singleton_Helper.close(rs);
				  			Singleton_Helper.close(pstmt);
				  		}
				  
				  %>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>