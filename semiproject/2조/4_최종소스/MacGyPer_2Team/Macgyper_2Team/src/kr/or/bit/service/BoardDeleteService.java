package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class BoardDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		String id = request.getParameter("id");
		String msg = "";
		String url ="";
		
		if(idx == null || idx.trim().equals("")){
			response.sendRedirect("board_list.jsp");
		}
		  
		BoardDao dao = new BoardDao();
		int result = dao.deleteOk(idx, id);
		
		if(result>0) {
			System.out.println("글 삭제 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 삭제 실패");
			request.setAttribute("result", "fail");
		}
		request.setAttribute("idx", idx);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/board/BoardDeleteok.jsp");
  
		return forward;
		
	}
}
