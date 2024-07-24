import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PaidServlet
 */
public class PaidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read values from ctx 
				PrintWriter out=response.getWriter();
				ServletContext ctx=getServletContext();
				out.print("<html><body>");
				  Cookie c[]=request.getCookies();
				  out.println("Hi "+c[0].getValue());
			        out.println("<br>Your laptops <br>");
			        //read 
				String v[]=(String[])ctx.getAttribute("lap");
				for(int i=0;i<v.length;i++)
				{
					out.print(v[i]+"<br>");
				}
			out.print("<br>are on the way</body></html>");
			}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	}

}
