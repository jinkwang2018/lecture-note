package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.BookDto;
import kr.or.bit.dto.NoteDto;

public class BookInserteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		int result = 0;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");

		try {
			if (id != null) {
				String book_title = request.getParameter("book_title");

				BookDto book = new BookDto();
				book.setId(id);
				book.setBook_title(book_title);

				NoteDao dao = new NoteDao();
				result = dao.insertBook(book);

				if (result > 0) {
					System.out.println("북 저장 성공");
					request.setAttribute("result", "success");
				} else {
					System.out.println("북 저장 실패");
					request.setAttribute("result", "fail");
				}

				foward = new ActionForward();
				foward.setRedirect(false);
				foward.setPath("/note/BookWriteok.jsp");
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
