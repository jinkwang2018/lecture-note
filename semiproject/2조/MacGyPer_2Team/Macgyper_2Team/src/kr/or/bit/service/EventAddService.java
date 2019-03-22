package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EventDao;
import kr.or.bit.dto.EventDto;

public class EventAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		try {
			EventDao dao = new EventDao();
			EventDto dto = new EventDto();
		
			dto.setUser_id(request.getParameter("user_id"));
			dto.setEvent_title(request.getParameter("title"));
			dto.setEvent_content(request.getParameter("content"));
			dto.setEvent_startdate(request.getParameter("start").replace("T", " "));
			dto.setEvent_enddate(request.getParameter("end").replace("T", " "));
			dto.setEvent_color(request.getParameter("color"));
			int result = dao.insertEvent(dto);

			if (result > 0) {
				System.out.println("이벤트 입력 성공");
				request.setAttribute("result", "success");
			} else {
				System.out.println("이벤트 입력 실패");
				request.setAttribute("result", "fail");
			}

			foward = new ActionForward();
			foward.setRedirect(false);
			foward.setPath("/Event.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return foward;
	}

}
