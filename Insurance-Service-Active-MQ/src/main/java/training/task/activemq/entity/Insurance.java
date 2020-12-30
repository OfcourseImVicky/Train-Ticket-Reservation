package training.task.activemq.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "Insurance")
@Entity
public class Insurance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9035568481456439359L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long ticketId;
	private Long userId;
	private double ticketPrice;
	private double insurancePrice;
	private String insuranceStatus;
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
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public double getInsurancePrice() {
		return insurancePrice;
	}
	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
	public String getInsuranceStatus() {
		return insuranceStatus;
	}
	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}
	@Override
	public String toString() {
		return "InsuranceDto [id=" + id + ", ticketId=" + ticketId + ", userId=" + userId + ", ticketPrice="
				+ ticketPrice + ", insurancePrice=" + insurancePrice + ", insuranceStatus=" + insuranceStatus + "]";
	}
	
}
