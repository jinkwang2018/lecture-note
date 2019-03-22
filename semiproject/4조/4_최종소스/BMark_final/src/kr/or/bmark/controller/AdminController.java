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
import kr.or.bmark.service.AdminMemberPagingService;
import kr.or.bmark.service.AdminMemberService;
import kr.or.bmark.service.MypageMyBoardDeleteService;
import kr.or.bmark.service.AdminGroupPagingService;
import kr.or.bmark.service.AdminGroupService;
import kr.or.bmark.service.AdminMainInsertService;
import kr.or.bmark.service.AdminMainService;
import kr.or.bmark.service.AdminMemberDeleteService;
import kr.or.bmark.service.AdminMemberInfoUpdateService;
import kr.or.bmark.service.AdminMainPagingService;
import kr.or.bmark.service.AdminMainDeleteService;

@WebServlet("*.admin")
public class AdminController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());

        ActionForward forward = new ActionForward();
        Action action = null;

        // 글 작성 화면 요청이 들어왔을때, ok
        if(cmdURI.equals("/member.admin")){
        	forward.setRedirect(false);
        	forward.setPath("/views/adminpage.jsp");
        		
		}  else if(cmdURI.equals("/memberlist.admin")) {//회원목록 불러오기
			try {
				action = new AdminMemberService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}  else if(cmdURI.equals("/memberlistpaging.admin")) {//회원목록 페이징처리
			try {
				action = new AdminMemberPagingService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
        
	    }  else if(cmdURI.equals("/grouplist.admin")) {//그룹목록 불러오기
			try {
				action = new AdminGroupService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}  else if(cmdURI.equals("/grouplistpaging.admin")) {//그룹목록 페이징처리
			try {
				action = new AdminGroupPagingService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
        
	    }  else if(cmdURI.equals("/mainlist.admin")) {//메인사이트 불러오기
			try {
				action = new AdminMainService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}	
	    }  else if(cmdURI.equals("/mainlistpaging.admin")) {//메인사이트 불러오기
			try {
				action = new AdminMainPagingService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }  else if(cmdURI.equals("/maininsert.admin")) {//메인사이트 추가
			try {
				action = new AdminMainInsertService();
				forward = action.execute(request, response);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		
		// 메인 사이트 삭제하기
	    }	else if (cmdURI.equals("/maindelete.admin")) {
     		try {
     			action = new AdminMainDeleteService();
     			forward = action.execute(request, response);

     		} catch (Exception e) {
     			e.printStackTrace();
     		}
     	// 메인 사이트 수정하기
//	    }	else if (cmdURI.equals("/mainupdate.admin")) {
//     		try {
//     			action = new AdminMainUpdateService();
//     			forward = action.execute(request, response);
//
//     		} catch (Exception e) {
//     			e.printStackTrace();
//     		}
     	
        
	}  else if(cmdURI.equals("/memberdelete.admin")) {//회원 삭제하기 
		try {
			action = new AdminMemberDeleteService();
			forward = action.execute(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}  else if(cmdURI.equals("/memberupdate.admin")) {//회원 수정하기
		try {
			action = new AdminMemberInfoUpdateService();
			forward = action.execute(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
        
        
        /*RequestDispatcher dis = request.getRequestDispatcher(viewPage);
        dis.forward(request, response);*/
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