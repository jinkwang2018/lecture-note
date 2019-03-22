package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.adminDao;
import kr.or.bmark.dto.memberDto;

public class AdminMemberDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		adminDao dao = new adminDao(); 
		String userid = request.getParameter("userid");//삭제할 맴버 아이디
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
        
		int result = dao.memberdelete(userid);//맴버 삭제
		
		int totalmembercount = dao.totalMemberCount();// 총 맴버수
		if(totalmembercount % pagesize==0){        //전체 건수 , pagesize > 
			pagecount = totalmembercount/pagesize;
		}else{
			pagecount = (totalmembercount/pagesize) + 1;
		}
		if(result > 0) {
			System.out.println(userid + "회원 삭제가 완료되었습니다");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println(userid + "회원 삭제에 실패했습니다");
			request.setAttribute("result", "fail");
			
		}
		List<memberDto> memberlist= dao.memberList(cpage, pagesize);
		//삭제한 페이지가 하나밖에 없는 상황에서 지웠을때 페이지를 옮기고 페이지를 하나 줄여준다
		if(memberlist.isEmpty()) {
			memberlist = dao.memberList(--cpage, pagesize);
		}
		ActionForward forward = new ActionForward();
		request.setAttribute("cpage", cpage);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("memberlist", memberlist);
		request.setAttribute("totalmembercount", totalmembercount);
		forward.setRedirect(false);
		forward.setPath("/views/admin/memberdeletelistok.jsp");
		
		return forward;	
		
	}
}
