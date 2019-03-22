package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;

public class BookDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int book_no = Integer.parseInt(request.getParameter("book_no"));
		String msg = "";
		String url ="";
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");

		ActionForward forward =null;
		int result =0;
		NoteDao dao;
		
		try {
			if(id != null) {
			dao = new NoteDao();
			result = dao.deleteBook(book_no);	
				if (result > 0) {
					System.out.println("메모 삭제 성공");
					request.setAttribute("result", "success");
				} else {
					System.out.println("메모 삭제 실패");
					request.setAttribute("result", "fail");
				}

				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/note/BookDeleteok.jsp");
			} else {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/login.jsp");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}
