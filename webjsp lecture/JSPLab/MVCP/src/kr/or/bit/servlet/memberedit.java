package kr.or.bit.servlet;

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

@WebServlet("/memberedit")
public class memberedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberedit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 System.out.println("넘어옴");
		 
		 PrintWriter out = response.getWriter();
		 out.print("<script>alert('dd')</script>");
		 int empno = Integer.parseInt(request.getParameter("empno")); 
		 //primary key empno 값을 받아 한명의 emp를 찾는다
		 //선택조회를 이용한다. 정권오빠
		 System.out.println(empno);
		   
		 
		 System.out.println("empno : " + empno);
		 Emp emp = new Emp();
		 Empdao dao = new Empdao();
		 emp = dao.emp_search(empno);
		 System.out.println(emp);
			request.setAttribute("empedit", emp);
			System.out.println("여기는 언제 실행??");
		 
		 RequestDispatcher dis = request.getRequestDispatcher("tables.jsp");
		 //deit.jsp 에서 수정가능 테이블을 display한다.
	
		dis.forward(request, response);
			
	}

}
