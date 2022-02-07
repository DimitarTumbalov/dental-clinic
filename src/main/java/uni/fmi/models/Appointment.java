package uni.fmi.models;

import java.time.LocalDateTime;

/**
 * 
 */
public class Appointment {
    private int id;
    private User creator;
    private LocalDateTime time;
    private Patient patient;
    private Calendar calendar;
	
    /**
     * Default constructor
     */
    public Appointment(final User creator, final Patient patient, final LocalDateTime time) {
    	this.creator = creator;
    	this.patient = patient;
    	this.time = time;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public User getCreator() {
        return creator;
    }

    /**
     * @param creator 
     * @return
     */
    public void setCreator(User creator) {
        this.creator =  creator;
    }

    /**
     * @return
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * @param time 
     * @return
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * @return
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient 
     * @return
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    /**
     * @return
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * @param calendar 
     * @return
     */
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

}