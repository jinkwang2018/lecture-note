package kr.or.kosta.survlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.DAO;
import kr.or.kosta.dto.DTO;

@WebServlet("/EmpInsert")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmpInsert() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
	    java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(javaTime);

		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");

		try{
			DAO dao= new DAO();
			DTO dto =new DTO(empno,ename,job,mgr,sqlDate,sal,comm,deptno);
			int result=dao.InsertList(dto);
			boolean success = false;
			
			if(result != 0){
				success = true;
		    }else{
		    	success = false;
		    }
			out.print(success);
	
		}catch(Exception e){
			out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
		}
	}
	
}
