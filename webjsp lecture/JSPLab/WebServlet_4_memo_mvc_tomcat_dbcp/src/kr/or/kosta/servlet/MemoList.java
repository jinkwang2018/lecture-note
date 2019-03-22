package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.memodao;
import kr.or.kosta.dto.memo;


@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
 private static final long serialVersionUID = 1L;
       

    public MemoList() {
        super();
       
    }

 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doProcess(request, response);
 }

 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doProcess(request, response);
 }

 private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	// View page 별도 사용 : memolist.jsp
	    
	 
        try { 
        	 
        	 memodao dao = new memodao();
        	 ArrayList<memo> memolist = dao.getMemoList();
        	 
        	 //요청 결과 저장
        	 request.setAttribute("memolist", memolist);
        	 
        	 //view 페이지 설정
        	 RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
             dis.forward(request, response);
        } catch (Exception e) { 
             
           System.out.println(e.getMessage());
        } 
         

    }//End service()------------ 
}
