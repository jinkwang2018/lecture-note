<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="css/preview.css" />

<style type="text/css">

img{
/* 나머지 style은 외부 css/preview.css로 빼 두었다. */
	border: 0 auto;
	margin: 10px;
	width: 140px;
	height: 150px;

}

</style>


<script type="text/javascript">


  
function gogo() {//예고편을 보고 해당 예고편의 영화를 예매페이지로 넘어가게 해준다.
	   if($('#name').text()!="Movie name"&&$('#name').text()!="영화선택"){//영화가 선택된 경우에만 페이지를 넘겨준다 (영화이름이 제대로 적혀잇을 경우)
	        location.href="ticketing.jsp?SIGUN_NM=<%=request.getParameter("SIGUN_NM")%>&BIZPLC_NM=<%=request.getParameter("BIZPLC_NM")%>&Moviename="+ $('#name').text(); 
	      
	   }else{
	      alert("영화를 선택해 주세요");
	   }
	      
	}
  
$(document).ready(function () {//드래그를 시전할 경우에만 드롭할 위치를 here로 표시하기 위해서 page시작과 동시에 here글자를 안보이게 해준다.
    $('h3').css("visibility", "hidden");
    $('#video1').attr("src","" );//이전페이지로 갔다 돌아올대 iframe에 남아있는 src를 없애준다. 반드시 광고가 먼저 나오게 된다
  }); 
 
function allowDrop(ev) {//이벤트가 제대로 시전되지 않앗을 경우 오류가 퍼지는것을 방지해준다
    ev.preventDefault();
}
function drag(ev) {//사진을 드래그 가능 상태로 설정해준다.
    ev.dataTransfer.setData("text", ev.target.id);//사진이 드래그될때 가지는 데이터 값의 타입은 text로 value값은 id로 설정해준다. id에 영화이름이 있다.
    $('h3').css("visibility", "visible");//드래그시 here글이 보이게 해준다.
 	$('#div2').attr({"style" : "border : 1px solid black"
    	
    });
   
}
function drop(ev) { //드롭이벤트를 걸어준다.
	   //drop
	    ev.preventDefault();
	     var data = ev.dataTransfer.getData("text");
	  
	     var worker; //워커 선언
	      $(document).ready(function(){
	      $('iframe').attr(
	                  {
	                  "src":"https://www.youtube.com/embed/36JvP5pw3po?autoplay=1&controls=0"
	                  }
	                  );
	             
	            if(worker) {                   //워커가 이미 작동중이라면 종료
	                     worker.terminate(); 
	                 };
	                 worker = new Worker("js/make2.js");//워커 js를 메모리에 올린다.
	                 worker.onmessage = function(event) {
	                    if(event.data==5){
	                       $('#hide').show();
	                    }
	                    if(event.data=="15"){
	                       worker.terminate();
	                       $('#video1').remove();
	                       $('#hide').before("<iframe   id='video1' width='95%' height='600px' border='0'></iframe>");
	                       $('#hide').hide();   
	                        
	                           console.log(data);
	                           $('#div2').empty();
	                           $("div > #"+data).clone().appendTo('#div2');//사진이 이전에서 없어지고 드롭된곳으로 옮겨지는 것이 아니라 이전에도 있고 드롭된곳에도 사진이 있게해준다.
	                          
	                            $('iframe').attr("src",$('#'+data).attr("alt"));//ifram 비디오 재생되는 곳에 src값을 넣어준다.
	                           $('#name').text(data);//영화이름을 보여준다.
	                          
	                    }
	                };
	                 
	              
	         });

		   	//광고 제거하기
			$('#hide').click(function(){
		    	 //워커를 종료시킨다.
		    	worker.terminate();
		    	$('#video1').remove();
		    	$('#hide').before("<iframe   id='video1' width='95%' height='600px' border='0'></iframe>");
		    	$('#hide').hide();
		    
		        console.log(data);
		        $('#div2').empty();
		        $("div > #"+data).clone().appendTo('#div2');
		        
		       $('iframe').attr("src",$('#'+data).attr("alt"));
		        $('#name').text(data);
		    	
			});	 
	}


function drop2(ev) {//보고있던 영상의 해당 사진을 왼쪽 div로 옮기면 사진과 영상이 사라진다.
	
	var getid = $('#div2 img').attr('id');
	$('#div1').attr("accept","getid");
	
	
	$('h3').css("visibility", "hidden");
	$('#div2').attr({"style" : "border : 0px solid black"
     	
    });
   ev.preventDefault();
   
   var data = ev.dataTransfer.getData("text");
   if(data == getid){
   console.log(data);
   
   $('#div2').empty();
   $('#video1').attr("src","" );
   $('#name').text("영화선택");
   }
}


 
</script>


</head>
<body>
	<div class="container-fluid" >
		<div class="row content" style="height:500px">
			<div class="col-sm-3 sidenav">
				
				<div class="nav nav-pills nav-stacked">
					<div class="active" style="background-color: #fed136; padding :5px;" >
					<h2 style="color:white; margin : 0px; text-align: center;">상영 영화 목록</h2>
					<h4 style="color:white; margin : 5px; text-align: center;">[DRAG 해주세요.]</h4>
					</div>
					<div id="div1" ondrop="drop2(event)" ondragover="allowDrop(event)" style = "height:30%; overflow: auto; border:0px">
						<img src="img/a.jpg" draggable="true" ondragstart="drag(event)"
							id="위대한_쇼맨"
							alt="https://www.youtube.com/embed/cnIOq6P8PUU?autoplay=1">
						<img src="img/b.jpg" draggable="true" ondragstart="drag(event)"
							id="블랙팬셔"
							alt="https://www.youtube.com/embed/tOKt6CxtL7s?autoplay=1">
						<img src="img/d.jpg" draggable="true" ondragstart="drag(event)"
							id="늑대아이"
							alt="https://www.youtube.com/embed/CVRON0VXr_I?autoplay=1">
						<img src="img/e.jpg" draggable="true" ondragstart="drag(event)"
							id="인셉션"
							alt="https://www.youtube.com/embed/hx1fqhNoH8A?autoplay=1">

					</div>

				</div>
				<br>
			
			</div>

			<div class="col-sm-9" >
				<div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<h2>I Love Movie</h2>

				<p id="name">Movie name</p>
				<h3>"<=Here"</h3>
				<br>
				<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services" id="gonext" onclick="gogo()"
				    style="background-color : #fed136; border-color : #fed136;">예매하기</a> 
			


				<%request.setCharacterEncoding("UTF-8"); out.print(request.getParameter("BIZPLC_NM"));%>
 		<hr>

				<iframe id="video1" style="width:95%; height:600px; border: 0px;"></iframe>
				<input type="button" id="hide" class="btn btn-danger" value="광고 건너뛰기" style="display: none">
				</div>
		</div>
	</div>

</body>
</html>
