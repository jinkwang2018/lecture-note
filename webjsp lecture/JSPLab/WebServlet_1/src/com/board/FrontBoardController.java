package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/FrontBoardController")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontBoardController() {
        super();
       
    }

	//Get , Post 방식의 요청에 대해서 같은 동작을 하고 싶다. 
    //1. servlet 제공하는 함수 : service()함수가 있지만
    //2. 만들어서 사용 하고 싶다  : doProcess()로
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
    	//do get과 post에 대한 모든 요청을 처리 할 수 있다. 
    	System.out.println("클라이언트 요청 : " + method);
    	
    	//1. 요청 받기 (GET,POST)
    	//요청 주소 : http://localhost:8090/WebServlet_1/board?cmd=list
    	String cmd = request.getParameter("cmd");
    	    	
    	//2. 요청 판단(판단의 기준) : command 방식 (parameter), url 방식(url)
    	//2.1 parameter 기준으로
    	//2.2 /board?cmd=login&userid=kglim
    	//String str = request.getParameter("cmd")
    	//if(str.equals("login")){로그인 처리}
    	
    	//TIP : URL 주소로 판단하는 방법도 있다. : board/boardlist
    	//							    board/boardwrite?title=aaa&content=bbb
    	//마지막 주소 문자 : boardlist 게시판 목록보기
    	//			  boardwrite 게시판 글쓰기
    	//문제 : 클라이언트 서버있는 페이지 주소 직접 입력 하면 접근 안되게 해야한다.
    	//보안폴더 > WEB-INF로 넣으면 된다. 클라이언트가 직접 접근 불가
    	//1. WEB-INF 접근 : 404 Error 
    	//2. WEB-INF 활용 : views > board > list.jsp
    	//				  views > member > memberof.jsp
    	//**** > 서버쪽에서 forward로만 접근 할 수 잇게 한다.
    	
    	//업무에 따라서 정한다.
    	String viewpage = null;
    	//cmd > null > error.jsp
    	//cmd > boardlist > list.jsp
    	//cmd > boardwrite > write.jsp
    	if(cmd==null) {
    		viewpage = "/error/error.jsp";
    	}else if(cmd.equals("boardlist")) {
    		viewpage = "/board/boardlist.jsp";
    		//DB연결
    		//select
    		//실행 > 결과(rs) > 객체담기
    		//boarddao dao = new boarddao();
    		//List<board> boardlist = dao.selectboardlist();
    		//request.setAttribute("list",boardlist);
    		//view page forward 방식으로 받아서
    		//<c:set var = "list" value="<%=request.getAttribute('list')>"
    		//for or each로 화면에 뿌리기
    		
    	}else if(cmd.equals("boardwrite")) {
    		viewpage = "/board/boardwrite.jsp";
    	}else if(cmd.equals("login")) {
    		viewpage = "/WEB-INF/login/login.jsp";
    	}else {
    		viewpage = "/error/error.jsp";
    	}
    	//3.결과 저장
    	//List<Emp> list = new ArrayList<>();
    	//list.add(new Emp(2000,"홍길동"));
    	//request.setAttribute("emplist",list)

    	//4.forward 방식으로 view를 지정한다.
    	RequestDispatcher dis = request.getRequestDispatcher(viewpage);
    	
    	//5. view forward 방식을 통해서(view에게 정보 전달 : request)
    	dis.forward(request,response); //servlet이 가지고 있는 request 객체의 주소를 view에게 전달하기
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"Get");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"Post");
		
	}

}
