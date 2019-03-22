<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	// SSE ����� ���� ���� �ð��� �˷��ִ� ������ ó���ϴ� �������̴�
	// ���⼭ �ð��� ����ؼ� Ŭ���̾�Ʈ���� �������ְ� �ȴ�

    response.setContentType("text/event-stream;charset=UTF-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Connection", "keep-alive");

    // ��Ű���� ���� �ð��� �����´�
    String accessTime = null;
    Cookie[] cs= request.getCookies();
     if(cs != null || cs.length > 0){
    	 for(Cookie c : cs){
    		 if(c.getName().equals("loginTime")){
    			 accessTime = c.getValue();
    		 }
    	 }
     }
	
     // ���� ���� �ð��� ����
     Date date = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
     String timeNow = formatter.format(date);
     
    // �ð��� ���̸� ����Ͽ� �̿�ð��� ���� (���� : ��)
    String[] arr_temp1 = timeNow.split(":");
    String[] arr_temp2 = accessTime.split(":");
	
    // ���� �ð� ( h * 60 + min)
    int temp1 = Integer.parseInt(arr_temp1[0]) * 60 + Integer.parseInt(arr_temp1[1]);
    
    // �α��� ��� �ð�( h * 60 + min )
    int temp2 = Integer.parseInt(arr_temp2[0]) * 60 + Integer.parseInt(arr_temp2[1]);
    
    // ���� �� ������ �� �ð� �� ������ ����ؼ� Ŭ���̾�Ʈ���� �����ش�
    int time = temp1 - temp2;
    out.write("event: Random\n");
    out.write("retry: 10000\n");
    out.write("data: "+ time + "\n\n");
    out.flush();
%>
</body>
</html>

















