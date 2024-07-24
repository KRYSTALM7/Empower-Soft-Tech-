import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html><body><form action='PaidServlet'>");
        //read form values 
		String uname=request.getParameter("t1");
		
		//cookie 
		Cookie ck=new Cookie("username", uname);
		//add cookie to response
		response.addCookie(ck);
		 
		   out.println("Hi "+uname);
			out.println("<br>you have selected :<br>");
		Enumeration e=request.getParameterNames();
		 long total=0;
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
	      String value[]=request.getParameterValues(name);
			
			//create servlet context 
			ServletContext ctx=getServletContext();
			//add value in ctx
			ctx.setAttribute("lap", value);  //key,value
            int len=value.length;
		   
		   
		  
		    if(len>0)
		    {
		    	for (int i=0;i<len;i++)
		    	{  
		    		if(value[i].equals(uname))
		    		{
		    			
		    		}
		    		else {
		    			
		    		
          		out.println(value[i]+"<br>");
		    		System.out.println(value[i]);
		    		if(value[i].equals("HP")) {
		    			total=total+40000;
		    		}
		    		if(value[i].equals("LEN")) {
		    			total=total+35000;
		    		}
		    		
		    		if(value[i].equals("DELL")) {
		    			total=total+50000;
		    		}
		    		}	
		    	}
		    }
		  
		    
			
		}
		 out.println("<br>Total<br>"+total);
		out.println("<input type='submit' value='confirm'>");
		out.println("</form>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
