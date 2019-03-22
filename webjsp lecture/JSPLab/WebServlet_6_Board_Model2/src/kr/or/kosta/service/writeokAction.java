package kr.or.kosta.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.board;

public class writeokAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		try {
		String writer = request.getParameter(writer);
		String pwd = request.getParameter(pwd);
		String subject = request.getParameter(subject);
		String content = request.getParameter(content);
		String email = request.getParameter(email);
		String homepage = request.getParameter(homepage);
		String filename = request.getParameter(filename);
		
		
		boarddao dao = new boarddao();
		board boardata = new board();
		int result = dao.writeok(boardata);
		
		String url ="board_writeok.jsp";
		   request.setAttribute("board_url", url); 
		   
		   foward = new ActionForward();
	       foward.setRedirect(false);
	       foward.setPath("/WEB-INF/views/redirect.jsp");
		}catch(Exception e) {
			
		}
         return foward;
	}

}
