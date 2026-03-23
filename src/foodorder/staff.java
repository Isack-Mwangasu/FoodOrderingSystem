package foodorder;

public class staff extends person {
    String role;

    void updateOrderStatus(order anOrder, String status) {
        anOrder.status = status;
        System.out.println("Staff updated order #" + anOrder.orderId + " status to: " + status);
    }
}