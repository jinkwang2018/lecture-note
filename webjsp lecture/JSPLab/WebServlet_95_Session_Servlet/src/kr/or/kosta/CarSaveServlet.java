package kr.or.kosta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.collections.SynchronizedStack;

@WebServlet("/carsave")
public class CarSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CarSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String product = request.getParameter("product");
		
		//1. servlet : session객체 얻기////////////////////////
		HttpSession session = request.getSession();
		///////////////////////////////////////////////////중요!
		System.out.println("sessionID:" + session.getId());
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("product");
		System.out.println("list Collection :" + list);
		
		if(product == null) {
			System.out.println("상품 선택 하지 않았어요");
		}else{
			if(list == null){
				System.out.println("list Collection is null");
				list = new ArrayList<>();
				list.add(product);
				session.setAttribute("product", list);
			}else {
				System.out.println("list Collection is not null");
				list.add(product);
			}
		}
		
		out.print("<html><body>");
			out.print("<a href='carbasket'>장바구니 보기</a>");
		out.print("</body></html>");	
		
	}

}






