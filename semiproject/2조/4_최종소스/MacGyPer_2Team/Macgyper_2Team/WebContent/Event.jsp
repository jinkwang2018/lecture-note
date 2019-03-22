<%@page import="net.sf.json.JSONArray"%>
<%@page import="kr.or.bit.dto.EventDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>MacGyPer Calendar</title>
<link href='css/Calendar/fullcalendar.css?ver=1' rel='stylesheet' />
<link href='css/Calendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<link  href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet"/>

<link rel="stylesheet" href="css/Bootstrap/assets/css/form-elements.css?ver=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<script src='js/Calendar/moment.min.js'></script>
<script src='js/Calendar/fullcalendar.js?ver=1'></script>
<script src='js/Calendar/ko.js'></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/Calendar/datepicker-ko.js"></script>

<link href="css/Bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/Bootstrap/css/sb-admin.css" rel="stylesheet">
<script src="js/Bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/Bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/Bootstrap/js/sb-admin.min.js"></script>
 
<style>
body {
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}

#fid label {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 90%;
	padding: .4em;
}

.textarea {
	margin-bottom: 12px;
	width: 90%;
	padding: .4em;
}

input.two {
	margin-bottom: 12px;
	width: 45%;
	padding: .4em;
	display: inline
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td, div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}

div.calendar-trash {
	float: right;
	padding-right: 8px;
	margin-right: 5px;
	padding-left: 8px;
	padding-top: 3px;
	cursor: pointer;
}

.to-trash {
	background-color: #EAEAEA;
	-webkit-border-radius: 5em;
	border-radius: 5em;
}
</style>

