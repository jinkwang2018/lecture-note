package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.memodao;


@WebServlet("/MemoId")
public class MemoId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemoId() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
		  String id = request.getParameter("id");
		  System.out.println("id : " + id);
			  memodao dao;
			try {
				dao = new memodao();
				String idcheck = dao.isIdCheckById(id);
				 out.print(idcheck); //true ,false 문자
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		  
		  
		 
		  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
