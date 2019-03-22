package kr.or.bmark.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.mainBoardDao;
import kr.or.bmark.dto.mainBoardDto;
import net.sf.json.JSONArray;

public class MainBoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List<Object> list = new ArrayList<>();
		String userid = (String)request.getSession().getAttribute("userid");
		
		try {
			mainBoardDao dao = new mainBoardDao();
			list.add(dao.getMainBoardList());
			
			// 만약, 로그인 된 상태라면? 그 사람이 과거에 추천 혹은 비추천한 평가 리스트를 가져와서 변화해주어야함!!
			if(userid != null) {
				list.add(dao.getUserEvalList(userid));
				list.add(dao.getMyBookList(userid));
				list.add(dao.getGroupBookList(userid));
			}
			JSONArray jsonlist = JSONArray.fromObject(list);
			request.setAttribute("jsonlist", jsonlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/mainlist.jsp");
		return forward;
	}
	
}
