package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.mainBoardDao;
import kr.or.bmark.dto.category;
import net.sf.json.JSONArray;

public class MainCategoryListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List<category> list;
		try {
			mainBoardDao dao = new mainBoardDao();
			list = dao.getCategoryList();
			JSONArray jsonlist = JSONArray.fromObject(list);
			request.setAttribute("jsonlist", jsonlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/categorylist.jsp");
		return forward;
	}
	
}
