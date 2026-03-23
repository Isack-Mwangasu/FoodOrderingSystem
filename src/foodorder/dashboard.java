package foodorder;

import java.util.Scanner;
import java.util.ArrayList;

public class dashboard {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // create menu
        ArrayList<fooditem> menu = new ArrayList<>();
        menu.add(new fooditem("Burger", 450, true));
        menu.add(new fooditem("Pizza", 800, true));
        menu.add(new fooditem("Fries", 200, true));
        menu.add(new fooditem("Soda", 100, true));
        menu.add(new fooditem("Ice Cream", 350, false));

        System.out.println("===== WELCOME TO FOOD ORDERING SYSTEM =====");
        System.out.println("1. Register as Customer");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");
        int menuItem = input.nextInt();
        input.nextLine();

        if (menuItem == 1) {

            // register customer
            customer aCustomer = new customer();
            aCustomer.addCustomer();

            // show menu
            System.out.println("\n===== MENU =====");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i));
            }

            // place order
            order anOrder = new order(1, aCustomer.name);
            System.out.println("\nEnter item numbers to order (0 to finish):");

            while (true) {
                System.out.print("Enter item number: ");
                int choice = input.nextInt();
                if (choice == 0)
                    break;
                if (choice < 1 || choice > menu.size()) {
                    System.out.println("Invalid choice.");
                } else {
                    anOrder.addItem(menu.get(choice - 1));
                }
            }

            // show order
            anOrder.printSummary();

            // payment
            System.out.println("\n===== PAYMENT =====");
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3. M-Pesa");
            System.out.print("Enter choice: ");
            int payChoice = input.nextInt();
            input.nextLine();

            payment aPayment = null;
            double total = anOrder.calculateTotal();

            if (payChoice == 1) {
                aPayment = new cashpayment(total);
            } else if (payChoice == 2) {
                System.out.print("Enter card number: ");
                String card = input.nextLine();
                aPayment = new cardpayment(total, card);
            } else if (payChoice == 3) {
                System.out.print("Enter M-Pesa number: ");
                String phone = input.nextLine();
                aPayment = new mobilepayment(total, phone);
            }

            // discount
            System.out.print("Do you have a discount code? (yes/no): ");
            String disc = input.nextLine();
            if (disc.equalsIgnoreCase("yes")) {
                System.out.print("Enter discount %: ");
                double percent = input.nextDouble();
                aPayment.applyDiscount(percent);
            }

            aPayment.processPayment();
            anOrder.status = "Confirmed";

            // staff updates
            staff aStaff = new staff();
            aStaff.role = "Manager";
            aStaff.name = "Bob";
            aStaff.updateOrderStatus(anOrder, "Preparing");
            aStaff.updateOrderStatus(anOrder, "Delivered");

            anOrder.printSummary();
            System.out.println("\nThank you for ordering, " + aCustomer.name + "!");

        } else if (menuItem == 2) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice.");
        }

        input.close();
    }
}