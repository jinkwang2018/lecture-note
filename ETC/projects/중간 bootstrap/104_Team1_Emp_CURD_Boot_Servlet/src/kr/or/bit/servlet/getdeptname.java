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

@WebServlet("/getdeptname")
public class getdeptname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getdeptname() {
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
			
			Empdao dao = new Empdao();
			ArrayList<String> deptnamelist = dao.get_deptnames();
			JSONArray jsonlist = JSONArray.fromObject(deptnamelist);
			
			System.out.println(jsonlist);
			
			response.getWriter().print(jsonlist);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
