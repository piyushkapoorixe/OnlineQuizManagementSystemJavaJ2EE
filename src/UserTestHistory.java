

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserTestHistory
 */
@WebServlet("/UserTestHistory")
public class UserTestHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTestHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		session= request.getSession(true);
		PrintWriter pw = response.getWriter();
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
			//Getting the userid from LoginPage1.java
			int studentid= LoginPage1.myuserid;
			System.out.println(studentid);
			//Selecting the results of particular student id
			ResultSet rs=stmt.executeQuery("select * from testhistory where userid="+studentid+"");
			//pw.print("<h1 style='margin-top: 5px;' ALIGN=CENTER>All Tests History<p ALIGN=RIGHT>Logout</p></h1>");
			pw.print("<html>");
			pw.print("<body style=\"background-color: lavender;\">");
			pw.print("<div><h1><center>Your Overall Test History</center></h1><div style=\"position:absolute;left:80%;top:5%;z-index:1;\"><a href=\"studenthomepage.jsp\">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"logout\">Logout</a></div></div>");
			pw.print("<center>");
			pw.print("<br><br>");
			pw.print("<table BORDER='2' style='border-collapse: collapse;'>");
			pw.print("<tr>");
			
			pw.print("<th ALIGN=CENTER style='width: 100px;'>"+"testid"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"userid"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"topicid"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"score"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"date"+"</th>");
			
			pw.print("</tr>");
			 while(rs.next())
			 {
				pw.print("<tr>");	 
			 pw.print("<td ALIGN=CENTER>"+rs.getInt(1)+"</td>"+"<td ALIGN=CENTER>"+rs.getInt(2)+"</td>"+"<td ALIGN=CENTER>"+rs.getInt(3)+"</td>"+"<td ALIGN=CENTER>"+rs.getInt(4)+"</td>"+"<td ALIGN=CENTER>"+rs.getString(5)+"</td>");
			 pw.print("</tr>");
				 
			 }
			 pw.print("</table>");
			 pw.print("</center>");
			 pw.print("</body>");
			 pw.print("</html>");
			 con.close();
		}catch(Exception e) {System.out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
