// MedicalRecord.java
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    // Attributes
    private String recordID;
    private List<String> diagnoses;
    private List<String> treatments;
    private List<Prescription> prescriptions;

    // Constructor
    public MedicalRecord() {
        this.recordID = "MR" + System.currentTimeMillis();  // Unique ID
        this.diagnoses = new ArrayList<>();
        this.treatments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Add a diagnosis
    public void addDiagnosis(String diagnosis) {
        diagnoses.add(diagnosis);
        System.out.println("Diagnosis added: " + diagnosis);
    }

    // Add a treatment
    public void addTreatment(String treatment) {
        treatments.add(treatment);
        System.out.println("Treatment added: " + treatment);
    }

    // Add a prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        System.out.println("Prescription added.");
    }

    // Display the medical record details
    public void displayRecord() {
        System.out.println("Medical Record ID: " + recordID);
        System.out.println("Diagnoses:");
        for (String diagnosis : diagnoses) {
            System.out.println("- " + diagnosis);
        }
        System.out.println("Treatments:");
        for (String treatment : treatments) {
            System.out.println("- " + treatment);
        }
        System.out.println("Prescriptions:");
        for (Prescription prescription : prescriptions) {
            prescription.displayDetails();
        }
    }

    // Getters
    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
}