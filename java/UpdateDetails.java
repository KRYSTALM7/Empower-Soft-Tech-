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
import java.sql.ResultSet;

/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("driver loaded");
		  //establishing the connection 
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","system");
		System.out.println("Connected to database");
		}
		catch(Exception e)
		{
			System.out.println("problem");
		}
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("username");
		
		try {
		//connect to db and run query 
		PreparedStatement ps=con.prepareStatement("select * from myusers where uname=? ");
		ps.setString(1, u);
		System.out.println("value Inserted");
		

		ResultSet rs=ps.executeQuery();
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(rs.next())
		{
			out.println("<form action='UpdateDbDetails'>");
			out.println("Name <input type='text' value='"+rs.getString(1)+"' name='t5'><br>");
			out.println("Username <input type='text' value='"+rs.getString(2)+"' name='t6'><br>");
			out.println("Password <input type='text' value='"+rs.getString(3)+"' name='t7'><br>");
			out.println("Question <input type='text' value='"+rs.getString(4)+"' name='t8'><br>");
			out.println("Answer <input type='text' value='"+rs.getString(5)+"' name='t9'><br>");
			out.println("<input type='submit' value='Update'><br>");
			out.println("</form>");
		}
		else 
		{
			out.println("<h1>Invalid</h1>");
		}
		out.println("</body></html>");
		}
		catch(Exception e)
		{
			System.out.println("Problem"+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	}
}
