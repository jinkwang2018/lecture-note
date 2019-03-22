package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.adminDao;
import kr.or.bmark.dto.member;
import kr.or.bmark.dto.memberDto;
/* 
* @FileName : MyBoardMemberInfoUpdateService.java 
* @Project : BMark
* @Date : 2018.04.12. 
* @Author : 이 진 우 
*/ 
public class AdminMemberInfoUpdateService implements Action {
// 마이페이지에서 수정한 개인 정보를 DB로 전달하고 다시 마이페이지를 로드하는 Service
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		String result = "";
		int row =0;
		
		//데이터를 받아와서 업데이트 하는 부분
		member member = new member();
		member.setUserid(request.getParameter("userid"));
		System.out.println(member.getUserid());
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		
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
        adminDao dao = new adminDao();
        
        
		int totalmembercount = dao.totalMemberCount();// 총 맴버수
		if(totalmembercount % pagesize==0){        //전체 건수 , pagesize > 
			pagecount = totalmembercount/pagesize;
		}else{
			pagecount = (totalmembercount/pagesize) + 1;
		}
		
		//새로 업데이트 된 정보를 뿌려주기 위해서 정보 가지고오기 
		try {
			row = dao.updateMemberInfo(member);// 데이터 집어넣기
			if(row<=0) {
				result = "fail1";
			}else {
				result = "success1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<memberDto> memberlist= dao.memberList(cpage, pagesize); 
		forward = new ActionForward();
		request.setAttribute("result", result);
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
