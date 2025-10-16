import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;
        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.println("\nSelect Category:");
                    System.out.println("1. Headphone");
                    System.out.println("2. Keyboard");
                    System.out.println("3. Mouse");
                    System.out.print("Enter choice: ");
                    int catChoice = sc.nextInt();

                    Product product = switch (catChoice) {
                        case 1 -> new Headphone(id, name, qty, price);
                        case 2 -> new Keyboard(id, name, qty, price);
                        case 3 -> new Mouse(id, name, qty, price);
                        default -> null;
                    };

                    if (product != null) {
                        inventory.addItem(product);
                    } else {
                        System.out.println("⚠️ Invalid category!");
                    }
                }
                case 2 -> inventory.displayAll();
                case 3 -> {
                    System.out.print("Search by (1) ID or (2) Name: ");
                    int opt = sc.nextInt();
                    sc.nextLine();
                    Product found = null;
                    if (opt == 1) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        found = inventory.searchItem(id);
                    } else if (opt == 2) {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        found = inventory.searchItem(name);
                    }
                    if (found != null) {
                        System.out.println("🔍 Product found:");
                        found.displayInfo();
                    } else {
                        System.out.println("❌ Product not found!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Product ID to remove: ");
                    int id = sc.nextInt();
                    inventory.removeItem(id);
                }
                case 5 -> System.out.println("👋 Exiting...");
                default -> System.out.println("⚠️ Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
