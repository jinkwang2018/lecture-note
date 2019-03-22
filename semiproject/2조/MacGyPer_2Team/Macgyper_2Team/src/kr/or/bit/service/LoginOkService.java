package kr.or.bit.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.JoinDao;
import kr.or.bit.dto.JoinDto;



public class LoginOkService  implements Action{
	static int i = 0;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException {

		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String chk = null;
		chk = request.getParameter("chk");
		Cookie co = new Cookie("id",id);
		JoinDao joindao = new JoinDao();
		String p = joindao.loginok(id);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		boolean success = false;
		if(p == null) {
			i++;
			if(i == 3) {
				forward.setPath("join/Join.jsp");
			}else {
				forward.setPath("Login.jsp");
			}
			
		}
		else if(p.equals(pwd)) {
			i = 0;
			if(chk != null) {
				co.setMaxAge(24*60*60);
			 	response.addCookie(co);
			}else {
				co.setMaxAge(0);
				response.addCookie(co);
			}
			Cookie[] cs = request.getCookies();
			session.setAttribute("member", id);
			success = true;
			forward.setPath("Main.jsp");
		}else{
			forward.setPath("Login.jsp");
		}
		return forward;
	}
}