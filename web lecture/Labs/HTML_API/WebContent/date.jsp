<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%
    response.setContentType("text/event-stream;charset=UTF-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Connection", "keep-alive");

    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    int num1 = (int)(Math.random()*7)+2;
    int num2 = (int)(Math.random()*8)+1;
    out.write("event: server-time\n\n");
    out.write("data: "+formatter.format(date) + "\n");
    out.write("data: " + num1 + " * " + num2 + "\n");
    out.write("data: "+String.valueOf(num1*num2) + "\n\n");
    
    
    /* out.write("event: question\n\n");
    out.write("data: " + num1 + " * " + num2 + "\n\n");
    
    out.write("event: answer\n\n");
    out.write("data: "+String.valueOf(num1*num2) + "\n\n"); */
    
    out.flush();
    
    
    
    
%>