package kr.or.kosta.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.memodao;

public class MemoIdCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		String idCheck = null;
		String id = request.getParameter("id");
		try {
			  memodao dao = new memodao();
			  idCheck =dao.isIdCheckById(id);
			  request.setAttribute("message",idCheck);
			
		}catch(Exception e) {
			System.out.println("ID 검증 오류 :" + e.getMessage());
		}
		
		forward  = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/uservalid.jsp");
		return 	forward;
	}

}
