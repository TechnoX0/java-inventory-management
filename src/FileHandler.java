import java.io.*;
import java.util.*;

public class FileHandler {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void saveToFile(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product p : products) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getCategory() + ","
                        + p.getQuantity() + "," + p.getPrice());
                writer.newLine();
            }
            System.out.println("💾 Inventory saved to file!");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving inventory: " + e.getMessage());
        }
    }

    public List<Product> loadFromFile() {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return products;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String category = parts[2];
                    int quantity = Integer.parseInt(parts[3]);
                    double price = Double.parseDouble(parts[4]);

                    // Recreate specific category object
                    switch (category.toLowerCase()) {
                        case "headphone" -> products.add(new Headphone(id, name, quantity, price));
                        case "keyboard" -> products.add(new Keyboard(id, name, quantity, price));
                        case "mouse" -> products.add(new Mouse(id, name, quantity, price));
                        default -> products.add(new Product(id, name, quantity, price, category));
                    }
                }
            }
            System.out.println("📂 Inventory loaded from file!");
        } catch (IOException e) {
            System.out.println("⚠️ Error loading inventory: " + e.getMessage());
        }

        return products;
    }
}
