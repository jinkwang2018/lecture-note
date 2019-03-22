package kr.or.bmark.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.mainBoardDao;
import kr.or.bmark.dto.groupBoardDto;
import kr.or.bmark.dto.team;
import net.sf.json.JSONArray;

public class GroupBoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List resultList = new ArrayList<>();
		List<groupBoardDto> usergrouplist = null;
		List<team> grouplist = null;
		
		String userid = (String)request.getSession().getAttribute("userid");
		int gid = 0;
		if(request.getSession().getAttribute("gid") != null) {
			gid = (int)request.getSession().getAttribute("gid");
		}
		System.out.println(gid);
		
		try {
			mainBoardDao dao = new mainBoardDao();
			JSONArray jsonlist = null;
			// 만약 로그인한 회원이라면 사람의 그룹이 가입되어 있는지 유무를 판단하고, 참가된 그룹이 있다면 그 그룹의 List 출력
			if(userid != null) {
				// 만약, 그 사람이 참가한 그룹이 있다면? 그 사람의 그룹 GID를 가져온다.
				//int userGID = dao.isGroupRegister(userid);
				if( gid > 0) {
					usergrouplist = dao.getGroupBoardList(gid);
					resultList.add(1);
					resultList.add(usergrouplist);
					jsonlist = JSONArray.fromObject(resultList);
				}
				// 그룹이 없다면, 그룹 참가 페이지
				else {
					grouplist = dao.getGroupList();
					resultList.add(0);
					resultList.add(grouplist);
					jsonlist = JSONArray.fromObject(resultList);
				}
			}
			// 회원이 아닌 경우.
			else {
				grouplist = dao.getGroupList();
				resultList.add(0);
				resultList.add(grouplist);
				jsonlist = JSONArray.fromObject(resultList);
			}
			
			
			request.setAttribute("jsonlist", jsonlist);
			//System.out.println("잘나오니?"+jsonlist);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/grouplist.jsp");
		return forward;

	}

}
