package kr.or.bmark.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.myBoard;
/* 
* @FileName : MyBoardListService.java 
* @Project : BMark
* @Date : 2018.04.10. 
* @Author : 김래영 
*/ 
public class MyBoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		List<myBoard> list = null;
		
		try {
			String userid = (String)request.getSession().getAttribute("userid");
			
			if(userid != null) {
				myBoardDao dao = new myBoardDao();
				list = dao.getList(userid);
			}else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("mymarklist", list);
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/my_boardlistOk.jsp");
		
		return forward;
	}

}
