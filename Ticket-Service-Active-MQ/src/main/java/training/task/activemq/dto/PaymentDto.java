package training.task.activemq.dto;

import java.io.Serializable;

public class PaymentDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -322384857025039773L;
	private Long id;
	private Long ticketId;
	private Long userId;
	private Long insuranceId;
	private double totalPrice;
	private String paymentStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", ticketId=" + ticketId + ", userId=" + userId + ", insuranceId=" + insuranceId
				+ ", totalPrice=" + totalPrice + ", paymentStatus=" + paymentStatus + "]";
	}
	
}
