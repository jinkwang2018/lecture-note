package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;

public class BoardReplyDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idx_fk =	request.getParameter("idx"); //덧글의 원본 게시글 번호
		String no =	request.getParameter("no"); //덧글의 순번(고유값)
		String pwd =	request.getParameter("delPwd"); //덧글의 암호
		   
		
		   
		boarddao dao = new boarddao();
		int result = dao.replyDelete(no, pwd);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "success");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("idx_fk", idx_fk);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/boardreply_deleteOk.jsp");
		
		return forward;
	}

}
