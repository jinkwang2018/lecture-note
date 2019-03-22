<%@ page  contentType = "text/event-stream;charset=utf-8" %>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
String today = formatter.format(new java.util.Date());

%>

retry: 2000

data: 오늘 날짜:<%=today%>
data: 오늘 날짜,<%=today%>

data: 이벤트2,데이터1
data: 이벤트2,데이터2