package foodorder;

public class payment {
    double amount;
    String type;

    void processPayment() {
        System.out.println("Processing payment of KES " + amount);
    }

    double applyDiscount(double percent) {
        double discounted = amount - (amount * percent / 100);
        System.out.println("Discount of " + percent + "% applied. New amount: KES " + discounted);
        amount = discounted; // ← ADD THIS LINE - updates the actual amount
        return discounted;
    }
}