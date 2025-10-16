public class Headphone extends Product {
    public Headphone(int id, String name, int quantity, double price) {
        super(id, name, quantity, price, "Headphone");
    }

    @Override
    public void displayInfo() {
        System.out.printf("🎧 [Headphone] ID: %d | Name: %s | Qty: %d | Price: %.2f%n",
                id, name, quantity, price);
    }
}
