import java.util.List;

public class Customer extends User {
    private String address;

    public Customer(String name, String email, String phone, String address) {
        super(name, email, phone); // calls User constructor
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void viewMenu(List<FoodItem> menu) {
        System.out.println("\n===== MENU =====");
        for (FoodItem item : menu) {
            System.out.println(item);
        }
    }
}