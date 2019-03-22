<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// SSE 기능을 통해 클라이언트가 서버에게 정보를 수신 받도록 해주는 코드들이다
// 매 페이지마다 해당 코드가 추가되어야 수신이 가능함
%>

	<script type="text/javascript">
	
		if (typeof (EventSource) !== "undefined") {
			var source = new EventSource("InformTime.jsp");
			source.onmessage = function(event) {
				var time = event.data;
						
				// 테스트 출력
				alert(time);
				
				if (time > 60){
					alert("접속하신 시간이 " + 60 + "분 지났습니다");
				}else if (time > 50){
					alert("접속하신 시간이 " + 50 + "분 지났습니다");
				}else if (time > 40){
					alert("접속하신 시간이 " + 40 + "분 지났습니다");
				}else if (time > 30){
					alert("접속하신 시간이 " + 30 + "분 지났습니다");
				}else if (time > 20){
					alert("접속하신 시간이 " + 20 + "분 지났습니다");
				}else if (time > 10){
					alert("접속하신 시간이 " + 10 + "분 지났습니다");
				}
				
			};
		} else {
		}
	</script>
</body>
</html>