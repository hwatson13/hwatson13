package toEat;
public class SystemAdmin extends User {
    /**
     * Default Constructor for an Admin, extends User qualities.
     * @param name
     */
    public SystemAdmin(String name) {
        super(name);
    }

    /**
     * Displays low stock across inventories.
     * @param inventoryManager
     */
    public void viewLowStockItems(InventoryManager inventoryManager) {
        System.out.println("\n*** System Admin: Low Stock Items ***");
        for (String inventoryName : inventoryManager.getInventories().keySet()) {
            Inventory inventory = inventoryManager.loadInventory(inventoryName);
            for (Item item : inventory.getItems()) {
                if (item.getQuantity() < 3) { // Low stock threshold
                    System.out.println("- Low stock: " + item.getName() + " (Quantity: " + item.getQuantity() + ")");
                }
            }
        }
        System.out.println("*** End of Low Stock Report ***\n");
    }    
}
