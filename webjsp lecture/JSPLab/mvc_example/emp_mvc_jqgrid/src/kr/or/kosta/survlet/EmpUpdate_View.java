package kr.or.kosta.survlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.dao.DAO;
import kr.or.kosta.dto.DTO;

@WebServlet("/EmpUpdate_View")
public class EmpUpdate_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpUpdate_View() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		DAO dao= new DAO();
		DTO dto =new DTO();
		String empno = request.getParameter("empno");
		dto.setEmpno(empno);
		JSONObject jsonobject = new JSONObject();
		DTO rs = dao.ViewList(empno);
		try {
				jsonobject.put("empno", rs.getEmpno());
				jsonobject.put("ename", rs.getEname());
				jsonobject.put("comm", rs.getComm());
				jsonobject.put("deptno", rs.getDeptno());
				jsonobject.put("hiredate", rs.getHiredate().toString());
				jsonobject.put("job", rs.getJob());
				jsonobject.put("mgr", rs.getMgr());
				jsonobject.put("sal", rs.getSal());
			
		} catch(Exception e) {
			out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
		}

		response.getWriter().print(jsonobject);
	}
}
