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

@WebServlet("/Listservlet")
public class Listservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Listservlet() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 전체 데이터 조회
			Empdao dao = new Empdao();
			ArrayList<Emp> Emplist = dao.getEmpList();
			JSONArray jsonlist = JSONArray.fromObject(Emplist);
			// 요청 결과 저장
			
			System.out.println(jsonlist);
			// view 페이지 설정
			/*RequestDispatcher dis = request.getRequestDispatcher("tables.jsp");
			dis.forward(request, response);*/
			
			response.getWriter().print(jsonlist);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
