package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.mainBoardDao;

public class HitOkService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		
		try {
			mainBoardDao dao = new mainBoardDao();
			int mnbid = Integer.parseInt(request.getParameter("sname"));
			
			String data = "";
			if(dao.setHit(mnbid)) {
				data = "조회수 +1";
			}else {
				data = "조회수 +0";
			}
			
			System.out.println(data);
			request.setAttribute("data", data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/site_hit.jsp");
		return forward;
	}
	
}
