package uni.fmi.appointment.model;

import java.time.LocalDateTime;

import uni.fmi.appointment.service.AppointmentService;
import uni.fmi.models.Patient;
import uni.fmi.models.User;

public class AppointmentScreenModel {
	private User creator;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDateTime time;
	private String message;

	public void setCreator(final User creator) {
		this.creator = creator;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setTime(final LocalDateTime time) {
		this.time = time;
	}

	public void clickSaveButton() {
		message = AppointmentService.appointment(creator, new Patient(email, phoneNumber, firstName, lastName), time);
	}
	
	public String getMessage() {
		return message;
	}

}
