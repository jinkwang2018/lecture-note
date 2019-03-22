package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.JoinDao;


public class IdCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("idcheck서비스 들어왔다 -1");
		ActionForward forward = null;
		String idCheck = null;
		String id = request.getParameter("id");
		
		try {
			  JoinDao joindao = new JoinDao();
			
			  idCheck =joindao.isIdCheckById(id);
			  request.setAttribute("message",idCheck);
			
		}catch(Exception e) {
			System.out.println("ID 검증 오류 :" + e.getMessage());
		}
		System.out.println("예외처리 끝나고 넘어간다.");
		forward  = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("join/uservalid.jsp");
		return 	forward;
	}

}
