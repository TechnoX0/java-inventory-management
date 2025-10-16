public abstract class Item {
    protected int id;
    protected String name;
    protected int quantity;
    protected double price;

    public Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public abstract void displayInfo();
}
