

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ServletRequest session;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
try {
	/*getting data entered in the addquestion.html by using getParameter()*/
	    String Question=request.getParameter("Question");
	    String Option1=request.getParameter("Option1");
	    String Option2=request.getParameter("Option2");
	    String Option3=request.getParameter("Option3");
	    String Option4=request.getParameter("Option4");
	    String Answer=request.getParameter("Answer");
	    String Explanation=request.getParameter("Explanation");
	    LoginPage1.session = request.getSession(true);
	    
			//pw.print("Questionname");
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();
			//getting the userid from LoginPage1
			int id=   LoginPage1.myuserid;
			//getting the usertype 2 from the LoginPage1 by using session
			int type=    (int) request.getSession(false).getAttribute("temptype");
			//getting the topic id by using the AddQuestion1.java
			int ttype = AddQuestion1.topictype;
			System.out.println(id+"==="+type+"==="+ttype);
			//validating the options and answer
			if(!Option1.equals(Option2) && !Option1.equals(Option3) && !Option1.equals(Option4) && !Option2.equals(Option3) && !Option2.equals(Option4) && !Option3.equals(Option4)) 
			{
			if(Option1.equals(Answer) || Option2.equals(Answer) ||Option3.equals(Answer) ||Option4.equals(Answer))
			{
				//inserting into table
			stmt.execute("INSERT INTO Questions VALUES (ques_seq.nextval,'"+Question+"','"+Option1+"','"+Option2+"','"+Option3+"','"+Option4+"','"+Answer+"',"+id+",'"+Explanation+"',"+type+","+ttype+")");
			
			/*  create sequence ques_seq
        	 * 
  2  minvalue 0
  3  start with 0
  4  increment by 1
  5  cache 10; */
			 ResultSet rs=stmt.executeQuery("select * from Questions");
			 while(rs.next())
			 {
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9)+" "+rs.getInt(10)+" "+rs.getInt(11));
			 }
			 /*Going back to addquestion.html to add next question*/
			 pw.print("<html><body><h4>Question Added Successfully</h4>"
			 		+ "<a href='Addquestion.html'>Go back to home page<a></body></html>");
			} else {
				/*if the options and answer validation fails stay in the same page*/
				 response.setContentType("text/html");
				 pw.println("<script type=\"text/javascript\">");
				 pw.println("alert('Correct Answer doesnt matches any options provided by you.');");
				 pw.println("window.location.assign('Addquestion.html');");
				 pw.println("</script>");
				 //RequestDispatcher rd = request.getRequestDispatcher("Addquestion.jsp");
				 //rd.forward(request,response);
			}
			} else {
				response.setContentType("text/html");
				 pw.println("<script type=\"text/javascript\">");
				 pw.println("alert('Provide 4 different options please.');");
				 pw.println("window.location.assign('Addquestion.html');");
				 pw.println("</script>");
			}
			 con.commit();
			 con.close();
			 
}
catch(Exception e){
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
