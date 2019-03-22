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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.dao.DAO;
import kr.or.kosta.dto.DTO;


@WebServlet("/EmpList")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JSONArray jsonarray = new JSONArray();
		
		try {
			
			DAO dao = new DAO();
			
			// 디비로 부터 데이터 조회
			ArrayList<DTO> dtoArr = dao.EmpList();
			
			DTO dto = new DTO();
			
			// 조회된 배열 데이터를 jsonObject로 
			for(int i=0; i<dtoArr.size(); i++){
				
				dto = dtoArr.get(i);
				JSONObject jsonobject = new JSONObject();	// 담아줄 객체를 새로 생성
				
				// dto 객체를 jsonObject 객체로 이동
				jsonobject.put("empno", dto.getEmpno());
				jsonobject.put("ename", dto.getEname());
				jsonobject.put("comm", dto.getComm());
				jsonobject.put("deptno", dto.getDeptno());
				jsonobject.put("hiredate", dto.getHiredate().toString());
				jsonobject.put("job", dto.getJob());
				jsonobject.put("mgr", dto.getMgr());
				jsonobject.put("sal", dto.getSal());
				jsonobject.put("button", "<a class='btn btn-sm btn-primary' href='javascript:void(0)' title='Edit' onclick='edit_person(" + dto.getEmpno() + ")'><i class='glyphicon glyphicon-pencil'></i> Edit</a>" +
										 "<a class='btn btn-sm btn-danger' href='javascript:void(0)' title='Hapus' onclick='delete_person(" + dto.getEmpno() + ")'><i class='glyphicon glyphicon-trash'></i> Delete</a>");
				jsonarray.add(jsonobject);
			}
		} catch(Exception e) {
			out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
		}
		response.getWriter().print(jsonarray);
	}
	
}
