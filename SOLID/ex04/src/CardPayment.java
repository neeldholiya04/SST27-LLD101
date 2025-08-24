public class CardPayment implements PaymentProvider {
    @Override
    public String pay(Payment payment) {
        return "Charged card: " + payment.getAmount();
    }
}
