package kr.or.bit.service;

import java.util.ArrayList; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;

public class BoardListService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao = new BoardDao();
		int totalboardCount = dao.totalboardCount();
		String psStr = request.getParameter("ps");    //pagesize
        String cpStr = request.getParameter("cp");    //currentpage
        
        if(psStr == null || psStr.trim().equals("")){ //null값 이거나 공백을 제거한 값이 "" 라면
            //default 값
            psStr = "10"; // default 5건씩 
        }
        
        if(cpStr == null || cpStr.trim().equals("")){
            cpStr= "1";        //default 1 page
        }
      
        int pagesize = Integer.parseInt(psStr);  //5
        int cpage = Integer.parseInt(cpStr);     //1
        int pagecount = 0;                       
        
        if(totalboardCount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = totalboardCount/pagesize;
        }else{
            pagecount = (totalboardCount/pagesize) + 1;
        }

        List<BoardDto> list= dao.list(cpage, pagesize);
		 
        ActionForward forward = new ActionForward();
        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("list", list);
        request.setAttribute("totalboardCount", totalboardCount);
        
        forward.setRedirect(false);
		forward.setPath("/board/BoardList.jsp");
		
		return forward;
	}

}
