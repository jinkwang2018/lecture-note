<%@page import="kr.or.kosta.dto.reply"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.dto.board"%>
<%@page import="kr.or.kosta.service.boardservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>board_content</title>
	 <link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" />
</head>
<body>
	<%
		String idx = request.getParameter("idx"); //글번호 받기
		
		//글번호를 가지고 오지 않았을 경우 예외처리 
		if(idx == null || idx.trim().equals("")){
			response.sendRedirect("board_list.jsp");
			//클라이언트 브라우져 (location.href="")
			return;
			//더 이상 코드를 실행하지 않고 클라이언트에게 전달 return 현재 쓰레드 종료 ...
		}
		
		idx = idx.trim();
		
		//원칙은 글번호 만 .... 목록으로 갔을때 현재 page 유지하고 싶다
		//list 돌아갔을때 page 유지
		String cpage = request.getParameter("cp"); //현재 페이지 정보  10페이지 101번글
		String pagesize = request.getParameter("ps"); //pagesize
		
		if(cpage == null || cpage.trim().equals("")){
			cpage = "1"; 
		}
		if(pagesize == null || pagesize.trim().equals("")){
			pagesize = "5"; 
		}
		
		//service 객체 불러서
		boardservice service = boardservice.getInstance();
		
		//조회수증가
		boolean res = service.addReadNum(idx);
		if(res) System.out.println("조회수 증가");
		
		//데이터 조회
		board boarddto = service.content(Integer.parseInt(idx));
		
		if(boarddto == null){
			response.sendRedirect("board_list.jsp");
			return;
		}
		
	%>
	<%
		pageContext.include("/include/header.jsp");
	%>
	<div id="pageContainer">
		<div style="padding-top: 30px; text-align: center">
			<center>
				<b>게시판 글내용</b>
				<table width="80%" border="1">
					<tr>
						<td width="20%" align="center"><b> 글번호 </b></td>
						<td width="30%"><%=idx %></td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td><%= boarddto.getWritedate() %></td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%"><%= boarddto.getWriter() %></td>
						<td width="20%" align="center"><b>조회수</b></td>
						<td><%= boarddto.getReadnum() %></td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>홈페이지</b></td>
						<td><%= boarddto.getHomepage() %></td>
						<td width="20%" align="center"><b>첨부파일</b></td>
						<td><%= boarddto.getHomepage() %></td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="3"><%= boarddto.getSubject() %></td>
					</tr>
					<tr height="100">
						<td width="20%" align="center"><b>글내용</b></td>
						<td colspan="3">
							<%
								String content = boarddto.getContent();
								if(content != null){
									content = content.replace("\n","<br>");
								}
								out.print(content);
							%>
						
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<a href="board_list.jsp?cp=<%= cpage %>&ps=<%= pagesize%>">목록가기</a>
				            |<a href="board_edit.jsp?idx=<%= idx%>&cp=<%= cpage %>&ps=<%= pagesize%>">편집</a>
				            |<a href="board_delete.jsp?idx=<%= idx%>&cp=<%= cpage %>&ps=<%= pagesize%>">삭제</a>
				            |<a href="board_rewrite.jsp?idx=<%= idx%>&cp=<%= cpage %>&ps=<%= pagesize%>&subject=<%=boarddto.getSubject() %>">답글</a>									
						</td>
					</tr>
				</table>
			<!--  꼬리글 달기 테이블 -->
			<form name="reply" action="board_replyok.jsp" method="POST">
				<!-- hidden 태그  값을 숨겨서 처리  -->
				<input type="hidden" name="idx" value="<%= idx %>">
				<input type="hidden" name="userid" value="">
					<!-- hidden data -->
					<table width="80%" border="1">
						<tr>
							<th colspan="2">덧글 쓰기</th>
						</tr>
						<tr>
							<td align="left">
								작성자 : <input type="text" name="reply_writer"><br />
								내&nbsp;&nbsp;용 : <textarea name="reply_content" rows="2" cols="50"></textarea>
							</td>
							<td align="left"> 
								비밀번호:<input type="password" name="reply_pwd" size="4">
								  	    <input type="button" value="등록" onclick="reply_check()">
							</td>
						</tr>
					</table>
			</form>
	<!-- 유효성 체크	 -->	
	<script type="text/javascript">
		function reply_check() {
			var frm = document.reply;
			if (frm.reply_writer.value == "" || frm.reply_content.value == ""
					|| frm.reply_pwd.value == "") {
				alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
				return false;
			}
			frm.submit();
		}
		function reply_del(frm) {
			//alert("del");
			//var frm = document.replyDel;
			//alert(frm);
			if (frm.delPwd.value == "") {
				alert("비밀번호를 입력하세요");
				frm.delPwd.focus();
				return false;
			}
			frm.submit();
		}
	</script>
	<br>
	<!-- 꼬리글 목록 테이블 -->
	<%
	  //덧글 목록 보여주기
	  List<reply> replylist = service.replylist(idx);
	  if(replylist != null && replylist.size() > 0)
	  {
	%>
		<table width="80%" border="1">
					<tr><th colspan="2">REPLY LIST</th></tr>
	<%	   
		for(reply replydto : replylist){
	%>
					<tr align="left">
						<td width="80%">
							[<%= replydto.getWriter() %>] : 
							<%= replydto.getContent() %><br>
							작성일:<%= replydto.getWritedate().toString() %>
						</td>
						<td width="20%">
							<form action="boardreply_deleteOk.jsp" method="POST" name="replyDel">
								<input type="hidden" name="no" value="<%=replydto.getNo()%>">
								<input type="hidden" name="idx" value="<%=idx %>">
								password :<input type="password" name="delPwd" size="4">
					 			<input type="button" value="삭제" onclick="reply_del(this.form)">
							</form>
						</td>
					</tr>
		<%
		}
		%>
		</table>
		<%
	  	}
		%>
		
		</center>
		</div>
	</div>
</body>
</html>