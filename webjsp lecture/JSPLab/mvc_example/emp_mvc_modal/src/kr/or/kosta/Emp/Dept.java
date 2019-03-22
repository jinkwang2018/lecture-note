package kr.or.kosta.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import kr.or.kosta.DAO.empDAO;
import kr.or.kosta.DTO.empDTO;


@WebServlet("/Dept")
public class Dept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Dept() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");//1.한글처리
		
		String dname  = request.getParameter("dname");
		//System.out.println("이름:" +dname);
		empDAO edao = new empDAO();
		
		ArrayList<empDTO> dlist =  edao.d_name();

		ArrayList<empDTO> deptlist =  edao.serachDept(dname);
		

		JSONArray jsonarr = JSONArray.fromObject(deptlist);
	
		request.setAttribute("dnamelist", dlist);
		request.setAttribute("jsonlist", jsonarr);
		
		/*PrintWriter out = response.getWriter();
		response.setContentType("application/x-json; charset=UTF-8");
		  out=response.getWriter();
		  out.print(jsonarr);
		  out.flush();
		  */

	   RequestDispatcher dis = request.getRequestDispatcher("/dept.jsp");
		
		dis.forward(request, response);
				
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
