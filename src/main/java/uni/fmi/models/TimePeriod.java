package uni.fmi.models;
import java.time.LocalTime;

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

}