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
<link rel="stylesheet" href="b.css" />

<style type="text/css">

img{
   border: 0 auto;
   margin: 10px;
   width: 90px;
   height: 100px;

}

</style>


<script type="text/javascript">


  
function gogo() {
   if($('#name').text()!="Movie name"&&$('#name').text()!="영화선택"){

        location.href="ticketing.jsp?SIGUN_NM=<%=request.getParameter("SIGUN_NM")%>&BIZPLC_NM=<%=request.getParameter("BIZPLC_NM")%>&Moviename="+ $('#name').text(); 
      
   }else{
      alert("영화를 선택해 주세요");
   }
      
}
 
  
  
  $(document).ready(function () {
    $('h3').css("visibility", "hidden");
    $('#video1').attr("src","" );
  });
  
function allowDrop(ev) {
    ev.preventDefault();
}


function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    $('h3').css("visibility", "visible");
   
   
}


function drop(ev) { 
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
                           $("div > #"+data).clone().appendTo('#div2');
                           //$('#test').attr("alt");
                           //console.log(  $('#test').attr("alt"));
                           
                            $('iframe').attr("src",$('#'+data).attr("alt"));
                           $('#name').text(data);
                          
                    }
                    console.log(event);
                };
                 
              
         });
            //이미지 숨김
         $('#hide').click(function(){
              //워커를 종료시킨다.
             worker.terminate();
             $('#video1').remove();
             $('#hide').before("<iframe   id='video1' width='95%' height='600px' border='0'></iframe>");
             $('#hide').hide();
          
              console.log(data);
              $('#div2').empty();
              $("div > #"+data).clone().appendTo('#div2');
              //$('#test').attr("alt");
              //console.log(  $('#test').attr("alt"));
              
             $('iframe').attr("src",$('#'+data).attr("alt"));
              $('#name').text(data);
             
         });    
   }


function drop2(ev) {
   
   var getid = $('#div2 img').attr('id');
   $('#div1').attr("accept","getid");
   
   
   $('h3').css("visibility", "hidden");
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

<nav class="navbar navbar-default">
      <div class="container-fluid">
         <div class="navbar-header">
             <a class="navbar-brand" href="#">Bitcamp104 1조</a>
          </div>
          <ul class="nav navbar-nav">
            <li><a href="#">Home</a></li>
            <li><a href="Logout.jsp">로그아웃</a></li>
         </ul>
      </div>
   </nav>
   <div id = "header" class="jumbotron text-center">
      <h1>HTML5_API</h1> 
      <p>Geoloaction</p> 
</div>
   <div class="container-fluid">
      <div class="row content">
         <div class="col-sm-3 sidenav">
            <h4>Movie List..</h4>
            <ul class="nav nav-pills nav-stacked">
               <li class="active"><a href="#section1">pickup and drop
                     into box</a></li>
               <div id="div1" ondrop="drop2(event)" ondragover="allowDrop(event)">
                  <img src="Images/a.jpg" draggable="true" ondragstart="drag(event)"
                     id="위대한_쇼맨"
                     alt="https://www.youtube.com/embed/cnIOq6P8PUU?autoplay=1">
                  <img src="Images/b.jpg" draggable="true" ondragstart="drag(event)"
                     id="블랙팬셔"
                     alt="https://www.youtube.com/embed/tOKt6CxtL7s?autoplay=1">
                  <img src="Images/d.jpg" draggable="true" ondragstart="drag(event)"
                     id="늑대아이"
                     alt="https://www.youtube.com/embed/CVRON0VXr_I?autoplay=1">
                  <img src="Images/e.jpg" draggable="true" ondragstart="drag(event)"
                     id="인셉션"
                     alt="https://www.youtube.com/embed/hx1fqhNoH8A?autoplay=1">

               </div>

            </ul>
            <br>
            <div class="input-group">
               <input type="text" class="form-control" placeholder="Search Blog..">
               <span class="input-group-btn">
                  <button class="btn btn-default" type="button">
                     <span class="glyphicon glyphicon-search"></span>
                  </button>
               </span>
            </div>
         </div>

         <div class="col-sm-9">
            <h4>
               <small>RECENT POSTS</small>
            </h4>
            <hr>


            <div id="div2" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
            <h2>I Love Movie</h2>

            <p id="name">Movie name</p>
            <h3>"<=Here"</h3>
            <br> <input style="float: right" type="button" id="gonext" onclick="gogo()" value="예매하기">


            <%
 
   request.setCharacterEncoding("UTF-8");
    out.print(request.getParameter("BIZPLC_NM"));
    
    %>
       <hr>

            <iframe id="video1" width="95%" height="600px"></iframe>
            <input type="button" id="hide" class="btn btn-danger" value="광고 건너뛰기" style="display: none">
            </div>
      </div>
   </div>


<footer class="container-fluid bg-4 text-center">
      <p>ⓒ 2018 Copyright: bit.or.kr</p>
</footer>

</body>
</html>