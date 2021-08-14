

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistrationDao;
import com.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String fname,lname,mob,email,password,gender,idproof,address,state,dist;
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ResultSet rs=null;
		
		/*
		fname = request.getParameter("FName");
		lname = request.getParameter("LName");
		mob = request.getParameter("Mobile");
		email = request.getParameter("Email");
		password = request.getParameter("pwd");
		gender = request.getParameter("Gender");
		idproof = request.getParameter("ID");
		address = request.getParameter("Address");
		state = request.getParameter("State");
		dist = request.getParameter("District");
		
		
		out.println(fname);
		out.println(lname);
		out.println(mob);
		out.println(email);
		out.println(password);
		out.println(gender);
		out.println(idproof);
		out.println(address);
		out.println(state);
		out.println(dist);
		*/
		User u = new User();
		u.setName("fname");
		u.setLname("lname");
		
		RegistrationDao rd1 = new RegistrationDao(); 
		rd1.save(u);
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db","root","");
			System.out.println("Connected");
			String query=" INSERT INTO user_details (u_fname, u_lname, u_mobile, u_email, u_password, u_gender,u_idproof,u_address, u_state, u_dist) VALUES (?,?,?,?,?,?,?,?,?,?) ";
			String query2="INSERT INTO login (username, password) VALUES (?,?)";
			PreparedStatement st = con.prepareStatement(query); 
			PreparedStatement st1 = con.prepareStatement(query2); 
			//rs = st.getGeneratedKeys();
			//rs.getInt(1); 
			
			String[] proof = request.getParameterValues("ID"); ;
		    StringBuffer Id  = new StringBuffer();
		      for(int i = 0; i < proof.length; i++) {
		         Id.append(proof[i]+",");
		      }
		      String str = Id.toString();
		      //System.out.print(str);
			
			/*String[] Id=request.getParameterValues("ID");
			for(int i=0;i<3;i++)
			{
				System.out.println(Id[i]);
			}*/
			st.setString(1, request.getParameter("FName")); 
			st.setString(2, request.getParameter("LName")); 
			st.setString(3, request.getParameter("Mobile")); 
			st.setString(4, request.getParameter("Email")); 
			st.setString(5, request.getParameter("pwd")); 
			st.setString(6, request.getParameter("Gender")); 
			st.setString(7, str);
			//st.setString(7, request.getParameter("ID")); 
			st.setString(8, request.getParameter("Address")); 
			st.setString(9,request.getParameter("State")); 
			st.setString(10,request.getParameter("District")); 
			
			
			
			st.executeUpdate(); 
			
			st1.setString(1, request.getParameter("Email")); 
			st1.setString(2, request.getParameter("pwd"));
			
			st1.executeUpdate();

			// Close all the connections 
			st.close();
			st1.close();
			con.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
			//out.println("<html><body><b>Successfully Inserted"+ "</b></body></html>"); 
			
		} catch (Exception e) {
			System.out.println("Error inside DBConnection class :\n Error in DBCOnnection Constructor "+e);
		}
	}

}
