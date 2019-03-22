package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.member;
/* 
* @FileName : MyBoardMemberInfoDeleteService.java 
* @Project : BMark
* @Date : 2018.04.12. 
* @Author : 이 진 우 
*/ 
public class MypageMemberInfoDeleteService implements Action {
// 마이페이지에서 삭제버튼을 누르면 내 아이디가 전달이되어 삭제시키는 Service입니다
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		
		String userid = (String) request.getSession().getAttribute("userid");
		String result = "";
		int row =0;
		try {
			myBoardDao dao = new myBoardDao();
			row = dao.deleteMemberInfo(userid);
			if(row<0) {
				result = "아이디 삭제 실패";
			}else {
				result = "아이디 삭제 성공";
			}
			request.setAttribute("result", result);
			System.out.println("잘나오니?"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/mypage/my_deleteok.jsp");
		return forward;
	
	}

}
