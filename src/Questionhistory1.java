

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Questionhistory1
 */
@WebServlet("/Questionhistory1")
public class Questionhistory1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questionhistory1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   public static int arrId[] = new int[5];
	public static  String arrAns[] = new String[5];
	public static String arrSelected[] =new String[5];
	public static int count;
	public static int ttype;
	public static ArrayList ar=new ArrayList();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 LoginPage1.session = request.getSession(true);
		/*getting the value of the particular selected topic value by using getParamter()*/
		String ttopictype=(request.getParameter("topic1"));
		 ttype=Integer.parseInt(ttopictype);
		
		 System.out.println("topictype is " + ttype);
		 PrintWriter pw = response.getWriter();
		 /*Code for displaying the random option values */
		 LinkedHashSet hs = new LinkedHashSet();
		 while(hs.size() != 4 ) {
		  int i = (int)Math.floor((Math.random()*4)) + 3;
		  hs.add(i);
		 }
		 Object a[] = hs.toArray();
		 int b[] = new int[hs.size()];
		 for(int i=0;i<hs.size();i++) {
		  b[i] = (int)a[i];
		  }
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();
				int i=0,j=0;
				
				/*Code for counting no.of question in the database for particular selected topic*/
				ResultSet rs1 =stmt.executeQuery("SELECT COUNT(*)FROM Questions where topic_id="+ttype+"");
				while(rs1.next()){
					count = rs1.getInt(1);
					
				}
				pw.print("<html>"+"<head><script type=\"text/javascript\">function preventBack(){window.history.forward();}setTimeout(\"preventBack()\", 0);window.onunload=function(){null};</script><link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\"><style type=\"text/css\"> .mycolor{background-color :#ffcce6;}.hov{height: 50%;width: 75%;}.hov:hover{z-index : 1;transform:scale(1.1);}.blue{background-color:lavender;}</style></head>"+"<body>");
				 pw.print("<h3>");
				 pw.print("<div id=\"divCounter\"></div>");
				 //pw.print("<br>");
					pw.print("<script src='newtimertest.js'></script>");
					/*After submitting going to the SampleTest.java for validating the answers*/
					pw.print("<div m-l-10 style=\"margin-left : 25%;\">");
					pw.print("<div m-r-10 style=\"margin-right : 5%;\">");
					pw.print("<form action='test1'>");
					/*Query for selecting random questions */
				ResultSet rs2=stmt.executeQuery(" select * from(select * from Questions where topic_id="+ttype+" order by dbms_random.value)where rownum <= 5");
				
				
				while(rs2.next())
				{
//					System.out.println("Question:"+rs2.getString(2));
//					System.out.println("OPtions1:"+rs2.getString(b[0]));
//					System.out.println("OPtions2:"+rs2.getString(b[1]));
//					System.out.println("OPtions3:"+rs2.getString(b[2]));
//					System.out.println("OPtions4:"+rs2.getString(b[3]));	
					
					//writing the style
					
//					System.out.println(arrId[i]);
					/*Inserting the question id in the array*/
					arrId[i] = rs2.getInt(1);
					/*inserting the correct option in the array*/
				 	arrAns[i] = rs2.getString(7);
				 	/*incrementing the i value to store the next value in array in the next index*/i++;
				 	
				 	int t = i;
				 	pw.print("<br>");
					pw.print("<div class=\"container\">");
					pw.print("<div class=\"w3-card-4 hov mycolor\" style=\"width:75%; border: 1px solid black;\"><header class=\"w3-container\" style=\"background-color :#ffcce6; \">");
				 	pw.print("<div class=\"row\">");
				 	pw.print("<h3 style=\"float: left\">Q:"+t++ +"</h3><center>"+ rs2.getString(2));
				 	pw.print("</center>");
				 	pw.print("</div>");
				 	pw.print("</header>");
				 	pw.print("<div class=\"w3-container\" style=\"background-color :lavender; \">");
				 	pw.print("<br>");
					pw.print("<input type='radio' name='ques"+j+"' id='one' value='"+rs2.getString(b[0])+"'>" + rs2.getString(b[0]));pw.print("<br>");
					pw.print("<input type='radio' name='ques"+j+"' id='one' value='"+rs2.getString(b[1])+"'>" + rs2.getString(b[1]));pw.print("<br>");
					pw.print("<input type='radio' name='ques"+j+"' id='one' value='"+rs2.getString(b[2])+"'>" + rs2.getString(b[2]));pw.print("<br>");
					pw.print("<input type='radio' name='ques"+j+"' id='one' value='"+rs2.getString(b[3])+"'>" + rs2.getString(b[3]));
					/*incrementing the j value to change the radio button name */
					j++;
					pw.print("<br><br></div></div></div>");
				}
				pw.print("<br>");
				 pw.print("<input type='submit' value='submit' onclick='myFunc()'>");
				 pw.print("</form>");
				 pw.print("</div>");
					pw.print("</h3>");
					pw.print("</body>"+"</html>");

				
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


