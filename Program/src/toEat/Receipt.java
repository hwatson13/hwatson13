package toEat;

import java.util.List;
public class Receipt {
    /** @param Items List of items purchased */
    private List<Item> items;
    /** @param totalAmount Total cost of the purchase */
    private double totalAmount; 

    /**
     * Default Constructor to Establish a Reciept.
     * @param items
     * @param totalAmount
     */
    public Receipt(List<Item> items, double totalAmount) {
        this.items = items;
        this.totalAmount = totalAmount;
    }

    /**
     * Retrieve the Items on a receipt.
     * @return items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Add items to a reciept or change what you bought.
     * @param items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Adds up the total for items and quantities on the receipt.
     * @return totalAmount Total cost of the receipt items
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set or change the total amount on a receipt depending on your purchases.
     * @param totalAmount
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

