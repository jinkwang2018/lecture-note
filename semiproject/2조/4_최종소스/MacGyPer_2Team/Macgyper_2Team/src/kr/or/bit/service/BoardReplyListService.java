package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;
import kr.or.bit.dto.ReplyDto;
import net.sf.json.JSONArray;

public class BoardReplyListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao = new BoardDao();
		String idx = request.getParameter("idx");
		List<ReplyDto> relpylist = dao.replylist(idx);

		JSONArray jsonarray = JSONArray.fromObject(relpylist);
       
		request.setAttribute("jsonarray", jsonarray);
		
        
        
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
	    forward.setPath("/board/BoardReplyListSend.jsp");
		return forward;
	}

}
