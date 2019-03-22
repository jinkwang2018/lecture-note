package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.groupDao;

public class GroupOutService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		HttpSession session = request.getSession();
		
		String userid = (String)request.getSession().getAttribute("userid");
		int gid = (int)request.getSession().getAttribute("gid");
		
		try {
			groupDao dao = new groupDao();
			// 실제 로그인 되어있는지 확인
			if(userid != null) {
				// 로그인한 회원이 가입된 그룹에서 그룹장인지 판단!!
				// 그룹장이라면, 그룹에 등록된 사이트와 가입한 회원들 모두 삭제
				if(dao.isGroupMaster(userid)) {
					dao.delGroupAllSite(gid);
					dao.delGroupAllMember(gid);
					dao.delGroup(gid);
				} 
				// 그룹장이 아니라면, 그룹에서만 탈퇴
				else {
					dao.outGroup(userid);
				}
				session.setAttribute("gid", 0);
				request.setAttribute("result", "OK");
			}
			// 안되어 있다면, else로 처리
			else {
				request.setAttribute("result", "NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/group/group_outOk.jsp");
		return forward;
	}
}
