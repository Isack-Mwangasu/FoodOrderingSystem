package foodorder;

public class cashpayment extends payment {
    cashpayment(double amount) {
        this.amount = amount;
        this.type = "Cash";
    }

    void processPayment() {
        System.out.println("Cash payment of KES " + amount + " received.");
    }
}