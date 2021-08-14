<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>

<style>
	
	table {
   margin-top:3%;
   border-collapse: collapse;
   width: 78%;
   overflow:auto;
   box-shadow: 0 0 20px rgba (0,0,0,0.5);
}

th, td {
    text-align: left;
    padding: 8px;
    border: 1px solid aqua;
    background-color: rgba(120,120,119,0.4);
    color: #fff;
}



th {
    background-color:  rgb(41,41,40);
    color: orange;
    font-size: 18px;
}

#frmLogin { 
	margin-top: 5%;
	margin-right: 55%;
	/*border: 5px solid red;*/
	padding: 20px 50px;
	background:  #f2f2f;
	color: white;
	display: inline-block;
	border-radius: 4px; 
	box-sizing: border-box;
}

</style>

</head>
<body>
		<jsp:include page="menu.jsp"></jsp:include>
	<%
	String s = request.getParameter("e_id");

		System.out.println("*******"+s);
		//request.getRequestDispatcher("Home.jsp").include(request, response);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db", "root", "");
			Statement stmt = connection.createStatement();
			String Query = "select * from user_details WHERE u_id="+s;
			ResultSet rs = stmt.executeQuery(Query);
			
			while (rs.next()) 
			{
				out.println("ID : "+rs.getInt(1));
			
			
	%>

	<form action="UpdateServlet" id="frmLogin">
	<fieldset>
		<legend>
			<b>Personal Details:</b>
		</legend>
		<table border=0>
			
			<tr>
				<td>ID</td>
				<td><input type="text" name="ID" size="20" value="<%out.println(rs.getInt(1));%>"readonly></td>
			</tr>
			
			<tr>
				<td>First Name</td>
				<td><input type="text" name="FName" size="20" value="<%out.println(rs.getString(2));%>"></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="LName" size="20" value="<%out.println(rs.getString(3));%>"></td>
			</tr>

			<tr>
				<td>Mobile No</td>
				<td><input type="text" name="Mobile" maxlength="10" value="<%out.println(rs.getString(4));%>"></td>
			</tr>


			<tr>
				<td>Email</td>
				<td><input type="email" name="Email" size="20" value="<%out.println(rs.getString(5));%>"></td>
			</tr>

		
		</table>
	</fieldset>
	

		<fieldset>
			<legend>
				<b>ID Proof</b>
			</legend>
			<input type="text" name="IDP" value="<%out.println(rs.getString(8));%>">
			
		</fieldset>

		<fieldset>
			<legend>
				<b>Address Details</b>
			</legend>
			<table>
				<tr>
					<td>Address</td>
					<td><input type="text" name="Address" value="<%out.println(rs.getString(9));%>"></textarea></td>
				</tr>

				<tr>
					<td>State</td>
					<td>
					<input type="text" name="State" value="<%out.println(rs.getString(10));%>">
					</td>
				</tr>

				<tr>
					<td>District</td>
					<td><input type="text" name="District" value="<%out.println(rs.getString(11));%>"></td>
				</tr>
			</table>
			</fieldset>
			<input type="submit" name="login" value="Update" class="form-submit-button">
			
	<% 
	}
		} catch (Exception e) {
			System.out.println(e);
		}
	%>
	
	
</body>
</html>