package kr.or.kosta.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.DAO.empDAO;
import kr.or.kosta.DTO.empDTO;


@WebServlet("/EmpEditOk")
public class EmpEditOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpEditOk() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   request.setCharacterEncoding("UTF-8");
	       response.setContentType("text/html;charset=UTF-8");
	       PrintWriter out = response.getWriter();

	       
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename =request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
		   String hiredate = request.getParameter("hiredate");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
		
			
				empDAO dao = new empDAO();
				empDTO dto = new empDTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setJob(job);
				dto.setMgr(mgr);
				dto.setHiredate(hiredate);
				dto.setSal(sal);
				dto.setComm(comm);
				dto.setDeptno(deptno);
				
				
				
					int result;
					try {
						result = dao.update(dto);
					
				

				String viewpage="";
				
				if(result>0){
					out.print("<script>alert('등록 성공!');</script>");
					viewpage="EmpList";
					
		         }else{
		        	out.print("<script>alert('등록 실패');</script>");
		        	viewpage="/memberedit.jsp";
		         }
				
				
				
				 response.setContentType("text/html; charset=UTF-8");
				 RequestDispatcher dis = request.getRequestDispatcher(viewpage);
			
				 dis.forward(request, response);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
