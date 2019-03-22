package kr.or.kosta.Emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosta.DAO.empDAO;
import kr.or.kosta.DTO.empDTO;


@WebServlet("/EmpEdit")
public class EmpEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EmpEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int empno = Integer.parseInt(request.getParameter("empdata_edit"));
		System.out.println("수정 empdata : " + empno);
		try{
			
			empDAO dao = new empDAO();
            empDTO empedit = dao.getMember(empno);
            
           
           //요청 결과 저장
           HttpSession session = request.getSession();
           session.setAttribute("editinfo", empedit);
          
          
          //view 정의
          RequestDispatcher dis = request.getRequestDispatcher("modal.jsp");
          dis.forward(request, response);
           
         
        } catch (Exception e) { 

           System.out.println(e.getMessage()); 

        } 
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
