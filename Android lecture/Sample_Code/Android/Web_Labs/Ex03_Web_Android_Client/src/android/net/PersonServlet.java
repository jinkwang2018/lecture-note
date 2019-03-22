package android.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    Map map;
	@Override
	public void init() throws ServletException {		
		super.init();
		map=new HashMap();
		map.put("보아", "22");
		map.put("아이유", "18");
		map.put("김구라", "39");
		System.out.println("init().."+map);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");	
		String age=(String)map.get(name);
		if(age!=null){
		out.println(age);
		}else{
			out.println("존재하지 않습니다!");	
		}
		System.out.println("person servlet doGet...");
		out.close();
	}//http://localhost:8888/androidtest1/PersonServlet?name=아이유 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");// post 방식일때는 request 처리 
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");		
		String age=(String)map.get(name);
		if(age!=null){
		out.println(age);
		}else{
			out.println("존재하지 않습니다!");	
		}
		System.out.println("PersonServlet doPost()...");
		out.close();
	}
}

