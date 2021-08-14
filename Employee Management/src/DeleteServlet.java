

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String i=request.getParameter("e_id");
		System.out.println(i);
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","");
			System.out.println("Connected");
			
			String query="DELETE FROM employee WHERE id="+i;
			
			PreparedStatement st = con.prepareStatement(query); 

			st.executeUpdate(); 
			
			out.println("<h1>ID : "+i+" Record Deleted Successfully</h1>");
			request.getRequestDispatcher("showdata.jsp").include(request, response);
			st.close();
			con.close();
			
			  
            
			
			//out.println("<html><body><b>Successfully Inserted"+ "</b></body></html>"); 
			
		} catch (Exception e) {
			System.out.println("Error inside DBConnection class :\n Error in DBCOnnection Constructor "+e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
