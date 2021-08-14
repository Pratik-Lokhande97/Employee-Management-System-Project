

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
          
        HttpSession session=request.getSession(false);  
        if(session!=null)
        {  
        	String name=(String)session.getAttribute("name");  
          
        	// out.print("Hello, "+name+" Welcome to Profile");
        	
        	out.print("<br><br><font style='color:white; font-size: 22px;'><b style='margin-left: 5.5em'>Hello  </b>  "+name+"  <b>  Welcome to Profile</b></font>");
        
        	request.getRequestDispatcher("Home.jsp").include(request, response);
        	
       
        	
        	String id=null,fname=null,lname=null,mobile=null,idproof=null,address=null,state=null,city=null;
        	
        	String e_id=null,e_email=null,e_mob=null,e_edu=null,e_post=null,e_exp=null;
    		
        	Connection con;
    		
    		ServletContext context = getServletContext();
    		
    		String url = context.getInitParameter("url");
    		String database = context.getInitParameter("database name");
    		String username = context.getInitParameter("username");
    		String password = context.getInitParameter("password");
    		
    		try 
    		{
    			DBConnection db = new DBConnection();
    			con = new DBConnection().con;
    			Statement st = con.createStatement();
    		
    			String query1="SELECT u_id,u_fname,u_lname,u_mobile,u_idproof,u_address,u_state,u_dist FROM user_details WHERE u_email='"+name+"'";
    			System.out.println(query1);
    			ResultSet rs1 = st.executeQuery(query1);
    			
    			while(rs1.next())
    			{
    				id = rs1.getString("u_id");
    				fname = rs1.getString("u_fname");
    				lname = rs1.getString("u_lname");
    				mobile = rs1.getString("u_mobile");
    				idproof = rs1.getString("u_idproof");
    				address = rs1.getString("u_address");
    				state = rs1.getString("u_state");
    				city = rs1.getString("u_dist");
    				
    				
    			}
    			
    			String query2="SELECT * FROM job_details WHERE emp_email='"+name+"'";
    			System.out.println(query2);
    			ResultSet rs2 = st.executeQuery(query2);
    			
    			
    			while(rs2.next())
    			{
    				e_id=rs2.getString("emp_id");
    				e_email=rs2.getString("emp_email");
    				e_mob=rs2.getString("emp_mobile");
    				e_edu=rs2.getString("emp_education");
    				e_post=rs2.getString("emp_post");
    				e_exp=rs2.getString("emp_experience");
    				
    				
    			}
    			
    			//"<table>\r\n" +
    			
    			//
    			
    			out.println("<table>\r\n" + 
    					"<tr><th colspan=\"10\">Personal Details</th></tr>  \r\n" + 
    					"<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Mobile No</th><th>ID Proof</th><th>Address</th><th>City</th><th>State</th></tr>\r\n" + 
    					"<tr><td>"+id+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+mobile+"</td><td>"+idproof+"</td><td>"+address+"</td><td>"+city+"</td><td>"+state+"</td></tr>\r\n"+ 
    					"</table>");
    			
    			/*out.println("<table>\r\n" +
    			"<tr><td>"+id+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+mobile+"</td><td>"+idproof+"</td><td>"+address+"</td><td>"+city+"</td><td>"+state+"</td></tr>\r\n"+ 
				"</table>" );
    			*/
    			
    			out.println("<table>\r\n" + 
    					"<tr><th colspan=\"11\">Job Details</th></tr>  \r\n" + 
    					"<tr><th>Employee ID</th><th>Email</th><th>Mobile No</th><th>Education</th><th>Post</th><th>Years of Experience</th><th>Action</th></tr>\r\n" + 
    					"<tr><td>"+e_id+"</td><td>"+e_email+"</td><td>"+e_mob+"</td><td>"+e_edu+"</td><td>"+e_post+"</td><td>"+e_exp+"</td><td><a href='UpdateJobDetails.html'>Update Details</a></td></tr>\r\n"+ 
    					"</table>");
    			
    			/*out.println("<table>\r\n" +
    	    			"<tr><td>"+e_id+"</td><td>"+e_email+"</td><td>"+e_mob+"</td><td>"+e_edu+"</td><td>"+e_post+"</td><td>"+e_exp+"</td></tr>\r\n"+ 
    					"</table>" );
    			*/
    			
    			
    			
    			
    			out.print("<br><br><font style='color:white; font-size: 22px; margin-left: 5.5em'>If you don't see Job Details Please</font> ");
    			out.print("<a href='JobDetails.html' class='space' style= 'font-size: 20px'> Insert Job Details</a>");
    			
    			//out.print("<a href='UpdateJobDetails.html'  class='space' style= 'font-size: 20px'> Update Job Details</a>");
    			
    		}catch(Exception e)
    		{
    			System.out.println(e);
    		}
        
        }  
        else
        {  
            out.print("<font style='color:white; font-size: 20px'><b>Please Login First</b></font>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
          
        
      
        out.close();

	}

	

}
