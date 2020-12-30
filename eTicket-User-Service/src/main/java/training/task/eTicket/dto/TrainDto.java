package training.task.eTicket.dto;

import java.io.Serializable;

public class TrainDto implements Serializable {
	
	private static final long serialVersionUID = 1290209793375795591L;
	private long id;
	private String trainName;
	private String source;
	private String destination;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
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

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainName=" + trainName + ", source=" + source + ", destination=" + destination
				+ "]";
	}

}
