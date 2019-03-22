package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		  
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		String pwd = request.getParameter("pwd");
		String msg = "";
		String url ="";
		
		if(idx == null || idx.trim().equals("")){
			response.sendRedirect("board_list.jsp");
		}
		  
		boarddao dao = new boarddao();
		int result = dao.deleteOk(idx, pwd);
		
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
		forward.setPath("/board/board_deleteok.jsp");
  
		return forward;
		
	}
}
