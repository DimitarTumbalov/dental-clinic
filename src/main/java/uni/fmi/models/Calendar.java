package uni.fmi.models;
import java.time.DayOfWeek;
import java.util.*;

/**
 * 
 */
public class Calendar {
    private Map<DayOfWeek, Set<TimePeriod>> workSchedule;
    private Set<DateTimePeriod> holidays;
    private User dentist;
    private Set<Appointment> appointments;
    
    /**
     * Default constructor
     */
    public Calendar(Map<DayOfWeek, Set<TimePeriod>> workSchedule, Set<DateTimePeriod> holidays) {
    	this.workSchedule = workSchedule;
    	this.holidays = holidays;
    }

    /**
     * @return
     */
    public Map<DayOfWeek, Set<TimePeriod>> getWorkSchedule() {
        return workSchedule;
    }

    /**
     * @param workSchedule 
     * @return
     */
    public void setWorkSchedule(Map<DayOfWeek, Set<TimePeriod>> workSchedule) {
        // TODO implement here
        this.workSchedule = workSchedule;
    }

    /**
     * @return
     */
    public Set<DateTimePeriod> getHolidays() {
        return holidays;
    }

    /**
     * @param holidays 
     * @return
     */
    public void setHolidays(Set<DateTimePeriod> holidays) {
        this.holidays = holidays;
    }

    /**
     * @return
     */
    public User getDentist() {
        return dentist;
    }

    /**
     * @param dentist 
     * @return
     */
    public void setDentist(User dentist) {
        this.dentist = dentist;
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

	@Override
	public int hashCode() {
		return Objects.hash(holidays, workSchedule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		return Objects.equals(holidays, other.holidays) && Objects.equals(workSchedule, other.workSchedule);
	}
    
    

}