

import java.io.IOException;
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
 * Servlet implementation class DeleteNewQues
 */
@WebServlet("/DeleteNewQues")
public class DeleteNewQues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewQues() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				LoginPage1.session=request.getSession(true);
				//getting the value of the question id by using getParameter
				String questionid2=request.getParameter("deletequesbutton");
				int deletemyquesid2=Integer.parseInt(questionid2);
				//LoginPage1.session.setAttribute("quesid", questionid2);
				
				try{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");  
					 
					//step3 create the statement object  
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from Questions");
					while(rs.next()) {
						//delete the question of the selected question using question id
					stmt.executeUpdate("delete from Questions where auto_increment_quesid='"+deletemyquesid2+"'");
					}
					 System.out.println("Delete ques Id is " +deletemyquesid2);
					 con.commit();
					 con.close();
					 //Control moving to ProfessorSelect.html
					 RequestDispatcher rd = request.getRequestDispatcher("questionhistory3");
					 rd.forward(request, response);
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
