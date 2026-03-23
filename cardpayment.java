package foodorder;

public class cardpayment extends payment {
    String cardNumber;

    cardpayment(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.type = "Card";
    }

    void processPayment() {
        System.out.println("Card payment of KES " + amount + " processed. Card: " + cardNumber);
    }
}