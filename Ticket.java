package Entry;

import java.sql.Date;

public class Ticket {
	private String PNR;
	private String UserID;
	private String FlightID;
	private Date FlightDate;
	
	public String getPNR() {
		return PNR;
	}
	public void setPNR(String pNR) {
		PNR = pNR;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getFlightID() {
		return FlightID;
	}
	public void setFlightID(String flightID) {
		FlightID = flightID;
	}
	public Date getFlightDate() {
		return FlightDate;
	}
	public void setFlightDate(Date flightDate) {
		FlightDate = flightDate;
	}
}
