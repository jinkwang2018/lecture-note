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


@WebServlet("/EmpSearch")
public class EmpSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");  //out print 한글처리  (던질때 한글처리 주의!)
	 
		
    		String name= request.getParameter("search").toUpperCase();
    		
    		empDAO edao = new empDAO();
    		
    		int memcount = edao.countMember(name);
    		ArrayList<empDTO> searchlist = edao.search(name);
    		
    		request.setAttribute("semplist", searchlist);
    		request.setAttribute("count", memcount);
    		

    		RequestDispatcher dis = request.getRequestDispatcher("/searchedlist.jsp");
    		
    		dis.forward(request, response);
    		
    		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
