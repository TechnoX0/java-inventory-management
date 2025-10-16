public class Keyboard extends Product {
    public Keyboard(int id, String name, int quantity, double price) {
        super(id, name, quantity, price, "Keyboard");
    }

    @Override
    public void displayInfo() {
        System.out.printf("⌨️ [Keyboard] ID: %d | Name: %s | Qty: %d | Price: %.2f%n",
                id, name, quantity, price);
    }
}
