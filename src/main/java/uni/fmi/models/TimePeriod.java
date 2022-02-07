package uni.fmi.models;
import java.time.LocalTime;
import java.util.Objects;

/**
 * 
 */
public class TimePeriod {
    private LocalTime start;
    private LocalTime end;
    
    /**
     * Default constructor
     */
    public TimePeriod(LocalTime start, LocalTime end) {
    	this.start = start;
    	this.end = end;
    }

    /**
     * @return
     */
    public LocalTime getStart() {
    	return start;
    }

    /**
     * @param start 
     * @return
     */
    public void setStart(LocalTime start) {
        this.start = start;
    }

    /**
     * @return
     */
    public LocalTime getEnd() {
        return end;
    }

    /**
     * @param end 
     * @return
     */
    public void setEnd(LocalTime end) {
        this.end = end;
    }

	@Override
	public int hashCode() {
		return Objects.hash(end, start);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimePeriod other = (TimePeriod) obj;
		return Objects.equals(end, other.end) && Objects.equals(start, other.start);
	}

}