<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>B-Mark Main Site</title>
	<!-- jQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
	
	<!-- Bootstrap CSS/theme -->
	<link href="style/bootstrap.min.css" rel="stylesheet">
	<link href="style/bootstrap-theme.css?ver=2" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>
	
	
	<!-- Custom styles -->
	<link href="style/style.css" rel="stylesheet">
	<link href="style/style-responsive.css" rel="stylesheet" />
	<link href="style/main-page-style.css?ver=1" rel="stylesheet">
	<link href="style/main-login-style.css?ver=1" rel="stylesheet">
	<link href="style/main-bookadd-form.css" rel="stylesheet">
	
	<!-- Custom JS -->
	<script src="js/main_view.js?ver=2"></script>

	<script>
		$(function() {
			var isLogin = "${sessionScope.userid}"; // 로그인 Session 정보 String으로 저장
			var isGroup = "${sessionScope.gid}";
			var categoryList = categoryAjax();
			var selectedCate = [];
			
			mainBoard(isLogin, isGroup);
			//mainMyBoard();
			//mainGroupBoard();
			
			//사용자가 '로그인 하시겠습니까?' 버튼 클릭시 모달 창 출력
			$('#login_btn').click(function() {
				//Modal css display를 block으로 바꿔줌으로서 다른 작업은 못하도록 설정
				$('#loginform').css("display", "block");
			});

			$(document).on("click", ".category", function() {
				var id = $(this).text().trim();
				/* 
					category class를 클릭한 text가 Show All일 경우, 전체 카테고리 리스트를 show!! 
					선택된 카테고리 리스트는 배경색 기존색으로 변경(removeClass)
					Show All 카테고리는 custom색으로 변경		
				*/
				if ($(this).text().trim() == "Show All") {
					$.each(categoryList, function(index, element) {
						$("#" + element).show(750);
					});
					$.each(selectedCate, function(index, element) {
						$(".category").removeClass("reddiv");
					});

					$("#showall").addClass("reddiv");
					selectedCate = [];

				} else {
					/* Show All이 아닌 카테고리 선택시 Show All style 배경색 기존색으로 변경(removeclass)*/
					$("#showall").removeClass("reddiv");

					/* 전체 카테고리 리스트는 hide, 선택된 카테고리 리스트만 show */
					if ($(this).hasClass("reddiv") == true) {
						$(this).removeClass("reddiv");

						const idx = selectedCate.indexOf($(this).text());
						selectedCate.splice(idx, 1);

						$.each(categoryList, function(index, element) {
							$('#' + element).hide(500);
						});
						$.each(selectedCate, function(index, element) {
							$("#" + element).show(750);
						});

					} else {
						/* 
							선택된 카테고리 style 배경색 custom 색으로 변경
							전체 카테고리 리스트는 hide, 선택된 카테고리 리스트만 show 
						*/
						$(this).addClass("reddiv");
						selectedCate.push($(this).text());

						$.each(categoryList, function(index, element) {
							$('#' + element).hide(500);
						});
						$.each(selectedCate, function(index, element) {
							$("#" + element).show(750);
						});
					}
				}
			});

			/* 추천 버튼 클릭 시, likeok.mainbmark 링크 forward */
			$(document).on('click', '.upbtn', function() {
				var sitename = $(this).parent().parent().data("code");
				var like = $(this).text().trim();
				var path = $(this);
				var responseData = [];
				//console.log(sitename + "/" + like);
				$.ajax({
						url : "likeok.mainbmark",
						data : {
							sname : sitename,
							good : like
						},
						dataType : "HTML",
						type : "POST",
						success : function(data) {
							responseData = data.trim().split("_");
							alert(responseData[0]);
							if(like < responseData[1])	{
								path.html("<img src='images/like2.png'><small>&nbsp;"
										+ responseData[1] + "</small>");
							}else {
								path.html("<img src='images/like1.png'><small>&nbsp;"
										+ responseData[1] + "</small>");
							}
							
						}
				});
			});

			/* 비추천 버튼 클릭시, dislikeok.mainbmark 링크 forward */
			$(document).on('click', '.downbtn', function() {
				var sitename = $(this).parent().parent().data("code");
				var dislike = $(this).text().trim();
				var path = $(this);
				var responseData = [];
				//console.log(sitename + "/" + like);
				$.ajax({
						url : "dislikeok.mainbmark",
						data : {
							sname : sitename,
							bad : dislike
						},
						dataType : "HTML",
						type : "POST",
						success : function(data) {
							console.log(data);
							responseData = data.trim().split("_");
							alert(responseData[0]);
							if(dislike < responseData[1]){
								path.html("<img src='images/dislike2.png'><small>&nbsp;"
										+ responseData[1] + "</small>");
							}else {
								path.html("<img src='images/dislike1.png'><small>&nbsp;"
										+ responseData[1] + "</small>");
							}
						}
				});
			});
			
			/* 즐겨찾기 (별이미지) 클릭시 starbook.mainbmark 링크 forward */
			$(document).on('click', '.starbook', function(){
				var userid = "${sessionScope.userid}";
				var gid = "${sessionScope.gid}";
				var mnbid =  $(this).parent().data("code");
				var starbookimg = $(this).children();
				
				// 사용자가 로그인을 안했다면?
				if(userid == ""){
					alert("\'로그인\'이 필요한 서비스입니다.");
				}else {
					// 로그인한 회원이 그룹에 가입되어 있다면?
					if(gid != 0) {
						//alert("\'그룹 OK\'");
						BootstrapDialog.show({
							//size: BootstrapDialog.SIZE_NOMAL,
	    					type: BootstrapDialog.TYPE_PRIMARY,
	    		            message: '새로운 북마크를 어디로 추가할까요?',
	    		            buttons: [{
	    		                label: '나의 북마크',
	    		                cssClass: 'btn-primary',
	    		                action: function(dialogItself){
	    		                	starMyBookmarkChecked(mnbid, starbookimg);
	    		                	if(starbookimg.attr("src") == "images/star2.png"){
	    		                		starbookimg.attr("src", "images/star3.png");
	    		                	}else if(starbookimg.attr("src") == "images/star3.png") {
	    		                		starbookimg.attr("src", "images/star3.png");
	    		                	}else {
	    		                		starbookimg.attr("src", "images/star4.png");
	    		                	}
	    		                	dialogItself.close();
	    		                }
	    		            },{
	    		                label: '그룹 북마크',
	    		                cssClass: 'btn-success',
	    	                	action: function(dialogItself){
	    	                		starGroupBookmarkChecked(mnbid, starbookimg);
	    	                		if(starbookimg.attr("src") == "images/star4.png"){
	    		                		starbookimg.attr("src", "images/star3.png");
	    		                	}else if(starbookimg.attr("src") == "images/star3.png"){
	    		                		starbookimg.attr("src", "images/star3.png");
	    		                	}else {
	    		                		starbookimg.attr("src", "images/star2.png");
	    		                	}
	    	                		dialogItself.close();
	    		                }
	    		            },{
	    		                label: '취소',
	    	                	action: function(dialogItself){
	    		                    dialogItself.close();
	    		                }
	    		            }]
	    		        });
					}
					// 로그인한 회원이 그룹이 없다면?
					else {
						//alert("\'그룹 NO\'");
						BootstrapDialog.show({
	    					type: [BootstrapDialog.TYPE_PRIMARY],
	    		            message: '새로운 북마크를 어디로 추가할까요?',
	    		            buttons: [{
	    		                label: '나의 북마크',
	    		                cssClass: 'btn-primary',
	    		                action: function(dialogItself){
	    		                	starMyBookmarkChecked(mnbid, starbookimg);
	    		                	starbookimg.attr("src", "images/star4.png");
	    		                	dialogItself.close();
	    		                }
	    		            },{
	    		                label: '취소',
	    	                	action: function(dialogItself){
	    		                    dialogItself.close();
	    		                }
	    		            }]
	    		        });
					}
				}
			});
			
			/* 조회수(사이트 링크 클릭시), hitok.mainbmark 링크 forward */
			/* $(document).on('click', '.sitelink', function() {
				var sitename = $(this).parent().data("code");
				var responseData = [];
				var linkpage=$(this).data("site").trim();
                var openNewWindow = window.open("about:blank");
                
                openNewWindow.location.href=linkpage;

				$.ajax({
					url : "hitok.mainbmark",
					data : {
						sname : sitename
					},
					dataType : "HTML",
					type : "POST",
					success : function(data) {
						responseData = data.trim().split("_");
						console.log(responseData[0]);
					}
				});
			}); */

			/* 조회수(사이트 링크 클릭시 더블클릭 버그 방지) */
			$(document).on('dblclick', '.sitelink', function() {
				return;
			});
			
			$(document).on('click', '.group-join', function() {
				//console.log();
				var groupID = $(this).data().code;
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_PRIMARY,
		            message: '해당 그룹에 가입하시겠습니까?',
		            buttons: [{
		                label: '가입하기',
		                cssClass: 'btn-primary',
		                action: function(dialogItself){
		                	// 그룹 가입하기 함수 실행 (동기)
		                    if(isLogin == ""){
		                    	alert("'로그인'이 필요한 서비스입니다.");
		                    	$.each(BootstrapDialog.dialogs, function(id, dialog){
		                            dialog.close();
		                        });
		                    }else {
		                    	BootstrapDialog.show({
		        					type: BootstrapDialog.TYPE_PRIMARY,
		        					
		        		            message: '<input type="text" id="form-password" placeholder="비밀번호">',
		        		            buttons: [{
		        		                label: '가입하기',
		        		                cssClass: 'btn-primary',
		        		                action: function(dialogRef){
		        		                	//console.log($('#form-password').val());
		        		                	var password = $('#form-password').val();
		        		                	$.ajax({
		        		                		url : "joinok.group", //호출 url
		        		                		data: {pw: password, gid: groupID},
		        		                		dataType : "html", //호출 데이터 형식 -> myBoardListOk html 형식
		        		                		success : function(data) { //성공시 출력되는 화면
		        		                			var msg = data.trim();
		        		                			if(msg == "OK") {
		        		                				alert("축하합니다! 해당 그룹에 \'가입\'되셨습니다!!");		
		        		                			    location.href='main.jsp';
		        		                			}else if(msg == "NO") {
		        		                				alert("해당 그룹의 \'비밀번호\'를 확인해주세요!!");
		        		                			}else {
		        		                				alert("잘못된 접근입니다.");		
		        		                				location.href='main.jsp';
		        		                			}
		        		                		}
		        		                	});
		        		                }
		        		            },{
		        		                label: '취소',
		        		                cssClass: 'btn-warning',
		        	                	action: function(dialogItself){
		        		                    dialogItself.close();
		        		                }
		        		            }]
		        		        });
		                    }
		                }
		            }, {
		                label: '취소',
		                cssClass: 'btn-warning',
	                	action: function(dialogItself){
	                		$.each(BootstrapDialog.dialogs, function(id, dialog){
	                            dialog.close();
	                        });
		                }
		            }]
		        });
			});
			
			$(document).on('dblclick', '.group-join', function() {
				return;
			});
		});
		
	</script>
	
