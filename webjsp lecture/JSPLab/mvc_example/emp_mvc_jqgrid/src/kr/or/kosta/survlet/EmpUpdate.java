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

import org.json.simple.JSONObject;

import kr.or.kosta.dao.DAO;
import kr.or.kosta.dto.DTO;


@WebServlet("/EmpUpdate")
public class EmpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EmpUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		try{
			DAO dao= new DAO();
			DTO dto =new DTO();
			dto.setEmpno(empno);
			dto.setEname(ename);
			dto.setJob(job);
			dto.setMgr(mgr);
			dto.setSal(sal);
			dto.setComm(comm);
			dto.setDeptno(deptno);
			
			int result=dao.UpdateList(dto);
			
			
			boolean success = false;
			if(result!=0){
				success = true;		
			}else{
				success = false;
			}
			out.print(success);
			
		}catch(Exception e){
			out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
		}
    }
}
