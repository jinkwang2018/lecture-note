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
 * Servlet implementation class FindServlet
 */
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();		
		
		String id=request.getParameter("id");
		
		System.out.println("id:"+id);
		
		JSONObject obj=new JSONObject();
		if("java".equals(id)){  // name , address 
			//JSON Object 생성해서 클라이언트에 응답한다. 
		try {
				obj.put("name", "아이유");
				obj.put("address", "종로");
				out.print(obj.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}			
		}	
		System.out.println("doPost..find.."+obj.toString());
		out.close();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();		
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		JSONObject obj=new JSONObject();
		if("java".equals(id)){  // name , address 
			//JSON Object 생성해서 클라이언트에 응답한다. 
		try {
				obj.put("name", "아이유");
				obj.put("address", "종로");
				out.print(obj.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}			
		}	
		System.out.println("doPost..find.."+obj.toString());
		out.close();
	}
}

