package kr.or.bit.service;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dto.JoinDto;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.JoinDao;



public class JoinService  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		 String id = request.getParameter("id");
		 String email = request.getParameter("email");
		 String name = request.getParameter("name");
		 String pwd = request.getParameter("pwd");
		 int pno = Integer.parseInt(request.getParameter("pno"));
		 String pwdcheck = request.getParameter("pwdcheck");
	
		 JoinDto joindto = new JoinDto();
		 joindto.setId(id);
		 joindto.setEmail(email);
		 joindto.setPwd(pwd);
		 joindto.setPno(pno);
		 joindto.setName(name);
		 joindto.setPwdcheck(pwdcheck);

		 JoinDao joindao = null;
		 
		 try {
			joindao = new JoinDao();
			int n = joindao.insertjoin(id, pwd, pwdcheck, name, pno, email);
			 
		} catch (SQLException e) {	
			e.printStackTrace();
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("Login.jsp");
		
		return forward;
	}

}
