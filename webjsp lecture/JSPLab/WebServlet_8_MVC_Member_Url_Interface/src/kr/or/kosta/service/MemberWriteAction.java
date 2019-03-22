package kr.or.kosta.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.MvcRegisterDao;
import kr.or.kosta.dto.MvcRegister;

public class MemberWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ID : " + request.getParameter("id"));
		System.out.println("PWD : " + request.getParameter("pwd"));
		System.out.println("EMAIL : " + request.getParameter("email"));
		
		//dao객체를 생성하기
	
		MvcRegister dto = new MvcRegister();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setPwd(request.getParameter("pwd"));
		dto.setEmail(request.getParameter("email"));
		
		//DAO 객체
		MvcRegisterDao dao = new MvcRegisterDao();
		int result = dao.writeOk(dto);
		
		String resultdata="";
		if(result > 0) {
			resultdata = "welcome to kosta " + dto.getId() + "님";
		}else {
			resultdata = "Insert Fail retry";
		}
		
		//데이터 담기
		request.setAttribute("data", resultdata);
		
		//request를 다시 controller에 넘겨준다.
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/Register/Register_welcome.jsp");
		
		return forward;
	}
	
}
