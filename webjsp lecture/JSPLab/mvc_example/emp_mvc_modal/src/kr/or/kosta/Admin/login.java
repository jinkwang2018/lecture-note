package kr.or.kosta.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.DAO.AdminListDAO;
import kr.or.kosta.DTO.AdminListDTO;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		AdminListDAO admindao = new AdminListDAO();
		AdminListDTO admindto = new AdminListDTO();
		
		AdminListDTO loginprocess =  admindao.login(id);
		if(loginprocess != null){
			HttpSession session = request.getSession();
			session.setAttribute("userid", loginprocess.getUserid());
		}
		
		 RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
         dis.forward(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
