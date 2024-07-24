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
 * Servlet implementation class Account
 */

public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	Connection con;
	public void init()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("driver loaded");
		  //establishing the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("Connected to database");
		}
		catch(Exception e)
		{
			System.out.println("problem");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	//read values from html 
			String u=request.getParameter("t1");
			String p=request.getParameter("t2");
			try {
			//connect to db and run query 
			PreparedStatement ps=con.prepareStatement("select * from myusers where uname=? and password=?");
			ps.setString(1, u);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			if(rs.next())
			{
				out.println("<h1>Valid</h1>");
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
	
	}


