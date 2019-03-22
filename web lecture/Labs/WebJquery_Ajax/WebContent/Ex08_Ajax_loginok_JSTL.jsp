<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<% request.setCharacterEncoding("UTF-8"); 

   /* Ex08_Ajax_loginok.jsp JSTL 변환 하세요 */
%>    

<c:set var = "user_id" value="${param.user_id}"/>
<c:set var = "user_pwd" value="${param.user_pw}"/>
<c:choose>
	<c:when test="${user_id == 'kosta' && user_pwd == '1004'}">
		<c:set var="result" value="success"/>
	</c:when>
	<c:otherwise>
		<c:set var="result" value="fail"/>
	</c:otherwise>
</c:choose>
${result}
