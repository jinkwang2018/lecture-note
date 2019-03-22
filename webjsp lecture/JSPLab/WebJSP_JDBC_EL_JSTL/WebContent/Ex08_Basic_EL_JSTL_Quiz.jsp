<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
1번 : checkbox
EL & JSTL 을 사용해서 값을 받아서 받을 값을 출력
값이 없는 경우는 Empty 라는 문자를 출력하세요
hint) request.getparametervalues("subject");
-->
<hr>
<c:choose>
	<c:when test = "${not empty paramValues.subject}">
	<ul>
		<c:forEach var = "subject" items = "${paramValues.subject}" varStatus ="status">
			<li>
				${subject}<br>
			</li>
		</c:forEach>
	</ul>
	</c:when>
	<c:when test="${empty paramValues.subject}">
		값을 입력하세요
	</c:when>
</c:choose>
<hr>
 
<!-- 2번  아래 코드를 el & jstl 변환하세요 -->
<%
  int year =Integer.parseInt(request.getParameter("year"));
%>
년도:<input type="text" value="<%= year %>"><br>
<h3>select Tag(생일)</h3>
<select id="newYear" name="newYear" title="년도선택">
	<option>년도선택</option>
	<option value="2010" <%if(year==2010){%> selected<%}%>>2010</option>
	<option value="2011" <%if(year==2011){%> selected<%}%>>2011</option>
	<option value="2012" <%if(year==2012){%> selected<%}%>>2012</option>
	<option value="2013" <%if(year==2013){%> selected<%}%>>2013</option>
	<option value="2014" <%if(year==2014){%> selected<%}%>>2014</option>
	<option value="2015" <%if(year==2015){%> selected<%}%>>2015</option>
	<option value="2016" <%if(year==2016){out.print("selected");}%>>2016</option>
</select>
<hr>
년도:<input type="text" value="${param.year}"><br>
<h3>select Tag(생일)</h3>
<%-- <select id="newYear" name="newYear" title="년도선택">
	<option>년도선택</option>
	<option value="2010" <c:if test="${param.year == 2010}">selected</c:if> >2010</option>
	<option value="2011" <c:if test="${param.year == 2011}">selected</c:if> >2011</option>
	<option value="2012" <c:if test="${param.year == 2012}">selected</c:if> >2012</option>
	<option value="2013" <c:if test="${param.year == 2013}">selected</c:if> >2013</option>
	<option value="2014" <c:if test="${param.year == 2014}">selected</c:if> >2014</option>
	<option value="2015" <c:if test="${param.year == 2015}">selected</c:if> >2015</option>
	<option value="2016" <c:if test="${param.year == 2016}">selected</c:if> >2016</option>
</select>
  --%>
<hr>
<!-- 3번
 choiceyn 값을 받아서 넘어온 값이 "y" 라는 문자라면
 아래 checkbox 에 checked 속성을 넣으세요 EL&JSTL 사용해서요
 
 -->
 <input type="checkbox" name="check" value="java"
  <c:if test="${param.choiceyn =='y'}">checked</c:if>>
</body>
</html>