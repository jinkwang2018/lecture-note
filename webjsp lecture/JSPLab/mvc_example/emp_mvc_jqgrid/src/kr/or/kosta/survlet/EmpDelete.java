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
import kr.or.kosta.dto.DTO;

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
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			DAO dao= new DAO();
			DTO dto =new DTO();
			String empno = request.getParameter("empno");
			dto.setEmpno(empno);
			int result=dao.deleteList(dto.getEmpno());
			
			boolean success = false;
			if(result != 0){
				success = true;
			}else{
				success = false;
			}
			out.print(success);
			
		} catch (Exception e) {
			out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
		}

	}
}