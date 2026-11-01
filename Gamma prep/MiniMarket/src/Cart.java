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
        this.manager = shop.getManager();
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

    public int calculateTotalPrice() {
        int total = 0;

        for (Product p : getProducts())
            total += p.getPrice() * getQuantity(p.getID());

        return total;
    }
}