package kr.or.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.dao.Empdao;
import kr.or.kosta.dto.Emp;

@WebServlet("*.do")
public class EmpFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmpFrontController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException | SQLException e) {
			System.out.println("doGet에러발생: " + e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException | SQLException e) {
			System.out.println("doPost에러발생: " + e.getMessage());

		}
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException {
		
		String command = request.getParameter("cmd").trim();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//2. 요청 판단 처리
		String viewpage="";
		
		if(command.equals("Insert")) {//EmpInSert.java
			int empno=Integer.parseInt(request.getParameter("empno"));
			String ename=request.getParameter("ename");
			String job=request.getParameter("job");
			int sal=Integer.parseInt(request.getParameter("sal"));
			int mgr=Integer.parseInt(request.getParameter("mgr"));
			String hiredate=request.getParameter("hiredate");
			int comm=Integer.parseInt(request.getParameter("comm"));
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			
			try {
				Empdao dao=new Empdao();
				int n=dao.insertEmp(empno, ename,job,mgr,hiredate,sal,comm,deptno);
				System.out.println(hiredate);
				System.out.println(n);
				
				}catch(Exception e) {
				
			}
			viewpage = "/WEB-INF/Emp/EmpInsert.jsp";
		}
		else if(command.equals("Delete")) {//EmpDelete.java
			String empno = request.getParameter("empno");
	    	  Empdao dao = new Empdao();
			  int deleteemp = dao.deleteEmp(empno);
			  viewpage = "/WEB-INF/Emp/EmpUpDe.jsp";
		}
		else if(command.equals("Update")) {//EmpUpdate.java
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			String hiredate = request.getParameter("hiredate");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			
			try {
				Empdao dao = new Empdao();
				int n = dao.updateEmp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} catch (Exception e) {
			}
			viewpage = "/WEB-INF/Emp/EmpUpDe.jsp";

		}
		else if(command.equals("UpDe")) {
			viewpage = "/WEB-INF/Emp/EmpUpDe.jsp";
		}
		else if(command.equals("Emp")) {
			viewpage = "/WEB-INF/Emp/EmpAllSearch.jsp";
		}
		else if(command.equals("EmpInsert")) {
			viewpage = "/WEB-INF/Emp/EmpInsert.jsp";
		}
		else if(command.equals("UpdateForm")) {
			viewpage = "/WEB-INF/Emp/UpdateForm.jsp";
		}
		

		//4. view 지정
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
	
	//5. forward 
		dis.forward(request, response);
	}

}







