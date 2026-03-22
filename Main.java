import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // --- Create Menu ---
        List<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem("Burger", 450, true));
        menu.add(new FoodItem("Pizza", 800, true));
        menu.add(new FoodItem("Fries", 200, true));
        menu.add(new FoodItem("Soda", 100, true));
        menu.add(new FoodItem("Ice Cream", 350, false));

        // --- Customer Registration ---
        System.out.println("===== WELCOME TO FOOD ORDERING SYSTEM =====");
        System.out.println("\n--- Customer Registration ---");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        // --- Create Customer from input ---
        Customer customer = new Customer(name, email, phone, address);
        RestaurantStaff staff = new RestaurantStaff("Bob", "bob@rest.com", "0798765432", "Manager");

        // --- Login and view menu ---
        customer.login();
        customer.viewMenu(menu);

        // --- Place Order ---
        Order order = new Order(1, customer);
        System.out.println("\n--- Place Your Order ---");
        System.out.println("Enter item numbers to order (enter 0 to finish):");

        // show numbered menu
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        // keep asking until they type 0
        while (true) {
            System.out.print("Enter item number: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice < 1 || choice > menu.size()) {
                System.out.println("Invalid choice. Try again.");
            } else {
                order.addItem(menu.get(choice - 1));
            }
        }

        // --- Show order summary ---
        order.printSummary();

        // --- Payment Method ---
        System.out.println("\n--- Choose Payment Method ---");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. M-Pesa");
        System.out.print("Enter choice: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        Payment payment = null;
        double total = order.calculateTotal();

        if (paymentChoice == 1) {
            payment = new CashPayment(total);

        } else if (paymentChoice == 2) {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine();
            payment = new CreditCardPayment(total, cardNumber);

        } else if (paymentChoice == 3) {
            System.out.print("Enter M-Pesa phone number: ");
            String mpesaPhone = scanner.nextLine();
            payment = new MobilePayment(total, mpesaPhone);

        } else {
            System.out.println("Invalid payment method.");
        }

        // --- Apply Discount ---
        System.out.print("\nDo you have a discount code? (yes/no): ");
        String hasDiscount = scanner.nextLine();

        if (hasDiscount.equalsIgnoreCase("yes")) {
            System.out.print("Enter discount percentage: ");
            double percent = scanner.nextDouble();
            total = payment.applyDiscount(percent);
        }

        // --- Process Payment ---
        System.out.println("\n===== PROCESSING PAYMENT =====");
        payment.processPayment();
        order.updateStatus("Confirmed");

        // --- Staff updates order ---
        System.out.println("\n===== RESTAURANT STAFF UPDATE =====");
        staff.updateOrderStatus(order, "Preparing");
        staff.updateOrderStatus(order, "Delivered");

        // --- Final Summary ---
        order.printSummary();

        System.out.println("\nThank you for ordering, " + customer.getName() + "! Enjoy your meal 🍔");
        scanner.close();
    }
}