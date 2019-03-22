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
import kr.or.kosta.service.MemoAddService;
import kr.or.kosta.service.MemoIdCheckService;
import kr.or.kosta.service.MemoListService;


@WebServlet("*.memo")
public class FrontmemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontmemoServlet() {
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
		
		
		
		Action action= null;
		ActionForward forward = null;
		
		if(url_command.equals("/MemoAdd.memo")) {
			try {
				  action = new MemoAddService();
				  forward = action.execute(request, response);
				  System.out.println("forward : 글쓰기") ;
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/MemoList.memo")) {
			try {
				  action = new MemoListService();
				  forward = action.execute(request, response);
				  
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url_command.equals("/MemoId.memo")) {
			try {
				  action = new MemoIdCheckService();
				  forward = action.execute(request, response);
			}catch (Exception e) {
				
			}
		}
		
		if(forward !=null) {
			if(forward.isRedirect()) { //true
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		
		
	}

}





