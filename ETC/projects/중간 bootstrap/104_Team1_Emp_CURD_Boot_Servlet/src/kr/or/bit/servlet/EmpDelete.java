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
 * Servlet implementation class EmpDelete
 */
@WebServlet("/EmpDelete")
public class EmpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//System.out.println("오긴 오니???");
		
		request.setCharacterEncoding("UTF-8");

		int empno = Integer.parseInt(request.getParameter("empno"));

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Empdao dao = new Empdao();
			int n = dao.deleteEmp(empno);
			if (n > 0) {
				out.print("<script>");
				out.print("alert('삭제성공');");
				out.print("</script>");
				out.print("<script>location.href='tables.jsp'</script>");
			} else {
				// int resultrow=0;
				// DAO insert >> 예외 >> return 0
				// 의미 : int resultrow=0;
				out.print("<script>");
				out.print("alert('삭제실패');");
				out.print("</script>");
				out.print("<script>location.href='tables.jsp'</script>");
			}
		} catch (Exception e) { // PK , varchar2(10) -> 20Byte ....
			out.print("<b> 오류 :" + e.getMessage() + "</b>");
		}
	}
}
