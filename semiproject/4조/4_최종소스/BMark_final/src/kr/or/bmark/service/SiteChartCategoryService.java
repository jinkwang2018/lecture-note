package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.chartDao;
import kr.or.bmark.dto.chart;
import net.sf.json.JSONArray;

public class SiteChartCategoryService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List<chart> categorylist = null;
		
		try {
			JSONArray cnamelist;
			chartDao dao = new chartDao();
			categorylist = dao.getChartcategoryList();
			
			cnamelist = JSONArray.fromObject(categorylist);
			
			request.setAttribute("cnamelist", cnamelist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/chart/siteChartCategoryOk.jsp");
		return forward;
	}
}
