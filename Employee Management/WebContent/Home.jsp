<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>

body
{
	background-image: url('image1.jpg');
	background-position: center;
  	background-repeat: no-repeat;
  	background-size: cover;
 	background-attachment: fixed;
	/*background-color:black;*/
}

a:link {
  color: green;
  background-color: transparent;
  text-decoration: none;
}

a:visited {
  color: black;
  background-color: transparent;
  text-decoration: none;
}

a:hover {
  color: red;
  background-color: transparent;
  text-decoration: underline;
}

a:active {
  color: yellow;
  background-color: transparent;
  text-decoration: underline;
}

.tab {
	
 	margin-right: 2.5em;
}

.space {
 margin-left: 2.5em;
}




</style>

</head>
<body>
	
	
	<%	
				
		
		request.getRequestDispatcher("menu.jsp").include(request, response); 
		//String uname=(String)session.getAttribute("name");
		//String s =(String)session.getAttribute("id");
		//int id = (Integer)session.getAttribute("id");
		//System.out.println(id);
	/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//out.println("class loaded");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db", "root","");
			Statement stmt = connection.createStatement();
			String Query = "select * from user_details WHERE u_email='"+uname+"'";
			ResultSet rs = stmt.executeQuery(Query);
			while (rs.next()) {
				
				 id=rs.getInt(1);
				
				//System.out.println(id);
				
			
			}
			out.print("<a href='Home.jsp' class='tab'>Home</a>");
			out.print("<a href='Profile.jsp?e_id="+id+"' class='tab'>Profile</a>");
			out.print("<a href='showdata.jsp?e_id="+id+"' class='tab'>Admin</a>");
			out.print("<a style= 'margin-left:78%;' href='LogoutServlet' >Logout</a>");
			out.println();
			
		}
		catch(Exception e)
		{
			out.println("================in show ......"+e);
		}
	*/
		%>
		
		
		
		
         
       


</body>
</html>