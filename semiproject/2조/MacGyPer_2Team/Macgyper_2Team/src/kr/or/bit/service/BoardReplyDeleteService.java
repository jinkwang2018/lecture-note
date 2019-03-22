package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class BoardReplyDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idx_fk =	request.getParameter("idx"); //덧글의 원본 게시글 번호
		String no =	request.getParameter("no"); //덧글의 순번(고유값)
		String id = request.getParameter("id");
  
		BoardDao dao = new BoardDao();
		int result = dao.replyDelete(no, id);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "fail");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("idx_fk", idx_fk);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/BoardReplyDeleteok.jsp");
		
		return forward;
	}

}
