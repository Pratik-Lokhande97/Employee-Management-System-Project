import java.sql.*;

public class DBConnection {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;
	    
	public DBConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db","root","");
			//System.out.println("Connected");
			
			
		} catch (Exception e) {
			System.out.println("Error inside DBConnection class :\n Error in DBCOnnection Constructor "+e);
		}
	}

}
