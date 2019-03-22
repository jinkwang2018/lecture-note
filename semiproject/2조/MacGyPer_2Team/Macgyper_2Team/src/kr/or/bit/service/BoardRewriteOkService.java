package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;

public class BoardRewriteOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDao dao = new BoardDao();
		BoardDto boarddata = new BoardDto();
		boarddata.setIdx(Integer.parseInt(request.getParameter("idx")));
		boarddata.setBoard_title(request.getParameter("board_title"));
		boarddata.setId(request.getParameter("id"));
		boarddata.setBoard_content(request.getParameter("board_content"));
		boarddata.setBoard_filename(request.getParameter("board_filename"));
		
		int result = dao.reWriteOk(boarddata);
		
		if(result>0) {
			System.out.println("글 수정 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 수정 실패");
			request.setAttribute("result", "fail");
		}
		
		String cpage = request.getParameter("cp");
		String pagesize = request.getParameter("ps");
		
		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/board/BoardRewriteok.jsp");
  
		return forward;
	}
	
}
