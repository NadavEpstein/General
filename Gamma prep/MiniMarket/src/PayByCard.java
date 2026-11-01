public class PayByCard implements PaymentMethod{
    public void pay(Order o) {
        System.out.println("Card payment successful!");
        o.markCompleted();
    }
}
