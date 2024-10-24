// Patient.java
import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    // Attributes specific to Patient
    private String patientID;
    private String name;
    private String contactInfo;
    private MedicalRecord medicalRecord;
    private List<Appointment> appointments;

    // Constructor
    public Patient(String userID, String password, String role,
                   String patientID, String name, String contactInfo) {
        super(userID, password, role);  // Calling the User class constructor
        this.patientID = patientID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.medicalRecord = new MedicalRecord();  // Initialize medical record
        this.appointments = new ArrayList<>();     // Initialize appointment list
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Add this getter to Patient.java to return the medical record
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    // Getter for appointments
    public List<Appointment> getAppointments() {
        return appointments;
    }

    // Method to update personal contact information
    public void updatePersonalInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
        System.out.println("Contact information updated successfully.");
    }

    // Method to view medical record
    public void viewMedicalRecord() {
        System.out.println("Displaying medical record for patient: " + this.name);
        medicalRecord.displayRecord();
    }

    // Method to schedule an appointment
    public void scheduleAppointment(Appointment appointment) {
        if (!appointments.contains(appointment)) {
            appointments.add(appointment);
            System.out.println("Appointment scheduled for " + this.name);
        }
    }

    // Method to reschedule an existing appointment
    public void rescheduleAppointment(Appointment oldAppointment, Appointment newAppointment) {
        if (appointments.remove(oldAppointment)) {
            appointments.add(newAppointment);
        } else {
            System.out.println("Appointment not found.");
        }
    }

    // Method to cancel an appointment
    public boolean cancelAppointment(Appointment appointment) {
        if (appointments.remove(appointment)) {
            System.out.println("Appointment canceled for " + this.name);
            return true;  // Indicate successful removal
        } else {
            System.out.println("Appointment not found.");
            return false;  // Indicate failure to remove
        }
    }


    // Method to view all scheduled appointments
    public void viewScheduledAppointments() {
        System.out.println("Scheduled Appointments for " + this.name + ":");
        for (Appointment appointment : appointments) {
            appointment.displayDetails();
        }
    }

    // Method to view past appointment outcome records
    // View past appointment outcome records
    public void viewPastAppointments() {
        System.out.println("Past Appointments for " + this.name + ":");
        boolean hasPastAppointments = false;

        for (Appointment appointment : appointments) {
            System.out.println("Checking appointment: " + appointment.getAppointmentID() + " - Status: " + appointment.getStatus());  // Debugging line

            if (appointment.isCompleted()) {
                appointment.displayOutcome();
                hasPastAppointments = true;
            }
        }

        if (!hasPastAppointments) {
            System.out.println("No past appointments available.");
        }
    }


    // Implementation of the abstract method from User class
    @Override
    public void displayMenu() {
        System.out.println("\nPatient Menu:");
        System.out.println("1. View Medical Record");
        System.out.println("2. Update Personal Information");
        System.out.println("3. View Available Appointment Slots");
        System.out.println("4. Schedule an Appointment");
        System.out.println("5. Reschedule an Appointment");
        System.out.println("6. Cancel an Appointment");
        System.out.println("7. View Scheduled Appointments");
        System.out.println("8. View Past Appointment Outcome Records");
        System.out.println("9. Logout");
    }
}