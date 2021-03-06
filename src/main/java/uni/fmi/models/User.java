package uni.fmi.models;
import java.util.*;

/**
 * 
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Set<Appointment> appointments;
    private Calendar calendar;
	
    /**
     * Default constructor
     */
    public User() {
    	this(null, null, null, null, null, null);
    }
    
    public User(String username, String email, String password, String firstName, String lastName, Role role) {
    	this.username = username;
    	this.email = email;
    	this.password = password;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.role = role;
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
    public String getUsername() {
        return username;
    }

    /**
     * @param username 
     * @return
     */
    public void setUsername(String username) {
        this.username = username;
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
    public String getPassword() {
        return password;
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
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
    public Role getRole() {
        return role;
    }

    /**
     * @param role 
     * @return
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return
     */
    public Set<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * @param appointment 
     * @return
     */
    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
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

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}
}