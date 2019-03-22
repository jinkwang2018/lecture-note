package kr.or.kosta.Controller;
import kr.or.kosta.Action.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("*.bbs")
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.setCharacterEncoding("UTF-8");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());
        
        //BoardCmd cmd = null;
        //String viewPage = null;
        ActionForward forward = new ActionForward();
        Action action = null;

        // 글 작성 화면 요청이 들어왔을때, ok
        if(cmdURI.equals("/boardwrite.bbs")){
        	forward.setRedirect(false);
        	forward.setPath("/board/board_write.jsp");
        }
        
        // 글 작성 요청, ok
        else if(cmdURI.equals("/boardwriteok.bbs")){
        	
        	action = new BoardWriteAction();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 리스트 보여주기, ok
        else if(cmdURI.equals("/boardlist.bbs")){
        	
        	action = new BoardListAction();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 상세보기, ok
        else if(cmdURI.equals("/boardRead.bbs")){
        	action = new BoardContentAction();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 화면 제공, ok
        else if(cmdURI.equals("/boardEditForm.bbs")){
        	action = new BoardEditAction();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 처리, ok
        else  if(cmdURI.equals("/boardEdit.bbs")){
        	action = new BoardEditOkAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 글 삭제 비밀번호 확인 화면 제공, ok
        else if(cmdURI.equals("/boardDeletePassword.bbs")){
        	forward.setRedirect(false);
        	forward.setPath("/board/board_delete.jsp");
        }
        
        
        // 글 삭제 비밀번호 확인 처리, ok
        else if(cmdURI.equals("/boardDeleteCheck.bbs")){
        	action = new BoardDeleteAction();
        	
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
        	forward.setPath("/board/board_rewrite.jsp");
        }
        
        // 답글 작성
        else if(cmdURI.equals("/boardRewriteok.bbs")) {
        	action = new BoardRewriteOkAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 작성
        else if(cmdURI.equals("/boardReplyok.bbs")) {
        	action = new BoardReplyAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 댓글 삭제
        else if(cmdURI.equals("/boardreplyDeleteOk.bbs")) {
        	action = new BoardReplyDeleteAction();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        /*
        /*
        // 글 작세 비밀번호 오류 화면 제공
        if(cmdURI.equals("/boardDeleteError.bbs")){
           viewPage = "boardDeleteError.jsp";
        }
        
        // 글 삭제 처리
        if(cmdURI.equals("/boardDelete.bbs")){
           cmd = new BoardDeleteCmd();
           cmd.execute(request, response);
           viewPage = "boardList.bbs";
        }
        
        // 글 검색 처리
        if(cmdURI.equals("/boardSearch.bbs")){
           cmd = new BoardSearchCmd();
           cmd.execute(request, response);
           viewPage = "boardSearchList.jsp";
        }
        
        // 답글 작성 화면 제공
        if(cmdURI.equals("/boardReplyForm.bbs")){
           cmd = new BoardReplyFormCmd();
           cmd.execute(request, response);
           viewPage = "boardReply.jsp";
        }
        
        // 답글 작성 처리
        if(cmdURI.equals("/boardReply.bbs")){
           cmd = new BoardReplyCmd();
           cmd.execute(request, response);
           viewPage = "boardList.bbs";
        }*/
        
     
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