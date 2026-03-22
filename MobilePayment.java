public class MobilePayment extends Payment {
    private String phoneNumber;

    public MobilePayment(double amount, String phoneNumber) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }

    public void processPayment() {
        System.out.println("M-Pesa payment of KES " + amount + " sent from " + phoneNumber);
    }
}