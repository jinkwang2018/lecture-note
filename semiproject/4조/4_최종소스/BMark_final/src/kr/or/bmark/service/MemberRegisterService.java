package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.memberDao;
import kr.or.bmark.dto.member;

public class MemberRegisterService implements Action{
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 10.
	 * @desc   : 회원가입 처리 Service
	 * @param member
	 * @return
	 */
		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	
			//System.out.println("여기까지 실행되는지 확인!!");
		 	
		 	ActionForward forward = new ActionForward();
		 	
			memberDao memberdao = new memberDao();
	   		member member=new member();
	   		
	   		int result=0;
	   		String msg ="";
	   		member.setUserid(request.getParameter("userid"));
	   		member.setPwd(request.getParameter("pw"));
	   		member.setName(request.getParameter("name"));
	   		member.setEmail(request.getParameter("email"));
	   		member.setPhone(request.getParameter("phone"));
	   		member.setZonecode(Integer.parseInt(request.getParameter("zonecode")));
	   		member.setAddr1(request.getParameter("addr1"));
	   		member.setAddr2(request.getParameter("addr2"));
	   		
	   		
	   		result = memberdao.joinMember(member);
	   		
	   		if(result>0){
	   			//회원가입 성공
	   			msg = "success";
	   		
	   		} else {
		   		//회원가입 실패
	   			msg= "fail";
	   		}
	   		request.setAttribute("msg", msg);	   		
	   		
	   		forward.setRedirect(false);
	   		forward.setPath("views/main/registerok.jsp");
	   		
	   		return forward;
		
	}
}