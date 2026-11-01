import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {
    private final Map<Integer, Product> products = new HashMap<>();

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) result.add(p.copy());
        return result;
    }

    public Product getProduct(int id) {
        Product product = products.get(id);
        return product == null ? null : product.copy();
    }

    public boolean exists(int id) { return products.containsKey(id); }

    public void addProduct(Product product) {
        if (product == null || exists(product.getID()))
            throw new IllegalArgumentException("Invalid or duplicate product");
        products.put(product.getID(), product.copy());
    }

    public Product takeProduct(int id, int quantity) {
        Product product = products.get(id);
        if (product == null || quantity <= 0 || quantity > product.getStock()) return null;
        product.setStock(product.getStock() - quantity);
        return product.copy();
    }

    public Product addExistingProduct(int id, int quantity) {
        Product product = products.get(id);
        if (product == null || quantity <= 0) return null;
        product.setStock(Math.addExact(product.getStock(), quantity));
        return product.copy();
    }
}
