package Entry;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	private Date date;
	private String source;
	private String destination;
	private String ID;
	private String status;
	private Time Arrivaltime;
	private Time Departuretime;
	private int capacity;
	private int seats;
	private int price;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Time getArrivaltime() {
		return Arrivaltime;
	}
	public void setArrivaltime(Time arrivaltime) {
		Arrivaltime = arrivaltime;
	}
	public Time getDeparturetime() {
		return Departuretime;
	}
	public void setDeparturetime(Time departuretime) {
		Departuretime = departuretime;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
