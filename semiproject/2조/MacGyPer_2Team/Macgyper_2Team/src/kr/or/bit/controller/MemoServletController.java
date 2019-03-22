package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.BookDeleteService;
import kr.or.bit.service.BookInserteService;
import kr.or.bit.service.BookListService;
import kr.or.bit.service.BookSearchService;
import kr.or.bit.service.BookSelectMemoService;
import kr.or.bit.service.BookWriteService;
import kr.or.bit.service.InsertMemoService;
import kr.or.bit.service.MemoDeleteService;
import kr.or.bit.service.MemoListService;
import kr.or.bit.service.MemoSelectService;
import kr.or.bit.service.MemoUpdateService;
import kr.or.bit.service.MemoSearchService;


@WebServlet("*.mo")
public class MemoServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemoServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.setCharacterEncoding("UTF-8");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String cmdURI = requestURI.substring(contextPath.length());
        System.out.println(cmdURI);
        
        ActionForward forward = new ActionForward();
        Action action = null;

        // 글 작성 화면 요청이 들어왔을때
        if(cmdURI.equals("/WriteMemo.mo")){
        	
        	action = new BookWriteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}

        }
        // 글 작성 요청
        else if(cmdURI.equals("/InsertMemo.mo")){
        	
        	action = new InsertMemoService();
        	try {
        		
				forward = action.execute(request, response);
				
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 리스트 보여주기
        else if(cmdURI.equals("/MemoList.mo")){
        	action = new MemoListService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        else if(cmdURI.equals("/BookList.mo")){
        	
        	action = new BookListService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        // 글 상세보기
        else if(cmdURI.equals("/DeleteMemo.mo")){
        	
        	action = new MemoDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
        // 글 수정 화면 제공
        else if(cmdURI.equals("/UpdateMemo.mo")){
        	
        	action = new MemoSelectService();
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 글 수정 처리
        else  if(cmdURI.equals("/UpdateMemoOk.mo")){
        	action = new MemoUpdateService();
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 글 삭제 비밀번호 확인 처리
        else if(cmdURI.equals("/InsertBook.mo")){
        	action = new BookInserteService();
        	
        	try {
				forward = action.execute(request, response);
			} 
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        else if(cmdURI.equals("/SelectMemo.mo")) {
        	action = new BookSelectMemoService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // 답글 작성
        else if(cmdURI.equals("/DeleteBook.mo")) {
        	action = new BookDeleteService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        else if(cmdURI.equals("/SearchMemo.mo")) {
        	
        	action = new MemoSearchService();
        	
        	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        else if(cmdURI.equals("/SearchBook.mo")) {
        	
        	action = new BookSearchService();
        	
        	try {
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

}
