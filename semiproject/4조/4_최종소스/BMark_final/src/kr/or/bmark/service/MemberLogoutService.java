package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;


public class MemberLogoutService implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session=request.getSession();
		
		//세션정보 삭제
		//request.getSession().removeAttribute("userid");
		session.removeAttribute("userid");
		
		forward.setRedirect(true); 
   		forward.setPath("main.jsp");
   		return forward;
		
	}

	
}
