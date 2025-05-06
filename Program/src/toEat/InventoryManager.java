package toEat;
import java.util.HashMap;
import java.util.Map;
public class InventoryManager {
    /** @param inventories, Maps inventory names */
    private Map<String, Inventory> inventories; 

    /**
     * Default constructor to work with InventoryManager
     */
    public InventoryManager() {
        inventories = new HashMap<>();
    }

    /**
     * Creates a new inventory space. 
     * @param inventoryName
     */
    public void createInventory(String inventoryName) {
        inventories.put(inventoryName, new Inventory(inventoryName));
    }

    /**
     * Load an existing inventory by Name.
     * @param inventoryName
     * @return InventoryNames
     */
    public Inventory loadInventory(String inventoryName) {
        return inventories.get(inventoryName);
    }

    /**
     * Adds an item to the specified Inventory. 
     * @param inventoryName
     * @param item
     */
    public void addItemToInventory(String inventoryName, Item item) {
        Inventory inventory = inventories.get(inventoryName);
        if (inventory != null) {
            inventory.addItem(item);
        }
    }

    /**
     * Retrieves all the created inventories. 
     * @return inventories
     */
    public Map<String, Inventory> getInventories() {
        return inventories;
    }
}


