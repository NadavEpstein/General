import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int ID;
    private final Customer customer;
    private final List<OrderItem> items;
    private final int totalPrice;
    private Status status;

    public Order(int ID, Customer customer, List<OrderItem> items, int totalPrice) {
        if (ID < 1 || customer == null || items == null || items.isEmpty() || totalPrice < 0)
            throw new IllegalArgumentException("Invalid order data");

        this.ID = ID;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalPrice = totalPrice;
        this.status = Status.PENDING;
    }

    private Order(Order original) {
        this.ID = original.ID;
        this.customer = original.customer;
        this.items = new ArrayList<>(original.items);
        this.totalPrice = original.totalPrice;
        this.status = original.status;
    }

    public Order copy() { return new Order(this); }
    public int getID() { return ID; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return List.copyOf(items); }
    public int getTotalPrice() { return totalPrice; }
    public Status getStatus() { return status; }

    void markCompleted() { status = Status.COMPLETED; }
}
