package kr.or.kosta.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.action.Action;
import kr.or.kosta.action.ActionForward;
import kr.or.kosta.dao.boarddao;

import kr.or.kosta.dto.board;


public class viewlistAction implements Action{
	
		@Override 
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			boarddao dao = new boarddao();
			
			ActionForward foward = null;
			try {
				String psStr = request.getParameter("ps");    //pagesize
		        String cpStr = request.getParameter("cp"); 
		        if(psStr == null || psStr.trim().equals("")){
		            //default 값
		            psStr = "5"; // default 5건씩 
		        }
		        
		        if(cpStr == null || cpStr.trim().equals("")){
		            cpStr= "1";        //default 1 page
		        }
		      
				  request.setCharacterEncoding("UTF-8");
				  int cpage = Integer.parseInt(cpStr);
				  int pagesize = Integer.parseInt(psStr);
				  int pagecount = 0; 
				  
				  if(totalboardCount % pagesize==0){        //전체 건수 , pagesize > 
			            pagecount = totalboardCount/pagesize;
			        }else{
			            pagecount = (totalboardCount/pagesize) + 1;
			        }
				 
				  
				  List<board> list = dao.list(cpage, pagesize);
				  int total = dao.totalboardCount();
				    //request.setAttribute("row", n);
				   
				   String url ="board_list.jsp";
				   
				   request.setAttribute("board_url", url); 
				   request.setAttribute("total", total); 
				   request.setAttribute("list",list);
				   
				   foward = new ActionForward();
	       	       foward.setRedirect(false);
	       	       foward.setPath("/WEB-INF/views/redirect.jsp");
	       	       
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return foward;
		}
		
		   
		 
		
		   
	      
}
