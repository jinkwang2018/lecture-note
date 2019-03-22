package kr.or.bit.controller;
import kr.or.bit.action.*;
import kr.or.bit.service.BoardContentService;
import kr.or.bit.service.BoardDeleteService;
import kr.or.bit.service.BoardEditOkService;
import kr.or.bit.service.BoardEditService;
import kr.or.bit.service.BoardFileDownloadService;
import kr.or.bit.service.BoardListService;
import kr.or.bit.service.BoardReplyDeleteService;
import kr.or.bit.service.BoardReplyListService;
import kr.or.bit.service.BoardReplyService;
import kr.or.bit.service.BoardRewriteOkService;
import kr.or.bit.service.BoardSearchService;
import kr.or.bit.service.BoardWriteService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("*.bbs")
public class BoardFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.setCharacterEncoding("UTF-8");
    	String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());
        
        
        ActionForward forward = new ActionForward();
        Action action = null;

        // 글 작성 화면 요청이 들어왔을때
        if(cmdURI.equals("/boardwrite.bbs")){
        	forward.setRedirect(false);
        	forward.setPath("/board/BoardWrite.jsp");
        }
        
        // 글 작성 요청
        else if(cmdURI.equals("/boardwriteok.bbs")){
        	
        	action = new BoardWriteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }

        // 글 리스트 보여주기
        else if(cmdURI.equals("/boardlist.bbs")){
        	action = new BoardListService();
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 검색 처리
        else if(cmdURI.equals("/boardSearch.bbs")){
        	action = new BoardSearchService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
 
        
        // 글 상세보기
        else if(cmdURI.equals("/boardRead.bbs")){
        	action = new BoardContentService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 화면 제공
        else if(cmdURI.equals("/boardEditForm.bbs")){
        	action = new BoardEditService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 처리
        else  if(cmdURI.equals("/boardEdit.bbs")){
        	action = new BoardEditOkService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
        // 글 삭제 비밀번호 확인 처리
        else if(cmdURI.equals("/boardDeleteCheck.bbs")){
        	action = new BoardDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 답글작성 화면제공
        else if(cmdURI.equals("/boardRewrite.bbs")) {
        	forward.setRedirect(false);
        	forward.setPath("/board/BoardRewrite.jsp");
        }
        
        // 답글 작성
        else if(cmdURI.equals("/boardRewriteok.bbs")) {
        	action = new BoardRewriteOkService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 작성
        else if(cmdURI.equals("/boardReplyok.bbs")) {
        	action = new BoardReplyService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 목록
        else if(cmdURI.equals("/replylist.bbs")) {
        	System.out.println("replylist.bbs 타는지욥?");
        	action = new BoardReplyListService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 삭제
        else if(cmdURI.equals("/boardreplyDeleteOk.bbs")) {
        	action = new BoardReplyDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 파일을 클릭하여 다운로드 요청
        else if(cmdURI.equals("/BoardFileDownloadService.bbs")) {
        		action = new BoardFileDownloadService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
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