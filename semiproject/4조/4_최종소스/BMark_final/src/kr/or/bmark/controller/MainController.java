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
import kr.or.bmark.service.DislikeOkService;
import kr.or.bmark.service.GroupBoardListService;
import kr.or.bmark.service.HitOkService;
import kr.or.bmark.service.LikeOkService;
import kr.or.bmark.service.MainBoardListService;
import kr.or.bmark.service.MainBookOkService;
import kr.or.bmark.service.MainCategoryListService;
import kr.or.bmark.service.MainMyBoardAddService;
import kr.or.bmark.service.MyBoardListService;
import kr.or.bmark.service.SiteChartCategoryService;
import kr.or.bmark.service.SiteChartListService;

@WebServlet("*.mainbmark")
public class MainController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doProcess(request, response);
   }
      
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
	   String requestURI = request.getRequestURI();
	   String contextPath = request.getContextPath();
	   String cmdURI = requestURI.substring(contextPath.length());
	   
	   ActionForward forward = new ActionForward();
	   Action action = null;
	   
	   // 메인에서 처음 초기화 했을 때, DB에 있는 카테고리들을 부려줘요
	   if(cmdURI.equals("/category.mainbmark")){
		   try {
			   action = new MainCategoryListService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   // 메인에서 처음 초기화 했을 때, 메인에 메인 데이터 뿌려주기
	   else if(cmdURI.equals("/mainboardwriteok.mainbmark")){
		   
		   try {
			   action = new MainBoardListService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   // 메인에서 처음 초기화 했을때 메인에 그룹데이터 뿌려주기
	   else if(cmdURI.equals("/groupboardwriteok.mainbmark")){
		   
		   try {
			   action = new GroupBoardListService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   // 좋아요 이미지 클릭시 +1 처리
	   else if(cmdURI.equals("/likeok.mainbmark")) {
		   
		   try {
			   action = new LikeOkService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   	   
	   // 싫어요 이미지 클릭시 +1 처리
	   else if(cmdURI.equals("/dislikeok.mainbmark")) {
		   
		   try {
			   action = new DislikeOkService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   // 사이트 링크 클릭시 조회수 +1 처리
	   else if(cmdURI.equals("/hitok.mainbmark")) {
		   
		   try {
			   action = new HitOkService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }	 
	   
	   
	   // 메인 북마크에서 마이북마크로 사이트 추가 처리
	   else if(cmdURI.equals("/starbook.mainbmark")) {
		   
		   try {
			   action = new MainBookOkService();
			   forward = action.execute(request, response);
		   } 
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   
	   // 새창으로 차트 페이지를 보여주는 서블릿
	   else if(cmdURI.equals("/sitechart.mainbmark")) {
			try {
				forward.setRedirect(false);
				forward.setPath("/views/chart/siteChartList.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
	   // 차트에서 보여줄 카테고리 목록들을 가져오는 서블릿
	   else if(cmdURI.equals("/sitechartcategory.mainbmark")) {
			try {
				action = new SiteChartCategoryService();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
	   // 차트를 보여주는 서블릿
	   else if(cmdURI.equals("/sitechartshow.mainbmark")) {
			try {
				action = new SiteChartListService();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
	   // 로그인된 사람에 따라서 그 사용자의 mybookmark를 보여주는...
	   else if(cmdURI.equals("/boardlist.mainbmark")) {
				try {
					action = new MyBoardListService();
					forward = action.execute(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
	   }
	   
	   //main my bookmark 사이트 추가하기
	   else if (cmdURI.equals("/boardadd.mainbmark")) {
 			try {
 				action = new MainMyBoardAddService();
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
}