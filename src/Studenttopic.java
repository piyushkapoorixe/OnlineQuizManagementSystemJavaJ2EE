

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Studenttopic
 */
@WebServlet("/Studenttopic")
public class Studenttopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studenttopic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginPage1.session = request.getSession(true);
		//LoginPage1.session.setAttribute("tempuserid", myuserid);
		//int userid=(int) request.getSession(false).getAttribute("tempuserid");
		 String ttopictype=(request.getParameter("topic1"));
		 int topictype = Integer.parseInt(ttopictype);
		 System.out.println("topictype is " + topictype);
//		 int mytopic = (int) session.getAttribute("topictype");
//		 System.out.println("mytopic is " + mytopic);
		 LoginPage1.session.setAttribute("temptypeid", topictype);
		  RequestDispatcher rd=request.getRequestDispatcher("questionhistory1");
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
