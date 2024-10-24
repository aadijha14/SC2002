import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create Doctor and Patient
        Doctor doctor = new Doctor("D001", "password", "Doctor", "D001", "John", "Cardiology");
        Patient patient = new Patient("P001", "password", "Patient", "P001", "Alice", "alice@gmail.com");

        // Set Doctor's Availability
        TimeSlot slot1 = new TimeSlot(new Date(System.currentTimeMillis() + 3600000),  // 1 hour from now
                                      new Date(System.currentTimeMillis() + 7200000)); // 2 hours from now
        doctor.addAvailability(slot1);

        System.out.println("\n-- Scheduling Appointment 1 --");
        Appointment appointment1 = new Appointment("A001", new Date(System.currentTimeMillis() + 3600000), doctor, patient);
        appointment1.schedule();  // Should succeed

        System.out.println("\n-- Scheduling Appointment 2 (Conflict Expected) --");
        Appointment appointment2 = new Appointment("A002", new Date(System.currentTimeMillis() + 3600000), doctor, patient);
        appointment2.schedule();  // Should detect conflict

        System.out.println("\n-- Rescheduling Appointment 1 --");
        appointment1.reschedule(new Date(System.currentTimeMillis() + 10800000));  // Reschedule 3 hours from now

        System.out.println("\n-- Canceling Appointment 1 --");
        appointment1.cancel();  // Verify cancellation works

        System.out.println("\n-- Completing Appointment 2 --");
        appointment2.completeAppointment("Regular Checkup completed.");  // Mark as completed

        System.out.println("\n-- Viewing Patient's Past Appointments --");
        patient.viewPastAppointments();  // This should now show the completed appointment

        System.out.println("\n-- Viewing Doctor's Personal Schedule --");
        doctor.viewPersonalSchedule();  // Verify the doctor's schedule reflects the changes
    }
}