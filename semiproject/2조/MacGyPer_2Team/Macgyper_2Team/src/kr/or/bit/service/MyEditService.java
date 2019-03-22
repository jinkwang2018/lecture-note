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



public class MyEditService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException, IOException {
		String id =  request.getParameter("id");
		JoinDao joindao = new JoinDao();
		JoinDto joindto = joindao.getSelectJoin(id);
		request.setAttribute("joindto", joindto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("join/MyUpdate.jsp");
		
		return forward;
	}

}
