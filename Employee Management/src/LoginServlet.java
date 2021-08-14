

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter();
		
		
		//request.getRequestDispatcher("menu.jsp").include(request, response); 
		int dbid=0;
		String dbUsername = null,dbPassword = null,f_name=null,l_name=null;
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
	
		Connection con;
	
		
		try {
			
			DBConnection db = new DBConnection();
			con = new DBConnection().con;
			Statement st = con.createStatement();
		
		
		
		String query="SELECT * FROM user_details WHERE u_email='"+uname+"'AND u_password='"+pwd+"';";
		System.out.println("Query  = "+query);
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			dbid=rs.getInt("u_id");
			dbUsername=rs.getString("u_email");
			dbPassword=rs.getString("u_password");
			f_name = rs.getString("u_fname");
			l_name = rs.getString("u_lname");
		}
		
		//String fl_name = f_name+l_name;
		 
		
		
		
		if(uname.equals(dbUsername) && pwd.equals(dbPassword))
		{
			
			HttpSession session=request.getSession();
			
			session.setAttribute("name",uname);
			session.setAttribute("id", dbid);
			
			request.getRequestDispatcher("Home.jsp").include(request, response);
			out.print("<br><br><br><font style='color:white; margin-left:20%; font-size: 20px'><b>Welcome</b> "+f_name+" "+l_name+"</font>");
			
			//session.setMaxInactiveInterval(60);
			
			
			
		}
		else
		{
			System.out.println("Login Failed");
			out.print("<font style='color:white; font-size: 15px'><b>Wrong Usernae or Password. Enter Correct Details</b></font>");  
            request.getRequestDispatcher("index.html").include(request, response);  
		}
		
	
		response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
		
		
		
		}catch (Exception e)
			{
				System.out.println(e);
			}
		
		  
	}

}
