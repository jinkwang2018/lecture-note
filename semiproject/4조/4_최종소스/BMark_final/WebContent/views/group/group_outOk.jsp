<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	String result = (String)request.getAttribute("result");
	
	if(result.equals("OK")) {
		msg = "그룹에서 정상적으로 탈퇴 되었습니다.";
	}
	else {
		msg = "잠시후 다시 시도해주세요";
	}
	request.setAttribute("board_msg", msg);
	request.setAttribute("board_url", url);
%> --%>
<c:set var="result" value="${requestScope.result}"/>
<c:choose>
	<c:when test="${result == 'OK'}">
		<script type="text/javascript">
			alert("그룹에서 정상적으로 탈퇴 되었습니다.");
			location.href = "mypage.mybmark";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("잠시후 다시 시도해주세요");
		</script>
	</c:otherwise>
</c:choose>

