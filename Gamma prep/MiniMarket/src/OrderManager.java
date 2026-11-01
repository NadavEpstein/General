import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private final Map<Integer, Order> orders = new HashMap<>();
    private int nextID = 1;

    public Order createOrder(Customer customer, List<OrderItem> items, int totalPrice) {
        Order order = new Order(nextID, customer, items, totalPrice);
        orders.put(nextID, order);
        nextID++;
        return order.copy();
    }

    public List<Order> getOrders() {
        List<Order> result = new ArrayList<>();
        for (Order order : orders.values()) result.add(order.copy());
        return result;
    }

    public Order getOrder(int id) {
        Order order = orders.get(id);
        return order == null ? null : order.copy();
    }

    public boolean exists(int id) { return orders.containsKey(id); }

    public boolean completeOrder(int id) {
        Order order = orders.get(id);
        if (order == null || order.getStatus() == Status.COMPLETED) return false;
        order.markCompleted();
        return true;
    }
}
