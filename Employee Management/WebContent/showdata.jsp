<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Data</title>


  
<style>
	
.margin{
	margin-top:1%;
}
	
#myTable {
   
   /*margin-top:5%;*/
   
   border-collapse: collapse;
   width: 78%;
   overflow:auto;
   
}

#myTable th, #myTable td{
  text-align: left;
  padding: 12px;
  /*width: 78%;*/
  border: 1px solid aqua;
  background-color: rgba(120,120,119,0.4);
  
}

#myTable tr.head, #myTable tr:hover {
  background-color: #f1f1f1;
}

#myTable th{
	color:white;
	background-color:orange;
}

#myTable td{
	color: #fff;
}

#myInput {
  
  margin-top:8%;
  margin-left:29%;
  width: 30%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 10px;
}



</style>
</head>
<body>
	  <jsp:include page="menu.jsp"></jsp:include> 
	
	
	<br><br><font style='color:white; margin-left:5%; font-size: 20px'><b>Employee Details</b></font>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
	 
	 
	<div class="margin">
		<table id="myTable">
  		<tr class="head">
		<th>ID</th>
		<th>First name</th>
		<th>Last name</th>
		<th>Mobile</th>
		<th>Email</th>
		<th>Update</th>
		<th>Delete</th>
		</tr>
		
		<%
			
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//out.println("class loaded");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik_db", "root", "");
			Statement stmt = connection.createStatement();
			String Query = "select * from user_details;";
			ResultSet rs = stmt.executeQuery(Query);
			while (rs.next()) {
			// out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getString(4)+""+rs.getString(5));
		%>
	
		<tr>
		<td>
		<%	
			out.print(rs.getInt(1));
			
		%>
		</td>

		<td>
		<%
			out.print(rs.getString(2));
		%>
		</td>

		<td>
		<%
			out.print(rs.getString(3));
		%>
		</td>

		<td>
		<%
			out.print(rs.getString(4));
		%>
		</td>

		<td>
		<%
			out.print(rs.getString(5));
		%>
		</td>

		

		<td>
		
		<%
			int id=rs.getInt(1);
			//System.out.println(id);
			
			
			out.print("<a href='update.jsp?e_id="+id+"'>Edit</a>");
			
			//"<a href='servlet2?uname="+n+"'>visit</a>"
		%>
	
		</td>
		
		<td>
		<%
			 id=rs.getInt(1);
			//System.out.println(id);
			
			out.print("<a href='DeleteServlet?e_id="+id+"'>Delete</a>");
			
		
		%>
		</td>
		</tr>
		

					

					<%-- <td>
<%out.println(rs.getInt(1));
%>
</td>
--%><!-- <td>out.println();</td>
<td>out.println(rs.getString(3));</td>
<td>out.println(rs.getString(4));</td>
<td>out.println(rs.getString(5));</td>
<td><a href="UpdateRecord">Edit</a></td>
<td><a href="DeleteRecord">Delete</a></td> -->
</tr>
		<%
		}
		}
		catch(Exception e)
		{
			out.println("================in show ......"+e);
		}
		%>
		
		
</table>
</div>
<script>
						/* function myFunction() {
							var input, filter, table, tr, td, i, txtValue;
							input = document.getElementById("myInput");
							filter = input.value.toUpperCase();
							table = document.getElementById("myTable");
							tr = table.getElementsByTagName("tr");
							for (i = 0; i < tr.length; i++) {
								td = tr[i].getElementsByTagName("td")[0];
								if (td) {
									txtValue = td.textContent || td.innerText;
									if (txtValue.toUpperCase().indexOf(filter) > -1) {
										tr[i].style.display = "";
									} else {
										tr[i].style.display = "none";
									}
								}
							}
						} */
						
						
						function myFunction() {
							  var input, filter, table, tr, td, i;
							  input = document.getElementById("myInput");
							  filter = input.value.toUpperCase();
							  table = document.getElementById("myTable");
							  var rows = table.getElementsByTagName("tr");
							  for (i = 0; i < rows.length; i++) {
							    var cells = rows[i].getElementsByTagName("td");
							    var j;
							    var rowContainsFilter = false;
							    for (j = 0; j < cells.length; j++) {
							      if (cells[j]) {
							        if (cells[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
							          rowContainsFilter = true;
							          continue;
							        }
							      }
							    }

							    if (! rowContainsFilter) {
							      rows[i].style.display = "none";
							    } else {
							      rows[i].style.display = "";
							    }
							  }
							}
						
					</script>
</body>
</html>