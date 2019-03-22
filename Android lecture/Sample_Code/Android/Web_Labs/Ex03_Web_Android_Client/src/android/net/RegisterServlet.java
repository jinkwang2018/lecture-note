package android.net;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");// post 방식일때는 request 처리 
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");		
		String address=request.getParameter("address");
		System.out.println("RegisterServlet doPost..."+id+" "+password+" "+name+" "+address);
		
		JSONObject obj=new JSONObject();
		try {
			obj.put("message", name+"님 register ok!!");
			out.print(obj.toString());
			System.out.println(obj.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");// post 방식일때는 request 처리 
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");		
		String address=request.getParameter("address");
		System.out.println("RegisterServlet doPost..."+id+" "+password+" "+name+" "+address);
		
		JSONObject obj=new JSONObject();
		try {
			obj.put("message", name+"님 register ok!!");
			out.print(obj.toString());
			System.out.println(obj.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.close();
	}
}





