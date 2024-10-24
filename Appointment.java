import java.util.Date;

public class Appointment {
    // Attributes
    private String appointmentID;
    private Date appointmentDate;
    private String status;  // e.g., "Scheduled", "Completed", "Cancelled"
    private Doctor doctor;
    private Patient patient;
    private String outcome; // Notes after appointment (if completed)

    // Constructor
    public Appointment(String appointmentID, Date appointmentDate, 
                       Doctor doctor, Patient patient) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.status = "Scheduled"; // Default status
        this.doctor = doctor;
        this.patient = patient;
        this.outcome = "";
    }

    // Schedule the appointment
    public boolean schedule() {
        if (doctor.hasConflict(this)) {
            System.out.println("Cannot schedule appointment. Conflict detected.");
            return false;
        }
        if (doctor.hasAvailabilityConflict(this)) {
            System.out.println("Appointment time is outside available slots.");
            return false;
        }
        doctor.acceptAppointment(this);
        patient.scheduleAppointment(this);
        System.out.println("Appointment scheduled successfully.");
        return true;
    }

    // Reschedule the appointment to a new date
    public void reschedule(Date newDate) {
        Appointment temp = new Appointment(appointmentID, newDate, doctor, patient); 
        if (doctor.hasConflict(temp)) {  // Use temporary appointment object to check conflicts
            System.out.println("Cannot reschedule appointment. Conflict detected.");
        } else {
            this.appointmentDate = newDate;
            System.out.println("Appointment rescheduled to: " + newDate);
        }
    }

    // Cancel the appointment
    public void cancel() {
        this.status = "Cancelled";
        doctor.declineAppointment(this);
        patient.cancelAppointment(this);
        System.out.println("Appointment cancelled.");
    }

    // Display appointment details
    public void displayDetails() {
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Patient: " + patient.getName());
        System.out.println("Status: " + status);
    }

    // Display appointment outcome if completed
    public void displayOutcome() {
        if ("Completed".equals(status)) {
            System.out.println("Outcome: " + outcome);
        } else {
            System.out.println("No outcome available. Appointment not completed.");
        }
    }

    public void completeAppointment(String outcome) {
        this.status = "Completed";  // Ensure status is marked correctly
        this.outcome = outcome;
        System.out.println("Appointment marked as completed.");
    }


    // Check if the appointment is completed
    public boolean isCompleted() {
        return "Completed".equals(status);
    }

    // Getters
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }
}
