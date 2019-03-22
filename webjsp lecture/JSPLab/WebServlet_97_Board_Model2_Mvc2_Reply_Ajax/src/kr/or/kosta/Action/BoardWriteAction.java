package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.Action.ActionForward;
import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.board;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boarddao dao = new boarddao();
		board boarddata = new board();
		
		boarddata.setSubject(request.getParameter("subject"));
		boarddata.setWriter(request.getParameter("writer"));
		boarddata.setEmail(request.getParameter("email"));
		boarddata.setHomepage(request.getParameter("homepage"));
		boarddata.setContent(request.getParameter("content"));
		boarddata.setPwd(request.getParameter("pwd"));
		boarddata.setFilename(request.getParameter("filename"));
		
		int result = dao.writeok(boarddata);
		
		if(result>0) {
			System.out.println("글 입력 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 입력 실패");
			request.setAttribute("result", "fail");
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/board/board_writeok.jsp");
  
		return forward;
	}

}
