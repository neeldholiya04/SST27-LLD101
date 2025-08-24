public class PaymentService {
    private final PaymentProvider provider;

    public PaymentService(PaymentProvider provider) {
        this.provider = provider;
    }

    public String processPayment(Payment payment) {
        return provider.pay(payment);
    }
}
