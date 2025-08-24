public class UpiPayment implements PaymentProvider {
    @Override
    public String pay(Payment payment) {
        return "Paid via UPI: " + payment.getAmount();
    }
}
