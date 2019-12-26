

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddQuestion1
 */
@WebServlet("/AddQuestion1")
public class AddQuestion1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private HttpSession session;

	//public static final int topictype = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//public static String topictype;
	public static int topictype=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getting the topic id by using the getParamter()
		 String ttopictype=(request.getParameter("topic1"));
		 topictype = Integer.parseInt(ttopictype);
		 System.out.println("topictype is " + topictype);
		 //Going to ProfessorSelect.html to perform some action for the selected topic
		  RequestDispatcher rd=request.getRequestDispatcher("questionhistory3");
			rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
