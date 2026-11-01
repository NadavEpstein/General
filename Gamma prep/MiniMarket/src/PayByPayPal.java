public class PayByPayPal implements PaymentMethod{
    public void pay(Order o) {
        System.out.println("PayPal payment successful!");
        o.markCompleted();
    }
}
