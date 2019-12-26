

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Questionhistory
 */
@WebServlet("/Questionhistory")
public class Questionhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questionhistory() {
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
			
			int profid = LoginPage1.myuserid;
			System.out.println(profid);
			
			ResultSet rs=stmt.executeQuery("select * from Questions");
			pw.print("<html>");
			pw.print("<body style=\"background-color: lavender;\">");
			pw.print("<div><h1><center>Your Overall Question History</center></h1><div style=\"position:absolute;left:80%;top:5%;z-index:1;\"><a href=\"professorhomepage.jsp\">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"logout\">Logout</a></div></div>");
			pw.print("<center>");
			pw.print("<br><br>");
			pw.print("<table BORDER='2' style=\" border-collapse: collapse;\">");
			pw.print("<tr>");
			
			pw.print("<th ALIGN=CENTER style='width: 100px;'>"+"QuestionID"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"QuestionName"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"Option1"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"Option2"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Option3"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Option4"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Correct Answer"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Answer Explanation"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Topic_ID"+"</th>");
			
			pw.print("</tr>");
			//pw.print("<td>"+"QuestionID"+"</td>"+"<td>"+"QuestionName"+"</td>"+"<td>"+"Option1"+"</td>"+"<td>"+"Option2"+"</td>"+"<td>"+"Option3"+"</td>"+"<td>"+"Option4"+"</td>"+"<td>"+"Correct Answer"+"</td>"+"<td>"+"UserID"+"</td>"+"<td>"+"Answer Explanation"+"</td>"+"<td>"+"User Type"+"</td>"+"<td>"+"Topic ID"+"</td>");
			//pw.print("</th>");
			 while(rs.next())
			 {
				 if(rs.getInt(8)==profid)
				 {
					 pw.print("<tr>");	 
					 pw.print("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td>"+"<td>"+rs.getString(9)+"</td>"+"<td>"+rs.getInt(11)+"</td>");
					 pw.print("</tr>");
				 }
			 }
			 pw.print("</table>");
			 pw.print("</body></html>");
			 con.commit();
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
