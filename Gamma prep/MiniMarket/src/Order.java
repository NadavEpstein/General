import java.util.Map;

public class Order {
    private final Shop shop;
    private final OrderManager manager;
    private Customer customer;
    private int ID;
    private Map<Integer, Integer> products;
    private Status status;
    private int price;

    public Order(Shop shop, Customer customer, int ID,
                 Map<Integer, Integer> products, int price) throws IllegalArgumentException {

        if (customer == null || shop == null || ID < 1 || products == null)
            throw new IllegalArgumentException("Invalid shop, customer, ID or product list");

        this.customer = customer;
        this.shop = shop;
        this.manager = shop.getOrderManager();
        this.ID = ID;
        this.status = Status.PENDING;
        this.price = price;

        this.products.putAll(products);
    }

    public Order copy() {
        Order copy = new Order(
                this.shop,
                this.customer,
                this.ID,
                this.products,
                this.price
        );

        copy.status = this.status;
        return copy;
    }

    public int getID() {
        return this.ID;
    }

}