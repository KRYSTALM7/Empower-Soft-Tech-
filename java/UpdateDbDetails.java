import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UpdateDbDetails
 */
public class UpdateDbDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading form params 
				String n1=request.getParameter("t6");
				String u1=request.getParameter("t6");
				String p1=request.getParameter("t7");
				String q1=request.getParameter("t8");
		       String a1=request.getParameter("t9"); 
				//jdbc code 
				try 
				{
					//loading the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("driver loaded");
				  //establishing the connection 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","system");
				System.out.println("Connected to database");
				PrintWriter out=response.getWriter();
				PreparedStatement ps=con.prepareStatement("update myusers set name=?,password=?,question=?,answer=? where uname=?");
				//set ?
			
				ps.setString(1,n1);
				ps.setString(2,p1);
				ps.setString(3,q1);
		        ps.setString(4, a1);
		        ps.setString(5,u1);
				//execute 
				int k=ps.executeUpdate();
				out.println("<html><body>");
				if(k>0)
				{
					out.println("<h2>Values Updated</h2>");
				}
				out.println("</body></html>");
				}
				catch(Exception e)
				{
					System.out.println("some problem "+e);
				}
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	}

}
