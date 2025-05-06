package toEat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Item {
    /* Name of the item.
    @param name
     */
    private String name;

    /** Double representing the price.
     * @param price
     */
    private double price;

    /** Representing the number of items.
     * @param quantity
     */
    private int quantity;

    /** The date when an item spoils.
     * @param expirationDate
     */
    private LocalDate expirationDate; 

    /**
     * Default Constructor
     * @param name
     * @param price
     * @param quantity
     * @param expirationDate
     */
    public Item(String name, double price, int quantity, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    /**
     * Returns the name of a given item.
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets a name of a given item.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the price of a given item.
     * @return price
     */
    public double getPrice() {
        return price;
    }
    /**
     * Set or change the price of a given item.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Return the quantity of a given item.
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets or changes the quantity of a given item. 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * Returns the Expiration Date for a given item.
     * @return expirationDate
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    /**
     * Sets or changes the expiration date of a given item.
     * @param expirationDate
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    /**
     * Helper function that checks if any items are expiring within two days
     * @return
     */
    public boolean isExpiringSoon() {
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(today, expirationDate);
        return daysBetween >= 0 && daysBetween <= 2;
    }
}

