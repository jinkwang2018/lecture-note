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
import kr.or.bmark.service.GroupCheckedService;
import kr.or.bmark.service.GroupCreateService;
import kr.or.bmark.service.GroupJoinService;
import kr.or.bmark.service.GroupOutService;
import kr.or.bmark.service.MainGroupBoardAddService;
import kr.or.bmark.service.MainMyBoardAddService;

/* 
* @FileName : GroupController.java 
* @Project : BMark
* @Date : 2018.04.18 
* @Author : 김태웅 
*/
@WebServlet("*.group")
public class GroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GroupController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());

        ActionForward forward = new ActionForward();
        Action action = null;

        
        if(cmdURI.equals("/test.group")){
        	forward.setRedirect(false);
        	forward.setPath("/views/adminpage.jsp");
        	
    	/*
         * 회원 가입 컨트롤러
         */
		} else if(cmdURI.equals("/joinok.group")) {//회원목록 불러오기
			try {
				action = new GroupJoinService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		} 
        /*
         * 회원 탈퇴 컨트롤러
         */
		else if(cmdURI.equals("/outGroupok.group")) {
			try {
				action = new GroupOutService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
        /*
         * 회원의 즐겨찾기(북마크)한 List Data 가져오는 컨트롤러
         */
		else if(cmdURI.equals("/starbook.group")) {
			try {
				action = new GroupCheckedService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
        
        //main my bookmark 사이트 추가하기
		else if (cmdURI.equals("/groupboardadd.group")) {
			try {
				action = new MainGroupBoardAddService();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
        //main my bookmark 사이트 추가하기
  		else if (cmdURI.equals("/addnewgroup.group")) {
  			try {
  				action = new GroupCreateService();
  				forward = action.execute(request, response);

  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  		}
        
        if(forward != null){
        	if(forward.isRedirect()) {
        		response.sendRedirect(forward.getPath());
        	}
        	else {
        		RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
        		dis.forward(request, response);
        	}
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
