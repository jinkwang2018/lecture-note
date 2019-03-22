package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;

public class BoardReplyService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		BoardDao dao = new BoardDao();
		String writer = request.getParameter("id");
		String content = request.getParameter("reply_content");
		String idx = request.getParameter("idx");

		int result = dao.replywrite(Integer.parseInt(idx), writer, content);
		
		if(result>0) {
			request.setAttribute("result", "success");
		}
		else {
			request.setAttribute("result", "fail");
		}
		
		request.setAttribute("idx", idx);
		response.getWriter().print(result);
		ActionForward forward = null;
	
		
		return forward;
	}

}
