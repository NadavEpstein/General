public class Shop {
    private final ProductManager manager;

    public Shop() {
        manager = new ProductManager();
    }

    public ProductManager getManager() {
        return manager;
    }
}