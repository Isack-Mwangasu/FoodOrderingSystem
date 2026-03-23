package foodorder;

import java.util.Scanner;

public class customer extends person {
    String address;

    void addCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Customer Registration");
        System.out.print("Enter full name: ");
        name = input.nextLine();
        System.out.print("Enter email: ");
        email = input.nextLine();
        System.out.print("Enter phone: ");
        phone = input.nextLine();
        System.out.print("Enter address: ");
        address = input.nextLine();

        System.out.println("\nCustomer Details:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }
}