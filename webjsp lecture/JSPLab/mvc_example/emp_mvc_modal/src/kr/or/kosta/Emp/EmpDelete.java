package kr.or.kosta.Emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.DAO.empDAO;


@WebServlet("/EmpDelete")
public class EmpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpDelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int empno=Integer.parseInt( request.getParameter("empdata_del"));
		//System.out.println("삭제 empdata: " + empno);
		empDAO dao = new empDAO();
		
		int result = dao.delete(empno);
		
		response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out = response.getWriter();
		if(result >0){
			out.print("<script>alert('삭제 성공!');</script>");
		}else{
			out.print("<script>alert('삭제 실패!');</script>");
		}
		 //out.flush();
		 RequestDispatcher dis = request.getRequestDispatcher("EmpList");
         dis.forward(request, response);
        
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
