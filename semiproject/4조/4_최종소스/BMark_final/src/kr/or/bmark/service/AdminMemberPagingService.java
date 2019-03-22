package kr.or.bmark.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.adminDao;
import kr.or.bmark.dto.memberDto;



public class AdminMemberPagingService  implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		adminDao dao = new adminDao();
		int totalmembercount = dao.totalMemberCount();
		
		String psstr = request.getParameter("ps");    //pagesize
        String cpstr = request.getParameter("cp");    //currentpage
        
        if(psstr == null || psstr.trim().equals("")){
            //default 값
            psstr = "10"; // default 5건씩 
        }
        
        if(cpstr == null || cpstr.trim().equals("")){
            cpstr= "1";        //default 1 page
        }
      
        int pagesize = Integer.parseInt(psstr);  //5
        int cpage = Integer.parseInt(cpstr);     //1
        int pagecount = 0;                       
        
        if(totalmembercount % pagesize==0){        //전체 건수 , pagesize > 
            pagecount = totalmembercount/pagesize;
        }else{
            pagecount = (totalmembercount/pagesize) + 1;
        }
        
        List<memberDto> memberlist= dao.memberList(cpage, pagesize);
		
        ActionForward forward = new ActionForward();
        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("pagecount", pagecount);
        request.setAttribute("memberlist", memberlist);
        request.setAttribute("totalmembercount", totalmembercount);
        
        forward.setRedirect(false);
        forward.setPath("/views/admin/memberlistpaging.jsp");
		
		return forward;
	}

}
