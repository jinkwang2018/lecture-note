<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.over {cursor:pointer;}
	</style>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
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
	</script>
</head>
<body>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>글제목</th>
					<th>글내용</th>
					<th>등록일</th>
					<th>조회수</th>				
				</tr>
			</thead>
			<tbody id="listView"></tbody>
		</table>
	</div>
	<div id="detailView">
		<form id="updateForm">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="text" name="seq" value="" readonly></td>
				</tr>
				<tr>
					<td>글제목</td>
					<td><input type="text" name="title" value=""></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><input type="text" name="content" value=""></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" name="regdate" value=""></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><input type="text" name="hit" value=""></td>
				</tr>
			</table>
			<input type="submit" id="btnUpdate" value="수정하기">
		</form>	
	</div>
</body>
</html>














