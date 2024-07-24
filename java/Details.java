

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
 * Servlet implementation class Details
 */
public class Details extends HttpServlet {
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);

	try {
	//connect to db and run query 
	PreparedStatement ps=con.prepareStatement("select * from myusers where  uname=? and password=? ");

	String u=request.getParameter("t1");
	String p=request.getParameter("t2");

	

	ps.setString(1, u);
	ps.setString(2, p);

	ResultSet rs=ps.executeQuery();
	PrintWriter out=response.getWriter();
	out.println("<html><body>");
	if(rs.next())
	{

		
		 out.println(" <table width='100%' border='1'>");
         out.println("<caption>");
         out.println("  <h2><b><u>Details Of User</b><u	</h2>");
         out.println(" </caption>");
         out.println("<tr>");
         out.println("  <th scope='col' width='5%'>Name</th>");
         out.println(" <th scope='col'width='30%'> UserName</th>");
         out.println(" <th scope='col'width='10%'>Password</th>");
         out.println(" <th scope='col'width='15%'>Security Question</th>");
         out.println("  <th scope='col'width='15%'>Answer</th>");
          out.println(" </tr>");
         out.println("<tr>");
         out.println("  <td>" + rs.getString(1) + "</td>");
         out.println("  <td>" + rs.getString(2)+ "</td>");
         out.println("  <td>" +rs.getString(3)  + "</td>");
         out.println(" <td>" +  rs.getString(4)+ "</td>");
         out.println(" <td>" + rs.getString(5) + "</td>");
         out.println("<br>");
         out.println("<br>");
          out.println("<a href= Login.html>Back to Main page</a>");
          out.println("<br><a href='UpdateDetails?username="+rs.getString(2)+"'>Update Details?</a>");
          
	}
	else 
	{
		out.println("<h1>Your Details Are Not Matching</h1>");
	}
	out.println("</ol></body></html>");
	}
	catch(Exception e)
	{
		System.out.println("Problem"+e);
	}
	
	
	
	}

}
