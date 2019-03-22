package kr.or.bit.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.IdCheckService;
import kr.or.bit.service.JoinDeleteService;
import kr.or.bit.service.JoinEditService;
import kr.or.bit.service.JoinService;
import kr.or.bit.service.JoinListService;
import kr.or.bit.service.LoginOkService;
import kr.or.bit.service.MyEditService;
import kr.or.bit.service.MyUpdateService;


@WebServlet("*.ch")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinController() {
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
		
		ActionForward forward = null; 
		Action action = null;
		forward = new ActionForward();
		if(url_command.equals("/joinok.ch")) { 
		
			forward.setRedirect(false);
			forward.setPath("/joinok.jsp");
			
		}else if(url_command.equals("/adminlist.ch")) { 
		
			forward.setRedirect(false);
			forward.setPath("/join/JoinList.jsp");
			
		}else if(url_command.equals("/joingo.ch")) { 
		
			forward.setRedirect(false);
			forward.setPath("/join/Join.jsp");
			
		}else if(url_command.equals("/loginok.ch")) { 
		
			action = new LoginOkService(); 
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		else if(url_command.equals("/join.ch")) { 
		
			action = new JoinService(); 
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}else if(url_command.equals("/joinlist.ch")) {
		
			action = new JoinListService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/idcheck.ch")) {
			
			action = new IdCheckService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/joindelete.ch")) {
			
			action = new JoinDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/joinedit.ch")) {
			action = new JoinEditService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/myedit.ch")) {
			action = new MyEditService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		else if(url_command.equals("/request.getContextPath()/myedit.ch")) {
			action = new MyEditService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		else if(url_command.equals("/myupdate.ch")) {
			action = new MyUpdateService();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		
		else if(url_command.equals("/chartAPI.ch")) { 
		      
	         forward.setRedirect(false);
	         forward.setPath("/join/ChartAPI.jsp");
	         
	      }
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
				
			}
		}
		
	}

}







