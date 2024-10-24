import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    // Attributes specific to Doctor
    private String doctorID;         // Unique identifier for the doctor
    private String name;             // Doctor's full name
    private String specialty;        // Doctor's specialty
    private List<Appointment> appointments;  // Doctor's scheduled appointments
    private List<TimeSlot> availability;     // Available time slots

    // Constructor
    public Doctor(String userID, String password, String role, 
                  String doctorID, String name, String specialty) {
        super(userID, password, role);  // Call User constructor
        this.doctorID = doctorID;
        this.name = name;
        this.specialty = specialty;
        this.appointments = new ArrayList<>();  // Initialize appointment list
        this.availability = new ArrayList<>();  // Initialize available slots
    }

    // Getter for doctor name
    public String getName() {
        // Check if name already contains "Dr." to avoid duplication
        return name.startsWith("Dr.") ? name : "Dr. " + name;
    }


    // Getter for doctor ID
    public String getDoctorID() {
        return this.doctorID;
    }

    // View a patient’s medical record (mock implementation)
    public MedicalRecord viewPatientRecord(String patientID) {
        System.out.println("Viewing medical record for patient ID: " + patientID);
        // In a real-world scenario, you'd search for the patient's record.
        return new MedicalRecord();  // Return an empty record for demo purposes
    }

    // Update a patient's medical record
    public void updateMedicalRecord(Patient patient, String diagnosis, String treatment) {
        MedicalRecord record = patient.getMedicalRecord();
        record.addDiagnosis(diagnosis);
        record.addTreatment(treatment);
        System.out.println("Medical record updated for patient: " + patient.getName());
    }

    // View the doctor’s personal schedule
    public List<Appointment> viewPersonalSchedule() {
        System.out.println("Viewing personal schedule for Dr. " + this.name);
        for (Appointment appointment : appointments) {
            appointment.displayDetails();
        }
        return appointments;
    }

    // Set the doctor’s availability
    public void setAvailability(List<TimeSlot> availableSlots) {
        this.availability = availableSlots;
        System.out.println("Availability set for Dr. " + this.name);
    }

    // Add availability slot (with conflict detection)
    public boolean addAvailability(TimeSlot slot) {
        for (TimeSlot existingSlot : availability) {
            if (existingSlot.isOverlapping(slot)) {
                System.out.println("Cannot add time slot. It overlaps with an existing slot.");
                return false;
            }
        }
        availability.add(slot);
        System.out.println("Time slot added successfully.");
        return true;
    }

    // Check if appointment conflicts with existing appointments
    public boolean hasConflict(Appointment newAppointment) {
        long newTime = newAppointment.getAppointmentDate().getTime();
        for (Appointment appointment : appointments) {
            long existingTime = appointment.getAppointmentDate().getTime();
            long oneHourInMillis = 3600000;  // Assuming 1-hour appointments

            if (Math.abs(newTime - existingTime) < oneHourInMillis) {
                return true;
            }
        }
        return false;
    }

    // Check if the appointment is within available time slots
    public boolean hasAvailabilityConflict(Appointment appointment) {
        long appointmentTime = appointment.getAppointmentDate().getTime();
        for (TimeSlot slot : availability) {
            if (appointmentTime >= slot.getStartTime().getTime() &&
                appointmentTime <= slot.getEndTime().getTime()) {
                return false;  // Appointment fits in an available slot
            }
        }
        System.out.println("Appointment conflicts with availability.");
        return true;
    }

    // Accept an appointment (if no conflicts)
    public void acceptAppointment(Appointment appointment) {
        if (hasConflict(appointment) || hasAvailabilityConflict(appointment)) {
            System.out.println("Conflict detected! Appointment cannot be accepted.");
        } else {
            appointment.setStatus("Confirmed");
            appointments.add(appointment);
            System.out.println("Appointment accepted.");
        }
    }

    // Decline an appointment
    public void declineAppointment(Appointment appointment) {
        appointment.setStatus("Declined");
        System.out.println("Appointment declined.");
        appointments.remove(appointment);
    }

    // Record the outcome of an appointment
    public void recordAppointmentOutcome(Appointment appointment, String outcome) {
        appointment.completeAppointment(outcome);
        System.out.println("Recorded outcome: " + outcome);
    }

    // Display the doctor’s menu (override from User class)
    @Override
    public void displayMenu() {
        System.out.println("\nDoctor Menu:");
        System.out.println("1. View Patient Medical Records");
        System.out.println("2. Update Patient Medical Records");
        System.out.println("3. View Personal Schedule");
        System.out.println("4. Set Availability for Appointments");
        System.out.println("5. Accept or Decline Appointment Requests");
        System.out.println("6. View Upcoming Appointments");
        System.out.println("7. Record Appointment Outcome");
        System.out.println("8. Logout");
    }
}
