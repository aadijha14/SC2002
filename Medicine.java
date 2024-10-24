public class Medicine {
    // Attributes
    private String medicineName;
    private int stockLevel;
    private int lowStockAlertLevel;

    // Constructor
    public Medicine(String medicineName, int stockLevel, int lowStockAlertLevel) {
        this.medicineName = medicineName;
        this.stockLevel = stockLevel;
        this.lowStockAlertLevel = lowStockAlertLevel;
    }

    // Getter for medicine name
    public String getMedicineName() {
        return medicineName;
    }

    // Getter for stock level
    public int getStockLevel() {
        return stockLevel;
    }

    // Setter for stock level
    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    // Check if stock is low
    public boolean isLowStock() {
        return stockLevel <= lowStockAlertLevel;
    }
}