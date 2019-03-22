package kr.or.bit.service;

import java.io.IOException;
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



public class JoinListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException, IOException {
		JoinDao joindao = new JoinDao();
		ArrayList<JoinDto> joinlist = joindao.JoinList();
		JSONArray joinjson = JSONArray.fromObject(joinlist);
		System.out.println(joinjson);
		request.setAttribute("joinjson", joinjson);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("join/JoinListSend.jsp");
		
		return forward;
	}

}
