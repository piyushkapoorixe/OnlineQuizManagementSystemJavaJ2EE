

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleTest
 */
@WebServlet("/SampleTest")
public class SampleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static int marks=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static  ArrayList<String> arr=new ArrayList<String>();
    public static  ArrayList<Integer> arrid=new ArrayList<Integer>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 LoginPage1.session = request.getSession(true);
		// ArrayList<String> arr=new ArrayList<String>();
//		for(int i=0;i<Questionhistory1.count;i++) {
//			if(i<5)
//		{
////			System.out.print("Id:"+Questionhistory1.arrId[i]+"\t");
////			System.out.print("Ans:"+Questionhistory1.arrAns[i]+"\t");
////			System.out.print("Options:"+request.getParameter("ques"+i+""));
//			arr.add(request.getParameter("ques"+i+""));
//			arrid.add(Questionhistory1.arrId[i]);
//		}
//		}
//		System.out.println(arr);
try {
	/*code for getting the time and date */
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date d = new Date();
	System.out.println(formatter.format(d));
	marks = 0;
				
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();
				
				//fetching the correct option
				for(int k=0;k<5;k++) {
			/*code for selecting the particular question based on the queston id stored in the array arrId[]*/
				String sql = "select * from Questions where auto_increment_quesid="+Questionhistory1.arrId[k]+"";
				
				ResultSet rs= stmt.executeQuery(sql);
				
				while(rs.next()){
				try{
					/*comparing the selected options with the correction option stored in the database*/
					if(request.getParameter("ques"+k+"").equals(rs.getString(7)))
					{
						arr.add(request.getParameter("ques"+k+""));
						arrid.add(Questionhistory1.arrId[k]);
						/*incrementing the marks by 1 if the selected option and correct opiton is true*/
					marks++;
					}
				} catch(Exception e) {continue;}	
				 
					
				}
				
				}
				//System.out.println("marks :"+marks);
				request.setAttribute("mar", marks);
				request.setAttribute("mydate", formatter.format(d));
				request.setAttribute("arr1", arr);
				LoginPage1.session.setAttribute("aquesid",arrid );
				LoginPage1.session.setAttribute("useroption",arr );
				/*After completing the calculating the marks going to DisplayMarks.java*/
				RequestDispatcher rd = request.getRequestDispatcher("Sampletest");
				rd.forward(request,response);
				
				
				
				
				con.commit();
				con.close();
}catch(Exception e){System.out.print(e);}
			
	}
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
