package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;

public class BoardContentService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String idx = request.getParameter("idx"); //글번호
	
		//글번호를 가지고 오지 않았을 경우 예외처리
		if(idx==null || idx.trim().equals("")){
			response.sendRedirect("boardlist.bbs");
		}
		
		idx = idx.trim();
	
	    String cpage =	request.getParameter("cp"); //현재 페이지 번호
	    String pagesize =	request.getParameter("ps"); //pagesize 정보
	
	    if(cpage==null || cpage.trim().equals("")){
			cpage="1";
		}
		if(pagesize==null || pagesize.trim().equals("")){
			pagesize="5";
		}
		BoardDao dao = new BoardDao();
		
		//조회수 증가
		boolean res = dao.getReadnum(idx);
		if(res) System.out.println("조회수 증가");
			
		//데이터 조회 출력(글번호가 없는 게시글에 조회시 ...)
		BoardDto boarddto = dao.getContent(Integer.parseInt(idx));
		if(boarddto == null){
			response.sendRedirect("boardlist.bbs");
		}
		
		ActionForward forward = new ActionForward();
	    request.setAttribute("boarddto", boarddto);
	    request.setAttribute("idx", idx);
	    request.setAttribute("cpage", cpage);
	    request.setAttribute("pagesize", pagesize);
	    request.setAttribute("dao", dao);
	    
	    forward.setRedirect(false);
		forward.setPath("/board/BoardContent.jsp");
		
		return forward;
	}
}
