package Entry;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		User user = new User();
		user.setName(request.getParameter("form-first-name"));
		user.setPassword(request.getParameter("form-password"));
		user.setAddress(request.getParameter("form-city"));
		user.setAge(Integer.parseInt(request.getParameter("form-age")));
		user.setGender(request.getParameter("form-gender"));
		user.setMobile(Integer.parseInt(request.getParameter("form-mobile")));
		
		boolean status = (new DAOMaster()).addUser(user);
		
		if(status == true){
			RequestDispatcher rd = request.getRequestDispatcher("index.html");  //Login Successful
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("homeindex.html");  //Stay on the same page
			rd.include(request, response);
		}

	}

}
