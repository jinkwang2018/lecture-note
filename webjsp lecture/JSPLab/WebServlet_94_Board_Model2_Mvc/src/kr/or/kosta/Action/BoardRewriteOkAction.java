package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.board;

public class BoardRewriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boarddao dao = new boarddao();
		board boarddata = new board();
		
		boarddata.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		boarddata.setSubject(request.getParameter("subject"));
		boarddata.setWriter(request.getParameter("writer"));
		boarddata.setEmail(request.getParameter("email"));
		boarddata.setHomepage(request.getParameter("homepage"));
		boarddata.setContent(request.getParameter("content"));
		boarddata.setPwd(request.getParameter("pwd"));
		boarddata.setFilename(request.getParameter("filename"));
		
		int result = dao.reWriteOk(boarddata);
		//out.print("실행결과 : " + result);
		
		if(result>0) {
			System.out.println("글 수정 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 수정 실패");
			request.setAttribute("result", "fail");
		}
		
		//추가사항 : 처리 완료시 이동 처리 (cpage , pagesize)
		String cpage = request.getParameter("cp");
		String pagesize = request.getParameter("ps");
		
		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/board/board_rewriteok.jsp");
  
		return forward;
	}
	
}
