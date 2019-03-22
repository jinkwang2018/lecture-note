package kr.or.bit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.NoteDto;

public class MemoSelectService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");
		
		int note_num = Integer.parseInt(request.getParameter("note_num"));
		try {
			   if(id != null) {
				   NoteDao dao = new NoteDao();
				   NoteDto note =  dao.getNoteSelect(note_num);
				   request.setAttribute("note", note);    
				   foward = new ActionForward();
				   foward.setRedirect(false);
				   foward.setPath("/note/NoteUpdate.jsp");
			   }else {
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
