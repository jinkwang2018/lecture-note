package kr.or.bit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.NoteDao;
import kr.or.bit.dto.BookDto;
import kr.or.bit.dto.NoteDto;
import net.sf.json.JSONArray;

public class BookSearchService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member");
		String book_title = request.getParameter("bookname");
		try {	
				if(id != null) {
					NoteDao dao = new NoteDao();
					ArrayList<BookDto> booksearchlist = (ArrayList<BookDto>)dao.getBookSearchList(book_title, id);
		       	     
					JSONArray jsonarray = JSONArray.fromObject(booksearchlist);
		    	       
					request.setAttribute("jsonarray", jsonarray);
		       	       
					foward = new ActionForward();
					foward.setRedirect(false);
					foward.setPath("/note/BookSearchok.jsp");
		       	       
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
