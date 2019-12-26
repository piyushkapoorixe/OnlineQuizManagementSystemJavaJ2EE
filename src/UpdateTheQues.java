

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
 * Servlet implementation class UpdateTheQues
 */
@WebServlet("/UpdateTheQues")
public class UpdateTheQues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheQues() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		LoginPage1.session = request.getSession(true);
		//getting the questionid from UpdateNewQues.java using session
		String updatemyquesid1=    (String) request.getSession(false).getAttribute("quesid");
		int updatemyquesid=Integer.parseInt(updatemyquesid1);
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
			 
			//step3 create the statement object  
			Statement stmt=con.createStatement();
			//code for updating the question and option using question id
			 ResultSet rs=stmt.executeQuery("update Questions set quesname='"+request.getParameter("uQuestion")+"', op1='"+request.getParameter("uOption1")+"', op2='"+request.getParameter("uOption2")+"', op3='"+request.getParameter("uOption3")+"', op4='"+request.getParameter("uOption4")+"', correctop='"+request.getParameter("uAnswer")+"', ansexplanation='"+request.getParameter("uExplanation")+"' where auto_increment_quesid = '"+updatemyquesid+"'");
			 System.out.println("Id is " +updatemyquesid);
			 // going to ProfessorSelect.html
			 RequestDispatcher rd=request.getRequestDispatcher("questionhistory3");
			 rd.forward(request,response);
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
