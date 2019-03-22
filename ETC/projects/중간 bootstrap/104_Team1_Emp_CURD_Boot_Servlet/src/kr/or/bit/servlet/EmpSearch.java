package kr.or.bit.servlet;
import java.util.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.Empdao;
import kr.or.bit.utils.Emp;
import net.sf.json.JSONArray;

@WebServlet("/EmpSearch")
public class EmpSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSearch() {
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
	  
		 int empno = Integer.parseInt(request.getParameter("empno"));

		 Empdao dao = new Empdao();
		 Emp emp = dao.emp_search(empno);
		 ArrayList<Emp> Emplist = new ArrayList<>();
		 
		 if(emp != null) {
			 Emplist.add(emp);
		 }
		 
		 JSONArray jsonlist = JSONArray.fromObject(Emplist);
		 response.getWriter().print(jsonlist);
		
	}	
}
