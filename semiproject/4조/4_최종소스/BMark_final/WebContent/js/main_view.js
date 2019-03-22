//서버로부터 카테고리 리스트를 비동기로 받아오는 함수
function categoryAjax() {
	var categoryList = [];
	$.ajax({
		url : "category.mainbmark",
		dataType : "JSON",
		type : "POST",
		success : function(data) {
			//console.log(data); // 카테고리 리스트 확인 콘솔
			$.each(data, function(index, element) {
				categoryList.push(element.cname);
				var html = "<div class='category categoryeffect'>"
						+ "<div><span>" + element.cname + "</span></div>"
						+ "</div>";
				
				$("#category-display").append(html);

				var html2 = "<div id='" + element.cname
						+ "' class='col-sm-12 sidenav'>" + "<div class='well'>"
						+ "<p class='pstyle'>" + element.cname + "</p>"
						+ "<div class='mycontainertable'>"
						+ "<table class='table table-striped'>" + "<tbody>"

						+ "</tbody>" + "</table>" + "</div>" + "</div>"
						+ "</div>";
				$("#mainbookmark").append(html2);
				
				$(".my-modal-category").append("<option>" + element.cname + "</option>");
			});
		},
		error: function (error) {
		    alert('error : ' + eval(error));
		}
	});
	return categoryList;
}

/*
 *	메인페이지에 Main Bookmark 가져오는 함수
 */
function mainBoard(isLogin, isGroup) {
	$.ajax({
		url : "mainboardwriteok.mainbmark",
		dataType : "JSON",
		type : "POST",
		success : function(data) {
			//console.log(data);
			if (data != null) {
				var userEvalList = new Map();
				var userJjimList = new Map();
				var userGroupList = new Map();
				// 로그인한 회원의 경우 그가 과거에 한 추천/비추천 행위 Map() 객체에 담기
				if(isLogin != "") {
					if(data.length > 1){
						$.each(data[1], function(){
							userEvalList.set(this.mnbid, this.eval);
						});
						$.each(data[2], function(){
							userJjimList.set(this.mnbid, this.userid);
						});
						$.each(data[3], function(){
							userGroupList.set(this.mnbid, this.gid);
						});
					}
				}
				
				$.each(data[0], function() {
					//console.log(this);
					var categoryName = this.cname;

					var likeTag = "<img src='images/like1.png'>";
					var dislikeTag = "<img src='images/dislike1.png'>";
					
					// 로그인한 사람이 어떤 사이트를 평가했다면?
					if(userEvalList.size > 0) {
						// 메인 페이지 북마크에 있는 사이트가 그 사람이 평가한 사이트 ID와 일치 한다면?
						if(userEvalList.has(this.snum)) {
							// 그 사이트를 추천했다면 ?
							if(userEvalList.get(this.snum) == "T") {
								likeTag = "<img src='images/like2.png'>";
							// 그 사이트를 비추천했다면 ?	
							}else {
								dislikeTag = "<img src='images/dislike2.png'>";
							}
						}
					}
					
					// 기본 별 이미지
					var starImageTag = "<img src='images/star.png' style='height:25px; width:25px;'>";
					
					// 로그인한 사람이 어떤 사이트를 개인이나 그룹에 즐겨찾기했다면?
					if(userJjimList.size > 0 || userGroupList.size > 0) {
						// 마이북마크에 즐겨찾기한 사이트와 일치 한다면?  붉은 별
						if(userJjimList.has(this.snum)) {
							starImageTag = "<img src='images/star4.png' style='height:25px; width:25px;'>";
						}
						// 가입한 그룹에 즐겨찾기한 사이트와 일치 한다면?  푸른 별
						if(userGroupList.has(this.snum)) {
							starImageTag = "<img src='images/star2.png' style='height:25px; width:25px;'>";
						}
						// 마이와 그룹 둘다 즐겨찾기한 사이트라면? 붉고 푸른 별
						if(userJjimList.has(this.snum) && userGroupList.has(this.snum)) {
							starImageTag = "<img src='images/star3.png' style='height:25px; width:25px;'>";
						}
					}
					
					$('#' + categoryName).find("tbody").append(
									"<tr class='tablehover' data-code='" + this.snum + "'>"
										+ "<td class='starbook' style='width:7%'>" + starImageTag + "</td>"
											
										+ "<td class='sitelink' data-site='"+ this.addr +"' style='" + this.content + "'>"
											+"<img src='" + this.icon + "' style='height:16px; width:16px;' onerror='this.onerror=null; this.src=\"images/bmark.png\";'>&nbsp;&nbsp;&nbsp;"
											+ this.name + "<span class='sitetooltip'><strong>'"+this.content+"'</span></td>"
											
										+ "<td><div class='downbtn confirmation-callback'>" + dislikeTag + "<small>&nbsp;"
											+ this.bad
											+ "</small></div>"
											+ "<div class='upbtn confirmation-callback'>" + likeTag + "<small>&nbsp;"
											+ this.good
										+ "</small></div></td>"
									+ "</tr>"
					)
				});
			}
		}
	});
	
	mainMyBoard();
}

