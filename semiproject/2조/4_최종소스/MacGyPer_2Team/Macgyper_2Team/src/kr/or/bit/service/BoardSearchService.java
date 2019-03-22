package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;
//////////////////////// 새로 추가 //////////////////////////////
public class BoardSearchService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao = new BoardDao();
		/*int totalboardCount = dao.totalboardCount();*/
		
		String psStr = request.getParameter("ps");    //pagesize
        String cpStr = request.getParameter("cp");    //currentpage
        String seStr = request.getParameter("search");
        
        int totalboardCount = dao.totalboardCount();
        int searchtotalboardCount = dao.searchTotalBoardCount(seStr);
        
        if(psStr == null || psStr.trim().equals("")){ //null값 이거나 공백을 제거한 값이 "" 라면
            //default 값
            psStr = Integer.toString(totalboardCount); // default 5건씩 
        }
        
        if(cpStr == null || cpStr.trim().equals("")){
            cpStr= "1";        //default 1 page
        }
        
        if(seStr == null || seStr.trim().equals("")){
            seStr= "";
        }
      
        int pagesize = Integer.parseInt(psStr);  //5
        int cpage = Integer.parseInt(cpStr);     //1
        int pagecount = 0;                       
        
        if(searchtotalboardCount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = searchtotalboardCount/pagesize;
        }else{
            pagecount = (searchtotalboardCount/pagesize) + 1;
        }
        //페이지 갯수 : 102 건 , pagesize :5   pagecount: 21
       
        List<BoardDto> list= dao.listSearch(cpage, pagesize, seStr);  
        
        ActionForward forward = new ActionForward();
        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("list", list);
        request.setAttribute("totalboardCount", searchtotalboardCount);
        
        forward.setRedirect(false);
		forward.setPath("/board/BoardList.jsp");
		
		return forward;
	}

}
