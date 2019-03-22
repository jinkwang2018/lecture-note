package kr.or.bmark.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.service.MemberLoginService;
import kr.or.bmark.service.MemberLogoutService;
import kr.or.bmark.service.MemberRegisterIdCheckService;
import kr.or.bmark.service.MemberRegisterService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());

        ActionForward forward = new ActionForward();
        Action action = null;

        // 회원가입 요청이 들어왔을때, ok
        if(cmdURI.equals("/register.member")){
        	forward.setRedirect(false);
        	forward.setPath("/views/register.jsp");
        }
        
        // 회원가입 요청의 db처리 , ok
        else if(cmdURI.equals("/registerok.member")){
        	action = new MemberRegisterService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 로그인 처리요청
        else if(cmdURI.equals("/login.member")){
        	action = new MemberLoginService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 로그아웃 처리요청
        else if(cmdURI.equals("/logout.member")){
        	action = new MemberLogoutService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 아이디 Check
        else if(cmdURI.equals("/idcheck.member")){
        	action = new MemberRegisterIdCheckService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        /*RequestDispatcher dis = request.getRequestDispatcher(viewPage);
        dis.forward(request, response);*/
        if(forward != null){
        	if(forward.isRedirect()) {
        		response.sendRedirect(forward.getPath());
        	}
        	else {
        		RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
        		dis.forward(request, response);
        	}
        }
        
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doProcess(request, response);
   }

}
