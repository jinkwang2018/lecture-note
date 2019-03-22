package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.memberDao;
import kr.or.bmark.dto.member;

public class MemberRegisterIdCheckService implements Action{
	/**
	 * 
	 * @author : 이진우
	 * @date   : 2018. 4. 17.
	 * @desc   : 아이디 확인 Service
	 * @param member
	 * @return
	 */
		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	
			//System.out.println("여기까지 실행되는지 확인!!");
		 	
		 	ActionForward forward = new ActionForward();
		 	int totalcount =0;
		 	String msg ="";
		 	
		 	String userid = request.getParameter("userid");
		 	
			memberDao dao=new memberDao();
			totalcount= dao.idcheck(userid); //아이디가 있는지 확인
	   		
	   		if(totalcount == 0){
	   			//중복되는 아이디가 없음
	   			msg = "success";
	   		
	   		} else {
		   		//중복되는 아이디가 있음
	   			msg= "fail";
	   		}
	   		request.setAttribute("msg", msg);	   		
	   		
	   		forward.setRedirect(false);
	   		forward.setPath("views/main/idcheckok.jsp");
	   		
	   		return forward;
		
	}
}