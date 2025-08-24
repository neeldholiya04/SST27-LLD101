public class WalletPayment implements PaymentProvider {
    @Override
    public String pay(Payment payment) {
        return "Wallet debit: " + payment.getAmount();
    }
}
