import jakarta.servlet.ServletConfig;
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
 * Servlet implementation class Form1
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//reading form params 
		String n=request.getParameter("t1");
		String u=request.getParameter("t2");
		String p=request.getParameter("t3");
		String q=request.getParameter("t4");
       String a=request.getParameter("t5"); 
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
		PreparedStatement ps=con.prepareStatement("insert into myusers values(?,?,?,?,?)");
		//set ?
		ps.setString(1,n);
		ps.setString(2,u);
		ps.setString(3,p);
		ps.setString(4,q);
        ps.setString(5, a);
		//execute 
		int k=ps.executeUpdate();
		out.println("<html><body>");
		if(k>0)
		{
			out.println("<h2>User Registered</h2>");
		}
		out.println("</body></html>");
		}
		catch(Exception e)
		{
			System.out.println("some problem "+e);
		}
		
	}

}
