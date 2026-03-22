public class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    public void processPayment() {
        System.out.println("Credit card payment of KES " + amount + " processed. Card ending: "
                + cardNumber.substring(cardNumber.length() - 4));
    }
}