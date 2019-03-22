package kr.or.bmark.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.groupDao;
import kr.or.bmark.dao.mainBoardDao;
import net.sf.json.JSONArray;

public class GroupCheckedService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward;
		List list = new ArrayList<>();
		
		try {
			int mnbid = Integer.parseInt(request.getParameter("mnbid"));
			String userid = (String)request.getSession().getAttribute("userid");
			
			String data = "";
			
			if( userid != null ) {
				groupDao dao = new groupDao();
				//이미 Group board에 존재한다면?
				if(dao.isGroupBookMark(mnbid, userid)) {
					list.add("이미 \'즐겨찾기\'하셨습니다.");
				}
				//Group board에 존재하지 않는다면?
				else {
					dao.addGroupBookMark(mnbid, userid);
					list = dao.getGroupMark(mnbid);
				}
			}
			
			JSONArray jsonlist = JSONArray.fromObject(list);
			request.setAttribute("jsonlist", jsonlist);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/groupadd_bookmark.jsp");
		return forward;
	}
}
