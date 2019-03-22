package kr.or.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.Empdao;
import kr.or.bit.utils.Emp;


@WebServlet("/Listservletok")
public class Listservletok extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Listservletok() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
	
		 PrintWriter out = response.getWriter();

		 Emp emp = new Emp();
		 System.out.println("처음");/*
		 System.out.println(request.getParameter("empno"));
		 emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		 System.out.println("1");
		 emp.setEname(request.getParameter("ename"));
		 System.out.println("2");
		 emp.setJob(request.getParameter("job"));
		 System.out.println("3");
		 emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
		 emp.setHiredate(request.getParameter("hiredate"));
		 System.out.println(request.getParameter("hiredate"));
		 emp.setSal(Integer.parseInt(request.getParameter("sal")));
		 System.out.println("4");
		 emp.setComm(Integer.parseInt(request.getParameter("comm")));
		 System.out.println("5");
		 emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		 System.out.println("6");
		 */
		 try {
		 Empdao dao = new Empdao();
		 int result = dao.updateemp(emp);
		 
		 if(result>0) {
			 	
		     	out.print("<script>");
			 	out.print("location.href='Listservlet'");
		     	out.print("</script>");
		     	
		
		 }else {
			 
		 }
		 }catch(Exception e) {
			 out.print("<b> 오류 :" + e.getMessage() + "</b>");
		 }
	
	}

}
