<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>

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
	height:3%;
	width:100%;
	padding: 14px 16px;
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
	height:3%;
	width:100%;
	background-color:black;
	
}

</style>
</head>
<body>

	<div class="header1">
		<a href="Home.jsp" class="tab1">Home</a>
		<a href="Profile.jsp" class="tab1">Profile</a>
		<a href="showdata.jsp" class="tab1">Admin</a>
		<a style= "margin-left:70%;" href="LogoutServlet" >Logout</a>
	</div>
	<div class="footer1">
    		<font style='top:20%; margin-left:50%; font-size: 15px'>@ Copyright Pratik Lokhande 2021</font>
          </div>
	
</body>
</html>