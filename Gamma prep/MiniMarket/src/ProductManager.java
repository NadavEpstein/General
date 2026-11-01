import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {

    private Map<Integer, Product> products;

    public ProductManager() {
        this.products = new HashMap<>();
    }

    public ProductManager copy() {
        ProductManager copy = new ProductManager();

        for (Product p : this.products.values()) {
            copy.products.put(p.getID(), p.copy());
        }

        return copy;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (Product p : this.products.values()) {
            products.add(p.copy());
        }

        return products;
    }

    public Product getProduct(int ID) {
        if (!exists(ID)) {
            System.out.println("No such product");
            return null;
        }

        for (Product p : products.values()) {
            if (p.getID() == ID) return p.copy();
        }

        return null;
    }

    public boolean exists(int id) {
        return products.get(id) != null;
    }

    public Product takeProduct(int id, int quantity) {
        if (!exists(id)) {
            System.out.println("No such product");
            return null;
        }

        if (quantity > products.get(id).getStock() || quantity < 0) {
            System.out.println("Invalid quantity");
            return null;
        }

        products.get(id).setStock(products.get(id).getStock() - quantity);
        return products.get(id).copy();
    }

    public void addProduct(Product product) {
        if (product == null || exists(product.getID())) {
            throw new IllegalArgumentException("Invalid or duplicate product");
        }

        products.put(product.getID(), product.copy());
    }

    public Product addExistingProduct(int id, int quantity) {
        if (!exists(id)) {
            System.out.println("No such product");
            return null;
        }

        if (quantity < 0) {
            System.out.println("Invalid quantity");
            return null;
        }

        products.get(id).setStock(products.get(id).getStock() + quantity);
        return products.get(id).copy();
    }
}
