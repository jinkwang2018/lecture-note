package kr.or.bmark.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.service.MyPageMyBoardListAgainService;
import kr.or.bmark.service.MyPageMyBoardListService;
import kr.or.bmark.service.MypageGroupBoardListAgainService;
import kr.or.bmark.service.MypageGroupBoardListService;
import kr.or.bmark.service.MypageMemberInfoDeleteService;
import kr.or.bmark.service.MypageMemberInfoSendService;
import kr.or.bmark.service.MypageMemberInfoUpdateService;
import kr.or.bmark.service.MypageMyBoardDeleteService;

/* 
* @FileName : MyController.java 
* @Project : BMark
* @Date : 2018.04.10. 
* @Author : 김래영 
*/
@WebServlet("*.mybmark")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyController() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		
		ActionForward forward = new ActionForward();
		Action action = null;

		if(cmdURI.equals("/mypage.mybmark")) {//마이페이지로 가는 URL
			forward.setRedirect(false);
			forward.setPath("/views/mypage.jsp");
			
		} else if(cmdURI.equals("/mypagememberedit.mybmark")) {//마이페이지 개인정보 수정 누르면 들어가는 URL
			try {
				action = new MypageMemberInfoSendService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}  else if(cmdURI.equals("/mypagememberupdate.mybmark")) {//마이페이지에서 개인정보 수정 완료하면 데이터가 들어가는 URL
			try {
				action = new MypageMemberInfoUpdateService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
		}  else if(cmdURI.equals("/mypagememberdelete.mybmark")) {//마이페이지에서 개인정보 수정 완료하면 데이터가 들어가는 URL
			try {
				action = new MypageMemberInfoDeleteService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}  else if(cmdURI.equals("/mypagegroupboardlist.mybmark")) {//마이페이지에서 그룹북마크를 가지고오는 함수
			try {
				action = new MypageGroupBoardListService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmdURI.equals("/mypagegroupboardlistagain.mybmark")) {//마이페이지에서 그룹북마크 게시판 페이징처리 데이터보내주기
			try {
				action = new MypageGroupBoardListAgainService();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  else if(cmdURI.equals("/mypagemyblist.mybmark")) {//마이 페이지 mybook mark 게시판 보여주기
			try {
				action = new MyPageMyBoardListService();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}			
		}  else if(cmdURI.equals("/mypagemyblistagain.mybmark")) {//마이 페이지 mybook mark 게시판 페이징처리 데이터 보내주기
			try {
				action = new MyPageMyBoardListAgainService();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		// 마이 페이지 mybook mark 사이트 데이터 삭제하기
		else if (cmdURI.equals("/mypagemyboarddelete.mybmark")) {
			try {
				action = new MypageMyBoardDeleteService();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}