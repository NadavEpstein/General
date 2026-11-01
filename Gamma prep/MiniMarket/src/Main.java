
public class Main {

    public static void main(String[] args) {

        // Initialize product management
        ProductManager manager = new ProductManager();

        // Create products
        Product laptop = new Product(1, "Laptop", 3000, 5);
        Product mouse = new Product(2, "Mouse", 100, 10);

        manager.addProduct(laptop);
        manager.addProduct(mouse);

        // Create customer
        Customer customer = new Customer(
                1,
                "John Smith",
                "john@example.com"
        );

        // Create shopping cart
        Cart cart = new Cart(customer);

        System.out.println("Welcome, " + customer.getName() + "!");
        System.out.println("\nAvailable products:");

        for (Product product : manager.getProducts()) {
            System.out.println(
                    product.getID() + ". " +
                            product.getName() + " - " +
                            product.getPrice() + " NIS"
            );
        }

        // Add products
        System.out.println("\nAdding products...");

        cart.addProduct(1, 2);
        cart.addProduct(2, 3);

        // Display cart
        System.out.println("\nShopping cart:");

        for (Product product : cart.getProducts()) {
            System.out.println(
                    product.getName() + " - " +
                            product.getPrice() + " NIS"
            );
        }

        // Display total
        System.out.println(
                "\nTotal: " + cart.calculateTotalPrice() + " NIS"
        );

        // Remove a product
        System.out.println("\nRemoving one mouse...");
        cart.removeProduct(2, 1);

        System.out.println(
                "Updated total: " +
                        cart.calculateTotalPrice() + " NIS"
        );

        // Attempt invalid operation
        System.out.println("\nAttempting invalid operation...");

        try {
            cart.addProduct(999, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }
}
