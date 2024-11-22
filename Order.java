import java.util.ArrayList;

public class Order {
    // Declare the customerName field at the class level
    private String customerName;
    private ArrayList<Item> items;

    // Constructor that accepts customer name and initializes the items list
    public Order(String customerName) {
        this.customerName = customerName;  // Initialize the customerName
        this.items = new ArrayList<>();
    }

    // Add an item to the order
    public void addItem(Item item) {
        items.add(item);
    }

    // Print out order details
    public void printOrderDetails() {
        // Ensure the customerName is accessible here
        System.out.println("Order for " + customerName + ":");
        for (Item item : items) {
            System.out.println(item.display());  // Display each item in the order
        }
        
        // Calculate total price of the order
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        System.out.println("Total: $" + total);
    }
}