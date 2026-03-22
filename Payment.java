public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // abstract = child classes MUST implement this their own way
    public abstract void processPayment();

    public double applyDiscount(double percent) {
        double discounted = amount - (amount * percent / 100);
        System.out.println("Discount of " + percent + "% applied. New amount: KES " + discounted);
        return discounted;
    }
}