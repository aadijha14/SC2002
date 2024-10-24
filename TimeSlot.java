import java.util.Date;

public class TimeSlot {
    private Date startTime;
    private Date endTime;

    // Constructor
    public TimeSlot(Date startTime, Date endTime) {
        if (endTime.before(startTime)) {
            throw new IllegalArgumentException("End time must be after start time.");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Check if two time slots overlap
    public boolean isOverlapping(TimeSlot other) {
        return this.startTime.before(other.endTime) && other.startTime.before(this.endTime);
    }

    // Display the time slot
    public void displaySlot() {
        System.out.println("Time Slot: " + startTime + " - " + endTime);
    }

    // Getters
    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
