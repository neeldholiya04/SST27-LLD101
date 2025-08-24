public class OrderService {
    private final Notifier notifier;
    private final OrderRepository repository;
    private final OrderCalculator calculator;

    public OrderService(Notifier notifier, OrderRepository repository, OrderCalculator calculator) {
        this.notifier = notifier;
        this.repository = repository;
        this.calculator = calculator;
    }

    public void checkout(String customerEmail, double subtotal) {
        double total = calculator.totalWithTax(subtotal);
        notifier.send(customerEmail, "Thanks! Your total is " + total);
        repository.save(total);
    }
}
