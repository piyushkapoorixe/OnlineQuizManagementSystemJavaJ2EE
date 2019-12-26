

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private Object confirmationpsw;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		String username=request.getParameter("uname");
		String oldpassword=request.getParameter("oldpsw");
		String newpassword=request.getParameter("chpsw");
		String confirmationpsw=request.getParameter("newpsw");
		 
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
		  
		//step3 create the statement object  
		int userid1;
		Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select *from Registration");
		 while(rs.next())
		 {
			 if(username.equals(rs.getString(2)) || username.equals(rs.getString(4)))
					 {
				 userid1=rs.getInt(1);
				 if(oldpassword.equals(rs.getString(3)))
					 {
					 if(newpassword.equals(confirmationpsw))
					 {
						 stmt.execute("update Registration set password='"+confirmationpsw+"' where userid="+userid1+"");
						 RequestDispatcher rd=request.getRequestDispatcher("index.html");
						 rd.forward(request, response);
					 }
					 else
					 {
						 System.out.println("Password is incorrect");
					 }
					 }
				 else
				 {
					 System.out.println("Password is incorrect");
				 }
					 }
			 else
			 {
				 System.out.println("Username is incorrect");
			 }
		 }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
