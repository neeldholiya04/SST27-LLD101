public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public void save(double total) {
        System.out.println("Order stored with total = " + total + " (pretend DB).");
    }
}
