package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.member;
/* 
* @FileName : MyBoardMemberInfoUpdateService.java 
* @Project : BMark
* @Date : 2018.04.12. 
* @Author : 이 진 우 
*/ 
public class MypageMemberInfoUpdateService implements Action {
// 마이페이지에서 수정한 개인 정보를 DB로 전달하고 다시 마이페이지를 로드하는 Service
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		
		//데이터를 받아와서 업데이트 하는 부분
		member member = new member();
		String userid = request.getParameter("userid");
		member.setUserid(userid);
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setZonecode(Integer.parseInt(request.getParameter("zonecode")));
		member.setAddr1(request.getParameter("addr1"));
		member.setAddr2(request.getParameter("addr2"));
		
		String result = "";
		int row =0;
		
		//새로 업데이트 된 정보를 뿌려주기 위해서 정보 가지고오기 
		member updatemember = null;
		try {
			myBoardDao dao = new myBoardDao();
			row = dao.updateMemberInfo(member);// 데이터 집어넣기
			if(row<0) {
				result = "수정에 실패했습니다";
			}else {
				result = "수정에 성공하였습니다";
			}
			updatemember = dao.getMemberInfo(userid);
			request.setAttribute("result", result);
			request.setAttribute("member", updatemember);
			System.out.println("잘나오니?"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/mypage/my_editok.jsp");
		return forward;
	
	}

}
