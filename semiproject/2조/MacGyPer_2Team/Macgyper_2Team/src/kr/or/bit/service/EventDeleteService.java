package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EventDao;

public class EventDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			System.out.println("삭제서비스 테스트 중");
			System.out.println();
			int event_id = Integer.parseInt(request.getParameter("event_id"));
			
			EventDao dao = new EventDao();
			int result = dao.deleteEvent(event_id);
			

			if (result > 0) {
				System.out.println("이벤트 삭제 성공");
				request.setAttribute("result", "success");
			} else {
				System.out.println("이벤트 삭제 실패");
				request.setAttribute("result", "fail");
			}
			request.setAttribute("id", event_id);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/Event.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;

	}

}
