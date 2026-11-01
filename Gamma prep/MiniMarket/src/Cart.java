import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Customer customer;
    private Map<Integer, Integer> products; //product id for productManager, quantity

    public Cart(Customer c) throws IllegalArgumentException {
        if (c == null) { throw new IllegalArgumentException("NULL customer"); }

        this.customer = c;
        this.products = new HashMap<>();
    }

    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        for (int id : products.keySet()) {
            productList.add(ProductManager.getProduct(id));
        }

        return productList;
    }

    public void addProduct(int ID, int quantity) {
        if (!ProductManager.exists(ID)) { System.out.println("Invalid ID."); }
        if (ProductManager.takeProduct(ID, quantity) == null) {
            System.out.println("Invalid quantity");
        }

        products.put(ID, quantity);
    }

    public void removeProduct(int id, int quantity) {
        if (!ProductManager.exists(id)) { System.out.println("Invalid ID."); }
        if (ProductManager.addExistingProduct(id, quantity) == null) {
            System.out.println("Invalid quantity");
        }

        int prevQuantity = products.get(id);
        products.remove(id);
        products.put(id, prevQuantity - quantity);
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Product p : getProducts()) {
            total += p.getPrice();
        }

        return total;
    }
}
