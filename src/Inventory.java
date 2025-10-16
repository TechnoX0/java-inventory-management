import Products.Product;

import java.util.*;

public class Inventory {
    private final List<Product> products;
    private final FileHandler fileHandler;

    public Inventory() {
        this.fileHandler = new FileHandler("inventory.txt");
        this.products = fileHandler.loadFromFile();
    }

    public void addItem(Product p) {
        products.add(p);
        System.out.println("✅ Product added successfully!");
        fileHandler.saveToFile(products);
    }

    public Product searchItem(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Product searchItem(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public void removeItem(int id) {
        Product found = searchItem(id);
        if (found != null) {
            products.remove(found);
            System.out.println("🗑️ Product removed successfully!");
            fileHandler.saveToFile(products);
        } else {
            System.out.println("❌ Product not found!");
        }
    }

    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("📦 Inventory is empty!");
            return;
        }
        System.out.println("\n=== INVENTORY LIST ===");
        for (Product p : products) {
            p.displayInfo();
        }
    }
}
