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
import kr.or.kosta.DTO.empDTO;


@WebServlet("/EmpInsert")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
         
         request.setCharacterEncoding("UTF-8");//1.한글처리
         response.setContentType("text/html; charset=UTF-8");
         
         int empno = Integer.parseInt(request.getParameter("empno"));
         String ename = request.getParameter("ename").toUpperCase();
         String job = request.getParameter("job").toUpperCase();
         int mgr = Integer.parseInt(request.getParameter("mgr"));
		 String hiredate = request.getParameter("hiredate");      
         int sal = Integer.parseInt(request.getParameter("sal"));
         int comm = Integer.parseInt(request.getParameter("comm"));
         int deptno = Integer.parseInt(request.getParameter("deptno")); 

          
            empDTO dto = new empDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
            empDAO dao = new empDAO();
            
            int n = dao.insert(dto);
            
            PrintWriter out = response.getWriter();
            String pageview="";
            if(n !=0){
               pageview="EmpList";
            
            
            }else{
               pageview="/index.jsp";
               
            }
            	//out.flush();
               
               RequestDispatcher dis = request.getRequestDispatcher(pageview);
               
               dis.forward(request, response);
     		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
