package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.chartDao;
import kr.or.bmark.dto.chart;
import net.sf.json.JSONArray;
/* 
* @FileName : SiteChartListService.java 
* @Project : BMark
* @Date : 2018.04.11. 
* @Author : 김래영 
*/ 
public class SiteChartListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List<chart> chartlist;
		
		try {
			chartDao dao = new chartDao();
			String category = request.getParameter("id");
			JSONArray jsonlist;
			
			chartlist = dao.getChartTop5List(category);
			jsonlist = JSONArray.fromObject(chartlist);
			
			//System.out.println("잘오니?" + jsonlist);
			request.setAttribute("jsonlist", jsonlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/chart/siteChartListOk.jsp");
		return forward;
	}

}
