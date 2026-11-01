import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Shop shop;
    private final ProductManager manager;
    private final Customer customer;
    private final Map<Integer, Integer> products = new HashMap<>();

    public Cart(Customer customer, Shop shop) {
        if (customer == null || shop == null)
            throw new IllegalArgumentException("Invalid customer or shop");
        this.customer = customer;
        this.shop = shop;
        this.manager = shop.getProductManager();
    }

    public boolean isEmpty() { return products.isEmpty(); }

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<>();
        for (int id : products.keySet()) result.add(manager.getProduct(id));
        return result;
    }

    public int getQuantity(int id) { return products.getOrDefault(id, 0); }

    public void addProduct(int id, int quantity) {
        if (quantity <= 0 || !manager.exists(id))
            throw new IllegalArgumentException("Invalid product or quantity");
        if (manager.takeProduct(id, quantity) == null)
            throw new IllegalArgumentException("Insufficient stock");
        products.put(id, Math.addExact(products.getOrDefault(id, 0), quantity));
    }

    public void removeProduct(int id, int quantity) {
        int current = getQuantity(id);
        if (quantity <= 0 || current < quantity)
            throw new IllegalArgumentException("Invalid quantity");
        manager.addExistingProduct(id, quantity);
        if (current == quantity) products.remove(id);
        else products.put(id, current - quantity);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : getProducts()) {
            total = Math.addExact(total,
                    Math.multiplyExact(product.getPrice(), getQuantity(product.getID())));
        }
        return total;
    }

    public Order placeOrder() {
        if (isEmpty()) return null;
        Order order = shop.createOrder(customer, new HashMap<>(products));
        products.clear();
        return order;
    }
}
