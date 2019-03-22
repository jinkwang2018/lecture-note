<%@page import="kr.or.kosta.dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	String idx = (String)request.getAttribute("idx");
	board boarddata = (board)request.getAttribute("boarddata");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="Stylesheet"
	href="<%=request.getContextPath()%>/style/default.css" />
	<script type="text/javascript">
	function editCheck() {

		if (!edit.writer.value) {

			alert("이름을 입력하세요");
			edit.writer.focus();
			return false;
		}
		if (!edit.pwd.value) {
			alert("비밀번호를 입력해야 합니다.");
			edit.pwd.focus();
			return false;
		}

		if (!edit.email.value) {
			alert("이메일을 입력해야합니다.");
			edit.email.focus();
			return false;
		}

		if (!edit.subject.value) {
			alert("제목을 입력하세요");
			edit.subject.focus();
			return false;
		}

		if (!edit.content.value) {
			alert("글 내용을 입력하세요");
			edit.content.focus();
			return false;
		}

		document.edit.submit();

	
	/////////////////
	$(function(){
		GetBoardList();
		RowUpdateBoard();
	});

	function RowUpdateBoard(){
		//https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_ajax_serialize
		$('#updateForm').on("submit",function(){
			var param = $(this).serialize();
			//console.log(param);
			//alert("submit");
			$.ajax({
				url:"CommentEditUpdate.jsp",
				dataType:"JSON",
				type : "POST",
				data : param, //{"seq" :"1" ,"title" : "A" , "content":"A" , "regdate":"11" , "hit":"1"} ,
				success : function(returndata){
					    alert(returndata.result);
					 	if(returndata.result){
							alert("수정성공");
							GetBoardList(); //데이터 갱신하기
						}else{
							alert("수정실패");
						}  
					}
				
				});
			
		 	return false; //기본적인 submit 하지 말아라
		});
	}
	
	
	
		function GetBoardList(){
			alert("호출 : GetBoardList");
			//데이터 만드는 작업 (비동기)
			$.ajax({
				url : "CommentEditList.jsp" ,
				dataType : "JSON",
				type : "POST" ,
				success : function(data){
					//console.log(data);
					$('#listView').empty();
					$('#listView').data("data",data); //key "data" value Array객체
					
					
					//data -> json 형태의 ArrayObject
					//테이블 구성하기
					for(var k=0 ; k < data.length ; k++){
						var tr="";
						tr += "<tr index='"+ (k) +"'>";
						tr += "<td>" + data[k].seq + "</td>";
						tr += "<td>" + data[k].title + "</td>";
						tr += "<td>" + data[k].content + "</td>";
						tr += "<td>" + data[k].regdate + "</td>";
						tr += "<td>" + data[k].hit + "</td>";
						tr += "</tr>";
						
						var trObj = $(tr); //trObj (json 객체로 만들기)
						console.log(trObj);
						
						trObj.addClass("over").on("click",function(){
							//tr > click 하면 상세  출력 
							
							var index = $(this).attr("index");
							//console.log(index);
							var data = $("#listView").data("data");
							console.log("데이터 : " + data);
							var rowdata = data[index];
							//console.log(data);
							
							//https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_prop_attr
							//각각의 input태그에 value값을 넣기
							$('#detailView').find(":input").each(function(){
								var name = $(this).prop("name"); //속성의 이름만 가져오기
								//console.log(name);
								var value =rowdata[name];
								//console.log(value);
								if(value != undefined){
									$(this).val(value);
								}
							});
							
						});
						
						$('#listView').append(trObj);
					}
				}
			});
		}

	}
</script>
</head>
<body>
	<%
		pageContext.include("/include/header.jsp");
	%>
	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<!-- form 시작 -->
			<form name="edit" action="boardEdit.bbs" method="POST">
				<center>
					<table width="90%" border="1">
						<tr>
							<td width="20%" align="center"><b> 글번호 </b></td>
							<td width="30%">
									<%=idx%> 
									<input type="hidden" name="idx" value="<%=idx%>"></td>
							<td width="20%" align="center"><b>작성일</b></td>
							<td><%=boarddata.getWritedate()%></td>
						</tr>
						<tr>
							<td width="20%" align="center"><b>글쓴이</b></td>
							<td width="30%">
								<input type="text" name="writer" value="<%=boarddata.getWriter()%>">
							</td>
							<td width="20%" align="center"><b>홈페이지</b></td>
							<td>
								<input type="text" name="homepage" value="<%=boarddata.getHomepage()%>">
							</td>
						</tr>
						<tr>
							<td width="20%" align="center"><b>비밀번호</b></td>
							<td>
								<input type="text" name="pwd">
							</td>
							<td width="20%" align="center"><b>이메일</b></td>
							<td>
								<input type="text" name="email" value="<%=boarddata.getEmail()%>">
							</td>
						</tr>

						<tr>
							<td width="20%" align="center"><b>제목</b></td>
							<td colspan="3">
								<input type="text" name="subject" value="<%=boarddata.getSubject()%>" size="40">
							</td>
						</tr>
						<tr height="100">
							<td width="20%" align="center"><b>글내용</b></td>
							<td colspan="3">
								<textarea rows="7" cols="50" name="content">
									<%=boarddata.getContent()%>
								</textarea>
							</td>
						</tr>

						<tr>
							<td width="20%" align="center"><b>첨부파일</b></td>
							<td colspan="3"><%=boarddata.getFilename()%> (<%=boarddata.getFilesize()%>bytes)<br /> 
								<input type="file" name="filename">
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<input type="button" value="수정하기" onclick="editCheck();"> 
								<input type="reset" value="다시쓰기">
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<a href="boardlist.bbs">목록</a>|
								<a href="boardEditForm.bbs?idx=<%=idx%>">편집</a> |
								<a href="boardDeletePassword.bbs?idx=<%=idx%>">삭제</a>|<a href="">답변</a>|
							</td>
						</tr>
					</table>
				</center>
			</form>
		</div>
	</div>
</body>
</html>