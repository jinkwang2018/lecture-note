package kr.or.bmark.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.adminDao;
import kr.or.bmark.dto.mainBoardDto;
import kr.or.bmark.dto.myBoard;

public class AdminMainInsertService implements Action{
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 17.
	 * @desc   : 사이트추가
	 * @param 
	 * @return
	 */
		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 	
			//System.out.println("여기까지 실행되는지 확인!!");
		 	
		 	ActionForward forward = new ActionForward();
		 	
			adminDao admindao =new adminDao();
	   		mainBoardDto main=new mainBoardDto();
	   		int totalmyboardcount = admindao.totalmyBoardCount();// 총 북마크 수
	   		
	   		boolean result=false;
	   		
	   		
	   		main.setCname(request.getParameter("cname"));
	   		main.setName(request.getParameter("name"));
	   		main.setContent(request.getParameter("content"));
	   		main.setAddr(request.getParameter("addr"));
	   		
	   		result=admindao.mainInsert(main);
	   		
	   		List<myBoard> mypagelist = admindao.myPageGetList();
	   		String msg ="";
	   		if(result==true){
	   			//System.out.println("사이트 등록 실패");
	   			msg="사이트 등록실패";
		   	}
	   			//System.out.println("사이트 등록 성공");
	   			msg="사이트 등록성공";
	   		
	   			request.setAttribute("msg", msg);
	   			request.setAttribute("totalboardcount", totalmyboardcount);
	   			request.setAttribute("mypagelist", mypagelist);
	   			
	   		forward.setRedirect(false); 
	   		forward.setPath("/views/adminpage2.jsp");
	   		return forward;
		
	}
}