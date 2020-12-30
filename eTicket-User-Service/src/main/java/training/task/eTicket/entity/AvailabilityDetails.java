package training.task.eTicket.entity;

import java.io.Serializable;
import java.time.DayOfWeek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "availability_details")
public class AvailabilityDetails implements Serializable{
	private static final long serialVersionUID = -6729776437353810187L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long trainId;
	private int dayOfWeek;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTrainId() {
		return trainId;
	}
	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	@Override
	public String toString() {
		return "AvailabilityDetails [id=" + id + ", trainId=" + trainId + ", dayOfWeek=" + dayOfWeek + "]";
	}
	
}
