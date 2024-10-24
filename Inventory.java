import java.util.ArrayList;
import java.util.List;

public class Inventory {
    // List of medicines in inventory
    private List<Medicine> medicines;

    // Constructor
    public Inventory() {
        this.medicines = new ArrayList<>();
    }

    // Add a new medicine to the inventory
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
        System.out.println(medicine.getMedicineName() + " added to inventory.");
    }

    // Update stock for a given medicine
    public void updateStock(String medicineName, int quantity) {
        for (Medicine medicine : medicines) {
            if (medicine.getMedicineName().equals(medicineName)) {
                medicine.setStockLevel(medicine.getStockLevel() + quantity);
                System.out.println("Updated stock for " + medicineName + ": " + medicine.getStockLevel());
                return;
            }
        }
        System.out.println("Medicine not found in inventory.");
    }

    // Get low stock medicines
    public List<Medicine> getLowStockMedicines(int threshold) {
        List<Medicine> lowStock = new ArrayList<>();
        for (Medicine medicine : medicines) {
            if (medicine.getStockLevel() <= threshold) {
                lowStock.add(medicine);
            }
        }
        return lowStock;
    }

    // Display inventory details
    public void displayInventory() {
        for (Medicine medicine : medicines) {
            System.out.println("Medicine: " + medicine.getMedicineName() +
                               ", Stock Level: " + medicine.getStockLevel());
        }
    }
}
