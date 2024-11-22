import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    ArrayList<Item>menu;
    ArrayList<Order>orders;
    

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem= new Item(name, price);
        newItem.setIndex(menu.size());
        menu.add(newItem);
    }
    public void displayMenu() {
        for (Item item:menu) {
            System.out.println(item.display());
        }
    }

    public void newOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter costumer name for new order:");
        String name = scanner.nextLine();

        Order newOrder = new Order(name);  // Create a new Order object
        boolean ordering = true;

        // While loop to take the user's menu item choices
        while (ordering) {
            System.out.println("Please enter a menu item index or 'q' to quit:");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                ordering = false;
            } else {
                try {
                    int itemIndex = Integer.parseInt(input);
                    if (itemIndex >= 0 && itemIndex < menu.size()) {
                        newOrder.addItem(menu.get(itemIndex));  // Add the selected item to the order
                        System.out.println("Added " + menu.get(itemIndex).getName() + " to your order.");
                    } else {
                        System.out.println("Invalid index. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid menu item index or 'q' to quit.");
                }
            }
        }

        // After collecting the order, print order details
        orders.add(newOrder);
        newOrder.printOrderDetails();
    }

    // Admin method to manually add menu items by input
    public void addMenuItemByInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the item name:");
        String name = scanner.nextLine();
        System.out.println("Enter the item price:");
        double price = Double.parseDouble(scanner.nextLine());
        addMenuItem(name, price);
        System.out.println("Menu item added!");
    }
}



