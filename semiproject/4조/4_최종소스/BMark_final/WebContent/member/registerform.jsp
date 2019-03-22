<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8" />
	<title>사용자등록</title>
	
</head>
<body>

	<div id="pageContainer">
	
		
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">회원기본정보</div>
		        <!-- 절대경로표시
		        <form action="/demoweb/membermanager/register.jsp" method="post">
		        -->
		        <form action="registerok.member" method="post"><!-- 상대경로표시 -->
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" name="mid" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" name="pwd" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td>
		                    <input type="password" name="confirm" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<input type="text" name="email" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>연락처</th>
		                <td>
		                	<input type="text" name="hp" style="width:280px" />
		                </td>
		            </tr>
		           	            		            
		        </table>
		        <div class="buttons">
		        	<input type="submit" value="등록" style="height:25px" />
		        	<input type="button" value="취소" style="height:25px"
		        		onclick="location.href='list.jsp';" />
		        	<!-- location.href='path' : path로 이동하는 javascript 명령 -->
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>

</body>
</html>