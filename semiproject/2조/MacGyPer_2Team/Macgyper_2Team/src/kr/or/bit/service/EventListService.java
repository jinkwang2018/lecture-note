package kr.or.bit.service;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EventDao;
import kr.or.bit.dto.EventDto;
import net.sf.json.JSONArray;

public class EventListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
			String id = request.getParameter("user_id");
			System.out.println(id);
		try {
			
				EventDao dao = new EventDao();
				EventDto dto = new EventDto();
	            
				ArrayList<EventDto> eventlist =(ArrayList<EventDto>) dao.getEventList(id);

				JSONArray jsonarray = JSONArray.fromObject(eventlist);
	            System.out.println(jsonarray);
	            request.setAttribute("jsonarray", jsonarray);
	            
	            foward = new ActionForward();
	            foward.setRedirect(false);
	            foward.setPath("/renderok.jsp");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foward;
	}

}
