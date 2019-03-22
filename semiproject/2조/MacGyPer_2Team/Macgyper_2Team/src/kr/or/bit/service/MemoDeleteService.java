package kr.or.bit.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;


public class MemoDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int note_num = Integer.parseInt(request.getParameter("note_num"));
		String msg = "";
		String url ="";
		
		ActionForward forward =null;
		int result =0;
		NoteDao dao;
		
		try {
			dao = new NoteDao();
			result = dao.deleteNote(note_num);
			
			if(result>0) {
				System.out.println("메모 삭제 성공");
				request.setAttribute("result", "success");
			}
			else {
				System.out.println("메모 삭제 실패");
				request.setAttribute("result", "fail");
			}
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/note/NoteDeleteok.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}
