import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Shop shop;
    private final ProductManager manager;
    private final Customer customer;
    private final Map<Integer, Integer> products = new HashMap<>();
    private int ordersMade;

    public Cart(Customer customer, Shop shop) {
        if (customer == null || shop == null)
            throw new IllegalArgumentException("Invalid customer or shop");

        this.customer = customer;
        this.shop = shop;
        this.manager = shop.getProductManager();
        this.ordersMade = 0;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<>();

        for (int id : products.keySet())
            result.add(manager.getProduct(id));

        return result;
    }

    public int getQuantity(int id) {
        return products.getOrDefault(id, 0);
    }

    public void addProduct(int id, int quantity) {
        if (quantity <= 0 || !manager.exists(id))
            throw new IllegalArgumentException("Invalid product or quantity");

        if (manager.takeProduct(id, quantity) == null)
            throw new IllegalArgumentException("Insufficient stock");

        products.put(id, products.getOrDefault(id, 0) + quantity);
    }

    public void removeProduct(int id, int quantity) {
        int current = getQuantity(id);

        if (quantity <= 0 || current < quantity)
            throw new IllegalArgumentException("Invalid quantity");

        manager.addExistingProduct(id, quantity);

        if (current == quantity)
            products.remove(id);
        else
            products.put(id, current - quantity);
    }

    public int getTotalPrice() {
        int total = 0;

        for (Product p : getProducts())
            total += p.getPrice() * getQuantity(p.getID());

        return total;
    }

    public Order placeOrder() {
        /*
        effectively, this functions moves over the reserved
        products from the cart to an order.
        the price of the order will be the price when it was made,
        or in other words the current price of the cart.
         */
        if (this.isEmpty()) {
            System.out.println("Cant order an empty cart.");
            return null;
        }

        ordersMade++;
        Map<Integer, Integer> prodCopies = new HashMap<>();
        for (int id : products.keySet()) {
            prodCopies.put(id, getQuantity(id));
        }

        Order order = new Order(shop, customer, ordersMade, products, getTotalPrice());
        this.products.clear();
        return order;
    }
}