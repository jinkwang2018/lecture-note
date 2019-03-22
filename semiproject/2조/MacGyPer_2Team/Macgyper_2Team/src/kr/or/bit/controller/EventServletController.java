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
import kr.or.bit.service.EventAddService;
import kr.or.bit.service.EventDeleteService;
import kr.or.bit.service.EventListService;
import kr.or.bit.service.EventUpdateService;

@WebServlet("*.event")
public class EventServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EventServletController() {
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
		System.out.println(url_command);
		
		
		Action action= null;
		ActionForward forward = null;
		System.out.println("이벤트 컨트롤러 들어왔?");
		if(url_command.equals("/EventAdd.event")) {
			try {
				  action = new EventAddService();//------------------------service
				  forward = action.execute(request, response);
				  
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/EventList.event")) {
			try {
				System.out.println("이벤트 컨트롤러 서비스로 들어왔?");
				  action = new EventListService();//------------------------service
				  forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/EventDelete.event")) {
			try {
				  action = new EventDeleteService();//------------------------service
				  forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(url_command.equals("/EventUpdate.event")) {
			try {
				  action = new EventUpdateService();//------------------------service
				  forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
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





