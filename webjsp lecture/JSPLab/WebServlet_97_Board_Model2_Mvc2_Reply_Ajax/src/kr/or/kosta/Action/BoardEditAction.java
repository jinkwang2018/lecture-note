package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.board;

public class BoardEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//수정하기
		
		//request.setCharacterEncoding("UTF-8");
		
		String idx = request.getParameter("idx");//글번호
		if (idx == null || idx.trim().equals("")) {
			response.sendRedirect("board_list.jsp");
		}
		
		boarddao dao = new boarddao();
		board boarddata = dao.getEditContent(idx);
		//PrintWriter out = response.getWriter();
		
		
		if (boarddata == null) {
			System.out.println("데이터 오류");
			response.sendRedirect("board_list.jsp");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("boarddata", boarddata);
	    request.setAttribute("idx", idx);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_edit.jsp");
		
		return forward;
	}

}
