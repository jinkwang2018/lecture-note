package kr.or.bmark.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.groupDao;
import kr.or.bmark.dao.mainBoardDao;
import kr.or.bmark.dto.groupBoardDto;
import kr.or.bmark.dto.team;
import net.sf.json.JSONArray;

public class GroupJoinService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List<team> grouplist = null;
		HttpSession session = request.getSession();
		
		String userid = (String)request.getSession().getAttribute("userid");
		
		try {
			// 실제 로그인 되어있는지 확인
			if(userid != null) {
				groupDao dao = new groupDao();
				int gid = Integer.parseInt((request.getParameter("gid")));
				int password = Integer.parseInt((request.getParameter("pw")));
				
				//System.out.println(gid + "/" + password);
				// 사용자가 입력한 비밀번호가 맞다면
				if(dao.isGroupJoinOk(gid, password)) {
					dao.addGrouptoUser(gid, userid);
					request.setAttribute("result", "OK");
					session.setAttribute("gid", gid);
				}else {
					request.setAttribute("result", "NO");
				}
			}
			// 안되어 있다면, else로 처리
			else {
				request.setAttribute("result", "NONE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/group/group_joinOk.jsp");
		return forward;

	}
}
