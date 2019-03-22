package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class BoardEditOkService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String idx = request.getParameter("idx");
		String msg = "";
		String url ="";
		PrintWriter out = response.getWriter();
		
		if(idx == null || idx.trim().equals("")){
			out.print("<script>");
			out.print("alert('글번호 오류');");
			out.print("location.href='board_list.jsp'");	   
			out.print("</script>");
		}
		
		BoardDao dao = new BoardDao();
		int result = dao.boardedit(request);
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("result", result);
	    request.setAttribute("idx", idx);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/BoardEditok.jsp");
		
		return forward;
	}

}