/* 
	category class를 클릭한 text가 Show All일 경우
	전체 카테고리 리스트를 show, 선택된 카테고리 리스트는 배경색 기존색으로 변경(removeClass)
	Show All 카테고리는 custom색으로 변경		
*/
function categoryClick(current) {
	console.log(current);
	var id = current.text().trim();
	
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
		if (current.hasClass("reddiv") == true) {
			current.removeClass("reddiv");

			const idx = selectedCate.indexOf(current.text());
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
			current.addClass("reddiv");
			selectedCate.push(current.text());

			$.each(categoryList, function(index, element) {
				$('#' + element).hide(500);
			});
			$.each(selectedCate, function(index, element) {
				$("#" + element).show(750);
			});
		}
	}
}

/* 
	B Mark 메인 화면 접근시 로그인 유무에 따라 
	그 사용자의 My BookMark List를 비동기로 뿌려주는 함수	
*/
function mainMyBoard(){
	$.ajax({
		url : "boardlist.mainbmark", //호출 url
		dataType : "html", //호출 데이터 형식 -> myBoardListOk html 형식
		success : function(data) { //성공시 출력되는 화면
			//console.log("data : " + data);
			$('#mainmyboard').html(data);
		}
	});

	mainGroupBoard();
}

/* 
	B Mark 메인 화면 접근시 사이트에 등록되어있는 그룹들을 뿌려준다.
	하지만, 그룹참가는 등록된 회원만 가능한 서비스이므로 비회원이 참가 버튼을 누르면 로그인이 필요한 서비스라고 알림창을 보여준다.
	로그인된 회원의 경우 그룹에 참가가 되어있다면, 그 사용자의 Group BookMark List를 비동기로 뿌려주고 아니라면 팀 참가 List가 보이게 된다.	
*/
function mainGroupBoard(){
	$.ajax({
		url : "groupboardwriteok.mainbmark", //호출 url
		dataType : "JSON", //호출 데이터 형식 -> myBoardListOk html 형식
		success : function(data) { //성공시 출력되는 화면
			console.log("data : " + data);
			// data[0]가 0이란 그룹 비참가자를 뜻하고, data[0]가 1은 그룹 참가자이다.
			if(data[0] == 0){
				var groupboard_header = 
					"<table class='table' style='margin-bottom: 0'>"
					+"<thead>"
						+"<tr>"
							+"<th>팀명</th>"
							+"<th>팀장</th>"
							+"<th>인원</th>"
						+"</tr>"
					+"</thead>"
					+"</table>";
				$('#maingruopcontainer').append(groupboard_header);
				
				if(data[1] != null){
					var groupboard = "<table class='table'><tbody align='left'>";
					$.each(data[1], function(index, element) {
						//console.log(element);
						groupboard += "<tr class='tablehover group-join grouptextfont' data-code='" + this.gid + "'>"
						groupboard += "<td>" + element.name + "</td>" + "<td>" + element.register + "</td>";
						groupboard += "<td>" + element.membercount + "<small>(명)</small></td>";
						groupboard += "</tr>";
					});
					groupboard += "</tbody></table>";
					$('#maingruopboard').append(groupboard);
				}
			}else {
				var groupboard_header = 
					"<table class='table' style='margin-bottom: 0'>"
					+"<thead>"
						+"<tr>"
							+"<th>로고</th>"
							+"<th>사이트명</th>"
						+"</tr>"
					+"</thead>"
					+"</table>";
				$('#maingruopcontainer').append(groupboard_header);
				
				if(data[1] != null){
					var groupboard = "<table class='table'><tbody class='group-bookmarktable' align='left'>";
					$.each(data[1], function(index, element) {
						//console.log(element);
						groupboard += "<tr class='tablehover sitelink'>"
						groupboard += "<td><img src='" + element.icon + "' style='height:16px; width:16px;' onerror='this.onerror=null; this.src=\"images/bmark.png\";'></td>"
						groupboard += "<td class='sitelink' data-site='"+ element.addr +"'>" + element.name + "</td>";
						groupboard += "</tr>";
					});
					groupboard += "</tbody></table>";
					$('#maingruopboard').append(groupboard);
				}
			}
		}
	});
}

