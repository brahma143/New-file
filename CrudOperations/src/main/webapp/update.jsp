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
           PreparedStatement ps = con.prepareStatement("select Name ,email from emp where id=?");
          	String id=""+request.getAttribute("id");
          	ps.setString(1, id);

           ResultSet rs = ps.executeQuery();
			String name="";
			String email="";
		if(rs.next()){
			name=rs.getString(1);
		    email=rs.getString(2);
		}
    %>
<form action="change" method="post">

name : <input type="text" name="name" value=<%= name %>>
Email :<input type="text" name="email" value=<%= email %>>
<button name="update" value=<%=id %>> update</button>
</form>
</body>
</html>