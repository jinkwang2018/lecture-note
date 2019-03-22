package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;

public class BoardEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String idx = request.getParameter("idx");//글번호
		if (idx == null || idx.trim().equals("")) {
			response.sendRedirect("board_list.jsp");
		}
		
		BoardDao dao = new BoardDao();
		BoardDto boarddata = dao.getEditContent(idx);

		if (boarddata == null) {
			response.sendRedirect("board_list.jsp");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("boarddata", boarddata);
	    request.setAttribute("idx", idx);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/BoardEdit.jsp");
		
		return forward;
	}

}
