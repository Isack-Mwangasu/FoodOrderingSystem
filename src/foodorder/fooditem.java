package foodorder;

public class fooditem {
    String name;
    double price;
    boolean available;

    fooditem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String toString() {
        return name + " - KES " + price + (available ? "" : " (Unavailable)");
    }
}