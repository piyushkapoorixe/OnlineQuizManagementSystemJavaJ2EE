

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class StudentQuesHis
 */
@WebServlet("/StudentQuesHis")
public class StudentQuesHis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// LoginPage1.session = request.getSession(true);
			//String ttopictype=(request.getParameter("topic1"));
			 //int topictype = Loginpage1.Session;
			 int topictype = AddQuestion1.topictype;
			//String ttopictype=(request.getParameter("topic1"));
			//int ttype=Integer.parseInt(ttopictype);
			//int myflag=1;
			//myflag = (int) LoginPage1.session.getAttribute("flag");
			 System.out.println("topictype is " + topictype);
			 PrintWriter pw = response.getWriter();
				try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement();
					
					//int profid = (int) request.getSession(false).getAttribute("tempuserid");
					//System.out.println(profid);
					
					int i=0,j=0;
					ResultSet rs=stmt.executeQuery("select * from Questions");
					//int next=0, marks=0;
					
//					pw.print("<table>");
//					pw.print("<th>");
//					pw.print("<td>"+"QuestionID"+"</td>"+"<td>"+"QuestionName"+"</td>"+"<td>"+"Option1"+"</td>"+"<td>"+"Option2"+"</td>"+"<td>"+"Option3"+"</td>"+"<td>"+"Option4"+"</td>"+"<td>"+"Correct Answer"+"</td>"+"<td>"+"UserID"+"</td>"+"<td>"+"Answer Explanation"+"</td>"+"<td>"+"User Type"+"</td>"+"<td>"+"Topic ID"+"</td>");
//					pw.print("</th>");
					 RequestDispatcher rd=request.getRequestDispatcher("ProfessorSelect.html");
					 rd.include(request,response);
					pw.print("<html>");
					pw.print("<body style=\"background-color: lavender;\">");
					pw.print("<br><br><br>");
					pw.print("<div><h1><center>Your Particular Topic  Question History</center></div></h1>");
					pw.print("<center>");
					pw.print("<br><br>");
					pw.print("<table BORDER='2' style=\" border-collapse: collapse;\">");
					pw.print("<tr>");
					
					pw.print("<th ALIGN=CENTER style='width: 100px;'>"+"QuestionID"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"QuestionName"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"Option1"+"</th>"+"<th ALIGN=CENTER style='width: 100px;'>"+"Option2"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Option3"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Option4"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Correct Answer"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Answer Explanation"+"</th>"+"<th ALIGN=CENTER style='width: 150px;'>"+"Topic_ID"+"</th>");
					
					pw.print("</tr>");
					 while(rs.next())
					 {
						 if(rs.getInt(11)==topictype)
						 {
//							 pw.print("<tr>");	 
//							 pw.print("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td>"+"<td>"+rs.getInt(8)+"</td>"+"<td>"+rs.getString(9)+"</td>"+"<td>"+rs.getInt(10)+"</td>"+"<td>"+rs.getInt(11)+"</td>");
//							 pw.print("</tr>");
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
