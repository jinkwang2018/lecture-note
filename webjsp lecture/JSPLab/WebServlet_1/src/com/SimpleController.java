package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 서블릿(servlet)
 java 파일로 웹 서비스를 할 목적으로 만든 파일
 서블릿 파일 조건 (웹 : request, response)객체 사용가능
 
 1.extends HttpServelet 반드시 상속(웹 환경에서 제공되는 요청,응답) 처리 가능
 2.SimpleController 서블릿
 3.서블릿은 이벤트 기반 동작(함수 특정 상황에 맞추어서 자동 호출된다.)
     [상황] : 클라이언트가 SimpleController를 요청했을 때
     	전송방식이 GET으로 넘어오면 자동으로 doGet()가 호출된다. 
     	전송방식이 POST로 넘어오면 자동으로 doPost()가 호출된다.
     
     doGET() -> <a href="board.do?id=kglim">서버에 요청</a>
     doPOST() -> <form method="POST"></form>
     
 3.1 클라이언트의 정보를 얻어온다 : request.getParameter()
 4.서블릿은 java 파일이므로 컴파일 해야한다. class파일이 생성되고 실행하고 결과를 리턴하는 방식이다.
 	기본적으로 자바는 멀티 쓰레드 기반의 처리 가능하다.
 	
 5.Model2기반의 MVC 패턴 작업
 	5.1 JSP만 가지고 개발 : Model(DAO,DTO)+JSP > Model1방식
 	5.2 JSP 클라이언트 요청 받고 -> 처리 담당 -> ?? JSP를 편하게 하고 싶다.
 	
 	5.3 Model2기반의 MVC
 		Model(DAO,DTO) > 자바클래스
 		View > JSP(EL,JSTL)
 		Controller > Servlet extends HttpServlet (웹 상황실..)
 		
 		1)클라이언트의 요청 파악(로그인, 게시판 글쓰기 , 게시판 상세보기)
 		2)요청을 파악(필요에 따라서 Model객체를 생성, 사용하거나 View를 사용할 수 있다.)
 
 6.Servlet파일을 클라이언트가 요청하는 방법
 	6.1 <form action="loginok.jsp" method="">
  		localhost:8090/WebServlet_1/loginok.jsp
  	
  	6.2 <url-pattern>/simple</url-pattern>
  		<form action="/simple" method="POST">
  		localhost:8090/WebServlet_1/simple 이 왓을 때
  		최초 요청이라면 servlet은 컴파일 되고 실행된다. doGet,doPost가 호출된다.
  		
  
	  Web.xml
	  <servlet>
	  	<servlet-name>simplecontroller</servlet-name>
	  	<servlet-class>com.SimpleController</servlet-class>
	  </servlet>
	  <servlet-mapping>
	  	<servlet-name>simplecontroller</servlet-name>
	  	<url-pattern>/simple</url-pattern>
	  </servlet-mapping>
 */
//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SimpleController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청");
		//1.사용자의 요청 파악(요청 값 받기) 
		String type = request.getParameter("type");
		
		//2.요청에 따른 업무수행(service 실행)
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			resultobj = "hello world";
		}else if(type.equals("date")){
			resultobj = new java.util.Date();
		}else {
			resultobj = "invalid data type";
		}
		
		//3.요청 완료에 따른 그 결과를 요청한 사용자에게 전달
		//정보를 저장 : request , session , application 객체를 사용해서
		request.setAttribute("result",resultobj);
		
		//4.결과 보여주기 >>필요한 view 지정한다.
		//화면을 출력할 페이지를 정하고 -> 출력할 데이터를 넘겨 주어야 한다. -> forward(제어권을 넘긴다.)
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		dis.forward(request,response); //forward 된 페이지에 request주소값 전달
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
