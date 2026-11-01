import java.net.IDN;

public class Product {

    private int ID;
    private String name;
    private int price;
    private int stock;

    public Product(int ID, String name, int price, int stock) throws IllegalArgumentException{
        if (ID < 1) { throw new IllegalArgumentException("Invalid ID"); }
        if (name == null || name.isBlank()) { throw new IllegalArgumentException("Invalid name"); }
        if (price < 0) { throw new IllegalArgumentException("Invalid price"); }
        if (stock < 0) { throw new IllegalArgumentException("Invalid stock"); }

        this.ID = ID;
        this.name = name;
        this.price = price;

        this.stock = stock;
    }

    public int getID() { return ID; }
    public String getName() { return name; }
    public int getPrice() {return price; }
    public int getStock() { return stock; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name");
            return;
        }

        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Invalid stock quantity");
            return;
        }

        this.stock = stock;
    }

    public Product copy() {
        return new Product(ID, name, price, stock);
    }
}
