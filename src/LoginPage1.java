

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
 * Servlet implementation class LoginPage1
 */
@WebServlet("/LoginPage1")
public class LoginPage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;
	public static String displayname;
	public static int myuserid,typeid;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 session = request.getSession(true);
		String username=request.getParameter("uname");/*getting the enter values in the loginfrom using getParamter()*/
		String password=request.getParameter("psw");/*getting the enter values in the loginfrom using getParamter()*/
		int type=Integer.parseInt(request.getParameter("submit"));/*getting the enter values in the loginfrom using getParamter()*/
		int type1=0;
	 myuserid=0;/* myuserid is required to check the user is student or professor and myuserid is declared as public static to use any where*/
		PrintWriter pw=response.getWriter();
		int c=0;
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select *from Registration");
		 while(rs.next())
		 {
			
			 if((username.equals(rs.getString(2))||username.equals(rs.getString(4))))
			 {
					 if(password.equals(rs.getString(3)))
			 {     type1=rs.getInt(5);
			
			 myuserid =rs.getInt(1);
			 displayname = rs.getString(2);
			 
						 
					c=1;	
					break;
			 }
					 else
					 {
						 c=0;
					 }
			 }
			 else
			 {
				 c=0;
			 }
		 }
		
		
		 if(c==1 && type1==type && type1==1)
		 {
			session.setAttribute("myname", displayname);
			 /*If the enterd value in the login form is matched with the values in database and and the usertype is 1 then going to StudentHomePage.html*/
			 RequestDispatcher rd=request.getRequestDispatcher("studenthomepage.jsp");
				rd.forward(request, response);
		 }
			 else if(c==1&&type1==type && type1==2)
			 {
				 /*If the enterd value in the login form is matched with the values in database and and the usertype is 2 then going to ProfessorHomePage.html*/
				 session.setAttribute("myname", displayname);
				 session.setAttribute("temptype", type1);
				 System.out.println("login:"+type1);
				 RequestDispatcher rd=request.getRequestDispatcher("professorhomepage.jsp");
					rd.forward(request, response);
			 }
			 else if(c==1 && type!=type1)
			 {
				 /*If enterd data is wrong showing alert box and staying in the login form */
					
					response.setContentType("text/html");
					 pw.println("<script type=\"text/javascript\">");
					 pw.println("alert('Invalid Credentials');");
					 pw.println("window.location.assign('index.html');");
					 pw.println("</script>");
			 }
		 
		 else
		 {
			 /*If enterd data is wrong showing alert box and staying in the login form */
			 System.out.println(type+" "+type1);
			 response.setContentType("text/html");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Invalid Credentials');");
			 pw.println("window.location.assign('index.html');");
			 pw.println("</script>");
			
		 }
		
		 con.commit();
		 con.close();
		}catch(Exception e){ System.out.println(e);} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
