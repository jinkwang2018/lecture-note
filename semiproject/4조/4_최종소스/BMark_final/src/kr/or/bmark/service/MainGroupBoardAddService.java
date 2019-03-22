package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.groupDao;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.myBoard;

public class MainGroupBoardAddService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Main에 저장되어 있는 유저 ID와 GID 가져옴.
		String userid = (String)request.getSession().getAttribute("userid");
		int gid = (int)request.getSession().getAttribute("gid");
		
		//로그인한 사람이라면?
		if(userid != null) {
			myBoardDao mdao = new myBoardDao();
			groupDao gdao = new groupDao();
			myBoard boarddata = new myBoard(); //insert siteinfoboard
			//myBoard data = new myBoard(); //insert myboard;
			
			boarddata.setName(request.getParameter("mymodalname"));
			boarddata.setAddr(request.getParameter("mymodaladdr"));
			boarddata.setContent(request.getParameter("mymodalcontent"));
			boarddata.setCname(request.getParameter("catename"));
			boarddata.setWriter(userid);
			
			int result = mdao.addsiteGroup(boarddata);
			int result2 = gdao.addGroupModalMark(userid);
			//System.out.println("result2 : " + result2);		

			if(result > 0 && result2 > 0) {
				//System.out.println("사이트 등록이 완료되었습니다");
				request.setAttribute("result", "success");
			}
			else {
				//System.out.println("사이트 등록에 실패했습니다");
				request.setAttribute("result", "fail");
			}
		}else {
			request.setAttribute("result", "forbid");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/groupBoardAdd_Ok.jsp");
		
		return forward;
	}
}
