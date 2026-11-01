import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Shop shop;
    private ProductManager manager = shop.getManager();
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
            productList.add(manager.getProduct(id));
        }

        return productList;
    }

    public boolean exists(int id) { return products.get(id) != null; }

    public void addProduct(int ID, int quantity) {
        if (!manager.exists(ID)) { System.out.println("Invalid ID."); return;}
        if (manager.takeProduct(ID, quantity) == null) {
            System.out.println("Invalid quantity");
            return;
        }

        int prevQuantity = products.get(ID);
        products.remove(ID);
        products.put(ID, prevQuantity + quantity);
    }

    public void removeProduct(int id, int quantity) {
        if (!this.exists(id)) { System.out.println("Invalid ID."); }
        if (manager.addExistingProduct(id, quantity) == null) {
            System.out.println("Invalid quantity");
        }

        int currQuantity = products.get(id);
        if (currQuantity < quantity) {
            System.out.println("Invalid quantity");
        }

        products.remove(id);
        products.put(id, currQuantity - quantity);
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Product p : getProducts()) {
            total += p.getPrice() * products.get(p.getID());
        }

        return total;
    }
}
