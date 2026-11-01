import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {

    private static Map<Integer, Product> products;

    public ProductManager() {
        this.products = new HashMap<>();
    }

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (Product p : ProductManager.products.values()) {
            products.add(p.copy());
        }

        return products;
    }

    public static Product getProduct(int ID) {
        if (!exists(ID)) {
            System.out.println("No such product");
            return null;
        }

        for (Product p : products.values()) {
            if (p.getID() == ID) return p;
        }

        return null;
    }

    public static boolean exists(int id) {
        return products.get(id) != null;
    }

    public static Product takeProduct(int id, int quantity) {
        if (!exists(id)) {
            System.out.println("No such product");
            return null;
        }

        if (quantity > products.get(id).getStock()) {
            System.out.println("Not available. Available stock: " + products.get(id).getStock());
        }

        products.get(id).setStock(products.get(id).getStock() - quantity);
        return products.get(id).copy();
    }

    public static Product addExistingProduct(int id, int quantity) {
        if (!exists(id)) {
            System.out.println("No such product");
            return null;
        }

        if (quantity < 0) {
            System.out.println("Invalid quantity");
        }

        products.get(id).setStock(products.get(id).getStock() + quantity);
        return products.get(id).copy();
    }



}
