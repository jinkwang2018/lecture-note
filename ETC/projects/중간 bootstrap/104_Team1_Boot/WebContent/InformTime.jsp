<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%
	// SSE 기능을 통해 접속 시간을 알려주는 연산을 처리하는 페이지이다
	// 여기서 시간을 계산해서 클라이언트에게 전송해주게 된다

    response.setContentType("text/event-stream;charset=UTF-8");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Connection", "keep-alive");

    // 쿠키에서 접속 시간을 가져온다
    String accessTime = null;
    Cookie[] cs= request.getCookies();
     if(cs != null || cs.length > 0){
    	 for(Cookie c : cs){
    		 if(c.getName().equals("loginTime")){
    			 accessTime = c.getValue();
    		 }
    	 }
     }
	
     // 현재 서버 시각을 산출
     Date date = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
     String timeNow = formatter.format(date);
     
    if(timeNow != null && accessTime != null){
    	 // 시각의 차이를 계산하여 이용시간을 산출 (단위 : 분)
        String[] arr_temp1 = timeNow.split(":");
        
        System.out.println(accessTime);
        
       String[] arr_temp2 = accessTime.split(":");
       
       // 현재 시각 ( h * 60 + min)
       int temp1 = Integer.parseInt(arr_temp1[0]) * 60 + Integer.parseInt(arr_temp1[1]);
       
       // 로그인 당시 시각( h * 60 + min )
       int temp2 = Integer.parseInt(arr_temp2[0]) * 60 + Integer.parseInt(arr_temp2[1]);
       
       // 접속 후 지나간 총 시간 분 단위로 계산해서 클라이언트에게 보내준다
       int time = temp1 - temp2;
       out.write("event: Random\n\n");
       out.write("retry: 30000\n");
       out.write("data: "+ time + "\n\n");
       out.flush();
    }
    System.out.println("end");
%>












