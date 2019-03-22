package kr.or.kosta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarDeleteServlet
 */
@WebServlet("/cardelete")
public class CarDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response , String method) throws ServletException, IOException {
		//공통적인  1,2 가지고 POST ,GET 다른 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
			HttpSession session = request.getSession();
			if(session != null) {
				//주의
				session.invalidate(); //로그 아웃
				
				//특정 값
				//session.removeAttribute("product");
			}else {
				out.print("생성된 session 이 없어요 <br>");
			}
		out.print("<a href='Product.html'>상품 구매 페이지 이동</a>");
		out.print("</body></html>");
	}

}







