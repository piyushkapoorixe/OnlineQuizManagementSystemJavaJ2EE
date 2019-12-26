

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayMarks
 */
@WebServlet("/DisplayMarks")
public class DisplayMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMarks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			try{
				PrintWriter pw = response.getWriter();
				LoginPage1.session = request.getSession(true);
				
				//LoginPage1.session = request.getSession(true);
				//Getting the marks value from SampleTest.java
				System.out.println("marks:"+request.getAttribute("mar"));
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
						  
						//step3 create the statement object  
						Statement stmt=con.createStatement();
				//Getting the user id from LoginPage1.java
						int id=   LoginPage1.myuserid;
//						int type=    (int) request.getSession(false).getAttribute("temptype");
						//getting the topic type id from the from Questionhistory 
						int ttype = Questionhistory1.ttype;
						System.out.println(id);
						System.out.println(id+"======"+ttype);
						System.out.println("Date is " + request.getAttribute("mydate"));
						
						
						
						
//			String id1=    (String) request.getSession(false).getAttribute("tempuserid");
////				//	int type=    (int) request.getSession(false).getAttribute("temptype");
//				String ttype1 = (String) request.getSession(false).getAttribute("temptypeid");
//				
//				//int id = Integer.parseInt(id1);
//				//int ttype = Integer.parseInt(ttype1);
////					System.out.println("id :"+id +"ttype :"+ttype);
						/*Inserting values into the testhistory table to see results*/
					String sql1 = "insert into testhistory values(testhistory_seq.nextval,"+id+","+ttype+","+request.getAttribute("mar")+",'"+request.getAttribute("mydate")+"')";
					
				stmt.execute(sql1);
				con.commit();
				con.close();
				/*after inserting the values going to result.html page*/
				RequestDispatcher rd = request.getRequestDispatcher("result.html");
				rd.forward(request, response);
			}catch(Exception e){
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
