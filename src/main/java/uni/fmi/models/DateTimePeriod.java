package uni.fmi.models;
import java.time.LocalDateTime;

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

}