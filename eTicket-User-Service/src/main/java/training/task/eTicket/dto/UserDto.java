package training.task.eTicket.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -2293008357441314935L;
	private long id;
	private String username;
	private String password;
	private String contactNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", contactNumber="
				+ contactNumber + "]";
	}

}
