package Entry;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServlet() {
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
		String PNR = new String();
		
		boolean status = true;
		
		do{
				PNR = getSaltString();
				status = DAOMaster.getPNR();
		}
		while(status==true);
		
		HttpSession s = request.getSession(true);
		
		Date dt = (Date)s.getAttribute("flightDate");
		String id = (String)s.getAttribute("FlightID");
		String username = (String)s.getAttribute("CurrentUser");
		
		Ticket ticket = new Ticket();
		ticket.setFlightDate(dt);
		ticket.setFlightID(id);
		ticket.setUserID(username);
		ticket.setPNR(PNR);
		
		boolean flag = (new DAOMaster()).addTicket(ticket);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowTicket.jsp");  //display flights
		s.setAttribute("TicketID", ticket);
		rd.forward(request, response);
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
