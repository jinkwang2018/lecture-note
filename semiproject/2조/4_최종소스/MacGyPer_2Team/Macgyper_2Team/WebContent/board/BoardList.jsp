<%@page import="java.util.List"%>
<%@page import="kr.or.bit.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Share Board</title>
<link href="css/Bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="js/Bootstrap/vendor/jquery/jquery.min.js"></script>
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    
	<jsp:include page="/include/header.jsp"></jsp:include>
		<div class="content-wrapper">
			<div class = "container-fluid" id="pageContainer" style="padding-top: 30px; text-align: center">
	<%  
        int cpage = (Integer)request.getAttribute("cpage");
        int pagesize = (Integer)request.getAttribute("pagesize");
        int pagecount = (Integer)request.getAttribute("pagecount");
        int totalboardCount = (Integer)request.getAttribute("totalboardCount");
        List<BoardDto> list = (List)request.getAttribute("list");
    %>
	<c:set var="pagesize" value="<%=pagesize%>" />
	<c:set var="cpage" value="<%=cpage%>" />
	<c:set var="pagecount" value="<%=pagecount%>" />
	<c:set var="list" value="<%=list%>"/>
	<c:set var="totalboardCount" value="<%=totalboardCount%>"/>
			  	
		
			<table style="width :80%; border:1 ; margin :50px; " cellspacing="0" align="center" class="table table-hover">
				<tr>
					<td colspan="5" style="height:50px">
					
						<button type="button" class="btn btn-warning pull-left" style="color:white" onClick="location.href='boardwrite.bbs'">글쓰기</button>
					
						<form name="bbs_search" action="boardSearch.bbs" method="POST">
								<span class="input-group-btn pull-right">
								<input type="submit" class="btn btn-warning pull-right" style="color:white" value="검색" ></span>
								<input type="search" name="search" class="pull-right form-control" placeholder="검색할 제목을 입력하세요" style="width:20%;"/>
						</form>
					
					
						<%-- <form name="list">
						<!-- PageSize설정:  -->
							<select name="ps" onchange="submit()">
								<%
		   						
		   						%>
		   						<c:forEach var="i" begin="10" end="20" step="5">
		   							<c:choose>
									<c:when test="${pagesize == i}">
	                            		 <option value='${i}' selected>${i}건</option>
	                        		</c:when>
									<c:otherwise>
	                                  	  <option value='${i}'>${i}건</option>
	                               </c:otherwise>
								</c:choose>
		   						</c:forEach>
		   					</select>
		   					씩 보기
						</form> --%>
					</td>
				</tr>
				<tr>
					<th width="10%" style="color: #666666">순번</th>
					<th width="40%" style="color: #666666">제목</th>
					<th width="20%" style="color: #666666">글쓴이</th>
					<th width="20%" style="color: #666666">날짜</th>
					<th width="10%" style="color: #666666">조회수</th>
				</tr>
				<!-- ////////////////////////////////////////////////////// -->
				<!-- 데이터가 한건도 없는 경우  -->
				<c:choose>
					<c:when test="${list == null || list.size() == 0}">
						<tr><td colspan='5'>데이터가 없습니다</td></tr></table>
						
					</c:when>
					
					<c:otherwise>
				<!-- ////////////////////////////////////////////////////// -->
						<c:forEach var="board" items="${list}">
							<c:set var="idx" value="${board.idx }" />
							<c:set var="subject" value="${board.board_title}" />
							<c:set var="writer" value="${board.id}" />
							<tr>
								<td align="center">${board.idx}</td>
								<td align="left">
									  <c:forEach var="i" begin="1" end="${board.depth}" step="1">
		                        		&nbsp;&nbsp;&nbsp;
		                    		 </c:forEach>  
		                    		<c:if test="${board.depth>0}">
										<img src='Images/re.gif' />
									</c:if>  
									<a href='boardRead.bbs?idx=${idx}&cp=${cpage}&ps=${pagesize}' style="color: black">
										<c:choose>
											<c:when test="${subject != null && fn:length(subject)> 30}">
			                            		${fn:substring(subject, 0, 30)}....
			                        		</c:when>
											<c:otherwise>
			                                  	${subject}
			                               </c:otherwise>
										</c:choose>
									</a>
								</td>
								<td align="center">
									<c:choose>
										<c:when test="${writer != null && fn:length(writer) > 8}">
		                                	${fn:substring(writer, 0, 8)}...
		                            	</c:when>
										<c:otherwise>
		                             	 ${writer}
		                           		</c:otherwise>
									</c:choose>
								</td>
								<td align="center">${board.board_date}</td>
								<td align="center">${board.board_count}</td>
							</tr>
						</c:forEach>
						
						<tr>
							<td colspan="3" align="center">
								<!--이전 링크 --> 
								<c:if test="${cpage>1}">
									<a href="boardlist.bbs?cp=${cpage-1}&ps=${pagesize}" style="color: #666666">◀ 이전&nbsp</a>
									<!--페이지 리스트 구현  -->
								</c:if> 
								<c:forEach var="i" begin="1" end="${pagecount}" step="1">
									<c:choose>
										<c:when test="${cpage==i}">
											<font color='red'>&nbsp<u>${i}</u>&nbsp</font>
										</c:when>
										<c:otherwise>
											<a href="boardlist.bbs?cp=${i}&ps=${pagesize}" style="color: #666666">&nbsp${i}&nbsp</a>
										</c:otherwise>
									</c:choose>
								</c:forEach> 
								<!--다음 링크 --> 
								<c:if test="${cpage<pagecount}">
									<a href="boardlist.bbs?cp=${cpage+1}&ps=${pagesize}" style="color: #666666">&nbsp다음 ▶</a>
								</c:if>
							</td>
							
							
							<td colspan="2" align="center">총 게시물 수 : ${totalboardCount}
							</td>
						</tr>
					</table>
			<!-- ////////////////////////////////////////////////////// -->
					
					
					</c:otherwise>
				</c:choose>
			<!-- ////////////////////////////////////////////////////// -->
			</div>
			<br><br>
		</div>
		<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>