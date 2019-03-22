package kr.or.bmark.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.myBoard;



public class MyPageMyBoardListAgainService  implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String userid =(String)session.getAttribute("userid");
		
		
		myBoardDao dao = new myBoardDao();
		int totalboardcount = dao.totalmyBoardCount(userid);
		
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
        
        if(totalboardcount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = totalboardcount/pagesize;
        }else{
            pagecount = (totalboardcount/pagesize) + 1;
        }
        //페이지 갯수 : 102 건 , pagesize :5   pagecount: 21
        
        List<myBoard> mypagelist= dao.myPageGetList(userid, cpage, pagesize);
		
        ActionForward forward = new ActionForward();
        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("mypagelist", mypagelist);
        request.setAttribute("totalboardcount", totalboardcount);
        
        forward.setRedirect(false);
        forward.setPath("/views/mypage/my_bookmarklist.jsp");
		
		return forward;
	}

}
