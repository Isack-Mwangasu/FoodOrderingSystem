public class RestaurantStaff extends User {
    private String role;

    public RestaurantStaff(String name, String email, String phone, String role) {
        super(name, email, phone);
        this.role = role;
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Staff updated order #" + order.getOrderId() + " to: " + status);
    }
}