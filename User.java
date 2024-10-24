public abstract class User {
    // Attributes
    protected String userID;
    protected String password;
    protected String role;

    // Constructor
    public User(String userID, String password, String role) {
        this.userID = userID;
        this.password = password;
        this.role = role;
    }

    // Login method
    public boolean login(String enteredID, String enteredPassword) {
        if (this.userID.equals(enteredID) && this.password.equals(enteredPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
    }

    // Change password method
    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    // Getter for userID
    public String getUserID() {
        return userID;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayMenu();
}