function likeClick() {
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
			path.html("<img src='images/like1.png'><small>&nbsp;" + responseData[1] + "</small>");
		}
	});	
}

function dislikeClick() {
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
			responseData = data.trim().split("_");
			alert(responseData[0]);
			path.html("<img src='images/dislike1.png'><small>&nbsp;" + responseData[1] + "</small>");
		}
	});
}


//차트를 보여주는 버튼
function chartsite(){
	window.open("sitechart.mainbmark", "Chart", "width=550, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
};

//로그인하면 그 회원이 북마크(즐겨찾기)한 리스트들 색깔있는 별로 칠하기
function starMyBookmarkChecked(mnbid, starbookimg) {
	$.ajax({
		url : "starbook.mainbmark",
		data : {mnbid : mnbid},
		dataType : "JSON",
		type : "POST",
		success : function(data){
			//console.log(data);
			//console.log(data[0].addr);
			if(data[0].mnbid == null){
				alert(data);
			}else {
				$('#main-myboard').prepend(
						  "<tr class='tablehover' data-code='" + data[0].mnbid + "'>"
							+ "<td class='starbook'>"
								+"<img src='" + data[0].icon + "' style='height:16px; width:16px;' onerror='this.onerror=null; this.src=\"images/bmark.png\";'></td>"   
							+ "<td class='sitelink' data-site='"+ data[0].addr +"'>"
								+ data[0].name + "</td>"
						+ "</tr>"
				);
				//starbookimg.attr("src", "images/star4.png");
			}
		}
	});
}

function starGroupBookmarkChecked(mnbid, starbookimg) {
	$.ajax({
		url : "starbook.group",
		data : {mnbid : mnbid},
		dataType : "JSON",
		type : "POST",
		success : function(data){
			//console.log(data);
			if(data[0].mnbid == null){
				alert(data);
			}else {
				console.log(data[1]);
				$('.group-bookmarktable').prepend(
						  "<tr class='tablehover' data-code='" + data[0].mnbid + "'>"
							+ "<td class='starbook'>"
								+"<img src='" + data[0].icon + "' style='height:16px; width:16px;' onerror='this.onerror=null; this.src=\"images/bmark.png\";'></td>"   
							+ "<td class='sitelink' data-site='"+ data[0].addr +"'>"
								+ data[0].name + "</td>"
						+ "</tr>"
				);
				//starbookimg.attr("src", "images/star2.png");
			}
		}
	});
}

/* 조회수(사이트 링크 클릭시), hitok.mainbmark 링크 forward */
jQuery(function (){
	$(document).on('click', '.sitelink', function() {
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
	});
});