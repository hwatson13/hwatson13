package toEat;
import java.util.ArrayList;
import java.util.List;
public class Inventory {

    /** @param name stores Inventories name as String */
    private String name;

    /** @param List stores Items to be inventory */
    private List<Item> items; 

    /** 
     * Default constructor 
     * @param String name
     */
    public Inventory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    /**
     * Adds specified item to the named Inventory.
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes specified item from named Inventory.
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Displays all items in a named Inventory.
     * @return items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Displays the name of a given Inventory.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the inventory name, or change it.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