</head>
<body>
<%
	pageContext.include("include/header.jsp");
%>
	
	<div id="loginform" class="modal">

		<form class="login-modal-content animate" action="login.member" method="post" id="signForm">
			<div class="imgcontainer">
				<span onclick="document.getElementById('loginform').style.display='none'"
					class="close" title="Close Modal">&times;</span> 
					<img src="images/user.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<label for="uname"><b>User ID</b></label>
				<input type="text" placeholder="Enter Your ID" name="userid" required> 
				<label for="psw"><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="pw" required>

				<button type="submit" class="loginbutton">Login</button>
				<div>
					<div align="left">
						<input type="checkbox" name="remember"> 자동 로그인 
					</div>
					<div align="center">
						<a href="register.member">회원가입이 필요하신가요?</a>
					</div>
				</div> 
			</div>
		</form>
	</div>
	
	<span class="hr-sect"><font size="5"><b>&nbsp;&nbsp; 개발자의 책갈피</b></font></span>
	
	<div>
		<ul style="list-style-type:square;">
			<font color="#00a0df" size="3"><b><li>IT 개발자를 위한 추천 사이트를 소개합니다!</li></b></font>
			<p style="LINE-HEIGHT: 2%"><br></p>
			<li>▶  B-Mark는 다량의 소스 정보와 가독성 좋은 UI로 이뤄진 개발자를 위한 사이트를 보여줍니다.</li> 
			<li>▶  B-Mark는 로그인을 통해 자신만의 북마크를 꾸밀 수 있습니다. 좀 더 편한 기능을 이용해보세요!!</li>
			<li>▶  B-Mark는 그룹 가입을 통해 그룹 공유 북마크를 공유  관리할 수 있습니다.</li>
		</ul>
		<hr class="hr-tag"><br>
		<p style="padding-left: 20px">최대한 빈틈없이 목록에 담으려 했지만, 놓친 것이 있을 수도 있습니다.리스트에는 없지만 자주 사용하는 좋은 웹 디자인 툴이나 리소스가 있으면 알려주시기 바랍니다.
			<span class="profile-ava" style="float: right;"><img src="images/chart.png" class="headimage">
					<button class="btn btn-primary" style="margin-right: 20px" onclick="chartsite();">
						사이트 통계 차트
					</button>
			</span>
		</p>
		
	</div>
	<hr>
	
	<!-- Category: 카테고리 -->
	<div class="maincontainer">
		<div>
			<h4><b class="categorytext">카테고리 선택</b></h4>
			<div id="category-display">
				<div id="showall" class='category categoryeffect reddiv'>
					<div><span>Show All</span></div>
				</div>
			
				<!--  
					카테고리 선택 영역!!!!!
				-->
			</div>
		</div>
		<hr class="clearhr">
	</div>
	<!-- Category: 카테고리 끝 -->

	<div class="container-fluid text-center" >
		<div class="content mymaindiv">
			<div id="mainbookmark" class="col-sm-9 text-left mymainbmark connectedSortable">
				<!-- 
					카테고리별 사이트 링크 영역!!!!!
				 -->
			</div>
			
			<div class="col-sm-3 sidenav">
				<div id="mybookmark" class="mymybmark"><!-- mycontainertable -->
					<% pageContext.include("views/main_my_bookmark.jsp"); %>
				</div>
				
				<div id="groupbookmark" class="mygroupbmark"><!-- mycontainertable -->
					<% pageContext.include("views/main_group_bookmark.jsp"); %>
				</div>
			</div>
			
		</div>
	</div>
	<hr class="clearhr">
<%
	pageContext.include("include/footer.jsp");
%>

</body>
</html>