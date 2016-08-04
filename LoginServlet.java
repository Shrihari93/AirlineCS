package Entry;

import Beans.UserDAO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login user = new Login();
		user.setUsername(request.getParameter("form-username"));
		user.setPassword(request.getParameter("form-password"));
		boolean status = (new DAOMaster()).Authenticate(user);
		
		if(status == true){
			RequestDispatcher rd = request.getRequestDispatcher("index.html");  //Login Successful
			HttpSession s = request.getSession(true);
			s.setAttribute("CurrentUser", user.getUsername());
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("homeindex.html");  //Stay on the same page
			rd.include(request, response);
		}
			
	}

}
