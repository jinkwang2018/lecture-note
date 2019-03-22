package kr.or.kosta.survlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.dao.DAO;

@WebServlet("/EmpCount")
public class EmpCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpCount() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		DAO dao= new DAO();
		int result=dao.countemp();
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("count", result);
		response.getWriter().print(jsonobject);
		//response.addHeader("Refresh", "5");
		//request.setAttribute("count", result);
		//RequestDispatcher dis = request.getRequestDispatcher("/dynamicemp.jsp");
		//dis.forward(request, response);
	}
}
