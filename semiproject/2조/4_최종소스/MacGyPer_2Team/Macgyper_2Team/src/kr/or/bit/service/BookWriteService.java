package kr.or.bit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.BookDto;

public class BookWriteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");
		try {
			if (id != null) {
				NoteDao dao = new NoteDao();
				ArrayList<BookDto> booklist = (ArrayList<BookDto>) dao.getBookList(id);

				request.setAttribute("booklist", booklist);

				foward = new ActionForward();

				System.out.println("로그인한 아이디" + session.getAttribute("member"));
				foward.setRedirect(false);
				foward.setPath("/note/NoteWrite.jsp");
			} else {
				foward = new ActionForward();
				foward.setRedirect(false);
				foward.setPath("/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return foward;
	}

}
