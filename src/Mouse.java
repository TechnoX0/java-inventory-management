public class Mouse extends Product {
    public Mouse(int id, String name, int quantity, double price) {
        super(id, name, quantity, price, "Mouse");
    }

    @Override
    public void displayInfo() {
        System.out.printf("🖱️ [Mouse] ID: %d | Name: %s | Qty: %d | Price: %.2f%n",
                id, name, quantity, price);
    }
}
