public class PaymentMethodProvider {

    public static PaymentMethod providePaymentMathod(String s) {
        if (s == null || s.isBlank()) { System.out.println("Invalid method type"); return null; }

        if (s.toUpperCase().equals("CARD")) {
            return new PayByCard();
        } else if (s.toUpperCase().equals("PAYPAL")) {
            return new PayByPayPal();
        } else if (s.toUpperCase().equals("CASH")) {
            return new PayByCash();
        } else {
            System.out.println("Invalid method type");
            return null;
        }
    }
}
