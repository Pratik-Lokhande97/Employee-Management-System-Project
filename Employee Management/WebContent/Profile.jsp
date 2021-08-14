<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

<!-- <link rel="stylesheet" href="css/demo.css"> --> 
<link rel="stylesheet" href="css/style.css"> 
<link rel="stylesheet" href="css/bootstrap.min.css"> 

<style>

body
{
	background-image: url('image1.jpg');
	background-position: center;
  	background-repeat: no-repeat;
  	background-size: cover;
 	background-attachment: fixed;
	
}

.header1 
{
	
	top:0px;
	
	border-bottom: 2px solid #DC3545;
	left:0px;
	color:black;
	position:fixed;
	height:5%;
	width:100%;
	padding: 5px 16px;
	background-color:white; 
	text-align:center;
}



a:link {
  
  color: black;
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

.tab1 {
	
	
 	margin-right: 2.5em;
}

.footer1{
	
	float: left;
	left:0px;
	bottom:3px;
	border-top: 1px solid #DC3545;
	color:white;
	position:fixed;
	padding: 8px 8px;
	height:5%;
	width:100%;
	background-color:black;
	
}

</style>

</head>
<body>

	<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
	
	<div class="header1">
		<a href="Home.jsp" class="tab1">Home</a>
		<a href="Profile.jsp" class="tab1">Profile</a>
		<a href="showdata.jsp" class="tab1">Admin</a>
		<a style= "margin-left:70%;" href="LogoutServlet" >Logout</a>
	</div>
	
	<div style="top-margin:20px">
	<%
	
	int id1 = (Integer)session.getAttribute("id");	
	System.out.println("================================="+id1);
	
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db", "root", "");
			Statement stmt = connection.createStatement();
			String Query = "select * from user_details WHERE u_id="+id1;
			ResultSet rs = stmt.executeQuery(Query);
		
			while (rs.next()) 
			{
				//out.println("ID : "+rs.getInt(1));
		
	
	%>
						
 
 		
 <section>
 
    <div class="rt-container"> 
    
        <div class="col-rt-12 mt-5"> 
       
            <div class="Scriptcontent">
              
<!-- Student Profile -->
<div class="student-profile py-sm-5">
  <div class="container">
    <div class="row align-items-center"> 
     
      <div class="col-lg-4">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent text-center">
            <img class="profile_img" src="3.png" alt="student dp">
            
            <h3><%out.println(rs.getString(2));%><%out.println(rs.getString(3));%></h3>
          </div>
          <div class="card-body">
            <p class="mb-0" ><strong class="pr-1">Employee ID : </strong><%out.println(rs.getString(1));%></p>
            <p class="mb-0" ><strong class="pr-1">Gender : </strong><%out.println(rs.getString(7));%></p>
            <p class="mb-0" ><strong class="pr-1">Hometown : </strong><%out.println(rs.getString(11));%></p>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent border-0">
            <br><h3 class="mb-0" ><i class="far fa-clone pr-1"></i>General Information</h3>
          </div>
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr>
              <th width="30%">Email ID : </th>
                <td width="2%">:</td>
                <td><%out.println(rs.getString(5));%></td>
              </tr>
              <tr>
                <th width="30%">Id Proofs</th>
                <td width="2%">:</td>
                <td><%out.println(rs.getString(8));%></td>
              </tr>
              <tr>
                <th width="30%">Address</th>
                <td width="2%">:</td>
                <td><%out.println(rs.getString(9));%></td>
              </tr>
              <tr>
                <th width="30%">State</th>
                <td width="2%">:</td>
                <td><%out.println(rs.getString(10));%></td>
              </tr>
              
            </table>
                
          </div>
        </div>
         
      </div>
    </div>
  </div>
</div>
<!-- partial -->
           
    		</div>
		</div>
    </div>
</section>
 		

	<% 
	}
		} catch (Exception e) {
			System.out.println(e);
		}
	%>
	
	<div class="footer1">
    		<font style='top:20%; margin-left:50%; font-size: 15px'>@ Copyright Pratik Lokhande 2021</font>
          </div>
	
</body>
</html>