package training.task.activemq.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TicketsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2004273319241551506L;
	
	private Long id;
	
	private Long userId;
	
	private String source;
	
	private String destination;
	
	private int totalSeats;
	
	private double totalTicketsPrice;
	
	private String bookingStatus;
	
	private LocalDate travelDate;
	
	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public double getTotalTicketsPrice() {
		return totalTicketsPrice;
	}

	public void setTotalTicketsPrice(double totalTicketsPrice) {
		this.totalTicketsPrice = totalTicketsPrice;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "TicketsDto [id=" + id + ", userId=" + userId + ", source=" + source + ", destination=" + destination
				+ ", totalSeats=" + totalSeats + ", totalTicketsPrice=" + totalTicketsPrice + ", bookingStatus="
				+ bookingStatus + "]";
	}

}
