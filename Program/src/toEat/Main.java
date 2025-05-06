package toEat;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // 1. Create and manage inventories: Kitchen and Pantry.
        /** How do we create a new inventory?
         * Note that the Program will not allow duplicate names. */
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.createInventory("Kitchen");
        inventoryManager.createInventory("Pantry");

        // Creating Items & Adding to Inventories.
        Inventory kitchenInventory = inventoryManager.loadInventory("Kitchen");
        Item apple = new Item("Apple", 1.99, 10, LocalDate.of(2025, 4, 30));
        Item milk = new Item("Milk", 2.49, 5, LocalDate.of(2025, 5,10));
        Item chocolate = new Item("Chocolate", 3.79, 2, LocalDate.of(2025, 5, 14));
        Item lettuce = new Item("Lettuce", 3.25, 1, LocalDate.of(2025, 4, 29));
        inventoryManager.addItemToInventory("Kitchen", apple);
        inventoryManager.addItemToInventory("Kitchen", milk);
        inventoryManager.addItemToInventory("Kitchen", chocolate);
        inventoryManager.addItemToInventory("Kitchen", lettuce);
        // Did our items get added to the kitchen? 
        System.out.println("Items in Kitchen Inventory after adding:");
        for (Item item : kitchenInventory.getItems()) {
            System.out.println(item.getName() + " - Quantity: " + item.getQuantity());
        }

        /** The remove function: Can we remove an item from the inventory?
         * What do the items look like afterward? */
        kitchenInventory.removeItem(apple);
        System.out.println("\nAfter removing Apple, Items in Kitchen Inventory:");
        for (Item item : kitchenInventory.getItems()) {
            System.out.println(item.getName());
        }

        // Check for expired Items with .isExpiringSoon
        // Did our method work?
        System.out.println("\nChecking for items expiring soon:");
        for (Item item : kitchenInventory.getItems()) {
            if (item.isExpiringSoon()) {
                System.out.println(item.getName() + " is expiring soon!");
            }
        }

        /** User creation and profile maintenance with Admin.  */
        User user = new User("John Doe");
        System.out.println("\nUser Created: " + user.getName());

        /** View System Logs. */
        SystemAdmin admin = new SystemAdmin("Admin");
        System.out.println("\nSystem Admin Created: " + admin.getName());
        admin.viewLowStockItems(inventoryManager);

        /** Reciept and Budget tracking, can we log our purchases? */
        Receipt receipt = new Receipt(kitchenInventory.getItems(), 15.00);
        System.out.println("\nReceipt Details:");
        System.out.println("Total Amount: $" + receipt.getTotalAmount());
    }
}
