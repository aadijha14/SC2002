import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    // Attributes specific to Administrator
    private List<User> hospitalStaff; // List of all staff
    private Inventory inventory;      // Hospital's inventory

    // Constructor
    public Administrator(String userID, String password, String role) {
        super(userID, password, role); // Call the User constructor
        this.hospitalStaff = new ArrayList<>(); // Initialize staff list
        this.inventory = new Inventory(); // Initialize inventory
    }

    // Add new staff to the hospital
    public void addStaff(User user) {
        hospitalStaff.add(user);
        System.out.println(user.getClass().getSimpleName() + " added: " + user.getUserID());
    }

    // Update an existing staff member's information
    public void updateStaff(User user) {
        for (int i = 0; i < hospitalStaff.size(); i++) {
            if (hospitalStaff.get(i).getUserID().equals(user.getUserID())) {
                hospitalStaff.set(i, user);
                System.out.println("Staff updated: " + user.getUserID());
                return;
            }
        }
        System.out.println("Staff not found: " + user.getUserID());
    }

    // Remove a staff member from the hospital
    public void removeStaff(String userID) {
        hospitalStaff.removeIf(user -> user.getUserID().equals(userID));
        System.out.println("Staff removed: " + userID);
    }

    // Manage the inventory (mock implementation)
    public void manageInventory(Medicine medicine, int stockLevel) {
        inventory.addMedicine(medicine);
        System.out.println("Medicine added to inventory: " + medicine.getMedicineName());
    }

    // Display the administrator’s menu (override from User class)
    @Override
    public void displayMenu() {
        System.out.println("\nAdministrator Menu:");
        System.out.println("1. Add Staff");
        System.out.println("2. Update Staff");
        System.out.println("3. Remove Staff");
        System.out.println("4. View Inventory");
        System.out.println("5. Manage Inventory");
        System.out.println("6. Logout");
    }
}