package kr.or.bit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.BookDto;

public class BookListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");
		try {
			if(id !=null) {
			   NoteDao dao = new NoteDao();
       	       ArrayList<BookDto> booklist = (ArrayList<BookDto>) dao.getBookList(id);
       	       
       	       foward = new ActionForward();
       	       
       	       request.setAttribute("booklist", booklist);
        	   foward.setRedirect(false);
        	   foward.setPath("/note/BookList.jsp");
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
