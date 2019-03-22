package kr.or.bmark.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.myBoardDao;
import kr.or.bmark.dto.myBoard;

public class MainMyBoardAddService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		myBoardDao dao = new myBoardDao();
		myBoard boarddata = new myBoard(); //insert siteinfoboard
		myBoard data = new myBoard(); //insert myboard;
		
		boarddata.setName(request.getParameter("mymodalname"));
		boarddata.setAddr(request.getParameter("mymodaladdr"));
		boarddata.setContent(request.getParameter("mymodalcontent"));
		boarddata.setCname(request.getParameter("catename"));
		
		String userid = (String)request.getSession().getAttribute("userid");
		/* request.getSession().getAttribute("?") 담당 부분 */
		
		if(userid != null) {
			boarddata.setWriter(userid);
			
			System.out.println("boarddata" + boarddata);
			//insert into siteinfoboard (mnbid, ccode, name, addr, content, hit, good, bad, type, writer, writeday)
			//values (SNUM.NEXTVAL, (select ccode from SCATEGORY where cname = ?), ?, ?, ?, 0, 0, 0, 'my', ?, sysdate)
			//System.out.println("boarddata : " + boarddata);
			int result = dao.addsiteMy(boarddata);
			
			data.setUserid(userid);
			//insert into myboard(mnbid, userid) values (snum.currval, ?)
	
			int result2 = dao.mybookmarkadd(data);
			//System.out.println("result2 : " + result2);		

			if(result > 0 && result2 > 0) {
				System.out.println("사이트 등록이 완료되었습니다");
				request.setAttribute("result", "success");
			}
			else {
				System.out.println("사이트 등록에 실패했습니다");
				request.setAttribute("result", "fail");
			}
		}else {
			request.setAttribute("result", "forbid");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/myBoardAdd_Ok.jsp");
		
		return forward;
	}
		
}
