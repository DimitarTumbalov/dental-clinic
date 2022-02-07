package uni.fmi.models;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 
 */
public class DateTimePeriod{
    private LocalDateTime start;
    private LocalDateTime end;
	
    /**
     * Default constructor
     */
    public DateTimePeriod(LocalDateTime start, LocalDateTime end) {
    	this.start = start;
    	this.end = end;
    }

    /**
     * @return
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * @param start 
     * @return
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * @return
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * @param end 
     * @return
     */
    public void setEnd(LocalDateTime end) {
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
		DateTimePeriod other = (DateTimePeriod) obj;
		return Objects.equals(end, other.end) && Objects.equals(start, other.start);
	}
}