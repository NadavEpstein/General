public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ProductManager manager = shop.getProductManager();

        manager.addProduct(new Product(1, "Laptop", 3000, 5));
        manager.addProduct(new Product(2, "Mouse", 100, 10));

        Customer customer = new Customer(1, "John Smith", "john@example.com");
        Cart cart = new Cart(customer, shop);

        cart.addProduct(1, 2);
        cart.addProduct(2, 3);
        cart.addProduct(2, 2);

        System.out.println("Cart total: " + cart.getTotalPrice() + " NIS");
        Order order = cart.placeOrder();

        System.out.println("Created order #" + order.getID()
                + " for " + order.getTotalPrice() + " NIS");
        System.out.println("Status: " + order.getStatus());
        System.out.println("Orders stored: " + shop.getOrderManager().getOrders().size());
    }
}
