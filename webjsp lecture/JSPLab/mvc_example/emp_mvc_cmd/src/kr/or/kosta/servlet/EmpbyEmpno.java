package kr.or.kosta.servlet;

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

import kr.or.kosta.dao.Empdao;
import kr.or.kosta.dto.Emp;

@WebServlet("/EmpbyEmpno")
public class EmpbyEmpno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpbyEmpno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@SuppressWarnings("unchecked")
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//최종 완성될 JSONObject 선언(전체)
        int empno = Integer.parseInt(request.getParameter("empno"));
        System.out.println("empno: " + empno);
		try {
			Empdao dao = new Empdao();
			Emp e = dao.getEmpListByEmpno(empno);
	        JSONObject deptnoinfo = new JSONObject();
	        deptnoinfo.put("empno", e.getEmpno());
	        deptnoinfo.put("ename", e.getEname());
	        deptnoinfo.put("job", e.getJob());
	        deptnoinfo.put("mgr", e.getMgr());
	        deptnoinfo.put("hiredate", e.getHiredate().toString());
	        deptnoinfo.put("sal", e.getSal());
	        deptnoinfo.put("comm", e.getComm());
	        deptnoinfo.put("deptno", e.getDeptno());
	        
			out.print(deptnoinfo);
			System.out.println("얏타! " + deptnoinfo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}