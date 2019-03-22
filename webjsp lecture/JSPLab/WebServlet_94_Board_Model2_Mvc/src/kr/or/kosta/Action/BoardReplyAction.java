package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.board;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		//서비스 객체 호출하고
		//insert 하고
		boarddao dao = new boarddao();
		
		String writer = request.getParameter("reply_writer");
		String content = request.getParameter("reply_content");
		String pwd = request.getParameter("reply_pwd");
		String userid = request.getParameter("userid");
		String idx = request.getParameter("idx");
		userid = "empty";

		//서비스 객체 호출하고
		//insert 하고
		int result = dao.replywrite(Integer.parseInt(idx), writer, userid, content, pwd);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "fail");
		}
		
		request.setAttribute("idx", idx);
		
		ActionForward forward = new ActionForward();
	    
	    forward.setRedirect(false);
		forward.setPath("/board/board_replyok.jsp");
		
		return forward;
	}

}
