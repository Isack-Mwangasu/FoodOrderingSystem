import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<FoodItem> items;
    private String status;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(FoodItem item) {
        if (item.isAvailable()) {
            items.add(item);
            System.out.println(item.getName() + " added to order.");
        } else {
            System.out.println("Sorry, " + item.getName() + " is unavailable.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void printSummary() {
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Items ordered:");
        for (FoodItem item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("Total: KES " + calculateTotal());
        System.out.println("Status: " + status);
    }
}