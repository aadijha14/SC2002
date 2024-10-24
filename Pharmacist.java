import java.util.ArrayList;
import java.util.List;

public class Pharmacist extends User {
    // Attributes
    private List<Prescription> prescriptions;  // List of prescriptions managed by the pharmacist
    private Inventory inventory;               // Pharmacist's inventory

    // Constructor
    public Pharmacist(String userID, String password, String role) {
        super(userID, password, role);  // Call User constructor
        this.prescriptions = new ArrayList<>();  // Initialize the list of prescriptions
        this.inventory = new Inventory();        // Initialize the inventory
    }

    public Inventory getInventory() {
        return inventory;
    }

    // View the outcome of a patient's appointment (mock implementation)
    public void viewAppointmentOutcome(String patientID) {
        System.out.println("Viewing appointment outcome for patient ID: " + patientID);
        // In real implementation, you'd fetch the outcome from Appointment.
    }

    // Update the status of a given prescription
    public void updatePrescriptionStatus(Prescription prescription, String newStatus) {
        prescription.updateStatus(newStatus);
    }

    // View inventory
    public void viewInventory() {
        System.out.println("Viewing Inventory:");
        inventory.displayInventory();
    }

    // Submit a replenishment request for medicine
    public void submitReplenishmentRequest(Medicine medicine) {
        System.out.println("Replenishment request submitted for: " + medicine.getMedicineName());
    }

    // Display the pharmacist’s menu (override from User class)
    @Override
    public void displayMenu() {
        System.out.println("\nPharmacist Menu:");
        System.out.println("1. View Appointment Outcome");
        System.out.println("2. Update Prescription Status");
        System.out.println("3. View Inventory");
        System.out.println("4. Submit Replenishment Request");
        System.out.println("5. Logout");
    }
}