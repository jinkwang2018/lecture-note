package kr.or.bmark.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.mainBoardDao;
import net.sf.json.JSONArray;

public class MainBookOkService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List list = new ArrayList<>();
		
		try {
			int mnbid = Integer.parseInt(request.getParameter("mnbid"));
			String userid = (String)request.getSession().getAttribute("userid");
			
			String data="";
			
			if( userid==null ) {
				data="\'로그인\'이 필요한 기능입니다.";
				list.add(data);
			}else {
				mainBoardDao dao = new mainBoardDao();
				//이미 myboard에 존재한다면
				if(dao.isMyBookMark(mnbid, userid)) {
					data="이미 \'즐겨찾기\'하셨습니다.";
					list.add(data);
				}
				//myboard에 존재하지않는다면
				else {
					//dao.addTypeMy(mnbid, userid);
					dao.addMyBookMark(mnbid, userid);
					list = dao.getBookMark(mnbid);
				}
			}
			
			JSONArray jsonlist = JSONArray.fromObject(list);
			request.setAttribute("jsonlist", jsonlist);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/myadd_bookmark.jsp");
		return forward;
	}
	
}
