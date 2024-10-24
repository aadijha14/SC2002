import java.util.Date;

public class Prescription {
    // Attributes
    private String prescriptionID;  // Unique prescription ID
    private String medicineName;    // Name of the medicine
    private int quantity;           // Quantity prescribed
    private String status;          // Status (e.g., "Pending", "Dispensed")
    private Doctor prescribedBy;    // Doctor who issued the prescription
    private Date issuedDate;        // Date the prescription was issued

    // Constructor
    public Prescription(String prescriptionID, String medicineName, int quantity, Doctor prescribedBy) {
        this.prescriptionID = prescriptionID;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.status = "Pending";  // Default status
        this.prescribedBy = prescribedBy;
        this.issuedDate = new Date();  // Default to current date
    }

    // Update the prescription status
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Prescription status updated to: " + newStatus);
    }

    // Display prescription details
    public void displayDetails() {
        System.out.println("Prescription ID: " + prescriptionID);
        System.out.println("Medicine: " + medicineName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Prescribed By: " + prescribedBy.getName());
        System.out.println("Issued Date: " + issuedDate);
        System.out.println("Status: " + status);
    }

    // Getters for prescription details
    public String getMedicineName() {
        return medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public Doctor getPrescribedBy() {
        return prescribedBy;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }
}
