package kr.or.kosta.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.memodao;

public class MemoAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward foward = null;
		try {
			 
			  request.setCharacterEncoding("UTF-8");
			
			  String id = request.getParameter("id");
			  String email = request.getParameter("email");
			  String memo = request.getParameter("memo");
			  
			   memodao dao = new memodao();
			   int result = dao.insertMemo(id, email, memo);
				 
			    //request.setAttribute("row", n);
			   String msg = "";
			   String url ="";
			   
			      if(result > 0){
					  msg = "등록성공";
					  url ="MemoList.memo";
				  }else{
					  msg = "등록실패";
					  url ="memo.html";
				  }
				  request.setAttribute("board_msg", msg);
				  request.setAttribute("board_url", url); 
			   
			  /* 
			   response.setContentType("text/html;charset=UTF-8");
				  
				   PrintWriter out = response.getWriter();
				   if(result>0){
					 out.print("<script>");
				     out.print("alert('등록성공..');");
				     out.print("</script>");
				     out.print("<script>");
				     out.print("location.href='MemoList.memo';");
				     out.print("</script>");
				     return null;
				   }else{
				     out.print("<script>");
				     out.print("alert('등록실패..');");
				     out.print("</script>");
				     out.print("<script>");
				     out.print("location.href='memo.html';");
				     out.print("</script>");
				     return null;
				     
				   }
			   
			   
			    
			      if(result > 0){
					  msg = "edit success";
					  url ="board_list.jsp";
				  }else{
					  msg = "edit fail";
					  url ="board_edit.jsp?idx="+idx;
				  }
				  request.setAttribute("board_msg", msg);
				  request.setAttribute("board_url", url); 
				
				  */
			   
			   foward = new ActionForward();
       	       foward.setRedirect(false);
       	       foward.setPath("/WEB-INF/views/redirect.jsp");
       	       
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return foward;
	}

}
