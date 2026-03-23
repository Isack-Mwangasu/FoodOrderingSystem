package foodorder;

import java.util.ArrayList;

public class order {
    int orderId;
    String customerName;
    ArrayList<fooditem> items = new ArrayList<>();
    String status = "Pending";

    order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    void addItem(fooditem item) {
        if (item.available) {
            items.add(item);
            System.out.println(item.name + " added to order.");
        } else {
            System.out.println("Sorry, " + item.name + " is unavailable.");
        }
    }

    double calculateTotal() {
        double total = 0;
        for (fooditem item : items) {
            total += item.price;
        }
        return total;
    }

    void printSummary() {
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Items:");
        for (fooditem item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("Total: KES " + calculateTotal());
        System.out.println("Status: " + status);
    }
}