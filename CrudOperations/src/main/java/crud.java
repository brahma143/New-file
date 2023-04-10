

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crud
 */
@WebServlet("/crud")
public class crud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String update = request.getParameter("update");
		 String delete = request.getParameter("delete");
		
		 System.out.print(delete);
		 if(delete!=null) {
			 Connection con = null;
	          try {
	        	  Class.forName("com.mysql.jdbc.Driver");
	              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emplyee?useSSl=true","root","Root@123");
	              PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
	             
	              ps.setString(1,delete);
	              ps.executeUpdate();
	              RequestDispatcher dispatcher= null;
	 			 dispatcher=request.getRequestDispatcher("index.jsp");
	 			 dispatcher.forward(request , response);
	              
	          }catch(Exception e) {
	        	  
	          }
	           
		 }else if(update !=null) {
			 RequestDispatcher dispatcher= null;
			 request.setAttribute("id", update);
			 dispatcher=request.getRequestDispatcher("update.jsp");
			 dispatcher.forward(request , response);
		 }
	}

}
