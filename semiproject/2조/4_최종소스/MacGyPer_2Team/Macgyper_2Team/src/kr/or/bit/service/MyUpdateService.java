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



public class MyUpdateService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException, IOException {
		ActionForward forward = null;
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
		  	   if(count>0) {
		  		   System.out.println("수정성공");
		  		   request.setAttribute("msg", "수정성공");
		  		   request.setAttribute("id", id);
		  			forward = new ActionForward();
		  			forward.setRedirect(false);
		  			forward.setPath("join/redirect.jsp");
	
		 	   	}else {
		 	   	  System.out.println("수정실패");
		 	   	request.setAttribute("msg", "수정실패");
		     	request.setAttribute("id", id);
		 	   	forward = new ActionForward();
	  			forward.setRedirect(false);
	  			forward.setPath("join/redirect.jsp");
		 	   	}
		  }catch(Exception e) {
		  	 System.out.println(e.getMessage());
		  }
		return forward;
	}

}
