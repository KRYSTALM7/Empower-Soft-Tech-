import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read form values 
				String uname=request.getParameter("t1");
				String sid=request.getParameter("sid");
				//cookie 
				Cookie ck=new Cookie("username", uname);
				//add cookie to response
				response.addCookie(ck);
				PrintWriter out=response.getWriter();
				out.println("<html><body>");
				out.println("Welcome "+uname);
				out.println("<br>session id"+sid);
				out.println("<br><form action='Servlet2'><input type='submit' value='View Profile'></form>");
				out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
