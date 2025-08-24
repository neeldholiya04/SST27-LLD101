/*
 * OrderService calculates totals, stores orders, and sends emails. That’s multiple responsibilities. It violates the Single Responsibility Principle.
 * OrderService is tightly coupled to EmailClient. If we wanted to add SMS or another notifier, we need to modify OrderService. This is the violation of Open/Closed Principle.
 * OrderService depends on a concrete class EmailClient. It should depend on an abstraction. This is the violation of Dependency Inversion Principle.
 */
public class Demo01 {
    public static void main(String[] args) {
        Notifier notifier = new EmailClient();
        OrderRepository repo = new InMemoryOrderRepository();
        OrderCalculator calculator = new OrderCalculator(0.18);

        OrderService service = new OrderService(notifier, repo, calculator);

        service.checkout("a@shop.com", 100.0);
    }
}
