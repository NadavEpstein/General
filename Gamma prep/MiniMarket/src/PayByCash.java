public class PayByCash implements PaymentMethod{
    public void pay(Order o) {
        System.out.println("Cash payment successful!");
        o.markCompleted();
    }
}
