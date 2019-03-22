package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.scene.control.Alert;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.NoteDto;

public class InsertMemoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		int result=0;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");
		try {
			foward = new ActionForward();
			if(id != null) {
				String note_title = request.getParameter("title");
				String note_content = request.getParameter("content");
				int book_no = Integer.parseInt(request.getParameter("book_no"));
			
				NoteDto note = new NoteDto();
				note.setId(id);
				note.setNote_title(note_title);
				note.setNote_content(note_content);
				note.setBook_no(book_no);

				NoteDao dao = new NoteDao();
				result = dao.insertNote(note);
			
				if (result > 0) {
					System.out.println("메모 저장 성공");
					request.setAttribute("result", "success");
				} else {
					System.out.println("메모 저장 실패");
					request.setAttribute("result", "fail");
				}
				foward.setRedirect(false);
				foward.setPath("/note/NoteWriteok.jsp");
			}else {
				foward.setRedirect(false);
				foward.setPath("/login.jsp");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foward;
	}
}