package foodorder;

public class mobilepayment extends payment {
    String phoneNumber;

    mobilepayment(double amount, String phoneNumber) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.type = "M-Pesa";
    }

    void processPayment() {
        System.out.println("M-Pesa payment of KES " + amount + " sent from " + phoneNumber);
    }
}