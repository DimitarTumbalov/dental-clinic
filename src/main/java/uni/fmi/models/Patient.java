package uni.fmi.models;
import java.util.*;

/**
 * 
 */
public class Patient {
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Set<Appointment> appointments;
	
    /**
     * Default constructor
     */
    public Patient(final String email, final String phoneNumber, final String firstName, final String lastName) {
    	this.email = email;
    	this.phoneNumber = phoneNumber;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
     * @return
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName 
     * @return
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName 
     * @return
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public Set<Appointment> getAppointments() {
    	return appointments;
    }

    /**
     * @param appointments 
     * @return
     */
    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

}