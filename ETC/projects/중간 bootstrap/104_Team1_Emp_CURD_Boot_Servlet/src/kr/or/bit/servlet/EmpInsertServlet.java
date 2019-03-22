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

/**
 * Servlet implementation class EmpInsertServlet
 */
@WebServlet(description = "insert입니다.", urlPatterns = { "/EmpInsertServlet"})
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset='UTF-8'");

		Empdao dao = new Empdao();
		PrintWriter out = response.getWriter();
		Emp dto = new Emp();
		dto.setEmpno(Integer.parseInt(request.getParameter("empno")));
		dto.setEname(request.getParameter("ename"));
		dto.setJob(request.getParameter("job"));
		dto.setMgr(Integer.parseInt(request.getParameter("mgr")));
		dto.setHiredate(request.getParameter("hiredate"));
		dto.setSal(Integer.parseInt(request.getParameter("sal")));
		dto.setComm(Integer.parseInt(request.getParameter("comm")));
		dto.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		if (0 < dao.insertEmp(dto)) {
			out.print("<script>location.href='tables.jsp'</script>");
		} else {
			out.print("<script>location.href='tables.jsp'</script>");
		}

		// 코드 구성
	}

}
