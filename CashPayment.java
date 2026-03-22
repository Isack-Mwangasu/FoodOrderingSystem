public class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    public void processPayment() {
        System.out.println("Cash payment of KES " + amount + " received.");
    }
}