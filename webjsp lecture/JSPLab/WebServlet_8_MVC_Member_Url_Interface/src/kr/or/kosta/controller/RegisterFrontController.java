package kr.or.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.MvcRegisterDao;
import kr.or.kosta.dto.MvcRegister;
import kr.or.kosta.service.LoginProcessAction;
import kr.or.kosta.service.MemberWriteAction;

//@WebServlet("/Register.do")
//회원가입 <a href="Register.do?cmd=register">회원가입</a>
//위 코드는 요청주소가 고정되어잇다.
//parameter를 통해서 페이지를 바꾸어 준다.
//Url 방식 > 주소 고정 > "/Register.do" 처리 
// "*.do" 처리  > a.do , b.do , c.do

@WebServlet("*.do")
public class RegisterFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterFrontController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String url_command = RequestURI.substring(ContextPath.length());
		
		//추가 코드
		ActionForward forward = null; //redirect와 path정보 갖는 클래스
		Action action = null; //인터페이스 ActionForward 타입을 리턴하는 execute 함수

		//CODE 제공
		//UI 제공
		if(url_command.equals("/Register.do")) { //?cmd=register
			forward = new ActionForward();        //UI 제공
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/Register/Register.jsp");	
			
			//key point : execute(HttpServletRequest request, HttpServletResponse response)
			//execute (내가 받은 요청 객체 주소, 응답객체 주소)
			//이 request에는 : request.getParameter("id");
		}else if(url_command.equals("/ok.do")) {
			//CODE 제공(업무처리)
			action = new MemberWriteAction(); //다형성 //CODE 제공
			forward = action.execute(request, response);
			
		}else if(url_command.equals("/login.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);        //UI 제공
			forward.setPath("/WEB-INF/Register/login.jsp");		
		}else if(url_command.equals("/loginok.do")) {
			
			action = new LoginProcessAction(); //다형성 //CODE 제공
			forward = action.execute(request, response);	
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
				//request -> MemberWriteAction 에서 넘겨준 주소가 담겨있다. 내가 넘겨준 주소와 같다.
			}
		}
	}

}







