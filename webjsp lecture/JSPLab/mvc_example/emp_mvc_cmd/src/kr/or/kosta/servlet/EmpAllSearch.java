package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.dao.Empdao;
import kr.or.kosta.dto.Emp;

/**
 * Servlet implementation class EmpAllSearch
 */
@WebServlet("/EmpAllSearch")
public class EmpAllSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpAllSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@SuppressWarnings("unchecked")
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String cp = request.getParameter("cp");
		//최종 완성될 JSONObject 선언(전체)
        JSONObject jsonObject = new JSONObject();
        //deptno의 JSON정보를 담을 Array 선언
        JSONArray deptnolist = new JSONArray();

		try {
			Empdao dao = new Empdao();
			ArrayList<Emp> Dlist = dao.getEmpList(Integer.parseInt(cp));
			for(int i = 0; i < Dlist.size(); i++) {
				Emp e = Dlist.get(i);
		        //deptno의 한명 정보가 들어갈 JSONObject 선언
		        JSONObject deptnoinfo = new JSONObject();
		        deptnoinfo.put("empno", e.getEmpno());
		        deptnoinfo.put("ename", e.getEname());
		        deptnoinfo.put("job", e.getJob());
		        deptnoinfo.put("mgr", e.getMgr());
		        deptnoinfo.put("hiredate", e.getHiredate().toString());
		        deptnoinfo.put("sal", e.getSal());
		        deptnoinfo.put("comm", e.getComm());
		        deptnoinfo.put("deptno", e.getDeptno());
		        
		        deptnolist.add(deptnoinfo);
			}
			jsonObject.put("emplist", deptnolist);

			out.print(jsonObject);
			System.out.println(jsonObject);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
