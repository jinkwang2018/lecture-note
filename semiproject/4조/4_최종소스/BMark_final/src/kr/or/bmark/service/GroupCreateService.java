package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.groupDao;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.myBoard;
import kr.or.bmark.dto.team;

public class GroupCreateService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Main에 저장되어 있는 유저 ID와 GID 가져옴.
		String userid = (String)request.getSession().getAttribute("userid");
		int gid = (int)request.getSession().getAttribute("gid");
		
		//로그인한 사람이라면?
		if(userid != null) {
			groupDao dao = new groupDao();
			team newteam = new team();
			
			newteam.setName(request.getParameter("tname"));
			newteam.setPw(request.getParameter("tpwd"));
			newteam.setContent(request.getParameter("tcontent"));
			newteam.setRegister(userid);
			
			int result = dao.createGroup(newteam);
			request.getSession().setAttribute("gid", dao.createJoinGroup(userid));
			System.out.println("여기까찌 되나봄.");
			if(result > 0) {
				request.setAttribute("result", "success");
			}else {
				request.setAttribute("result", "fail");
			}
		}else {
			request.setAttribute("result", "forbid");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/mypage/group_create_Ok.jsp");
		
		return forward;
	}
}
