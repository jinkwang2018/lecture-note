package com.bit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "이 녀석은 controller 입니다.", urlPatterns = { "/Front.do" })
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FrontServletController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청들어옴");
		//localhost:8090/WebServlet_1/Front.do?cmd=greeting
		String command = request.getParameter("cmd");
		
		String m = "";
		if(command.endsWith("greeting")) {
			Message msg = new Message();
			m = msg.getMessage(command);
		}
		request.setAttribute("msg",m);
		
		//view
		RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청들어옴");
	}

}
