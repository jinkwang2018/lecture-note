package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.JoinDao;
import kr.or.bit.dto.JoinDto;
import net.sf.json.JSONArray;



public class JoinEditService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException, IOException {
		 try {	
		  	   String id = request.getParameter("id");
		  	   String pwd = request.getParameter("pwd");
		  	   String pwdcheck = request.getParameter("pwdcheck");
		  	   String name = request.getParameter("name");
		  	   int pno = Integer.parseInt(request.getParameter("pno"));
		  	   String email = request.getParameter("email");
		  	   JoinDto dto = new JoinDto();
		  	   dto.setId(id);
		  	   dto.setPwd(pwd);
		  	   dto.setPwdcheck(pwdcheck);
		  	   dto.setName(name);
		  	   dto.setPno(pno);
		  	   dto.setEmail(email);
		  	   JoinDao dao = new JoinDao();
		  	   int count = dao.getUpdateJoin(dto);
		  	   response.getWriter().print(count);
		  
		  }catch(Exception e) {
		  	 System.out.println(e.getMessage());
		  }
		ActionForward forward = null;
		return forward;
	}
}
