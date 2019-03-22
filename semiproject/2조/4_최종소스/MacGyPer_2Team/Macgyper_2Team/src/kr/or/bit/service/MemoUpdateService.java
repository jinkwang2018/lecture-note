package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.NoteDto;

public class MemoUpdateService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int note_num = Integer.parseInt(request.getParameter("note_num"));
		String note_title = request.getParameter("note_title");
		String note_content = request.getParameter("note_content");
		int book_no = Integer.parseInt(request.getParameter("book_no"));
		
		NoteDto note = new NoteDto();
		note.setNote_num(note_num);
		note.setNote_title(note_title);
		note.setNote_content(note_content);
		note.setBook_no(book_no);
		
		String msg = "";
		String url ="";
		
		ActionForward forward =null;
		int result =0;
		NoteDao dao;
		try {
			dao = new NoteDao();
			result = dao.updateNote(note);
			
			if(result>0) {
				System.out.println("업데이트 성공");
				request.setAttribute("result", "success");
			}
			else {
				System.out.println("업데이트 실패");
				request.setAttribute("result", "fail");
			}
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/note/NoteUpdateok.jsp");
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
