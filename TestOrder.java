import java.util.Scanner;

public class TestOrder {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Adding some initial items to the menu
        kiosk.addMenuItem("Coffee", 1.50);
        kiosk.addMenuItem("Latte", 3.50);
        kiosk.addMenuItem("Muffin", 2.50);

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        // Menu loop
        while (keepRunning) {
            System.out.println("\nWelcome to the Coffee Kiosk!");
            System.out.println("1. View Menu");
            System.out.println("2. New Order");
            System.out.println("3. Admin: Add Menu Item");
            System.out.println("4. Quit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    kiosk.displayMenu();
                    break;
                case "2":
                    kiosk.newOrder();
                    break;
                case "3":
                    kiosk.addMenuItemByInput();
                    break;
                case "4":
                    System.out.println("Thank you for visiting!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
