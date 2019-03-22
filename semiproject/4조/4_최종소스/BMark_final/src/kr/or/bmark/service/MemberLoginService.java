package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.memberDao;
import kr.or.bmark.dto.member;

public class MemberLoginService implements Action{
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 11.
	 * @desc   : 회원 로그인 처리 Service
	 * @param member
	 * @return
	 */
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// System.out.println("여기까지 실행되는지 확인!!");

		ActionForward forward = new ActionForward();

		// 서블릿에서는 session을 request 객체로부터 얻기
		// jsp 가 아니기 때문에 session 없어요
		HttpSession session = request.getSession();

		memberDao memberdao = new memberDao();
		member member = new member();

		int result = -1;

		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pw"));

		result = memberdao.isMember(member);
		String msg ="";
		try {
			if (result == 0) {//아이디가 존재하지만 비밀번호가 틀렸을때
				msg="failpwd";
				
			} else if (result == -1) {//아이디가 존재하지 않을때
				msg="failid";
				
			} else {
				// 로그인 성공시
				session.setAttribute("userid", member.getUserid());
				// gid 세션 생성 (회원정보 전체를 불러와서 GID를 추출 후 GID세션에 저장)
				member = memberdao.getDetailMember(member);
				session.setAttribute("gid", member.getGid());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg="error";
		}
		request.setAttribute("msg", msg);
		forward.setRedirect(false);
		forward.setPath("/views/main/loginok.jsp");
		return forward;

	}
}