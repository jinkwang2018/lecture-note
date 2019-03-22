package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.myBoard;

public class MypageMyBoardDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		myBoardDao dao = new myBoardDao(); 
		
		int mnbid = Integer.parseInt(request.getParameter("mnbid"));//게시글 아이디
		String userid = (String)request.getSession().getAttribute("userid");//내 현재 로그인된 아이디 검색
		int totalmyboardcount = dao.totalmyBoardCount(userid);// 총 북마크 수
		
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
        
        if(totalmyboardcount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = totalmyboardcount/pagesize;
        }else{
            pagecount = (totalmyboardcount/pagesize) + 1;
        }
		int result = dao.myboardsitedelete(mnbid,userid);		
		dao.myboarddatadelete(mnbid,userid);
		totalmyboardcount--;
		if(result > 0) {
			System.out.println("사이트 삭제가 완료되었습니다");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("사이트 삭제에 실패했습니다");
			request.setAttribute("result", "fail");
		}
		List<myBoard> mypagelist = dao.myPageGetList(userid, cpage, pagesize);
		//삭제한 페이지가 하나밖에 없는 상황에서 지웠을때 페이지를 옮기고 페이지를 하나 줄여준다
		if(mypagelist.isEmpty()) {
			mypagelist = dao.myPageGetList(userid, --cpage, pagesize);
			--pagecount;
		}
		ActionForward forward = new ActionForward();
		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("mypagelist", mypagelist);
		request.setAttribute("totalboardcount", totalmyboardcount);
		forward.setRedirect(false);
		forward.setPath("/views/mypage/my_boarddeleteok.jsp");
		
		return forward;	
		
	}
}
