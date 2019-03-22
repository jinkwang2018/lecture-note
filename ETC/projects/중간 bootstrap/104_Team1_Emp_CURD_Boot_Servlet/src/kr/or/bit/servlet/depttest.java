package kr.or.bit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.Empdao;
import kr.or.bit.utils.Emp;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class depttest
 */
@WebServlet("/depttest")
public class depttest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public depttest() {
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
	  
		 int deptno = Integer.parseInt(request.getParameter("deptno"));
		 System.out.println(deptno);
		
		 ArrayList<Emp> Emplist = new ArrayList<>();
		 Empdao dao = new Empdao();
		 Emplist = dao.dept_search(deptno);
		 		 
		 JSONArray jsonlist = JSONArray.fromObject(Emplist);
		 response.getWriter().print(jsonlist);
		
	}	
}