<script type="text/javascript">

  $(document).ready(function() {
	 
	  $('[title="휴지통"]').tooltip(); 
	  console.log($('#user_id').val());
	  var dialog, form;
	  var event_title = $("#title");
	  var event_startdate = $("#startdate");
	  var event_enddate = $("#enddate");
	  var event_starttime = $("#starttime");
	  var event_endtime = $("#endtime"); 
	  var event_content = $("#content");
	  var event_id = $("#event_id");
      var timeRegExp = /^([1-9]|[01][0-9]|2[0-4]):([0-5][0-9])$/;
	  var dayReg="";
	  var allFields = $( [] ).add( event_title ).add( event_startdate ).add( event_enddate ).add( event_starttime ).add( event_endtime ).add( event_content );
      var tips = $(".validateTips");
	  var initialLocaleCode = 'ko';
	  var textCountLimit = 100;
	  var event_color= $("#event_color");
	  
	   event_content.keyup(function() {
	        // 텍스트영역의 길이를 체크
	        var textLength = $(this).val().length;
	        if (textLength >textCountLimit) {
	        	tips.text("글자수 초과").addClass( "ui-state-highlight" );
	        	
		      setTimeout(function() {
		        tips.removeClass( "ui-state-highlight", 1500 );
		        $(this).removeClass( "ui-state-error", 1500 );
		      }, 500 );
		      $(this).addClass("ui-state-error");
	        }else{
	        	tips.text("현재 "+textLength+"자");
	        }
		});
	   var ck = false;
	   
    var calendar = $('#calendar').fullCalendar({
      header: {
        left: 'prev,next, today',
        center: 'title',
        right: 'addEventButton,month,listDay,listWeek'
      },
      eventTextColor : '#fff',
      locale: initialLocaleCode,
       
      views: {
        listDay: { buttonText: '일' },
        listWeek: { buttonText: '주' }
      },
      navLinks: true, 
      editable: true,
      eventLimit: true, 
      defaultView: 'month',
      selectable:true,
      selectHelper:true,
      dragRevertDuration: false,
      select:function(start, end, allDay) {
    	 var endstr = end.format().substring(0,7);
    	 if((end.format().substring(8))<=10){
    		  endstr += ("-"+"0"+(end.format().substring(8)-1));
    	   }else{
    		  endstr +=  ("-"+(end.format().substring(8)-1));
    	  } 
     	  event_startdate.val(start.format());
    	  event_enddate.val(endstr);
    	  $('#savebtn').show();
    	  $('#editbtn').hide();
    	  $("#Modalmain").modal();
    	  calendar.fullCalendar('unselect');
      }, 
       eventClick: function(event, jsEvent, view){
    	  datepic();
    	  event_title.val(event.title);
    	  event_content.val(event.content);
    	  event_startdate.val(event.start.format().substring(0,10));
    	  event_enddate.val(event.end.format().substring(0,10));
    	  event_starttime.val(event.start.format().substring(11,16));
    	  event_endtime.val(event.end.format().substring(11,16));
          event_id.val(event.id);
          event_color.val(event.color);
          
          $('#editbtn').show();
          $('#savebtn').hide();
          $("#Modalmain").modal();
      },  
       eventDragStop: function(event,jsEvent) {
          var trashEl = jQuery('#calendarTrash');
          var ofs = trashEl.offset();
          var x1 = ofs.left;
          var x2 = ofs.left + trashEl.outerWidth(true);
          var y1 = ofs.top;
          var y2 = ofs.top + trashEl.outerHeight(true);

          if (jsEvent.pageX >= x1 && jsEvent.pageX<= x2 &&
              jsEvent.pageY >= y1 && jsEvent.pageY <= y2) {
        	  deleteevent(event.id);
          }
      },
      eventDrop : function(event, delta, revertFunc){
    	  event_title.val(event.title);
    	  event_content.val(event.content);
    	  event_startdate.val(event.start.format().substring(0,10));
    	  event_enddate.val(event.end.format().substring(0,10));
    	  event_starttime.val(event.start.format().substring(11,16));
    	  event_endtime.val(event.end.format().substring(11,16));
          event_id.val(event.id);
          event_color.val(event.color);
    	  editmodal();
      },
      events: function(start, end, timezone, callback) {
          $.ajax({
              url: 'EventList.event',
              dataType: 'json',
              data : {user_id :$('#user_id').val()},
              success: function(data) {
                  var events = [];
                  $(data).each(function(index, obj) {
                      events.push({
                    	    id : obj.event_id,
	      					title : obj.event_title,
	      					content : obj.event_content,
	      					start : obj.event_startdate,
	      					end : obj.event_enddate,
	      					color : obj.event_color
	      				
                      });
                  });
                  callback(events);
              }
          });
      },
      customButtons: {
          addEventButton: {
            text: '일정 추가',
            click: function() {
            	datepic();
            	$('#savebtn').show();
          	    $('#editbtn').hide();
    			$("#Modalmain").modal();
            }
          }
        }
    });

    function deleteevent(a){
    	$.ajax({
         	url:"EventDelete.event",
         	data: {"event_id":a},
         	success:function(data){
         		calendar.fullCalendar('removeEvents',a);
         		initmodal();
         }});
    	
    }
	function datepic(){
		var dateFormat = "yy-mm-dd", 
		from = $("#startdate").datepicker($.datepicker.regional["ko"],{
			defaultDate : "+1w",
			changeMonth : true,
		}).on("change", function() {
			to.datepicker("option", "minDate", getDate(this));
		}), 
		to = $("#enddate").datepicker($.datepicker.regional["ko"],{
			defaultDate : "+1w",
			changeMonth : true,
		});
		function getDate(element) {
			var date;
			try {
				date = $.datepicker.parseDate(dateFormat, element.value);
			} catch (error) {
				date = null;
			}
			return date;
		}
	}
	function updateTips( t ) {
	      tips
	        .text( t )
	        .addClass( "ui-state-highlight" );
	      setTimeout(function() {
	        tips.removeClass( "ui-state-highlight", 1500 );
	      }, 500 );
	    }

	function checkTime(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}
	
	$("#allday").click(function() {
		if($("#allday").is(":checked")){
			event_starttime.val("00:00");
			event_endtime.val("23:59");
			$("#starttime").attr("disabled", "disabled");
			$("#endtime").attr("disabled", "disabled");
			$("#starttime").css("background-color", "#eeeeee");
			$("#endtime").css("background-color", "#eeeeee");
		}
		else if(!($("#allday").is(":checked"))){
			$("#starttime").removeAttr("disabled");
			$("#starttime").css("background-color", "#ffffff");
			$("#endtime").removeAttr("disabled");
			$("#endtime").css("background-color", "#ffffff");
			event_starttime.val("");
			event_endtime.val("");				
		}
	}); 
		
	function initmodal(){	
		form[ 0 ].reset();
		allFields.removeClass( "ui-state-error" );
		$("#starttime").removeAttr("disabled");
		$("#starttime").css("background-color", "#ffffff");
		$("#endtime").removeAttr("disabled");
		$("#endtime").css("background-color", "#ffffff");
		$("p").text(""); 
	}
	
	function checkDay(o, regexp, n) {
		if (o.val().trim()==regexp||o.val()==null) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}
	
	function editmodal(){
		var valid = true;
		allFields.removeClass( "ui-state-error" );
		valid = valid && checkDay(event_title, dayReg, "제목을 입력하세요");
		valid = valid && checkDay(event_startdate, dayReg, "날짜를 입력하세요");
		valid = valid && checkTime(event_starttime, timeRegExp, "시간:HH24:MM을 입력하세요");
		valid = valid && checkDay(event_enddate, dayReg, "날짜를 입력하세요");
		valid = valid && checkTime(event_endtime, timeRegExp, "시간:HH24:MM을 입력하세요");
		
		
		if (valid) {
			var start = event_startdate.val()+"T"+event_starttime.val()+":00";
			var end = event_enddate.val()+"T"+event_endtime.val()+":00";
            var title = event_title.val();
            var content = event_content.val();
            var id = event_id.val();
            var color = event_color.val();
            var event ={
            		id : id,
                    title: title,
                    start: start,
                    end: end,
                    content : content,
                    user_id : $('#user_id').val(),
                    color : event_color.val()
            }             
            $.ajax({
            	url:"EventUpdate.event",
            	data:event,
            	success:function(){
            		$.ajax({
        				url:"EventList.event",
        				dataType: "json",
        	    	    method: "POST",
        	    	    data : {user_id :$('#user_id').val()},
        	      	success:function(data){
        	      		calendar.fullCalendar('removeEvents');	
        	      		$(data).each(function(index,obj){
        	      			calendar.fullCalendar('renderEvent', {
        	      					id : obj.event_id,
        	      					title : obj.event_title,
        	      					content : obj.event_content,
        	      					start : obj.event_startdate,
        	      					end : obj.event_enddate,
        	      					color : obj.event_color
        	      			});
        	      			$('#closebtn').trigger('click');
        	      		});
        	      		initmodal();
        	      	}
        	  });
            }});
		}
	}
	
	function savemodal(){
		var valid = true;
		allFields.removeClass( "ui-state-error" );
		valid = valid && checkDay(event_title, dayReg, "제목을 입력하세요");
		valid = valid && checkDay(event_startdate, dayReg, "날짜를 입력하세요");
		valid = valid && checkTime(event_starttime, timeRegExp, "시간:HH24:MM을 입력하세요");
		valid = valid && checkDay(event_enddate, dayReg, "날짜를 입력하세요");
		valid = valid && checkTime(event_endtime, timeRegExp, "시간:HH24:MM을 입력하세요");
		
		if (valid) {
			var start = event_startdate.val()+"T"+event_starttime.val()+":00";
			var end = event_enddate.val()+"T"+event_endtime.val()+":00";
            var title = event_title.val();
            var content = event_content.val();
            var color = event_color.val();
            var event ={
                    title: title,
                    start: start,
                    end: end,
                    content : content,
                    user_id : $('#user_id').val(),
                    color : color
            };             
            $.ajax({
            	url:"EventAdd.event",
            	data:event,
            	success:function(){
            		$.ajax({
        				url:"EventList.event",
        				dataType: "json",
        	    	    method: "POST",
        	    	    data : {user_id :$('#user_id').val()},
        	      	success:function(data){
        	      		calendar.fullCalendar('removeEvents');
        	      		$(data).each(function(index,obj){
        	      			calendar.fullCalendar('renderEvent', {
        	      					id : obj.event_id,
        	      					title : obj.event_title,
        	      					content : obj.event_content,
        	      					start : obj.event_startdate,
        	      					end : obj.event_enddate, 
        	      					color : obj.event_color
        	      			});
        	      			$('#closebtn').trigger('click');
        	      		});
        	      		initmodal();
        	      	}
        	  });
            }});
            
		}
	}
	
	$('#closebtn').click(function(){
		initmodal();
	});	
	
	$('#editbtn').click(function(){
		editmodal();
	});
 	
	$('#savebtn').click(function(){
		savemodal();
	}); 
		
	  form = $("#Modalmain").find( "form" ).on( "submit", function( event ) {
	   event.preventDefault();
	   savemodal();
	 });
	
});
</script>
</head>
<body class="fixed-nav sticky-footer bg-dark">
	<jsp:include page="/include/header.jsp"></jsp:include>
	<div class="content-wrapper">
		<div class="container-fluid" id="pageContainer">
			<div id='calendar'>
				<div id="calendarTrash" class="calendar-trash">
					<img data-toggle="tooltip" title="휴지통" src="Images/trash.png" />
				</div>
			</div>
        	<br><br>
		</div>
		<jsp:include page="/include/footer.jsp"></jsp:include>
		
	</div>
	<div class="modal fade" id="Modalmain" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div id="dibtn" class="modal-header">
					<h4 class="modal-title">일정 추가</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>

				</div>
				<div class="modal-body">
					<p class="validateTips"></p>
					<form method="post">
						<fieldset id="fid">
							<label for="name">제목</label> <input type="text"
								name="event_title" id="title" placeholder="제목을 입력하세요"
								class="text ui-widget-content ui-corner-all"><br> <label
								for="name"><input name="isAllDay" id="allday"
								type="checkbox" style="margin: 10px"> 하루종일</label> <label
								for="from">Start</label> <input type="text"
								name="event_startdate" id="startdate" readonly="readonly"
								placeholder="날짜" class="two ui-widget-content ui-corner-all">
							<input type="text" name="event_starttime" id="starttime"
								placeholder="시간(HH24:mm)"
								class="two ui-widget-content ui-corner-all"> <label
								for="to">End:</label> <input type="text" name="event_enddate"
								id="enddate" readonly="readonly" placeholder="날짜"
								class="two ui-widget-content ui-corner-all"> <input
								type="text" name="event_endtime" id="endtime"
								placeholder="시간(HH24:mm)"
								class="two ui-widget-content ui-corner-all"> <label
								for="content">내용</label>
							<textarea name="content" id="content" placeholder="최대 100자"
								maxlength="99" class="textarea ui-widget-content ui-corner-all"></textarea>
							<input type="hidden" name="event_id" id="event_id"> <input
								type="hidden" name="event_color" id="event_color"
								value="#F9C300"> <input type="hidden" name="user_id"
								id="user_id" value="${sessionScope.member}"> <input
								type="submit" tabindex="-1"
								style="position: absolute; top: -1000px">
						</fieldset>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn" id="savebtn">저장</button>
					<button type="button" class="btn" id="editbtn">수정</button>
					<button type="button" class="btn" id="closebtn"
						data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>