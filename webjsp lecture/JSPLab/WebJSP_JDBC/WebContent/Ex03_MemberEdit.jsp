<%@page import="kr.or.kosta.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* 
		Ex03_Memberlist.jsp?id=hong
		sql > select * from kostamember where id=?
		결과를 : input type="text" value="rs.getString()"	
		한건일 경우 : rs.next();
		
		주의 ) 출력 서버 보낼거다 수정할 수 있다 value=<% ...
			   출력 서버 보낼거다 수정할 수 없다 value=<%  readonly
			  출력 서버 보내지 않을 거야 <td><%= ...</td>
	
	         select id , pwd , name , age , trim(gender) , email from 
	         koreamember where id=?
			  
	   update emp
	   set ename =? , job =?
	   where empno=?		   
			  
	*/



%>
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
	<% 
	//id값 받기
	String id = request.getParameter("id");


	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		conn = Singleton_Helper.getConnection("oracle");
		String sql="select id, pwd , name, age ,trim(gender),email from koreamember where id=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		//while 문처리
        //고정된 UI 데이터를 매핑
        rs.next();
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
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<form action="Ex03_MemberEditok.jsp" method="post">

					<h3 style="text-align: center;">회원가입</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<td>아이디</td>
								<td>
								  <input type="text" name="id" value="<%=rs.getString(1)%>" readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
								<td><%=rs.getString(2)%></td>
							</tr>
							<tr>
								<td>이름</td>
								<td>
								   <input type="text" name="name" value="<%=rs.getString(3)%>" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>나이</td>
								<td>
									<input type="text" name="age" value="<%=rs.getString(4)%>" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>[<%=rs.getString(5)%>]
									<input type="radio" name="gender" id="gender" value="여" 
									<%if (rs.getString(5).equals("여")) {%>checked <%}%>>여자 
									<input type="radio" name="gender" id="gender" value="남" 
									<%if (rs.getString(5).equals("남")) {%>checked <%}%>>남자</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" value="<%=rs.getString(6)%>" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="수정하기">
								<a href='Ex03_Memberlist.jsp'>리스트이동</a></td>
						</table>

					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>
<%
	}catch(Exception e){
						
					}finally{
						Singleton_Helper.close(pstmt);
						Singleton_Helper.close(rs);
					}
%>
