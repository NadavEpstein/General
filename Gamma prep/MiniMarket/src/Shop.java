public class Shop {
    private final ProductManager productManager;
    private final OrderManager orderManager;

    public Shop() {
        productManager = new ProductManager();
        orderManager = new OrderManager();
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }
}