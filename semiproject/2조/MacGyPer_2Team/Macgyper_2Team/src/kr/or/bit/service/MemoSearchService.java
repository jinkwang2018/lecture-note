package kr.or.bit.service;


import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.NoteDto;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MemoSearchService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");
		try {
			if (id != null) {
				String note_title = request.getParameter("notename");
				NoteDao dao = new NoteDao();
				ArrayList<NoteDto> notesearchlist = (ArrayList<NoteDto>) dao.getNoteSearchList(note_title, id);

				JSONArray jsonarray = JSONArray.fromObject(notesearchlist);

				request.setAttribute("jsonarray", jsonarray);
				foward = new ActionForward();
				foward.setRedirect(false);
				foward.setPath("/note/NoteSearchok.jsp");
			} else {
				foward = new ActionForward();
				foward.setRedirect(false);
				foward.setPath("/login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return foward;
	}

}
