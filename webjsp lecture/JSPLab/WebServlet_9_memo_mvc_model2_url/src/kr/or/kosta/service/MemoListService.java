package kr.or.kosta.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.memodao;
import kr.or.kosta.dto.memo;

public class MemoListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		try {
			   memodao dao = new memodao();
       	       ArrayList<memo> memolist = dao.getMemoList();
       	       request.setAttribute("memolist", memolist);
       	       
       	       foward = new ActionForward();
       	       foward.setRedirect(false);
       	       foward.setPath("/WEB-INF/views/memolist.jsp");
       	       
		}catch(Exception e) {
			e.printStackTrace();
		}

		return foward;
	}

}
