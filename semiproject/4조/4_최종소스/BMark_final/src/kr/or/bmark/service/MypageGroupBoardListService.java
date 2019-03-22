package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.groupBoardDto;
import net.sf.json.JSONArray;

public class MypageGroupBoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int gid =(int)request.getSession().getAttribute("gid");
		//System.out.println("현재 이 사람의 그룹 ID: " + gid);

		myBoardDao dao = new myBoardDao();
		int totalteamboardcount = dao.totalteamBoardCount(gid);
		
		String psstr = request.getParameter("ps");    //pagesize
        String cpstr = request.getParameter("cp");    //currentpage
        
        if(psstr == null || psstr.trim().equals("")){
            //default 값
            psstr = "5"; // default 5건씩 
        }
        
        if(cpstr == null || cpstr.trim().equals("")){
            cpstr= "1";        //default 1 page
        }
      
        int pagesize = Integer.parseInt(psstr);  //5
        int cpage = Integer.parseInt(cpstr);     //1
        int pagecount = 0;                       
        
        if(totalteamboardcount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = totalteamboardcount/pagesize;
        }else{
            pagecount = (totalteamboardcount/pagesize) + 1;
        }
				
		List<groupBoardDto> list =  dao.mypageTeamBoardList(gid, cpage,pagesize);
		JSONArray jsonlist = JSONArray.fromObject(list);
		ActionForward forward = new ActionForward();

		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("jsonlist", jsonlist);
		request.setAttribute("totalboardcount", totalteamboardcount);
		
		forward.setRedirect(false);
		forward.setPath("/views/mypage/group_bookmark.jsp");
		
		return forward;

	}

}
