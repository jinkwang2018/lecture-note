package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.member;
/* 
* @FileName : MyBoardMemberInfoSendService.java 
* @Project : BMark 
* @Date : 2018.04.12. 
* @Author : 이 진 우 
*/ 
public class MypageMemberInfoSendService implements Action {
	// 마이페이지에서 수정할 개인 정보를 페이지로 전달하는 Service
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		
		String userid = (String) request.getSession().getAttribute("userid");
		
		member member =null;
		try {
			myBoardDao dao = new myBoardDao();
			member = dao.getMemberInfo(userid);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/mypage/my_edit.jsp");
		return forward;
		
	}

}
