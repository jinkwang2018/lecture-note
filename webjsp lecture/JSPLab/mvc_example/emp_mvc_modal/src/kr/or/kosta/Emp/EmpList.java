package kr.or.kosta.Emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.DAO.empDAO;
import kr.or.kosta.DTO.empDTO;


@WebServlet("/EmpList")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmpList() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	empDAO edao = new empDAO();
		
		ArrayList<empDTO> empgetlist =  edao.getMemberList();
		
		
		request.setAttribute("emplist", empgetlist);
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("/memberlist.jsp");
		
		dis.forward(request, response);
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
