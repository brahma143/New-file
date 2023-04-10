

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class change
 */
@WebServlet("/change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("update");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(id);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emplyee?useSSl=true","root","Root@123");
            PreparedStatement ps = con.prepareStatement("update emp set Name=? , email=? where id=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, id);
            ps.executeUpdate();
            RequestDispatcher dispatcher= null;
			 dispatcher=request.getRequestDispatcher("index.jsp");
			 dispatcher.forward(request , response);
			
		}catch(Exception e) {
			
		}
	}

}
