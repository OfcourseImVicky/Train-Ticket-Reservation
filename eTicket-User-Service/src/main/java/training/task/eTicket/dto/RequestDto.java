package training.task.eTicket.dto;

import java.time.LocalDate;

public class RequestDto {

	
	private String source;
	
	private String destination;
	
	private int totalSeats;
	
	private LocalDate travelDate;
	
	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
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



	@Override
	public String toString() {
		return "TicketsDto [ source=" + source + ", destination=" + destination
				+ ", totalSeats=" + totalSeats + "]";
	}

}
