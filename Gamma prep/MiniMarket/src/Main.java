public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ProductManager manager = shop.getManager();

        Product laptop = new Product(1, "Laptop", 3000, 5);
        Product mouse = new Product(2, "Mouse", 100, 10);

        manager.addProduct(laptop);
        manager.addProduct(mouse);

        Customer customer = new Customer(
                1, "John Smith", "john@example.com"
        );

        Cart cart = new Cart(customer, shop);

        System.out.println("Welcome, " + customer.getName() + "!");

        cart.addProduct(1, 2);
        cart.addProduct(2, 3);
        cart.addProduct(2, 2);

        System.out.println("\nShopping cart:");

        for (Product product : cart.getProducts()) {
            System.out.println(
                    product.getName() + " - " +
                            cart.getQuantity(product.getID()) + " x " +
                            product.getPrice() + " NIS"
            );
        }

        System.out.println("\nTotal: " + cart.calculateTotalPrice() + " NIS");

        cart.removeProduct(2, 1);

        System.out.println(
                "Updated total: " + cart.calculateTotalPrice() + " NIS"
        );
    }
}