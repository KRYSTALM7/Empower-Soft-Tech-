

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
 * Servlet implementation class Validation
 */
public class Validation extends HttpServlet {
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
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	//read values from html 
			String u=request.getParameter("t1");
			String q=request.getParameter("t2");
			String a=request.getParameter("t3");
			try {
			//connect to db and run query 
			PreparedStatement ps=con.prepareStatement("select * from myusers where uname=? and question=? and answer=?");
			ps.setString(1, u);
			ps.setString(2, q);
			ps.setString(3, a);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			if(rs.next())
			{
				out.println("<h1>Your Password Is</h1>"+rs.getString(3));
			}
			else 
			{
				out.println("<h1>Your Details Are Not Matching</h1>");
			}
			out.println("</body></html>");
			}
			catch(Exception e)
			{
				System.out.println("Problem"+e);
			}
	
	
	}

}
