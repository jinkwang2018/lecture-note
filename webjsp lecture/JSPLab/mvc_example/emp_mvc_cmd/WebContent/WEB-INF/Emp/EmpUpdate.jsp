<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
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
<jsp:include page="/common/Top.jsp"></jsp:include>
<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
		
		</tr>
		<tr>
			<td style="width: 700px">
				<form action="Emp.do?cmd=Update" method="post" id = "up">
				<h3>Update</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<td>empno</td>
								<td><input type="text" name="empno"></td>
							</tr>
							
							<tr>
								<td>ename</td>
								<td><input type="text" name="ename"></td>
							</tr>
							
							<tr>
								<td>job</td>
								<td><input type="text" name="job"></td>
							</tr>
							
							<tr>
								<td>mgr</td>
								<td><input type="text" name="mgr"></td>
							</tr>
							
							<tr>
								<td>sal</td>
								<td><input type="text" name="sal"></td>
							</tr>
							
							<tr>
								<td>comm</td>
								<td><input type="text" name="comm"></td>
							</tr>
							
							<tr>
								<td>deptno</td>
								<td><input type="text" name="deptno" ></td>
							</tr>
							
							<tr>
								<td colspan="2">
								<input type="submit" id = "Upbtn" value="수정하기">
								</td>
							</tr>
						</table>
					</div>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>