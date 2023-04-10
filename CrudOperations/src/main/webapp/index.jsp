<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.sql.*" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  

<% 
           Connection con = null;
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emplyee?useSSl=false","root","Root@123");
           PreparedStatement ps = con.prepareStatement("select * from emp");
          

           ResultSet rs = ps.executeQuery();
			

    %>

<form action="crud" method="post">  

<table border=1>  
<tr>
	<th> ID</th>
		<th> Email</th>
			<th> Name</th>
				<th> Password</th>
				
</tr>

<% while(rs.next()){
	%>
	<tr>
	<td> <%=rs.getString(1) %></td>
		<td> <%=rs.getString(4) %></td>
			<td> <%=rs.getString(2) %></td>
				<td> <%=rs.getString(3) %></td>
				<td><button name="delete" value=<%=rs.getString(1) %>> delete</button></td>
				
				<td><button name="update" value=<%=rs.getString(1) %>>update</button></td></tr>
	<%
} %>


</table>  
</form>  
</body>
</html>