

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String s = request.getParameter("ID");
		System.out.println(s);
	
		out.print("<a href=showdata.jsp>Show</a>");
		
		ResultSet rs=null;
		
		String FName=null,LName=null,Mobile=null,Email=null,IDP=null,Address=null,State=null,District=null;
		
		FName=request.getParameter("FName");
		LName=request.getParameter("LName");
		Mobile=request.getParameter("Mobile");
		Email=request.getParameter("Email");
		IDP=request.getParameter("IDP");
		Address=request.getParameter("Address");
		State=request.getParameter("State");
		District=request.getParameter("District");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db","root","");
			System.out.println("Connected");
			
			
			String query="UPDATE user_details SET u_fname='"+FName+"',u_lname='"+LName+"',u_mobile='"+Mobile+"',u_email='"+Email+"',u_idproof='"+IDP+"',u_address='"+Address+"',u_state='"+State+"',u_dist='"+District+"'WHERE u_id="+s;
			
		System.out.println(query);
		
			PreparedStatement st = con.prepareStatement(query); 
			 
			System.out.println();
			
			//rs = st.getGeneratedKeys();
			//rs.getInt(1); 
		
			
			st.executeUpdate(); 
			out.println("<h4>Update Success..!!</h4>");
		
			// Close all the connections 
			st.close();
			
			con.close();
			
			  
            
			
			//out.println("<html><body><b>Successfully Inserted"+ "</b></body></html>"); 
			
		} catch (Exception e) {
			System.out.println("Error inside DBConnection class :\n Error in DBCOnnection Constructor "+e);
		}
		
		
		
	}

	

}
