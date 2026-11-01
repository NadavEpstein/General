import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shop {
    private final ProductManager productManager = new ProductManager();
    private final OrderManager orderManager = new OrderManager();

    public ProductManager getProductManager() { return productManager; }
    public OrderManager getOrderManager() { return orderManager; }

    Order createOrder(Customer customer, Map<Integer, Integer> cartProducts) {
        if (customer == null || cartProducts == null || cartProducts.isEmpty())
            throw new IllegalArgumentException("Cannot create an empty order");

        List<OrderItem> items = new ArrayList<>();
        int totalPrice = 0;

        for (Map.Entry<Integer, Integer> entry : cartProducts.entrySet()) {
            Product product = productManager.getProduct(entry.getKey());
            int quantity = entry.getValue();
            if (product == null || quantity < 1)
                throw new IllegalArgumentException("Invalid cart contents");

            OrderItem item = new OrderItem(product.getID(), product.getName(),
                    product.getPrice(), quantity);
            items.add(item);
            totalPrice = Math.addExact(totalPrice, item.getSubtotal());
        }
        return orderManager.createOrder(customer, items, totalPrice);
    }
}
