package Entry;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Search flight = new Search();
		flight.setDate(request.getParameter(""));
		flight.setDestination(request.getParameter(""));
		flight.setSource(request.getParameter(""));
		
		ArrayList<Flight> Air = (new DAOMaster()).SearchFlights(flight);  // return all the flights for respective inputs
		
		if(Air.isEmpty()==false){
			RequestDispatcher rd = request.getRequestDispatcher("DisplayFlights.jsp");  //display flights
			HttpSession s = request.getSession(true);
			s.setAttribute("AvailableFlights", Air);
			s.setAttribute("flightDate", request.getParameter(""));
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("index.html");  //Stay on the same page
			rd.include(request, response);
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
