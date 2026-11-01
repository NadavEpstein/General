public final class OrderItem {
    private final int productID;
    private final String productName;
    private final int unitPrice;
    private final int quantity;

    public OrderItem(int productID, String productName, int unitPrice, int quantity) {
        if (productID < 1 || productName == null || productName.isBlank()
                || unitPrice < 0 || quantity < 1) {
            throw new IllegalArgumentException("Invalid order item");
        }
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getProductID() { return productID; }
    public String getProductName() { return productName; }
    public int getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    public int getSubtotal() { return Math.multiplyExact(unitPrice, quantity); }
}
