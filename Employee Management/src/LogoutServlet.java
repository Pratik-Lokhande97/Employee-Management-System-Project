

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        HttpSession session=request.getSession(); 
        String uname=request.getParameter("uname");
        
        session.invalidate();  
          
        out.print("<br><font style='color:white; margin-left:10%; font-size: 20px'><b>You are successfully logout </b></font>");  
        request.getRequestDispatcher("index.html").include(request, response);  
        
        
        out.close();  

		
	}


}
