public class Product extends Item {
    protected String category;

    public Product(int id, String name, int quantity, double price, String category) {
        super(id, name, quantity, price);
        this.category = category;
    }

    @Override
    public void displayInfo() {
        System.out.printf("ID: %d | Name: %s | Category: %s | Qty: %d | Price: %.2f%n",
                id, name, category, quantity, price);
    }

    // Getters
    public String getName() { return name; }
    public int getId() { return id; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
