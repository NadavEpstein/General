import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private final Map<Integer, Order> orders = new HashMap<>();

    public List<Order> getOrders() {
        List<Order> result = new ArrayList<>();

        for (Order o : orders.values())
            result.add(o.copy());

        return result;
    }

    public Order getOrder(int id) {
        Order order = orders.get(id);
        return order == null ? null : order.copy();
    }

    public boolean exists(int id) {
        return orders.containsKey(id);
    }

    public void addOrder(Order order) {
        if (order == null || exists(order.getID()))
            throw new IllegalArgumentException("Invalid or duplicate order");

        orders.put(order.getID(), order.copy());
    }
}
