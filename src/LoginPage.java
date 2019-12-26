

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;
/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String name=""; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			/*By using the getParamter method getting the values enter in the registration form
			 uname is userid,uemail is mail id,psw is password,type is used to check wheather the user is student or professor*/
			   name=request.getParameter("uname");
			  String mailid=request.getParameter("uemail");
			  String password=(request.getParameter("psw"));
			  int type=Integer.parseInt(request.getParameter("submit"));
			  int count1=0;
			  
			  int flag=0;
			  ;
			//step4 execute query  
		        if(!name.equals("")&&!mailid.equals("")&&!password.equals("")&&type!=0)
		        {
		        	ResultSet res1=stmt.executeQuery("select count(*) from Registration");
		        	while(res1.next()){
		        		count1=res1.getInt(1);
		        	}
		        	if(count1!=0)
		        	{
		        	ResultSet rs=stmt.executeQuery("select * from Registration");  
					while(rs.next())
					{
						
						if(!name.equals(rs.getString(2)) && !mailid.equals(4))
						{		
					flag=1;
					
						}
						else
						{
							
							flag=0;
//							
							break;
						}
					}
		        	}
		        	else
		        	{
		        		flag=1;
		        	}
					if(flag==1)
					{
						stmt.execute("INSERT INTO Registration VALUES (reg_seq.nextval,'"+name+"','"+password+"','"+mailid+"',"+type+")");
						System.out.print("Registration Successful");
						  /*If validation of register is successfully staying in to login form*/
						  if(type==1)
							{
							RequestDispatcher rd=request.getRequestDispatcher("index.html");
							rd.forward(request, response);
							}
							else if(type==2)
							{
								RequestDispatcher rd=request.getRequestDispatcher("index.html");
								rd.forward(request, response);
							}
						  /*If validation of register is unsuccessfully staying in to registration form*/
							else
							{
								response.setContentType("text/html");
								 pw.println("<script type=\"text/javascript\">");
								 pw.println("alert('Invalid Credentials');");
								 pw.println("window.location.assign('Registration.html');");
								 pw.println("</script>"); 
								 System.out.print("Registration not Successful");
							}
					
					}
					else
					{
						 response.setContentType("text/html");
						 pw.println("<script type=\"text/javascript\">");
						 pw.println("alert('Invalid Credentials');");
						 pw.println("window.location.assign('Registration.html');");
						 pw.println("</script>"); 
						 System.out.print("Registration not Successful");
					
						
					}
			
			con.commit();
			
		        }
		        else
		        {
		        	response.setContentType("text/html");
					 pw.println("<script type=\"text/javascript\">");
					 pw.println("alert('Invalid Credentials');");
					 pw.println("window.location.assign('Registration.html');");
					 pw.println("</script>"); 
					 System.out.print("Registration not Successful");
		        }
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
